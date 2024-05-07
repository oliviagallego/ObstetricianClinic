package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import obstetricianclinic.ifaces.PregnancyManager;
import obstetricianclinic.pojos.*;

public class JDBCPregnancyManager implements PregnancyManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCPregnancyManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}
	
	@Override
	public void addPregnancy(Pregnancy pregnancy) {
		try {
		String sql= "INSERT INTO pregnancies (dateConception, birthReport, woman_id) " + "VALUES(?,?,?);";
		PreparedStatement insert= c.prepareStatement(sql);
		insert.setDate(1, pregnancy.getDateConception());
		insert.setString(2, pregnancy.getBirthReport());
		insert.setInt(3, pregnancy.getWoman().getId());
		insert.executeUpdate();
		insert.close();
		}catch(SQLException sqlE) {
			System.out.println("Database exception");
			sqlE.printStackTrace();
		}
	}

	
	@Override
	public List<Pregnancy> searchPregnancyByDateOfConception(Date dateOfConception) {
		List<Pregnancy> pregnancies= new ArrayList<Pregnancy>();
		try {
			String sql= "SELECT * FROM pregnancies WHERE dateOfConception LIKE ?";
			PreparedStatement search= c.prepareStatement(sql);
			search.setDate(1, dateOfConception);
			ResultSet rs= search.executeQuery();
			
			while(rs.next()) {
				Integer pregnancy_id = rs.getInt("id");
				Date dateConception= rs.getDate("dateConception");
				String birthReport= rs.getString("birthReport");
				
				Pregnancy pregnancy= new Pregnancy(pregnancy_id, dateConception, birthReport);
				pregnancies.add(pregnancy);
			}
			search.close();
			rs.close();
		}catch(SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return pregnancies;
	}

	@Override
	public void updatePregnancy(Pregnancy pregnancy) {
		try {
			String sql = "UPDATE pregnancies SET" + " dateConception = ?, " + " birthReport = ?, " + " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setDate(1, pregnancy.getDateConception());
			p.setString(2, pregnancy.getBirthReport());
			p.setInt(3, pregnancy.getId());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}

	@Override
	public List<Pregnancy> searchPregnancyByWoman(int id) {
		List<Pregnancy> list = new ArrayList<Pregnancy>();
		try {
			String sql = "SELECT * FROM pregnancies WHERE woman_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				// Create a new Pregnancy
				Integer pregnancy_id = rs.getInt("id");
				Date dateConception = rs.getDate("dateConception");
				String birthReport = rs.getString("birthReport");
				Pregnancy pg= new Pregnancy(pregnancy_id, dateConception, birthReport);
				list.add(pg);
			}
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return list;
	}

}
