package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import obstetricianclinic.ifaces.LabStaffManager;
import obstetricianclinic.pojos.*;

public class JDBCLabStaffManager implements LabStaffManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCLabStaffManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addLabStaff(LabStaff labStaff) {
		try {

			String sql= "INSERT INTO labStaffs (name, surname,username) " + "VALUES(?, ?, ?);"; 
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setString(1, labStaff.getName());
			insert.setString(2, labStaff.getSurname());
			insert.setString(3, labStaff.getUsername());
			
			insert.executeUpdate();
			insert.close();
			
			}catch(SQLException sqlE) {
				System.out.println("Database exception");
				sqlE.printStackTrace();
			}
		
	}

	
	
	@Override
	public void updateLabStaff(LabStaff labStaff) {
		try {

			String sql = "UPDATE labStaffs SET" + " name = ?, " +  " surname = ?, " + "username = ?" +" WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, labStaff.getName());
			p.setString(2, labStaff.getSurname());
			p.setString(3, labStaff.getUsername());
			p.setInt(4, labStaff.getId());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}

	}
	
	@Override
	public List<LabStaff> searchLabStaffByNameAndSurname(String name, String surname, String username) {
		List<LabStaff> listLabStaff = new ArrayList<LabStaff>();
		try {
			String sql = "SELECT * FROM labStaffs WHERE  (name, surname,username) VALUES (?, ?, ?);";
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, name);
			p.setString(2, surname);
			p.setString(3, username);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Integer labStaff_id= rs.getInt("id");
				name= rs.getString("name");
				surname= rs.getString("surname");
				username= rs.getString("username");
				LabStaff labStaff = new LabStaff(labStaff_id, name, surname,username);
				listLabStaff.add(labStaff);
			}
			
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return listLabStaff;
	}

	@Override
	public LabStaff getLabStaffFromUser(String username) {
		try {
			String sql = "SELECT * FROM labStaffs WHERE username = ?";
			PreparedStatement p= c.prepareStatement(sql);
            p.setString(1, username);
            ResultSet rs= p.executeQuery();
            LabStaff labStaffs= new LabStaff(username);
    		return labStaffs;
        } catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return null;
	}
}
