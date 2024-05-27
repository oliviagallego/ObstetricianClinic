package obstetricianclinic.jpa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.*;

import obstetricianclinic.ifaces.UserManager;
import obstetricianclinic.pojos.Obstetrician;
import obstetricianclinic.pojos.Role;
import obstetricianclinic.pojos.User;
	
public class JPAUserManager implements UserManager {
		private EntityManager em;
		
		public JPAUserManager() {
			em= Persistence.createEntityManagerFactory("obstetricianclinic-provider").createEntityManager();
			em.getTransaction().begin();
			em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
			em.getTransaction().commit();
			
			try {
				this.getRole("manager");
			}catch(NoResultException e) {
				this.createRole(new Role("obstetrician"));
				this.createRole(new Role("labStaff"));
				this.createRole(new Role("manager"));
			}
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
			Query q = em.createNativeQuery("SELECT * FROM roles WHERE name LIKE ?", Role.class);
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
			User u =null;
			Query q = em.createNativeQuery("SELECT * FROM users WHERE username = ? AND password = ?",User.class);
			q.setParameter(1, username);
			q.setParameter(2, password);
			try {
				u= (User) q.getSingleResult();
			}catch(NoResultException e) {
				return null;
			}
			return u;
		}
		
		@Override
		public User changePassword(User user, String newPassword) {
			
			try {
				Query q = em.createNativeQuery("SELECT * FROM users WHERE username = ? AND password = ?",User.class);
				q.setParameter(1, user.getUsername());
				q.setParameter(2, user.getPassword());
				user= (User) q.getSingleResult();

				em.getTransaction().begin();
				user.setPassword(newPassword);
				em.getTransaction().commit();
				return user;
				
			}catch(NoResultException e) {
				return null;
			}
		}
	
		
		public void logOut() {
			em.close();
		}
		
		@Override
		public String encryptPassword(String password) {
		    try {
		        
		        MessageDigest md = MessageDigest.getInstance("SHA-256");

		        
		        byte[] hashedBytes = md.digest(password.getBytes());


		        StringBuilder sb = new StringBuilder();
		        for (byte b : hashedBytes) {
		            sb.append(String.format("%02x", b));
		        }

		        return sb.toString(); 
		    } catch (NoSuchAlgorithmException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
	
}
