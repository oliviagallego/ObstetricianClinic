package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obstetricianclinic.ifaces.LabReportManager;
import obstetricianclinic.pojos.LabReport;
import obstetricianclinic.pojos.Woman;

public class JDBCLabReportManager implements LabReportManager {
	private ConnectionManager conMan;
	private Connection c;
	
	public JDBCLabReportManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addLabReport(LabReport labReport) {
		try {
			String sql= "INSERT INTO labReports (date_test, pregnant, woman_id, labStaff_id) " + "VALUES(?,?,?,?);";
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setDate(1, labReport.getDate_Test());
			insert.setBoolean(2, labReport.isPregnant());
			insert.setInt(3, labReport.getWoman().getId());
			insert.setInt(4, labReport.getLabStaff().getId());
			insert.executeUpdate();
			insert.close();
			
			}catch(SQLException sqlE) {
				System.out.println("Database exception");
				sqlE.printStackTrace();
		}		
	}

	@Override
	public void updateLabReport(LabReport report) {
		try {
			String sql = "UPDATE labReports SET" + " date_Test = ?, " + " pregnant = ?, " + " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setDate(1, report.getDate_Test());
			p.setBoolean(2, report.isPregnant());
			p.setInt(3, report.getId());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<LabReport> searchLabReportByWoman(int id) {
		List<LabReport> list = new ArrayList<LabReport>();
		try {
			String sql = "SELECT * FROM labReports WHERE woman_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				// Create a new LabReport
				Integer laboratoryReport_id = rs.getInt("laboratoryReport_id");
				Date date_Test = rs.getDate("date_test");
				Boolean pregnant = rs.getBoolean("pregnant");
				LabReport labReport = new LabReport(laboratoryReport_id, date_Test, pregnant);
				list.add(labReport);
			}
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<LabReport> searchLabReportByLabStaff(int id) {
		List<LabReport> list = new ArrayList<LabReport>();
		try {
			String sql = "SELECT * FROM labReports WHERE labStaff_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				// Create a new LabReport
				Integer labReport_id = rs.getInt("id");
				Date date_Test = rs.getDate("dateTest");
				Boolean pregnant = rs.getBoolean("pregnant");
				LabReport labReport = new LabReport(labReport_id, date_Test, pregnant);
				list.add(labReport);
			}
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return list;
	}

}
