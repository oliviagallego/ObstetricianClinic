package obstetricianclinic.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import obstetricianclinic.pojos.*;
import obstetricianclinic.ifaces.NewbornManager;
import java.sql.Date;

public class JDBCNewbornManager implements NewbornManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCNewbornManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addNewborn(Newborn newborn) {
	  

		try  {
			String query = "INSERT INTO newborns (name, surname, dob, weight, gender, pregnancy_id) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement insert = c.prepareStatement(query);
            insert.setString(1, newborn.getName());
            insert.setString(2, newborn.getSurname());
            insert.setDate(3, newborn.getDob());
            insert.setFloat(4, newborn.getWeight());
            insert.setString(5, newborn.getGender());
            insert.setInt(6, newborn.getPregnancy().getId());
            insert.executeUpdate();
            System.out.println("Newborn successfully added to the database.");
	    } catch (SQLException sqlE) {
	        System.out.println("Database exception");
	        sqlE.printStackTrace();
	    }
	}

	@Override
	public void updateNewborn(Newborn newborn) {
		try {
			String sql = "UPDATE newborns SET" + " name = ?, " + " surname = ?, " + " dob = ?, " + " weight = ?, " + " gender = ? "+ " WHERE newborn_id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, newborn.getName());
			p.setString(2, newborn.getSurname());
			p.setDate(3, newborn.getDob());
			p.setFloat(4, newborn.getWeight());
			p.setString(5, newborn.getGender());
			p.setInt(6, newborn.getId());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}

	@Override
	public List<Newborn> searchNewbornByPregnancy(int id) {
		List<Newborn> list= new ArrayList<Newborn>();
		try {
			String sql = "SELECT * FROM newborns WHERE pregnancy_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				
				Integer newborn_id = rs.getInt("newborn_id");
				String name = rs.getString("name");
				String surname= rs.getString("surname");
				Date dob = rs.getDate("dob");
				Float weight= rs.getFloat("weight");
				String gender = rs.getString("gender");
				Newborn newborn = new Newborn(newborn_id, name, surname, dob, weight, gender);
				list.add(newborn);
			}
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Newborn getNewborn(int id) {
		try {
			String sql = "SELECT * FROM newborns WHERE newborn_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			rs.next();
			String name= rs.getString("name");
			String surname = rs.getString("surname");
			Date dob = rs.getDate("dob");
			Float weight= rs.getFloat("weight");
			String gender = rs.getString("gender");
			Newborn newborn = new Newborn(name, surname, dob, weight, gender);
			rs.close();
			p.close();
			return newborn;
		}catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		return null;
		}
	}

}
