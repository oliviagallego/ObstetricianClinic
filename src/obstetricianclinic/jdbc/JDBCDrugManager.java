package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import obstetricianclinic.ifaces.DrugManager;
import obstetricianclinic.pojos.Drug;

public class JDBCDrugManager implements DrugManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCDrugManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addDrug(Drug drug) {
		try {
			String sql= "INSERT INTO drugs (drugName, drugType) " + "VALUES(?,?);";
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setString(1, drug.getDrugName());
			insert.setString(2, drug.getDrugType());
			
			insert.executeUpdate();
			insert.close();
			
			}catch(SQLException sqlE) {
				System.out.println("Database exception");
				sqlE.printStackTrace();
			}

	}

	@Override
	public void removeDrug(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateDrug(int id, String newName, String newDescription) {
		// TODO Auto-generated method stub

	}

}
