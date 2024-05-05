package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import obstetricianclinic.ifaces.*;

public class ConnectionManager {
	
	private Connection c;
	private static PregnancyManager pregnancyMan;
	private static WomanManager womanMan;
	private static NewbornManager newbornMan;
	private static ObstetricianManager obstetricianMan;
	private static DiseaseManager diseaseMan;
	private static LabReportManager labReportMan;
	private static LabStaffManager labStaffMan;
	
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
			this.labReportMan= new JDBCLabReportManager();//preguntar
			this.labStaffMan= new JDBCLabStaffManager();
			
		}catch (Exception e) {
			System.out.println("Database access error");
			e.printStackTrace();
		}
	}
	
	
	

	public Connection getC() {
		return c;
	}




	public static PregnancyManager getPregnancyMan() {
		return pregnancyMan;
	}




	public static WomanManager getWomanMan() {
		return womanMan;
	}




	public static NewbornManager getNewbornMan() {
		return newbornMan;
	}




	public static ObstetricianManager getObstetricianMan() {
		return obstetricianMan;
	}




	public static DiseaseManager getDiseaseMan() {
		return diseaseMan;
	}




	public static LabReportManager getLabReportMan() {
		return labReportMan;
	}




	public static LabStaffManager getLabStaffMan() {
		return labStaffMan;
	}




	private void createTables() {
		try {
			Statement createTables1= c.createStatement();
			String create1= "CREATE TABLE obstetrician ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "surname TEXT NOT NULL)";
			
			createTables1.executeUpdate(create1);
			createTables1.close();
			
			
			Statement createTables2= c.createStatement();
			String create2= "CREATE TABLE woman ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "surname TEXT NOT NULL,"
					+ "dob DATE NOT NULL,"
					+ "weight REAL NOT NULL,"
					+ "obstetrician_id INTEGER REFERENCES obstetrician(id))";
			createTables2.executeUpdate(create2);
			createTables2.close();
			
			Statement createTables3= c.createStatement();
			String create3= "CREATE TABLE disease ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "type_Disease TEXT NOT NULL,"
					+ "drug TEXT)";
			createTables3.executeUpdate(create3);
			createTables3.close();
			
			Statement createTables4= c.createStatement();
			String create4= "CREATE TABLE laboratoryReport ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "date_test DATE NOT NULL,"
					+ "pregnant TEXT NOT NULL(pregnant='positive' OR pregnant='negative',"
					+ "laboratoryStaff_id INTEGER REFERENCES laboratoryStaff(id),"
					+ "woman_id INTEGER REFERENCES woman(id))";
			createTables4.executeUpdate(create4);
			createTables4.close();
			
			Statement createTables5= c.createStatement();
			String create5= "CREATE TABLE pregnancy ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "date_conception DATE NOT NULL,"
					+ "birth_report TEXT NOT NULL,"
					+ "woman_id INTEGER REFERENCES woman(id))";
			createTables5.executeUpdate(create5);
			createTables5.close();
			
			Statement createTables6= c.createStatement();
			String create6= "CREATE TABLE newborn ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "surname TEXT NOT NULL,"
					+ "dob DATE NOT NULL,"
					+ "weight INTEGER NOT NULL,"
					+ "gender TEXT NOT NULL CHECK(gender='Female' OR gender='Male'),"
					+ "pregnancy_id INTEGER REFERENCES pregnancy(id))";
			createTables6.executeUpdate(create6);
			createTables6.close();
			
			Statement createTables7= c.createStatement();
			String create7= "CREATE TABLE laboratoryStaff ("
					+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "surname TEXT NOT NULL)";
			createTables7.executeUpdate(create7);
			createTables7.close();
			
			Statement createTables8= c.createStatement();
			String create8= "CREATE TABLE woman_disease ("
					+ "woman_id INTEGER REFERENCES woman(id),"
					+ "disease_id INTEGER REFERENCES disease(id)"
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
