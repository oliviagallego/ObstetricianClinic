package obstetricianclinic.ifaces;

import java.util.List;

import obstetricianclinic.pojos.*;

public interface UserManager {

	public void register(User user);
	public void assignRole(User user, Role role);
	
	public Role getRole(String name);
	public List<Role> getRoles();
	
	public User logIn(String name, String password);
	public void logOut();
	public User changePassword(User user, String newPassword);
}