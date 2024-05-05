package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.List;

import obstetricianclinic.ifaces.LabReportManager;
import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.ConnectionManager;
import obstetricianclinic.pojos.LabReport;
import obstetricianclinic.pojos.Woman;

public class PregnancyMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static WomanManager womanMan;
	private static LabReportManager labReportMan;
	private static PregnancyManager pregMan;
	
	public static void main(Woman woman) {
		ConnectionManager conMan = new ConnectionManager();
		womanMan = conMan.getWomanMan();
		pregMan = conMan.getPregnancyMan();
		labReportMan=conMan.getLabReportMan();
	
		while (true) {
			try {
				System.out.println("Pregnancys's Menu of: "+woman.getName()+" "+woman.getSurname());
				System.out.println("\nChoose an option, please:");
				System.out.println("\n1. Search pregnancy");
				System.out.println("\n2. Add a pregnancy to the woman's data.");
				System.out.println("\n0. Exit");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							pregnancySearch();
							break;
						}
						case 2: {
							addPregancy(woman);
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

			}
				
				

               

public static void pregnancySearch() throws IOException {
	System.out.println("Please what do you want to see of the woman's data:");
	System.out.println("\nChoose an option:");
	System.out.println("\n1. View woman's information");
	System.out.println("\n2. View woman's laboratory report");
	System.out.println("\n3. View woman's pregnancy record");
	int option= Integer.parseInt(r.readLine());
	switch(option) {
	case 1:
		Woman o=womanMan.viewWoman(id);
		System.out.println(o);
		break;
	case 2:
		List<LabReport> l= labReportMan.getLabReportsByWoman(woman);
		System.out.println(l);
		break;
	case 3:
		PregnancyMenu.main(woman);
		break;
	default: {
		System.out.println(" ERROR: Invalid option.");
	}
	
	}	

}

public static void addPregancy(Woman woman) throws IOException {
	System.out.println("Please what do you want to update of the woman's data:");
	System.out.println("\nChoose an option:");
	System.out.println("\n1. Change name");
	System.out.println("\n2. Change surname");
	System.out.println("\n3. Change dob");
	System.out.println("\n3. Change weight");
	int option= Integer.parseInt(r.readLine());
	switch(option) {
	case 1:
		Woman o=womanMan.viewWoman(id);
		System.out.println(o);
		break;
	case 2:
		List<LabReport> l= labReportMan.getLabReportsByWoman(woman);
		System.out.println(l);
		break;
	case 3:
		PregnancyMenu.main(woman);
		break;
	default: {
		System.out.println(" ERROR: Invalid option.");
	}
   }

	




	
	
	
	
	
	
	
	

}

}
