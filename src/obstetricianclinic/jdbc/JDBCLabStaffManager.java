package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import obstetricianclinic.ifaces.LabStaffManager;
import obstetricianclinic.pojos.LabReport;
import obstetricianclinic.pojos.LaboratoryStaff;

public class JDBCLabStaffManager implements LabStaffManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCLabStaffManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}


	@Override
	public void addLabStaff(LaboratoryStaff staff) {
		try {
			String sql= "INSERT INTO laboratoryStaffs (name, surname) " + "VALUES(?,?);"; 
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setString(1, staff.getName());
			insert.setString(2, staff.getSurname());
			insert.executeUpdate();
			insert.close();
			
			}catch(SQLException sqlE) {
				System.out.println("Database exception");
				sqlE.printStackTrace();
		}
	}

	@Override
	public void updateLabStaff(LaboratoryStaff staff) {
		try {
			String sql = "UPDATE ... SET" + " name = ?, " + " surname = ?, " + " WHERE id = ?"; //me pasa lo mismo no sé donde guardarlo
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, staff.getName());
			p.setString(2, staff.getSurname());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}		
	}

}
