package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obstetricianclinic.ifaces.DiseaseManager;
import obstetricianclinic.pojos.Disease;
import obstetricianclinic.pojos.Woman;

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
			String sql= "INSERT INTO diseases (type_Disease) " + "VALUES(?);";
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
			String sql = "UPDATE diseases SET" + " type_Disease = ?, " + " WHERE disease_id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setString(1, disease.getDiseaseType());
			p.setInt(2, disease.getId());
			
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}

	@Override
	public List<Disease> searchDiseaseByName(String diseaseType) {
		List<Disease> listDiseases= new ArrayList<Disease>();
		try {
			String sql = "SELECT * FROM diseases WHERE type_Disease = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, "%"+diseaseType+"%");
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				Integer disease_id= rs.getInt("disease_id");
				String Type= rs.getString("type_Disease");
				Disease d= new Disease(disease_id, Type);
				listDiseases.add(d);
			}
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return listDiseases;
	
	}

}