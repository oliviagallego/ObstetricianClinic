package obstetricianclinic.jdbc;

import java.sql.Connection;

import obstetricianclinic.ifaces.DrugManager;

public class JDBCDrugManager implements DrugManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCDrugManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addDrug(String name, String description) {
		// TODO Auto-generated method stub

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
