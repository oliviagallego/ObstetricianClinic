package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import obstetricianclinic.ifaces.DiseaseManager;
import obstetricianclinic.pojos.Disease;

public class JDBCDiseaseManager implements DiseaseManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCDiseaseManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addDisease(Disease disease) { //
		try {
			String sql= "INSERT INTO diseases (diseaseType) " + "VALUES(?);";
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setString(1, disease.getDiseaseType());
			insert.executeUpdate();
			insert.close();
			
			}catch(SQLException sqlE) {
				System.out.println("Database exception");
				sqlE.printStackTrace();
			}

	}
	

	@Override
	public void updateDisease(Disease disease) {
		try {
			String sql = "UPDATE diseases SET" + " DiseaseType = ?, " + " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, disease.getDiseaseType());
	
			
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}
	
	@Override
	public void assignDiseaseToWoman(int disease_id, int woman_id) {
		try {
			String sql = "INSERT INTO woman_diseases(disease_Id, woman_Id) VALUES (?,?)";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, disease_id);
			p.setInt(2, woman_id);
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}
}
