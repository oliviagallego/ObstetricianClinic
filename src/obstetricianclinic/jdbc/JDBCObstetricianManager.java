package obstetricianclinic.jdbc;

import java.sql.Connection;
import obstetricianclinic.pojos.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import obstetricianclinic.ifaces.ObstetricianManager;

public class JDBCObstetricianManager implements ObstetricianManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCObstetricianManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addObstetrician(Obstetrician obstetrician) {
	try {
		String query = "INSERT INTO obstetricians (name, surname) VALUES (?, ?);";
		PreparedStatement insert = c.prepareStatement(query);
		insert.setString(1, obstetrician.getName());
		insert.setString(2, obstetrician.getSurname());
		insert.executeUpdate();
		insert.close();
	}catch(SQLException sqlE) {
		System.out.println("Database exception");
		sqlE.printStackTrace();
	}
	
	}

	@Override
	public void updateObstetrician(Obstetrician obs){
		try {
			String sql = "UPDATE obstetricians SET" + " name = ?, " + " surname = ?, " + " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, obs.getName());
			p.setString(2, obs.getSurname());
			p.setInt(3, obs.getId());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}

}
