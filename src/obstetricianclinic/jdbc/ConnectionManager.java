package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import obstetricianclinic.ifaces.*;

public class ConnectionManager {
	
	private Connection c;
	private PregnancyManager pregnancyMan;
	private WomanManager womanMan;
	private NewbornManager newbornMan;
	private ObstetricianManager obstetricianMan;
	private DiseaseManager diseaseMan;
	private LabReportManager labReportMan;
	private LabStaffManager labStaffMan;
	
	public ConnectionManager() {
		try {
			Class.forName("org.sqlite.JDBC"); // establish a connection with the database
			c = DriverManager.getConnection("jdbc:sqlite:./db/obstetricianclinic.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			createTables();
			
			this.pregnancyMan = new JDBCPregnancyManager(this);
			this.womanMan = new JDBCWomanManager(this);
			this.newbornMan = new JDBCNewbornManager(this);
			this.obstetricianMan = new JDBCObstetricianManager(this);
			this.diseaseMan = new JDBCDiseaseManager(this);
			this.labReportMan= new JDBCLabReportManager(this);
			this.labStaffMan= new JDBCLabStaffManager(this);
			
			
		}catch (Exception e) {
			System.out.println("Database access error");
			e.printStackTrace();
		}
	}
	


	public Connection getConnection() {
		return c;
	}



	public PregnancyManager getPregnancyMan() {
		return pregnancyMan;
	}



	public WomanManager getWomanMan() {
		return womanMan;
	}



	public NewbornManager getNewbornMan() {
		return newbornMan;
	}



	public ObstetricianManager getObstetricianMan() {
		return obstetricianMan;
	}



	public DiseaseManager getDiseaseMan() {
		return diseaseMan;
	}




	public LabReportManager getLabReportMan() {
		return labReportMan;
	}




	public LabStaffManager getLabStaffMan() {
		return labStaffMan;
	}






	private void createTables() {
		try {
			Statement createTables1= c.createStatement();
			String create1= "CREATE TABLE obstetricians ("
					+ "obstetrician_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "name TEXT NOT NULL, "
					+ "username TEXT NOT NULL, "
					+ "surname TEXT NOT NULL)";
			
			createTables1.executeUpdate(create1);
			createTables1.close();
			
			
			Statement createTables2= c.createStatement();
			String create2= "CREATE TABLE women ("
					+ "woman_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "name TEXT NOT NULL, "
					+ "surname TEXT NOT NULL, "
					+ "dob DATE NOT NULL, "
					+ "weight REAL NOT NULL, "
					+ "obstetrician_id INTEGER REFERENCES obstetricians(id))";
			createTables2.executeUpdate(create2);
			createTables2.close();
			
			Statement createTables3= c.createStatement();
			String create3= "CREATE TABLE diseases ("
					+ "disease_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "type_Disease TEXT NOT NULL)";
			createTables3.executeUpdate(create3);
			createTables3.close();
			
			Statement createTables4= c.createStatement();
			String create4= "CREATE TABLE labReports ("
					+ "laboratoryReport_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "date_test DATE NOT NULL, "
					+ "pregnant BOOLEAN NOT NULL, "
					+ "labStaff_id INTEGER REFERENCES labStaffs(id), "
					+ "woman_id INTEGER REFERENCES women(id))";
			createTables4.executeUpdate(create4);
			createTables4.close();
			
			Statement createTables5= c.createStatement();
			String create5= "CREATE TABLE pregnancies ("
					+ "pregnancy_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "date_conception DATE NOT NULL, "
					+ "birth_report TEXT , "
					+ "woman_id INTEGER REFERENCES women(id))";
			createTables5.executeUpdate(create5);
			createTables5.close();
			
			Statement createTables6= c.createStatement();
			String create6= "CREATE TABLE newborns ("
					+ "newborn_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "name TEXT NOT NULL, "
					+ "surname TEXT NOT NULL, "
					+ "dob DATE NOT NULL, "
					+ "weight INTEGER NOT NULL, "
					+ "gender TEXT NOT NULL CHECK(gender='Female' OR gender='Male'), "
					+ "pregnancy_id INTEGER REFERENCES pregnancies(id))";
			createTables6.executeUpdate(create6);
			createTables6.close();
			
			Statement createTables7= c.createStatement();
			String create7= "CREATE TABLE labStaffs ("
					+ "labStaff_id INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "name TEXT NOT NULL, "
					+ "username TEXT NOT NULL, "
					+ "surname TEXT NOT NULL)";
			createTables7.executeUpdate(create7);
			createTables7.close();
			
			Statement createTables8= c.createStatement();
			String create8= "CREATE TABLE women_diseases ("
					+ "woman_id INTEGER REFERENCES women(id), "
					+ "disease_id INTEGER REFERENCES diseases(id), "
					+ "PRIMARY KEY(woman_id, disease_id))";
			createTables8.executeUpdate(create8);
			createTables8.close();
			
			
		}catch(SQLException sqlE) {
			if(sqlE.getMessage().contains("already exist")) {
				System.out.println("No need to create the tables; already there");
			}
			else {
				System.out.println("Error in query");
				sqlE.printStackTrace();
			}
		}
	}
	
	public void closeConnection() {
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
	}
}
