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
}
