package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obstetricianclinic.ifaces.LabStaffManager;
import obstetricianclinic.pojos.LabReport;
import obstetricianclinic.pojos.LaboratoryStaff;
import obstetricianclinic.pojos.Woman;

public class JDBCLabStaffManager implements LabStaffManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCLabStaffManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}
	/* Voy a añadiría un método para añadir LabStaff pq como tal en ningún momento creamos uno
	public void addLabStaff(LaboratoryStaff labStaff) {
		try {
			String query = "INSERT INTO (lista de laboratory staff) (name, surname, id) VALUES (?, ?, ?);";
			PreparedStatement insert = c.prepareStatement(query);
			insert.setString(1, labStaff.getName());
			insert.setString(2, labStaff.getSurname());
			insert.setInt(3, labStaff.getId());
			insert.executeUpdate();
			insert.close();
		}catch(SQLException sqlE) {
			System.out.println("Database exception");
			sqlE.printStackTrace();
		}
	}
	
	*/
	@Override
	public void addLabReport(LabReport report) {
		try {
			String sql= "INSERT INTO labReports (dateTest, pregnant) " + "VALUES(?,?);";
			PreparedStatement insert= c.prepareStatement(sql);
			insert.setDate(2, report.getDateTest()); //no se pq no me deja
			insert.setBoolean(3, report.isPregnant());
			
			insert.executeUpdate();
			insert.close();
			
			}catch(SQLException sqlE) {
				System.out.println("Database exception");
				sqlE.printStackTrace();
			}
	}

	@Override
	public LabReport getLabReport(int id) {
		// este método no está ya en el pojo de LabReport?
		return null;
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
	public void deleteLabReport(int id) {
		try {
			String sql = "DELETE FROM labReports WHERE id = ?";
			PreparedStatement p;
			p = c.prepareStatement(sql);
			p.setInt(1, id);
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}

	@Override
	public List<LabReport> listAllLabReports(LaboratoryStaff staff) {
		// Creo que está mal, según el moc up se busca por date of test, voy a hacer otro  
		return null;
	}

	//Se puede borrar pero es la que yo añadiría
	@Override
	public List<LabReport> searchLabReportByDateOfTest(Date dateOfTest) {
		List<LabReport> labReports= new ArrayList<LabReport>();
		try {
			String sql= "SELECT * FROM labReports WHERE dateOfTest LIKE ?";
			PreparedStatement p;
			p= c.prepareStatement(sql);
			p.setString(1, "%" + dateOfTest + "%");
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				Date dateOfTest= rs.getDate("dateOfTest");
				Pregnant pregnant= rs.getPregnant("pregnant");//me pide que haga cast no se porque
				LabReport r = new LabReport(id, dateOfTest, pregnant);
				labReports.add(r);
			}
			rs.close();
			p.close();
		}catch(SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return labReports;
	}

}
