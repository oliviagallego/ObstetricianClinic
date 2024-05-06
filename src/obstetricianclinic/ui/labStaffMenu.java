package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.*;
import obstetricianclinic.pojos.*;

public class labStaffMenu {

	public static void menu(User user, UserManager userMan) {
		// TODO Auto-generated method stub
		
	}
	
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static ObstetricianManager obstetricianMan;
	private static WomanManager womanMan;
	private static UserManager userMan;
	private static LabReportManager labReportMan;
	private static LabStaffManager labStaffMan;
	
	public static void main(User user, UserManager man) {
		ConnectionManager conMan = new ConnectionManager();
		obstetricianMan = conMan.getObstetricianMan();
		womanMan = conMan.getWomanMan();
		userMan = man;
		
	
	while (true) {
		try {
			System.out.println("Welcome to the obstetrician clinic!!");
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

				} catch (NumberFormatException e) {
					System.out.println("Please write a number");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("I/O Exception.");
					e.printStackTrace();
				}
			}
	
	
	
	
	
	public static void addLabReport() throws IOException{
			System.out.println("Date of test (dd-MM-yyyy):");
			String dateTest = r.readLine();
			LocalDate dobLocalDate = LocalDate.parse(dateTest, formatter);
			Date dateTestDate = Date.valueOf(dobLocalDate); 
		    //No me acuerdo como pedir un boolean
			LabReport labreport = new LabReport();
			labReportMan.addLabReport(labreport);
			}

	
	
		
	

	//Para ver lab report en el obstetrician
	//public static void searchLabReport() throws IOException{
	//	System.out.println("Date of test (dd-MM-yyyy) of the report you are searching: ");
	//	String dateTest = r.readLine();
	//	LocalDate dobLocalDate = LocalDate.parse(dateTest, formatter);
	//	Date dateTestDate = Date.valueOf(dobLocalDate); 
	//	LabReport report= labReportMan.getLabReportsDOT(dateTestDate);
	//	System.out.println(report);
	
	}
