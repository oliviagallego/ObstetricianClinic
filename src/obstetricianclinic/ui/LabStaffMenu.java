package obstetricianclinic.ui;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.*;
import obstetricianclinic.pojos.*;

public class LabStaffMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static ObstetricianManager obstetricianMan;
	private static WomanManager womanMan;
	private static LabReportManager labReportMan;
	private static LabStaffManager labStaffMan;
	
	public static void menu(User user, UserManager man, ConnectionManager conMan) {
		/*if (user.getRole() == null || !user.getRole().getName().equals("labStaff")) {
            System.out.println("Access Denied: You do not have the necessary permissions to access this menu.");
            return;  MEJOR  LO DE DEBAJO IGUAL Q OBSTETRICIANMENU
        }*/
		obstetricianMan = conMan.getObstetricianMan();
		womanMan = conMan.getWomanMan();
		labStaffMan = conMan.getLabStaffMan();
		labReportMan = conMan.getLabReportMan();
		
		LabStaff labStaff = labStaffMan.getLabStaffFromUser(user.getUsername());
	    if (labStaff == null) {
	        System.out.println("LabStaff not found, please check the credentials.");
	        return;
	    }
        
        while (true) {
        	try {
        		System.out.println("Welcome to the LabStaff clinic!!");
        		System.out.println("Choose an option, please:");
        		System.out.println("1. Add Laboratory Reports");
        		System.out.println("0. Exit");
        		int choice = Integer.parseInt(r.readLine());
        		switch (choice) {
        		
        		case 1: {
					 addLabReport();
					break;
				}
				
				case 0: {
					conMan.closeConnection();
					return;
				}
				default: {
					System.out.println(" ERROR: Invalid option.");
				}
				}
        	}catch (NumberFormatException e) {
				System.out.println("Please write a number");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("I/O Exception.");
				e.printStackTrace();
			}
        }
    }
	public static void addLabReport() throws IOException {
        try {
            System.out.println("\nLaboratory report:");
            System.out.println("\nDate of test (dd-MM-yyyy):");
            String dateTest = r.readLine();
            LocalDate dobLocalDate = LocalDate.parse(dateTest, formatter);
            Date dateTestDate = Date.valueOf(dobLocalDate);
            System.out.println("Is the pregnancy test positive(true) or negative (false)? ");
            boolean testResult = Boolean.parseBoolean(r.readLine());

            LabReport labreport = new LabReport(dateTestDate, testResult);
            labReportMan.addLabReport(labreport);
            System.out.println("Laboratory report added successfully.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please ensure correct data format.");
        }
    }
}



