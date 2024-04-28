package obstetricianclinic.jdbc;

import java.sql.Connection;

import obstetricianclinic.ifaces.DiseaseManager;

public class JDBCDiseaseManager implements DiseaseManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCDiseaseManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addDisease(String name) {
		// TODO Auto-generated method stub

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
