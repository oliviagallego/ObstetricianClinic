package obstetricianclinic.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import obstetricianclinic.ifaces.UserManager;
import obstetricianclinic.pojos.Role;
import obstetricianclinic.pojos.User;

public class ManagerMenu {
	
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

}
