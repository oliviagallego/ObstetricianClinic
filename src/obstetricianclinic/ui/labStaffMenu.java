package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dogclinic.pojos.Dog;
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
			System.out.println("1. View Laboratory Reports");
			System.out.println("2. Add Laboratory Reports");
			System.out.println("3.Update Laboratory Reports");
			System.out.println("0. Exit");

		
    int choice = Integer.parseInt(r.readLine());
	switch (choice) {
	
			case 1: {
				
				break;
					}
			case 2: {
				addLabReport();
				break;
					}
			case 3: {
				
				break;
					}
	
			case 0: {
				conMan.closeConnection();
				return;
					}
			default: {
			System.out.println(" ERROR: Invalid option.");
					}
	} }
	catch (NumberFormatException e) {
		System.out.println("Please write a number");
		e.printStackTrace();
	} 
	catch (IOException e) {
		System.out.println("I/O Exception.");
		e.printStackTrace();
						};}}
	
public static void addLabReport() throws IOException{
			System.out.println("Date of test (dd-MM-yyyy):");
			String dateTest = r.readLine();
			LocalDate dobLocalDate = LocalDate.parse(dateTest, formatter);
			Date dateTestDate = Date.valueOf(dobLocalDate); 
		    //No me acuerdo como pedir un boolean
			System.out.println("Disease:");
			String Disease = r.readLine();
			LabReport labreport = new LabReport();
			labReportMan.addLabReport(labreport);

}
	


public void updateLabReport()throws IOException{
		System.out.println("What do you want to change");
		System.out.println("1.Change Date of test");
		System.out.println("2.Change if the woman is pregnant");
		System.out.println("3.Change Disease");
		
		int choice = Integer.parseInt(r.readLine());
		switch (choice) {

		case 1: {
			LabReport d = labReportMan.getLabReport(id);
		    System.out.println("New Date of Test  (" + d.getDateTest().toLocalDate() + "):");
			String dot = r.readLine();
			if (!dot.equals("")) {
				LocalDate dotLocalDate = LocalDate.parse(dot, formatter);
				Date dotDate = Date.valueOf(dotLocalDate);
				d.setDateTest(dotDate);
			   };
				}
		case 2: {
			//ns trabajar con boolean lo tengo que repasar
			break;
				}
		case 3: {
			Disease e = Disease.getDiseaseType(id);
			LabReport d = labReportMan.getLabReport(id);
			System.out.println("Type the new disease");
			System.out.println("Disease: (" + e.getDiseaseType() + "):");
			String disease = r.readLine();
			if (!disease.equals("")) {
				d.setDiseaseType(disease);
			break;
				}
		
		
		
		}
	}
		
	
	
	}
	}

	
	
	
	
	
		}
	
	
	
	
	
	
	
	
	
	
