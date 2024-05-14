package obstetricianclinic.ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.jdbc.ConnectionManager;
import obstetricianclinic.pojos.*;
import obstetricianclinic.jpa.*;


public abstract class LogInMenu {

	private static UserManager userMan;
	private static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] Args)  throws NumberFormatException, IOException{
		
		ConnectionManager conMan = new ConnectionManager();
		userMan = new JPAUserManager();

		System.out.print("\nWelcome to the Obstetrician Clinic!");

		while (true) {
			System.out.println("\nLog-In menu:");
			//String username = Utilities.readString(" -Username: ");
			System.out.println("Surname:");
			String username = r.readLine();
			System.out.println("Pasword:");
			String password = r.readLine();
			//String password = Utilities.readString(" -Password: ");

			User user = userMan.logIn(username, password);
			// User user = userMan.logIn("manager", "default0", "manager@obstetricianClinic.com");

			if (user != null) {
                if (user.getRole().getName().equals("manager")) {
                    ManagerMenu.menu(user, userMan, conMan);

                } else if (user.getRole().getName().equals("obstetrician")) {
                    ObstetricianMenu.menu(user, userMan, conMan);
                } else if(user.getRole().getName().equals("lab staff")){
                	 labStaffMenu.menu(user, userMan, conMan);
                }
                else {
                    System.out.println("Access Denied: Your role is not recognized.");
                }
            } else {
                System.out.println("Error: Wrong username or password.");
            }
		}
	}
}
