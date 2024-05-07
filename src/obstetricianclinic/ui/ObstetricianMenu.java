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

//import obstetricianclinic.jpa.JPAUserManager;esta por programar



public class ObstetricianMenu {
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private static ObstetricianManager obstetricianMan;
	private static WomanManager womanMan;
	private static UserManager userMan;
	
	public static void menu(User user, UserManager man) {
		ConnectionManager conMan = new ConnectionManager();
		obstetricianMan = conMan.getObstetricianMan();
		womanMan = conMan.getWomanMan();/* solo tenemos q hacer uso del método*/
		userMan = man;
		Obstetrician obstetrician = userMan.getObstetricianFromUser(user);
		while (true) {
			try {
				System.out.println("Welcome to the obstetrician clinic!!");
				System.out.println("Choose an option, please:");
				System.out.println("1. Register a Woman");
				System.out.println("2. Select a woman");
				System.out.println("3. Change password");
				System.out.println("0. Exit");

			
        int choice = Integer.parseInt(r.readLine());
		switch (choice) {
						case 1: {
							registerwoman();
							break;
						}
						case 2: {
							int id_obs=obstetrician.getId();
							Woman woman= searchWomanByNameAndSurname(id);
							WomanMenu.menu(woman);
							break;
						}
						case 3: {
							System.out.println("\nChange password:");
							String password = Utilities.readString(" -Type new password: ");
							user = man.changePassword(user, password);
							System.out.println(" -Password changed correctly to " + user.getPassword());
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
				
				

               

public static void registerwoman() throws IOException {
	System.out.println("Please type the womans data:");
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
	Woman woman = new Woman(name, surname, dobDate, weight);
	womanMan.registerWoman(woman);

}

public static Woman searchWomanByNameAndSurname(int id) throws IOException {
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
        return listWomen.get(0);  // Return the single found woman
    }

    // Multiple women found, let user choose
    System.out.println("Multiple matches found, please choose one:");
    for (int i = 0; i < listWomen.size(); i++) {
        System.out.println((i + 1) + ". " + listWomen.get(i));
    }
    System.out.println("Enter the number of the woman you choose:");
    int choice = Integer.parseInt(r.readLine()) - 1;  // Adjust for zero-based index
    if (choice >= 0 && choice < listWomen.size()) {
        return listWomen.get(choice);  // Return the selected woman
    } else {
        System.out.println("Invalid choice, please enter a valid number.");
        return null;  // Return null if the input choice is out of range
    }

   }
	 

	




	
	
	
	
	
	
	
	
}


