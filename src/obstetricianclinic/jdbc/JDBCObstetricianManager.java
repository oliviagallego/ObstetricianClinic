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
		String query = "INSERT INTO obstetricians (name, surname, password, id) VALUES (?, ?, ?, ?);";
		PreparedStatement insert = c.prepareStatement(query);
		insert.setString(1, obstetrician.getName());
		insert.setString(2, obstetrician.getSurname());
		insert.setString(3, obstetrician.getPassword());
		insert.setInt(4, obstetrician.getId());
		insert.executeUpdate();
		insert.close();
	}catch(SQLException sqlE) {
		System.out.println("Database exception");
		sqlE.printStackTrace();
	}

	}

	@Override
	public void removeObstetrician(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObstetrician(int id, String newName, String newSpecialization) {
		// TODO Auto-generated method stub

	}

}
