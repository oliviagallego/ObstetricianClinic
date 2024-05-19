package obstetricianclinic.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.ConnectionManager;
import obstetricianclinic.pojos.*;
import obstetricianclinic.jpa.*;

public abstract class LogInMenu{
	
	private static UserManager userMan;
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] Args) throws SQLException { // throws NumberFormatException, IOException, Exception{
			
			try {
				ConnectionManager conMan = new ConnectionManager();
				userMan = new JPAUserManager();

				System.out.print("\nWelcome to the Obstetrician Clinic!");
				initialSetup();
				/*
				 Hemos creado el manager
				
				String usernameManager = "Manager";
				String passwordManager = "Manager123";
				Role roleManager = userMan.getRole("manager");
				User manager = new User(usernameManager, passwordManager);
				userMan.register(manager);
		
				userMan.assignRole(manager, roleManager);
				*/
				
				while (true) {
					System.out.println("\nLog-In menu");
					System.out.println("\nUsername:");
					String username = r.readLine();
					System.out.println("\nPasword:");
					String password = r.readLine();
					
					User user = userMan.logIn(username, password);
					// User user = userMan.logIn("manager", "default0", "manager@obstetricianClinic.com");

					if (user != null) {
		                if (user.getRole().getName().equals("manager")) {
		                    ManagerMenu.menu(user, userMan, conMan);

		                } else if (user.getRole().getName().equals("obstetrician")) {
		                    ObstetricianMenu.menu(user, userMan, conMan);
		                } else if(user.getRole().getName().equals("labstaff")){
		                	 LabStaffMenu.menu(user, userMan, conMan);
		                }
		                else {
		                    System.out.println("Access Denied: Your role is not recognized.");
		                }
		            } else {
		                System.out.println("Error: Wrong username or password.");
		            }
				}
			}catch (IOException e) {
	            System.out.println("\nAn error occurred: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("\nUnexpected error: " + e.getMessage());
	        }
		}
	public static void initialSetup() {
	    String username = "Manager";
	    String password = "Manager123";
	    if (userMan.getUser(username) == null) { 
	        User manager = new User(username, password);
	        userMan.register(manager, "manager");
	        userMan.assignRole(manager, userMan.getRole("manager"));
	    } else {
	        System.out.println("Manager user already exists.");
	    }
	}

	
}
