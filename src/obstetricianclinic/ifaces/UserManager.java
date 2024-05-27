package obstetricianclinic.ifaces;

import java.util.List;

import obstetricianclinic.pojos.*;

public interface UserManager {

	public void register(User user);
	public void createRole(Role role);
	public Role getRole(String name);
	public void assignRole(User user, Role role);
	public List<Role> getAllRoles();
	public User logIn(String username, String password);
	public void logOut();
	public User changePassword(User username, String newPassword);
	public String encryptPassword(String password);
}