package obstetricianclinic.ifaces;

import java.util.List;

import obstetricianclinic.pojos.*;

public interface UserManager {

	public void register(User user);
	public void createRole(Role role);
	public Role getRole(String name);
	public void assignRole(User user, Role role);
	public List<Role> getAllRoles();
	//Return null if there is no user
	public User logIn(String username, String password);
	public void logOut();
	public User changePassword(User username, String newPassword);
}