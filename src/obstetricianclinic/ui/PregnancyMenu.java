package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
				System.out.println("\n0. Exit");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							Pregnancy pregSearch=pregnancySearch();
							subPregnancyMenu(pregSearch);
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
				
public static Pregnancy pregnancySearch() throws IOException {
	System.out.println("Please insert the date of conception:");
	String dateC = r.readLine();
	LocalDate dateCLocalDate = LocalDate.parse(dateC, formatter);
	Date dateConception = Date.valueOf(dateCLocalDate);
	List<Pregnancy> listPregnancies = pregMan.searchPregnancyByDateOfConception(dateConception);
	
	if (listPregnancies.isEmpty()) {
        System.out.println("No pregnancy found with the date of conception provided.");
        return null;  // Return null if no matches are found
    }

    if (listPregnancies.size() == 1) {
        System.out.println("One pregnancy found: " + listPregnancies.get(0));
        return listPregnancies.get(0);  // Return the single found pregnancy
    }

    // Multiple pregnancies found, let user choose
    System.out.println("Multiple matches found, please choose one:");
    for (int i = 0; i < listPregnancies.size(); i++) {
        System.out.println((i + 1) + ". " + listPregnancies.get(i));
    }
    System.out.println("Enter the number of the pregnancy you choose:");
    int choice = Integer.parseInt(r.readLine()) - 1;  // Adjust for zero-based index
    if (choice >= 0 && choice < listPregnancies.size()) {
        return listPregnancies.get(choice);  // Return the selected pregnancy
    } else {
        System.out.println("Invalid choice, please enter a valid number.");
        return null;  // Return null if the input choice is out of range
    }
	
	}	

public static void addPregancy(Woman woman) throws IOException {
	List<LabReport> reports = labReportMan.searchLabReportByWoman(woman.getId());
	LabReport lastReport = null; 
	
	if (!reports.isEmpty()) {
	    lastReport = reports.get(reports.size() - 1);  
	    if(lastReport.isPregnant()==true) {
	    	System.out.println("Register Pregnancy:");
	    	Date dateTest=lastReport.getDate_Test();
	    	System.out.println("Date of Test: "+dateTest);
	    	System.out.println("Date of conception: ");
	    	String dateC = r.readLine();
	    	LocalDate dateCLocalDate = LocalDate.parse(dateC, formatter);
	    	Date dateConception = Date.valueOf(dateCLocalDate);
	    	System.out.println("Birth report: ");
	    	String textReport= r.readLine();
	    	System.out.println("How many Newborns you need to add? ");
	    	int number= Integer.parseInt(r.readLine()); 
	    	List<Newborn> newborns=new ArrayList<Newborn>();
	    	while(number>0) {
	    		System.out.println(number+" -Please type the Newborn data:");
	    		System.out.println("Name:");
	    		String name = r.readLine();
	    		System.out.println("Surname:");
	    		String surname = r.readLine();
	    		System.out.println("Weight:");
	    		Float weight = Float.parseFloat(r.readLine());
	    		System.out.println("Gender (F/M):");
	    		String gender = r.readLine();
	    		Newborn newborn= new Newborn(name,surname,lastReport.getDate_Test(),weight,gender);
	    		newborns.add(newborn);
	    		bornMan.addNewborn(newborn);
	    		number--;
	    	}
	    	Pregnancy pregnancy= new Pregnancy(dateConception,textReport,newborns,woman);
	    	pregMan.addPregnancy(pregnancy);
	    	System.out.println("Pregnancy added successfully.");
	    }
	    }else {
	    	System.out.println("The woman needs to take a laboratory test.");
	    }
	}

public static void subPregnancyMenu(Pregnancy pregnancy) {
	while (true) {
		try {
			System.out.println("Pregnancys's Menu of:"+pregnancy.getDateConception());
			System.out.println("\nChoose an option, please:");
			System.out.println("\n1. View pregnancy's Data");
			System.out.println("\n2. Update pregnancy's Data");
			System.out.println("\n3. View Newborns's Data");
			System.out.println("\n0. Exit");

		
    int choice = Integer.parseInt(r.readLine());
	switch (choice) {
					case 1: {
						System.out.println(pregnancy);
						break;
					}
					case 2: {
						updatePregancy(pregnancy);
						System.out.println(pregnancy);
						break;
					}
					case 3: {
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
public static void updatePregancy(Pregnancy pregnancy) throws IOException {
	System.out.println("Please what do you want to update of the pregnancy's data:");
	System.out.println("\nChoose an option:");
	System.out.println("\n1. Change Date of conception");
	System.out.println("\n2. Change Birth report");
	int option= Integer.parseInt(r.readLine());
	switch(option) {
	case 1:
		System.out.println("The actual Date of conception is: "+pregnancy.getDateConception());
		System.out.println("\n Give me the new Date of test: ");
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


