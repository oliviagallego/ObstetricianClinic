package obstetricianclinic.ui;
import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.*;
import obstetricianclinic.pojos.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//import obstetricianclinic.jpa.JPAUserManager; esta por programar
public class ObstetricianMenu {
	
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static WomanManager womanMan;
	private static ObstetricianManager obstetricianMan;
	
	public static void menu(User user, UserManager userMan, ConnectionManager conMan) {
		womanMan = conMan.getWomanMan();/* solo tenemos q hacer uso del método*/
		obstetricianMan = conMan.getObstetricianMan();
		
		Obstetrician obstetrician = obstetricianMan.getObstetricianFromUser(user.getUsername());
	    if (obstetrician == null) {
	        System.out.println("Obstetrician not found, please check the credentials.");
	        return;
	    }
	   
		while (true) {
			try {
				System.out.println("Welcome to the obstetrician clinic!!");
				System.out.println("Choose an option, please:");
				System.out.println("1. Register a Woman");
				System.out.println("2. Select a woman");
				System.out.println("3. Change password");
				System.out.println("4. Access to disease´s menu");
				System.out.println("0. Log out\n");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							registerwoman(obstetrician);
							break;
						}
						case 2: {
							int id_obs=obstetrician.getId();
							Woman woman= searchWomanByNAndS(id_obs);
							WomanMenu.menu(woman, conMan);
							break;
						}
						case 3: {
							System.out.println("\nChanging Manager Password: ");
							String password = Utilities.readString("\nType new password: ");
							String hashedpassword= userMan.encryptPassword(password);
							user = userMan.changePassword(user, hashedpassword);
							System.out.println("\nPassword changed correctly to " + user.getPassword());
							break;
						}
						case 4:{
							DiseaseMenu.menu(conMan);
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
				
				

               

public static void registerwoman(Obstetrician obst) throws IOException {
	System.out.println("Please type woman's data:");
	System.out.println("Name:");
	String name = r.readLine();
	System.out.println("Surname:");
	String surname = r.readLine();
	System.out.println("Weight:");
	Float weight = Float.parseFloat(r.readLine());
	System.out.println("Date of birth (dd-MM-yyyy):");
	String dob = r.readLine();
	LocalDate dobLocalDate = LocalDate.parse(dob, formatter);
	Date dobDate = Date.valueOf(dobLocalDate); 
	Woman woman = new Woman(name, surname, dobDate, weight, obst);
	womanMan.registerWoman(woman);

}

public static Woman searchWomanByNAndS(int id) throws IOException {
	List<Woman>listWomenOfObstetrician= womanMan.searchWomanByObstetrician(id);
	
	System.out.println("Search woman by name:");
	String name = r.readLine();
	System.out.println("Surname:");
	String surname = r.readLine();
	
	List<Woman> listWomen=new ArrayList<>();
	for(int i=0; i<listWomenOfObstetrician.size(); i++) {
		Woman o=listWomenOfObstetrician.get(i);
		if(o.getName().equals(name)&&o.getSurname().equals(surname)) {
			listWomen.add(o);
		}
	}
	
	if (listWomen.isEmpty()) {
        System.out.println("No women found with the name and surname provided.");
        return null;  // Return null if no matches are found
    }

    if (listWomen.size() == 1) {
        System.out.println("One woman found: " + listWomen.get(0));
        return listWomen.get(0);  
    }

   
    System.out.println("Multiple matches found, please choose one:");
    for (int i = 0; i < listWomen.size(); i++) {
        System.out.println((i + 1) + ". " + listWomen.get(i));
    }
    System.out.println("Enter the number of the woman you choose:");
    int choice = Integer.parseInt(r.readLine()) - 1;  // Adjust for zero-based index
    if (choice >= 0 && choice < listWomen.size()) {
    	// Assign the same obstetrician to the woman
    	// For this woman
    		// Get the diseases getDiseasesOfWoman(int womanid)
    		// Get the pregnancies 
        return listWomen.get(choice);  // Return the selected woman
    } else {
        System.out.println("Invalid choice, please enter a valid number.");
        return null;  
    }

   }
	
}


