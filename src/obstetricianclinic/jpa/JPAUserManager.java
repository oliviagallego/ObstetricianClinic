package obstetricianclinic.jpa;

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
		initializeRoles();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		//Create default roles
		//if they don't exist already
		try {
			this.getRole("obstetrician");
		}catch(NoResultException e) {
			this.createRole(new Role("obstetrician"));
			this.createRole(new Role("labStaff"));
			this.createRole(new Role("manager"));
		}
		
	}
	
	private void initializeRoles() {
        em.getTransaction().begin();
        try {
            String[] roleNames = {"obstetrician", "labStaff", "manager"};
            for (String roleName : roleNames) {
                try {
                    getRole(roleName);
                } catch (NoResultException e) {
                    createRole(new Role(roleName));
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
	
	@Override
    /*public void register(User user) {
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }*/
	public void register(User user, String roleName) {
        Role role = getRole(roleName);
        if (role == null) {
            role = new Role(roleName);
            createRole(role);
        }
        user.setRole(role);
        em.getTransaction().begin();
        try {
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void createRole(Role role) {
        em.getTransaction().begin();
        try {
            em.persist(role);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

	@Override
	public Role getRole(String name) {
		Query q = em.createNativeQuery("SELECT * FROM roles WHERE name LIKE ?", Role.class);
		q.setParameter(1, name);
		q.getSingleResult();
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
        try {
            user.setRole(role);
            role.addUser(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

	@Override
	public User logIn(String username, String password) {
		User u =null;
		Query q = em.createNativeQuery("SELECT * FROM users WHERE username = ? AND password = ? ",User.class);
		q.setParameter(1, username);
		q.setParameter(2, password);
		q.getSingleResult();
		try {
			u= (User) q.getSingleResult();
			
		}catch(NoResultException e) {
			return null;
		}
		
		return u;
	}

	@Override
	public User changePassword(User user, String newPassword) {
		em.getTransaction().begin();
        try {
            user.setPassword(newPassword);
            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
	}

	public void logOut() {
		if (em.isOpen()) {
            em.close();
        }
	}
	
	@Override
    public User getUser(String username) {
		User u =null;
		Query q = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        q.setParameter("username", username);
        q.getSingleResult();
        try {
        	u= (User) q.getSingleResult();
			return u;
		}catch(NoResultException e) {
			return null;
		}
    }
	

}
