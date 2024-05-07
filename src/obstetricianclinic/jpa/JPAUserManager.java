package obstetricianclinic.jpa;

import java.util.List;

import javax.persistence.*;

import obstetricianclinic.ifaces.UserManager;
import obstetricianclinic.pojos.Role;
import obstetricianclinic.pojos.User;

public class JPAUserManager implements UserManager {
	private EntityManager em;
	

	public JPAUserManager() {
		em= Persistence.createEntityManagerFactory("obstetricianclinic-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void register(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	@Override
	public void createRole(Role role) {
		em.getTransaction().begin();
		em.persist(role);
		em.getTransaction().commit();
	}

	@Override
	public Role getRole(String name) {
		Query q = em.createNativeQuery("SELECT FROM roles WHERE name LIKE ?", Role.class);
		q.setParameter(1, name);
		Role role= (Role) q.getSingleResult();
		return role;
	}
	
	@Override
	public List<Role> getAllRoles() {
		Query q= em.createNativeQuery("SELECT * FROM roles", Role.class);
		List<Role> roles= (List<Role>) q.getResultList();
		return roles;
	}

	@Override
	public void assignRole(User user, Role role) {
		em.getTransaction().begin();
		user.setRole(role);//assign role to user
		//add User to List of Users in Role
		role.addUser(user);
		em.getTransaction().commit();

	}

	@Override
	public User logIn(String username, String password) {
		Query q = em.createNativeQuery("SELECT FROM users WHERE username = ? AND password = ?",User.class);
		q.setParameter(1, username);
		q.setParameter(2, password);
		//TODO remember to provide bad password to see what happens
		User user= (User) q.getSingleResult();
		return user;
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public User changePassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
