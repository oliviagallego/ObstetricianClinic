package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import obstetricianclinic.ifaces.PregnancyManager;
import obstetricianclinic.pojos.Pregnancy;

public class JDBCPregnancyManager implements PregnancyManager {
	Connection c;

	@Override
	public void addPregnancy(Date dateOfConception) {
		try {
		String sql= "INSERT INTO pregnancy (dateConception) " + "VALUES(?);";
		PreparedStatement insert= c.prepareStatement(sql);
		insert.setDate(1, dateOfConception.getDateConception());//????
		
		insert.executeUpdate();
		insert.close();
		}catch(SQLException sqlE) {
			System.out.println("Database exception");
			sqlE.printStackTrace();
		}
	}

	@Override
	public List<Pregnancy> searchPregnancyByDateOfConception(Date dateOfConception) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
