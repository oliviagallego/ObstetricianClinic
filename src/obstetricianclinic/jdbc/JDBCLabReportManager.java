package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.util.List;

import obstetricianclinic.ifaces.LabReportManager;
import obstetricianclinic.pojos.LabReport;
import obstetricianclinic.pojos.Woman;

public class JDBCLabReportManager implements LabReportManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCLabReportManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addLabReport(LabReport labReport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLabReport(LabReport report) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LabReport getLabReportById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabReport> getLabReportsByWoman(Woman woman) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabReport> listAllLabReports() {
		// TODO Auto-generated method stub
		return null;
	}

}
