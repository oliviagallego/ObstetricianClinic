package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.pojos.*;
import obstetricianclinic.jdbc.*;

public class ManagerMenu {
	
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	
	private static LabStaffManager labStaffMan;
	private static ObstetricianManager obstetricianMan;
	private static UserManager userMan; 
	private static XMLManager xmlMan;


	public static void menu(User user, UserManager userMan, ConnectionManager conMan, XMLManager xmlMan)  throws IOException, Exception, SQLException  {

		obstetricianMan = conMan.getObstetricianMan();
		labStaffMan= conMan.getLabStaffMan();
		ManagerMenu.userMan = userMan; 
		
		
		while(true) {
			try {
			System.out.println("\nMANAGER MENU):" 
					+ "\n 1. Register Obstetrician"
					+ "\n 2. Select Obstetrician" 
					+ "\n 3. Register Laboratory Staff"
					+ "\n 4. Select Laboratory Staff" 
					+ "\n 5. Change Password" 
					+ "\n 6. XML Obstetrician"
					+ "\n 7. XML LabStaff"
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
				if (labstaff != null) {
                    System.out.println("Lab Staff selected: " + labstaff.toString());
                }
				break;
			case 5:{
				System.out.println("\nChanging Manager Password: ");
				String password = Utilities.readString(" -Type new password: ");
				user = userMan.changePassword(user, password);
				System.out.println(" -Password changed correctly to " + user.getPassword());
				break;
				}	
			case 6:{
				System.out.println("\nSave obstetrician information to a file:");
				Obstetrician g= searchObstetricianByNameAndSurname(user.getId());
				saveObstetricianToFile(g.getId());
				
				break;
				}
			case 7:{
				System.out.println("\nSave labstaff information to a file:");
				LabStaff l= searchLabStaffByNameAndSurname(user.getId());
				saveLabstaffToFile(l.getId());
				
				break;
				}
			case 0: {
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
		
		
		System.out.println("Introduce the Log in information:");
		System.out.println("UserName:");
		String username = r.readLine();
		System.out.println("Password:");
		String password = r.readLine();
		Obstetrician obstetrician = new Obstetrician(name, surname,username);
		obstetricianMan.addObstetrician(obstetrician);
		
		User user = new User(username, password);
		userMan.register(user);
		Role role = userMan.getRole("obstetrician");
		userMan.assignRole(user, role);
		System.out.println("\nThe obstetrician "+obstetrician.getName()+" "+obstetrician.getSurname()+" is inserted to the Database");
	}
	
	public static void registerLabStaff() throws IOException, Exception {
		/*if (userMan == null) {
	        System.out.println("UserManager has not been initialized");
	        throw new IllegalStateException("UserManager is required but was not initialized.");
	    }*/
		System.out.println("\nRegistration of a laboratory staff: ");
		System.out.println("Please type the laboratory staff data:");
		System.out.println("Name:");
		String name = r.readLine();
		System.out.println("Surname:");
		String surname = r.readLine();
		
		System.out.println("Introduce the Log in information:");
		System.out.println("UserName:");
		String username = r.readLine();
		System.out.println("Password:");
		String password = r.readLine();
		
		LabStaff labStaff = new LabStaff(name, surname, username);
		labStaffMan.addLabStaff(labStaff);
		User user = new User(username, password);
		userMan.register(user);
		Role role = userMan.getRole("labStaff");
		userMan.assignRole(user, role);
		System.out.println("\nThe labStaff "+labStaff.getName()+" "+labStaff.getSurname()+" is inserted to the Database");
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
		for(Obstetrician obstetrician:listObstetricianOfManager) {
			
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
	private static void saveObstetricianToXml(Integer obstetrician_id) {
		
		if(obstetrician_id != null){
			Obstetrician obstetrician = obstetricianMan.getObstetrician(obstetrician_id);
			System.out.println(obstetrician.toString());
			xmlMan.obstetrician2Xml(obstetrician);
		}
	}
private static void saveObstetricianToHtml(Integer obstetrician_id) {
		
		
		if(obstetrician_id != null){
			Obstetrician obstetrician = obstetricianMan.getObstetrician(obstetrician_id);
			System.out.println(obstetrician.toString());
			xmlMan.obstetrician2Html(obstetrician);
		}
	}
private static void saveObstetricianToFile(Integer obstetrician_id) {
	
	System.out.println(" -Choose file type: "
			+ "\n   1. XML file"
			+ "\n   2. HTML file");
	int file = Utilities.readInteger(" -File type: ");
	
	switch(file) {
		case 1:
			System.out.println("Save to XML file:");
			saveObstetricianToXml(obstetrician_id);
			break;
		case 2:
			System.out.println("Save to HTML file:");
			saveObstetricianToHtml(obstetrician_id);
			break;
		default:
			System.out.println(" ERROR: invalid option.");
	}
}
private static void saveLabStaffToXml(Integer labStaff_id) {
	
	if(labStaff_id != null){
		LabStaff labstaff = labStaffMan.getLabStaff(labStaff_id);
		System.out.println(labstaff.toString());
		xmlMan.labstaff2Xml(labstaff);
	}
}
private static void saveLabStaffToHtml(Integer labStaff_id) {
	
	
	if(labStaff_id != null){
		LabStaff labstaff = labStaffMan.getLabStaff(labStaff_id);
		System.out.println(labstaff.toString());
		xmlMan.labstaff2Html(labstaff);
	}
}
private static void saveLabstaffToFile(Integer labStaff_id) {
	
	System.out.println(" -Choose file type: "
			+ "\n   1. XML file"
			+ "\n   2. HTML file");
	int file = Utilities.readInteger(" -File type: ");
	
	switch(file) {
		case 1:
			System.out.println("Save to XML file:");
			saveLabStaffToXml(labStaff_id);
			break;
		case 2:
			System.out.println("Save to HTML file:");
			saveLabStaffToHtml(labStaff_id);
			break;
		default:
			System.out.println(" ERROR: invalid option.");
	
}
	}
}