package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.ConnectionManager;
import obstetricianclinic.pojos.*;

public class DiseaseMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	
	private static WomanManager womanMan;
	private static DiseaseManager diseaseMan;
	
	public static void menu(ConnectionManager conMan) {

		womanMan = conMan.getWomanMan();
		diseaseMan = conMan.getDiseaseMan();

		while (true) {
			try {
				System.out.println("Disease menu:");
				System.out.println("\nChoose an option, please:");
				System.out.println("\n1. Add disease");
				System.out.println("\n2. Select disease to update");
				System.out.println("\n0. Back");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							resgisterDisease();
							break;
						}
						case 2: {
							Disease d =searchDiseaseByName();
							updateDisease(d);
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

	private static Disease searchDiseaseByName()throws IOException  {
		System.out.println("Search disease by name:");
		String name = r.readLine();
		List<Disease>listDiseases= diseaseMan.searchDiseaseByName(name);
		System.out.println(listDiseases);
		Disease d= new Disease();
		
		if (listDiseases.isEmpty()) {
	        System.out.println("No disease found with the name provided.");
	        return null; 
	    }
		if (listDiseases.size() == 1) {
			d=listDiseases.get(0);
	        System.out.println("Only one Disease found: " + d);
	        
	        return d;  
	    }

	    
	    System.out.println("Multiple matches found, please choose one:");
	    for (int i = 0; i < listDiseases.size(); i++) {
	        System.out.println((i + 1) + ". " + listDiseases.get(i));
	    }
	    System.out.println("Enter the number of the Disease you choose:");
	    int choice = Integer.parseInt(r.readLine()) - 1;  // Adjust for zero-based index
	    if (choice >= 0 && choice < listDiseases.size()) {
	    	d=listDiseases.get(choice);
	        return d;  // Return the selected woman
	    } else {
	        System.out.println("Invalid choice, please enter a valid number.");
	        return null;  // Return null if the input choice is out of range
	    }
	}

	private static void resgisterDisease() throws IOException {
		System.out.println("Please type disease´s name: ");
		String diseaseType = r.readLine();
		Disease disease = new Disease(diseaseType);
		diseaseMan.addDisease(disease);
	}
	
	
	private static void updateDisease(Disease disease) throws IOException {
		System.out.println("Please write the new disese name");
		String diseaseType = r.readLine();
		disease.setDiseaseType(diseaseType);
		diseaseMan.updateDisease(disease);
		System.out.println("The disease has been updated correctly");

	}
	
	

	
	}