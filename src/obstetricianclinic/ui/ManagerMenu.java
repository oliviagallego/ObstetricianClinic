package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import obstetricianclinic.ifaces.*;
import obstetricianclinic.pojos.*;
import obstetricianclinic.jdbc.*;

public class ManagerMenu {
	
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	
	private static LabStaffManager labStaffMan;
	private static ObstetricianManager obstetricianMan;
	private static UserManager userMan; // no entiendo porque me obliga a importarlo a la fuerza cuando se lo pasamos como parametro al menu


	public static void menu(User user, UserManager userMan, ConnectionManager conMan)  throws IOException, Exception {

		obstetricianMan = conMan.getObstetricianMan();
	    //userMan = conMan.getUser();
		labStaffMan= conMan.getLabStaffMan();
		
		while(true) {
			try {
			System.out.println("\nMANAGER MENU):" 
					+ "\n 1. Register Obstetrician"
					+ "\n 2. Select Obstetrician" 
					+ "\n 3. Register Laboratory Staff"
					+ "\n 4. Select Laboratory Staff" 
					+ "\n 5. Change Password" 
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
				registerLabStaff();
				break;
				}
			case 4:
				LabStaff labstaff = searchLabStaffByNameAndSurname(user.getId());
			case 5:{
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
			} catch (Exception e) {
		        System.out.println("Registration failed: " + e.getMessage());
		        
		    }
		}
	}
	
	public static void registerObstetrician() throws IOException, Exception {
		System.out.println("\nRegistration of an obstetrician: ");
		System.out.println("Please type the obstetrician data:");
		System.out.println("Name:");
		String name = r.readLine();
		System.out.println("Surname:");
		String surname = r.readLine();
		Obstetrician obstetrician = new Obstetrician(name, surname);
		obstetricianMan.addObstetrician(obstetrician);
		
		//Me he dado cuenta de que faltaba esto
		System.out.println("Introduce the Log in information:");
		System.out.println("UserName:");
		String userName = r.readLine();
		System.out.println("Password:");
		String password = r.readLine();
		
		User user = new User(userName, password);
		userMan.register(user);
		Role role = userMan.getRole("obstetrician");
		userMan.assignRole(user, role);
	}
	
	public static void registerLabStaff() throws IOException,Exception {
		System.out.println("\nRegistration of an laboratory staff: ");
		System.out.println("Please type the laboratory staff data:");
		System.out.println("Name:");
		String name = r.readLine();
		System.out.println("Surname:");
		String surname = r.readLine();
		LabStaff labStaff = new LabStaff(name, surname);
		labStaffMan.addLabStaff(labStaff);
		
		System.out.println("Introduce the Log in information:");
		System.out.println("UserName:");
		String userName = r.readLine();
		System.out.println("Password:");
		String password = r.readLine();
		User user = new User(userName, password);
		userMan.register(user);
		Role role = userMan.getRole("labStaff");
		userMan.assignRole(user, role);
	}
	
	

	
	public static Obstetrician searchObstetricianByNameAndSurname(int id) throws IOException {
		System.out.println("\nSelect obstetrician: ");
		System.out.println("Search Obstetrician by name and surname:");
		System.out.println("Name: ");
		String name = r.readLine();
		System.out.println("Surname:");
		String surname = r.readLine();
		System.out.println("Username:");
		String username = r.readLine();
		List<Obstetrician>listObstetricianOfManager= obstetricianMan.searchObstetricianByNameAndSurname(name, surname,username);
		List<Obstetrician> listObstetrician = new ArrayList<>();
		for(int i=0; i<listObstetricianOfManager.size(); i++) {
			Obstetrician obstetrician = listObstetricianOfManager.get(i);
			if(obstetrician.getName().equals(name)&&obstetrician.getSurname().equals(surname)) {
				listObstetrician.add(obstetrician);
			}
		}
		
		if (listObstetrician.isEmpty()) {
	        System.out.println("No obstetrician found with the name and surname provided.");
	        return null;  
	    }

	    if (listObstetrician.size() == 1) {
	        System.out.println("One obstetrician found: " + listObstetrician.get(0));
	        return listObstetrician.get(0);  
	    }

	    System.out.println("Multiple matches found, please choose one:");
	    for (int i = 0; i < listObstetrician.size(); i++) {
	        System.out.println((i + 1) + ". " + listObstetrician.get(i));
	    }
	    System.out.println("Enter the number of the obstetrician you want to choose:");
	    int choice = Integer.parseInt(r.readLine()) - 1; 
	    if (choice >= 0 && choice < listObstetrician.size()) {
	        return listObstetrician.get(choice);
	    } else {
	        System.out.println("Invalid choice, please enter a valid number.");
	        return null; 

	   }
	
}
	
	public static LabStaff searchLabStaffByNameAndSurname(int id) throws IOException {
		System.out.println("\nSelect laboratory staff: ");
		System.out.println("Search laboratory staff by name and surname:");
		System.out.println("Name: ");
		String name = r.readLine();
		System.out.println("Surname:");
		String surname = r.readLine();
		System.out.println("Username:");
		String username = r.readLine();
		List<LabStaff>listLabStaffOfManager= labStaffMan.searchLabStaffByNameAndSurname(name, surname,username);
		List<LabStaff> listLabStaff = new ArrayList<>();
		for(int i=0; i<listLabStaffOfManager.size(); i++) {
			LabStaff labStaff = listLabStaffOfManager.get(i);
			if(labStaff.getName().equals(name) && labStaff.getSurname().equals(surname)) {
				listLabStaff.add(labStaff);
			}
		}
		
		if (listLabStaff.isEmpty()) {
	        System.out.println("No laboratory staff found with the name and surname provided.");
	        return null;  
	    }

	    if (listLabStaff.size() == 1) {
	        System.out.println("One laboratory staff found: " + listLabStaff.get(0));
	        return listLabStaff.get(0);  
	    }

	    System.out.println("Multiple matches found, please choose one:");
	    for (int i = 0; i < listLabStaff.size(); i++) {
	        System.out.println((i + 1) + ". " + listLabStaff.get(i));
	    }
	    System.out.println("Enter the number of the laboratory staff you want to choose:");
	    int choice = Integer.parseInt(r.readLine()) - 1; 
	    if (choice >= 0 && choice < listLabStaff.size()) {
	        return listLabStaff.get(choice);
	    } else {
	        System.out.println("Invalid choice, please enter a valid number.");
	        return null; 

	   }
	
}
}