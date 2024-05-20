package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.Date;

import obstetricianclinic.pojos.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	@Override
	/*public void addObstetrician(Obstetrician obstetrician) throws SQLException {
	    try {
	        if (obstetrician.getUsername() == null || obstetrician.getUsername().trim().isEmpty()) {
	            throw new IllegalArgumentException("Username must not be null or empty");
	        }
	        if (obstetricianExists(obstetrician.getUsername())) {
	            System.out.println("An obstetrician with this username already exists. Please use a different username.");
	            return;
	        }
	        
	        String query = "INSERT INTO obstetricians (name, surname, username) VALUES (?, ?, ?);";
	        try (PreparedStatement insert = c.prepareStatement(query)) {
	            insert.setString(1, obstetrician.getName());
	            insert.setString(2, obstetrician.getSurname());
	            insert.setString(3, obstetrician.getUsername());
	            insert.executeUpdate();
	            System.out.println("Obstetrician successfully added to the database.");
	        }
	    } catch (SQLException sqlE) {
	        System.out.println("Database exception");
	        sqlE.printStackTrace();
	    }
	}*/
	public void addObstetrician(Obstetrician obstetrician) {
		if (checkUsernameExists(obstetrician.getUsername())) {
	        System.out.println("Username already exists. Please choose a different username.");
	        return;
	    }
	    String sql = "INSERT INTO obstetricians (name, surname, username) VALUES (?, ?, ?)";
	    try (Connection conn = this.conMan.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, obstetrician.getName());
	        pstmt.setString(2, obstetrician.getSurname());
	        pstmt.setString(3, obstetrician.getUsername());
	        int affectedRows = pstmt.executeUpdate();
	        if (affectedRows > 0) {
	            System.out.println("Obstetrician successfully added to the database.");
	        } else {
	            System.out.println("Failed to add the obstetrician to the database.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Database error during obstetrician registration.");
	        e.printStackTrace();
	    }
	}


	public boolean checkUsernameExists(String username) {
	    String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
	    try (Connection conn = this.conMan.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, username);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1) > 0;
	        }
	    } catch (SQLException e) {
	        System.out.println("Database error during username check.");
	        e.printStackTrace();
	        throw new RuntimeException("Failed to check if username exists", e);
	    }
	    return false;
	}



	@Override
	public Obstetrician getObstetrician(int id) {
		String sql = "SELECT * FROM obstetricians WHERE id = ?";
	    try (PreparedStatement p = c.prepareStatement(sql)) {
	        p.setInt(1, id);
	        try (ResultSet rs = p.executeQuery()) {
	            if (rs.next()) {
	            	
	                String name = rs.getString("name");
	                String surname = rs.getString("surname");
	                String username = rs.getString("username");
	                return new Obstetrician(name, surname, username, id);
	            } else {
	                System.out.println("No obstetrician found with the given ID.");
	                return null;
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	        e.printStackTrace();
	        return null;
	    }
	}
	

	@Override //Lo he corregido por que salia el error: SQL error or missing database (near ",": syntax error)
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
    		return obs;
        } catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return null;
	}

}
