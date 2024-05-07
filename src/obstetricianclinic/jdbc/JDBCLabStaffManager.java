package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

			String sql= "INSERT INTO labStaffs (name, surname) " + "VALUES(?,?);"; 
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setString(1, labStaff.getName());
			insert.setString(2, labStaff.getSurname());
			
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

			String sql = "UPDATE labStaffs SET" + " name = ?, " + " surname = ?, " + " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, labStaff.getName());
			p.setString(2, labStaff.getSurname());
			p.setInt(3, labStaff.getId());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}

	}
}
