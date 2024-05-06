package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


import obstetricianclinic.ifaces.WomanManager;
import obstetricianclinic.pojos.Woman;

public class JDBCWomanManager implements WomanManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCWomanManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void registerWoman(Woman woman) {
		try {
			String sql= "INSERT INTO women (name, surname, dob, weight, obstetrician_id) " + "VALUES(?,?,?,?,?);";
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setString(1, woman.getName());
			insert.setString(2, woman.getSurname());
			insert.setDate(3, woman.getDob());
			insert.setFloat(4, woman.getWeight());
			insert.setInt(5, woman.getObstetrician().getId());

			
			insert.executeUpdate();
			insert.close();
			
		}catch(SQLException sqlE) {
				System.out.println("Database exception");
				sqlE.printStackTrace();
		}

	}

	@Override
	public void deleteWoman(int id) {
		try {
			String sql = "DELETE FROM womans WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setInt(1, id);
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}

	}

	@Override
	public List<Woman> searchWomanByNameAndSurname(String name, String surname) {
		List<Woman> women= new ArrayList<Woman>();
		try {
			String sql= "SELECT * FROM women WHERE name LIKE ? AND surname LIKE ?";
			PreparedStatement p;
			p= c.prepareStatement(sql);
			p.setString(1, "%" + name + "%");
			p.setString(2, "%" + surname + "%");
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				String womanName= rs.getString("name");
				String womanSurname= rs.getString("surname");
				Woman w = new Woman(id, womanName, womanSurname);
				women.add(w);
			}
			rs.close();
			p.close();
		}catch(SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return women;
	}

	@Override
	public void updateWoman(Woman woman) {
		try {
			String sql = "UPDATE women SET" + " name = ?, " + " surname = ?, " + " dob = ? " + " weight = ? "+ " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, woman.getName());
			p.setString(2, woman.getSurname());
			p.setDate(3, woman.getDob());
			p.setFloat(4, woman.getWeight());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}

	}

	@Override
	public Woman viewWoman(int id) {
		try {
			String sql = "SELECT * FROM women WHERE id = ?";
			PreparedStatement p;
			p= c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			String name= rs.getString("name");
			String surname= rs.getString("surname");
			Date dob = rs.getDate("dob");
			Float weight= rs.getFloat("weight");
			Woman w= new Woman(id, name, surname, dob, weight);
			rs.close();
			p.close();
			return w;
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return null;
	}


}
