package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.util.List;

import obstetricianclinic.ifaces.LabStaffManager;
import obstetricianclinic.pojos.LabReport;
import obstetricianclinic.pojos.LabStaff;

public class JDBCLabStaffManager implements LabStaffManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCLabStaffManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addLabReport(LabReport report) {
		// TODO Auto-generated method stub

	}

	@Override
	public LabReport getLabReport(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLabReport(LabReport report) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLabReport(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LabReport> listAllLabReports(LabStaff staff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLabStaff(String name, String surname) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLabStaff(String name, String surname) {
		// TODO Auto-generated method stub
		
	}

}
