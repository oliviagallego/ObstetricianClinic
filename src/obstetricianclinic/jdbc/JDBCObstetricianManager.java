package obstetricianclinic.jdbc;

import java.sql.Connection;

import obstetricianclinic.ifaces.ObstetricianManager;

public class JDBCObstetricianManager implements ObstetricianManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCObstetricianManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addObstetrician(String name, String specialization) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObstetrician(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateObstetrician(int id, String newName, String newSpecialization) {
		// TODO Auto-generated method stub

	}

}
