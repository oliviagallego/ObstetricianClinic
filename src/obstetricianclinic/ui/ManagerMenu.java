package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import obstetricianclinic.ifaces.UserManager;
<<<<<<< HEAD

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.pojos.*;
import obstetricianclinic.jdbc.*;

=======
import obstetricianclinic.pojos.Role;
import obstetricianclinic.pojos.User;
>>>>>>> branch 'main' of https://github.com/oliviagallego/ObstetricianClinic

public class ManagerMenu {
<<<<<<< HEAD
	private static DiseaseManager diseaseMan;
	private static LabReportManager labReportMan;
	private static LabStaffManager labStaffMan;
	private static NewbornManager newbornMan;
	private static ObstetricianManager obstetricianMan;
	private static PregnancyManager pregnancyMan;
	private static UserManager userMan;
	private static WomanManager womanMan;
	//creo que nos falta una interfaz XML que aun no hemos dado en clase 
	
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));


	public static void menu(User user, UserManager userMan) {
		userMan = man;
		ConnectionManager conMan = new ConnectionManager(); // creamos la conexion con el jdbc
		while(true) {
			try {
			System.out.println("\nMANAGER MENU):" 
					+ "\n 1. Register Obstetrician"
					+ "\n 2. Select Obstetrician" 
					+ "\n 3. Change Password" 
					+ "\n 0. Log out");
			int option = Utilities.readInteger("Choose an option: ");
=======
	
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	private static UserManager userMan;
	
	public static void menu( UserManager userMan) throws NumberFormatException, IOException{
		System.out.print("Choose a username: ");
		String username= r.readLine();
		System.out.print("Password:");
		String password= r.readLine();
		System.out.println("Choose your role (type its name):");
		List<Role> roles= userMan.getAllRoles();
		System.out.println(roles);
		String roleName= r.readLine();
		Role r= userMan.getRole(roleName);
		User u= new User(username, password, r);
		
	}
>>>>>>> branch 'main' of https://github.com/oliviagallego/ObstetricianClinic

			switch(option) {
			case 1:{
				System.out.println("\nRegistration of an obstetrician: ");
				registerObstetrician();
				break;
				}
			case 2:{
				System.out.println("\nSelect obstetrician: ");
				updateObstetrician();
				break;
				}
			case 3:{
				System.out.println("\nChanging Manager Password: ");
				String password = Utilities.readString(" -Type new password: ");
				user = man.changePassword(user, password);
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
}

