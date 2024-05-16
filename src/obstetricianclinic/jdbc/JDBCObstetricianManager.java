package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.Date;

import obstetricianclinic.pojos.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
	public Obstetrician getObstetrician(int id) {
		try {
			String sql = "SELECT * FROM obstetricians WHERE id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			Obstetrician obs = new Obstetrician(name, surname, id);
			rs.close();
			p.close();
			return obs;
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public List<Obstetrician> searchObstetricianByNameAndSurname(String name, String surname) {
		List<Obstetrician> listObstetricians = new ArrayList<Obstetrician>();
		try {
			String sql = "SELECT * FROM obstetricians WHERE  (name, surname) VALUES (?, ?);";
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, name);
			p.setString(2, surname);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Integer obstetrician_id= rs.getInt("id");
				name= rs.getString("name");
				surname= rs.getString("surname");
				Obstetrician obs = new Obstetrician(name, surname,obstetrician_id);
				listObstetricians.add(obs);
			}
			
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return listObstetricians;
	}
	

}
