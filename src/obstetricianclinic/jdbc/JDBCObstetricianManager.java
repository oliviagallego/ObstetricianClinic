package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.Date;

import obstetricianclinic.pojos.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dogclinic.pojos.Dog;
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
	
	//He añadido este método que nos faltaba 
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
	
	//Meteria un metodo para buscar Obstetrician PERO NO SE QUE 
	
	public List<Obstetrician> searchObstetricianByNameAdnSurname(String name, String Surname) {
		List<Obstetrician> listObstetricians = new ArrayList<Obstetrician>();
		try {
			String sql = "SELECT * FROM obstetricians WHERE name = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Integer obstetrician_id= rs.getInt("id");
				String name= rs.getString("name");
				String surname= rs.getString("surname");
			
				Woman w= new Woman(woman_id, name, surname, dob, weight);
				listObstetricians.add(w);
			}
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return listObstetricians;
	}

	
	

}
