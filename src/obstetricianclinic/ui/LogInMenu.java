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
	private static XMLManager xmlMan;
	public static void main(String[] Args) throws SQLException { // throws NumberFormatException, IOException, Exception{
			
			try {
				ConnectionManager conMan = new ConnectionManager();
				
				userMan = new JPAUserManager();
				xmlMan = conMan.getXmlMan();
				System.out.print("\nWelcome to the Obstetrician Clinic!");
			

				/*
				String usernameManager = "Manager";
				String passwordManager = "Manager123";
				String hashedpassword3= userMan.encryptPassword(passwordManager);
				Role roleManager = userMan.getRole("manager");
				User manager = new User(usernameManager, hashedpassword3);
				userMan.register(manager);
		
				userMan.assignRole(manager, roleManager);
				*/
				while (true) {
					System.out.println("\nLog-In menu");
					System.out.println("\nUsername:");
					String username = r.readLine();
					System.out.println("\nPassword:");
					String password = r.readLine();
					String hashedpassword= userMan.encryptPassword(password);
					
					User user = userMan.logIn(username, hashedpassword);
					// User user = userMan.logIn("manager", "default0", "manager@obstetricianClinic.com");

					if (user != null) {
		                if (user.getRole().getName().equals("manager")) {
		                	ManagerMenu manMenu= new ManagerMenu(user, userMan, conMan, xmlMan);
		                	manMenu.menu(user, userMan, conMan);
		                    //ManagerMenu.menu(user, userMan, conMan);

		                } else if (user.getRole().getName().equals("obstetrician")) {
		                    ObstetricianMenu.menu(user, userMan, conMan);
		                } else if(user.getRole().getName().equals("labStaff")){
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
	            e.printStackTrace();
	        }
		}
}
