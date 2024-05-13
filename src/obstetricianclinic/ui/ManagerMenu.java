package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.pojos.*;
import obstetricianclinic.jdbc.*;

public class ManagerMenu {
	
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	
	private static LabStaffManager labStaffMan;
	private static ObstetricianManager obstetricianMan;

	public static void menu(User user, UserManager userMan, ConnectionManager conMan)  throws IOException {

		obstetricianMan = conMan.getObstetricianMan();
		labStaffMan= conMan.getLabStaffMan();
		
		while(true) {
			try {
			System.out.println("\nMANAGER MENU):" 
					+ "\n 1. Register Obstetrician"
					+ "\n 2. Select Obstetrician" 
					+ "\n 3. Change Password" 
					+ "\n 0. Log out");
			int option = Utilities.readInteger("Choose an option: ");

		switch(option) {
			case 1:{
				registerObstetrician();
				break;
				}
			case 2:{
				Obstetrician obs = searchObstetricianByNameAndSurname(user.getId());
				break;
				}
			case 3:{
				System.out.println("\nChanging Manager Password: ");
				String password = Utilities.readString(" -Type new password: ");
				user = userMan.changePassword(user, password);
				System.out.println(" -Password changed correctly to " + user.getPassword());
				break;
				}		case 0: {
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
			}catch (IOException e) {
				System.out.println("I/O Exception.");
				e.printStackTrace();
			}
		}
	}
	
	public static void registerObstetrician() throws IOException {
		System.out.println("\nRegistration of an obstetrician: ");
		System.out.println("Please type the obstetrician data:");
		System.out.println("Name:");
		String name = r.readLine();
		System.out.println("Surname:");
		String surname = r.readLine();
		System.out.println("Password:");
		Integer password = Integer.parseInt(r.readLine());
		Obstetrician obstetrician = new Obstetrician(name, surname, password);
		obstetricianMan.addObstetrician(obstetrician);
	}
	

	
	public static Obstetrician searchObstetricianByNameAndSurname(int id) throws IOException {
		System.out.println("\nSelect obstetrician: ");
		System.out.println("Search Obstetrician by name and surname:");
		System.out.println("Name: ");
		String name = r.readLine();
		System.out.println("Surname:");
		String surname = r.readLine();
		List<Obstetrician>listObstetricianOfManager= obstetricianMan.searchObstetricianByNameAndSurname(name, surname);
		List<Obstetrician> listObstetrician = new ArrayList<>();
		for(int i=0; i<listObstetricianOfManager.size(); i++) {
			Obstetrician obstetrician = listObstetricianOfManager.get(i);
			if(obstetrician.getName().equals(name)&&obstetrician.getSurname().equals(surname)) {
				listObstetrician.add(obstetrician);
			}
		}
		
		if (listObstetrician.isEmpty()) {
	        System.out.println("No Obstetrician found with the name and surname provided.");
	        return null;  
	    }

	    if (listObstetrician.size() == 1) {
	        System.out.println("One Obstetrician found: " + listObstetrician.get(0));
	        return listObstetrician.get(0);  
	    }

	    System.out.println("Multiple matches found, please choose one:");
	    for (int i = 0; i < listObstetrician.size(); i++) {
	        System.out.println((i + 1) + ". " + listObstetrician.get(i));
	    }
	    System.out.println("Enter the number of the woman you choose:");
	    int choice = Integer.parseInt(r.readLine()) - 1; 
	    if (choice >= 0 && choice < listObstetrician.size()) {
	        return listObstetrician.get(choice);
	    } else {
	        System.out.println("Invalid choice, please enter a valid number.");
	        return null; 

	   }
	
}
}

