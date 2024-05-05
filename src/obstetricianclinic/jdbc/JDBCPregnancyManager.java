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
	public void addPregnancy(Date dateOfConception) {
		try {
		String sql= "INSERT INTO pregnancies (dateConception) " + "VALUES(?);";
		PreparedStatement insert= c.prepareStatement(sql);
		insert.setDate(1, dateOfConception);
		
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
				Integer id = rs.getInt("id");
				Date dateTest = rs.getDate("dateTest");
				Date dateConception= rs.getDate("dateConception");
				String laboratoryResult= rs.getString("laboratoryResult");
				String birthReport= rs.getString("birthReport");
				List<Newborn> newborns= conMan.getNewbornMan();//???
				Woman woman= conMan.getWomanMan().getWoman();//????
				
				Pregnancy pregnancy= new Pregnancy(id, dateTest, dateConception, laboratoryResult, birthReport, newborns, woman);
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
	public void addBirthReport(String birthReport, Pregnancy pregnancy) {
		// Esto como lo gestionamos? va aquí?
		
	}

	@Override
	public void updatePregnancy(Pregnancy pregnancy) {
		try {
			String sql = "UPDATE pregnancies SET" + " dateTest = ?, " + " birthReport = ?, " + " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setDate(1, pregnancy.getDateTest());
			p.setString(2, pregnancy.getBirthReport());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		
	}

}
