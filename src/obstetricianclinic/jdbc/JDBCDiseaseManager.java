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
	public void addDisease(Disease disease) {
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
	public void removeDisease(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDisease(int id, String newName) {
		// TODO Auto-generated method stub

	}

}