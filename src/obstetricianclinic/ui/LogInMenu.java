package obstetricianclinic.ui;
import java.io.IOException;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.pojos.*;
import obstetricianclinic.jpa.*;


public abstract class LogInMenu {

	private static UserManager userMan;

	public static void main(String[] Args)  throws NumberFormatException, IOException{

		userMan = (UserManager) new JPAUserManager();
		System.out.print("\nWelcome to the Obstetrician Clinic!");

		while (true) {
			System.out.println("\nLog-In menu:");
			String username = Utilities.readString(" -Username: ");
			String password = Utilities.readString(" -Password: ");

			User user = userMan.logIn(username, password);
			// User user = userMan.logIn("manager", "default0", "manager@obstetricianClinic.com");

			if (user != null) {
                if (user.getRole().getName().equals("manager")) {
                    ManagerMenu.menu(userMan);
                } else if (user.getRole().getName().equals("obstetrician")) {
                    ObstetricianMenu.menu(user, userMan);
                } else if(user.getRole().getName().equals("lab staff")){
                	 labStaffMenu.menu(user, userMan);
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
