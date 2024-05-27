package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import obstetricianclinic.ifaces.LabReportManager;
import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.ConnectionManager;
import obstetricianclinic.pojos.*;


public class PregnancyMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static WomanManager womanMan;
	private static LabReportManager labReportMan;
	private static PregnancyManager pregMan;
	private static NewbornManager bornMan;
	
	public static void menu(Woman woman) {
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
				System.out.println("\n3. Update pregnancy's Data");
				System.out.println("\n4. View Newborns's Menu");
				System.out.println("\n0. Back");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							Pregnancy pregnancy=pregnancySearch(woman);
							System.out.println(pregnancy);
							break;
						}
						case 2: {
							Pregnancy p= addPregancy(woman);
							NewbornMenu.menu(p);
							break;
						}
						case 3: {
							Pregnancy pregnancy=pregnancySearch(woman);
							updatePregancy(pregnancy);
							System.out.println(pregnancy);
							break;
						}
						case 4: {
							Pregnancy pregnancy=pregnancySearch(woman);
							NewbornMenu.menu(pregnancy);
							break;
						}
						case 0: {
							
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
				
public static Pregnancy pregnancySearch(Woman woman) throws IOException {

	System.out.println("Please insert the date of conception of the pregnancy you want:");
	String dateC = r.readLine();
	LocalDate dateCLocalDate = LocalDate.parse(dateC, formatter);
	Date dateConception = Date.valueOf(dateCLocalDate);
	List<Pregnancy> listPregnancies = pregMan.searchPregnancyByDateOfConception(dateConception);
	
	if (listPregnancies.isEmpty()) {
        System.out.println("No pregnancy found with the date of conception provided.");
        return null;  
    }

    if (listPregnancies.size() == 1) {
        System.out.println("One pregnancy found: " + listPregnancies.get(0));
        return listPregnancies.get(0);  
    }

    
    System.out.println("Multiple matches found, please choose one:");
    for (int i = 0; i < listPregnancies.size(); i++) {
        System.out.println((i + 1) + ". " + listPregnancies.get(i));
    }
    System.out.println("Enter the number of the pregnancy you choose:");
    int choice = Integer.parseInt(r.readLine()) - 1;  
    if (choice >= 0 && choice < listPregnancies.size()) {
        return listPregnancies.get(choice);  
    } else {
        System.out.println("Invalid choice, please enter a valid number.");
        return null;  
    }
	
	}	

public static Pregnancy addPregancy(Woman woman) throws IOException {
	List<LabReport> reports = labReportMan.searchLabReportByWoman(woman.getId());
	LabReport lastReport = null; 
	
	if (!reports.isEmpty()) {
	    lastReport = reports.get(reports.size() - 1);  
	    if(lastReport.isPregnant()==true) {
	    	System.out.println("Register Pregnancy:");
	    	System.out.println("Date of Test: "+lastReport.getDate_Test());
	    	System.out.println("Date of conception: ");
	    	String dateC = r.readLine();
	    	LocalDate dateCLocalDate = LocalDate.parse(dateC, formatter);
	    	Date dateConception = Date.valueOf(dateCLocalDate);
	    	System.out.println("Birth report: ");
	    	String textReport= r.readLine();
	    	
	    	Pregnancy p = new Pregnancy(dateConception,textReport, woman);
	    	pregMan.addPregnancy(p);
	    	return p;
	    }
	    return null;
	    }else {
	    	System.out.println("The woman needs to take a laboratory test.");
	    	return null;
	    }
	}

public static void updatePregancy(Pregnancy pregnancy) throws IOException {
	System.out.println("Please what do you want to update of the pregnancy's data:");
	System.out.println("\nChoose an option:");
	System.out.println("\n1. Change Date of conception");
	System.out.println("\n2. Change Birth report");
	int option= Integer.parseInt(r.readLine());
	switch(option) {
	case 1:
		System.out.println("The actual Date of conception is: "+pregnancy.getDateConception());
		System.out.println("\n Give me the new Date of conception: ");
		String dateC = r.readLine();
    	LocalDate dateCLocalDate = LocalDate.parse(dateC, formatter);
    	Date dateConception = Date.valueOf(dateCLocalDate);
    	pregnancy.setDateConception(dateConception);
		pregMan.updatePregnancy(pregnancy);
		break;
	case 2:
		System.out.println("The actual Birth report is: "+pregnancy.getBirthReport());
		System.out.println("\n Give me the new Birth report: ");
		String report = r.readLine();
		pregnancy.setBirthReport(report);
		pregMan.updatePregnancy(pregnancy);
		break;
		
	default: {
		System.out.println(" ERROR: Invalid option.");
	}
		
   }
	}


}


