package obstetricianclinic.ui;
import obstetricianclinic.ifaces.UserManager;


public abstract class LogInMenu {

	private static UserManager userMan;

	public static void main(String[] Args) {

		userMan = new JPAUserManager();
		System.out.print("\nWelcome to the Obstetrician Clinic!");

		while (true) {
			System.out.println("\nLog-In menu:");
			String username = Utilities.readString(" -Username: ");
			String password = Utilities.readString(" -Password: ");

			User user = userMan.logIn(username, password);
			// User user = userMan.logIn("manager", "default0", "manager@bloodBank.com");

			if (user != null) {
				if (user.getRole().getName().equals("manager")) {
					ManagerMenu.menu(user, userMan);
				}
				if (user.getRole().getName().equals("nurse")) {
					NurseMenu.menu(user.getEmail());
				}
			} else {
				System.out.println("Error: Wrong username or password.");
			}
		}
	}
}
