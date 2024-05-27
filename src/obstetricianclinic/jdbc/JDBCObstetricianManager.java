package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.Date;

import obstetricianclinic.pojos.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import obstetricianclinic.ifaces.ObstetricianManager;

public class JDBCObstetricianManager implements ObstetricianManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCObstetricianManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	
	public void addObstetrician(Obstetrician obstetrician) {
		try {
			String query = "INSERT INTO obstetricians (name, surname, username) VALUES (?, ?, ?);";
			PreparedStatement insert = c.prepareStatement(query);
			insert.setString(1, obstetrician.getName());
			insert.setString(2, obstetrician.getSurname());
			insert.setString(3, obstetrician.getUsername());
			
			
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
			String sql = "SELECT * FROM obstetricians WHERE obstetrician_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			String name = rs.getString("name");
			String username= rs.getString("username");
			String surname = rs.getString("surname");
			Obstetrician obs = new Obstetrician(name, username, surname, id);
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
	public List<Obstetrician> searchObstetricianByNameAndSurname(String name, String surname, String username) {
	    List<Obstetrician> listObstetricians = new ArrayList<Obstetrician>();
	    try {
	        String sql = "SELECT * FROM obstetricians WHERE name = ? AND surname = ? AND username = ?";
	        PreparedStatement p = c.prepareStatement(sql);
	        p.setString(1, name);
	        p.setString(2, surname);
	        p.setString(3, username);
	        ResultSet rs = p.executeQuery();

	        while (rs.next()) {
	            Integer obstetrician_id = rs.getInt("obstetrician_id"); // He cambiado el nombre de la columna a la que apunta
	            name = rs.getString("name");
	            surname = rs.getString("surname");
	            username = rs.getString("username");
	            Obstetrician obs = new Obstetrician(name, surname, username, obstetrician_id);
	            listObstetricians.add(obs);
	        }
	        rs.close();
	        p.close();
	    } catch (SQLException e) {
	        System.out.println("Database error.");
	        e.printStackTrace();
	    }
	    return listObstetricians;
	}
	
	@Override
	public Obstetrician getObstetricianFromUser(String username) {
		try {
			String sql = "SELECT * FROM obstetricians WHERE username = ?";
			PreparedStatement p= c.prepareStatement(sql);
            p.setString(1, username);
            ResultSet rs= p.executeQuery();
	        Integer obstetrician_id = rs.getInt("obstetrician_id");
	        String name = rs.getString("name");
            String surname = rs.getString("surname");
            Obstetrician obs= new Obstetrician(name, surname, username, obstetrician_id);
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
	public String getUsername(Obstetrician obstetrician) throws SQLException {
		String sql = "SELECT * FROM obstetricians WHERE username = ?";
		PreparedStatement p = c.prepareStatement(sql);
		p.setString(1, obstetrician.getUsername());
		ResultSet rs = p.executeQuery();
		String name = rs.getString("username");
		rs.close();
		p.close();
		return name;
	}
	

}
