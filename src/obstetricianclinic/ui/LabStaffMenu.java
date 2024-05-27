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
import obstetricianclinic.jpa.JPAUserManager;
import obstetricianclinic.pojos.*;

public class LabStaffMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static ObstetricianManager obstetricianMan;
	private static WomanManager womanMan;
	private static LabReportManager labReportMan;
	private static LabStaffManager labStaffMan;
	private static UserManager userMan;
	public static void menu(User user, UserManager man, ConnectionManager conMan) {
		
		obstetricianMan = conMan.getObstetricianMan();
		womanMan = conMan.getWomanMan();
		labStaffMan = conMan.getLabStaffMan();
		labReportMan = conMan.getLabReportMan();
		userMan = new JPAUserManager();
		
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
        		System.out.println("2. Change password");
        		System.out.println("0. Log out");
        		int choice = Integer.parseInt(r.readLine());
        		switch (choice) {
        		
        		case 1: {
					 addLabReport(labStaff);
					break;
				}
        		case 2: {
        			System.out.println("\nChanging Manager Password: ");
    				String password = Utilities.readString("\nType new password: ");
    				String hashedpassword= userMan.encryptPassword(password);
    				user = man.changePassword(user, hashedpassword);
    				System.out.println("\nPassword changed correctly to " + user.getPassword());
    				break;
				}
				case 0: {
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
	public static void addLabReport(LabStaff labStaff) throws IOException {
        try {
            System.out.println("\nLaboratory report:");
            System.out.println("\nDate of test (dd-MM-yyyy):");
            String dateTest = r.readLine();
            LocalDate dobLocalDate = LocalDate.parse(dateTest, formatter);
            Date dateTestDate = Date.valueOf(dobLocalDate);
            System.out.println("Is the pregnancy test positive(true) or negative (false)? ");
            boolean testResult = Boolean.parseBoolean(r.readLine());
            System.out.println("\nThe women of our database are: ");
            List <Woman> ws=womanMan.listWomen();
            for(int i= 0; i<ws.size(); i++) {
            	Woman o= ws.get(i);
            	System.out.println((i+1)+"- "+o);
            }
            System.out.println("\nSelect a woman: ");
            int id=Integer.parseInt(r.readLine());
            Woman w=womanMan.getWoman(id);
            LabReport labreport = new LabReport(dateTestDate, testResult, w,labStaff );
            labReportMan.addLabReport(labreport);
            System.out.println("Laboratory report added successfully.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please ensure correct data format.");
        }
    }
}



