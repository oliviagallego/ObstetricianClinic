package obstetricianclinic.jdbc;
import java.ifaces.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obstetricianclinic.pojos.Newborn;
import obstetricianclinic.pojos.Pregnancy;
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
		try {
			String query = "INSERT INTO newborns (name, surname, dob, weight, gender, pregnancyId) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement insert = c.prepareStatement(query);
			insert.setString(1, newborn.getName());
			insert.setString(2, newborn.getSurname());
			insert.setDate(3, newborn.getDob());
			insert.setFloat(4, newborn.getWeight());
			insert.setString(5, newborn.getGender());
			insert.setInt(6, newborn.getPregnancy().getId());
			insert.executeUpdate();
			insert.close();
		}catch(SQLException sqlE) {
			System.out.println("Database exception");
			sqlE.printStackTrace();
		}

	}

	@Override
	public List<Newborn> searchNewbornByDOB(Date dob) {
		List<Newborn> newborns= new ArrayList<Newborn>();
		try {
			String sql= "SELECT * FROM newborns WHERE dob LIKE ?";
			PreparedStatement search= c.prepareStatement(sql);
			search.setDate(1, dob);
			ResultSet rs= search.executeQuery();
			
			while(rs.next()) {
				Integer id = rs.getInt("id");
				String name= rs.getString("name");
				String surname= rs.getString("surname");
				Date dofBirth= rs.getDate("dob");
				Float weight= rs.getFloat("weight");
				String gender= rs.getString("gender");
				
				Newborn newborn= new Newborn(id, name,surname, dofBirth, weight, gender);
				newborns.add(newborn);
			}
			search.close();
			rs.close();
		}catch(SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return newborns;
	}

	@Override
	public void updateNewborn(Newborn newborn) {
		try {
			String sql = "UPDATE newborns SET" + " name = ?, " + " surname = ?, " + " dob = ? " + " weight = ? "+ " gender = ? "+ " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, newborn.getName());
			p.setString(2, newborn.getSurname());
			p.setDate(3, newborn.getDob());
			p.setFloat(4, newborn.getWeight());
			p.setString(5, newborn.getGender());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}

	@Override
	public List<Newborn> searchNewbornByPregnancy(int pregnancyId) {
		// TODO Auto-generated method stub
		return null;
	}

}
