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
	Connection c;
	
	public JDBCLabReportManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addLabReport(LabReport labReport) {
		try {
			String sql= "INSERT INTO labReports (dateTest, pregnant) " + "VALUES(?,?);";
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setDate(1, labReport.getDateTest());
			insert.setBoolean(2, labReport.isPregnant());
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
			String sql = "UPDATE labReports SET" + " dateTest = ?, " + " pregnant = ?, " + " WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setDate(1, report.getDateTest());
			p.setBoolean(2, report.isPregnant());
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		
	}

	@Override
	public LabReport getLabReportById(int id) {
		//no me haria falta que en vez de devolver un labReport, devuelva la lista ?? 
		//tmb le pasaria otra cosa que no fuera el id
		return null;
	}

	@Override
	public List<LabReport> getLabReportsByWoman(Woman woman) {
		List<LabReport> reports= new ArrayList<LabReport>();
		try {
			String sql= "SELECT * FROM reports WHERE name LIKE ? AND surname LIKE ?";
			PreparedStatement p;
			p= c.prepareStatement(sql);
			/* he cogido la estructura de un metodo de woman pero tengo varias dudas
			p.setString(1, "%" + name + "%");
			p.setString(2, "%" + surname + "%");
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				String womanName= rs.getString("name");
				String womanSurname= rs.getString("surname");
				Woman w = new Woman(id, womanName, womanSurname);
				reports.add(w);
			}
			rs.close();
			p.close();
		}catch(SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		*/
		return reports;
		return null;
	}

	@Override
	public List<LabReport> listAllLabReports() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  Date getDateTest(LabReport labReport) {
		//TODO Auto-generated method stub
		return null;
	}

}
