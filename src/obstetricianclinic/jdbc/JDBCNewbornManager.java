package obstetricianclinic.jdbc;

import java.sql.Connection;

import obstetricianclinic.ifaces.NewbornManager;

public class JDBCNewbornManager implements NewbornManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCNewbornManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addNewBorn(String name, String surname, float weight, String gender) {
		// TODO Auto-generated method stub

	}

}
