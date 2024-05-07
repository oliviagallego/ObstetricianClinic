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

			oman_id= rs.getInt("id");
				String name= rs.getString("name");
				String surname= rs.getString("surname");
				Date dob = rs.getDate("dob");
	
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
			String sql = "DELETE FROM women WHERE id = ?";
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
	public void updateWoman(Woman woman) {
		try {
			String sql = "UPDATE women SET" + " name = ?, " + " surname = ?, " + " dob = ? " + " weight = ? "+ " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, woman.getName());
			p.setString(2, woman.getSurname());
			p.setDate(3, woman.getDob());
			p.setFloat(4, woman.getWeight());
			p.setInt(5, woman.getId());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}

	}

	@Override
	public List<Woman> searchWomanByObstetrician(int id) {
		List<Woman> list = new ArrayList<Woman>();
		try {
			String sql = "SELECT * FROM women WHERE obstetrician_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				// Create a new Woman
				Integer w			Float weight= rs.getFloat("weight");
				Woman w= new Woman(woman_id, name, surname, dob, weight);
				list.add(w);
			}
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void assignWomanToDisease(int woman_id, int disease_id) {
		try {
			String sql = "INSERT INTO women_diseases (woman_id, disease_id) VALUES (?,?)";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, woman_id);
			p.setInt(2, disease_id);
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		
	}

	@Override
	public Woman getWoman(int id) {
		try {
			String sql = "SELECT * FROM women WHERE id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			String name = rs.getString("name");
			String surname= rs.getString("surname");
			Date dob = rs.getDate("dob");
			Float weight= rs.getFloat("weight");
			Woman w= new Woman(name, surname, dob, weight);
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
