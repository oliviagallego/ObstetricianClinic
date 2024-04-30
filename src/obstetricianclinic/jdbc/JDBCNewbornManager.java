package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import obstetricianclinic.pojos.Newborn;
import obstetricianclinic.ifaces.NewbornManager;
import java.sql.Date;

public class JDBCNewbornManager implements NewbornManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCNewbornManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void addNewborn(Newborn newborn) {
		try {
			String query = "INSERT INTO Newborns (name, surname, dob, weight, gender) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement insert = c.prepareStatement(query);
			insert.setString(1, newborn.getName());
			insert.setString(2, newborn.getSurname());
			insert.setFloat(3, newborn.getWeight());
			insert.setString(4, newborn.getGender());
			insert.setDate(5, newborn.getDob());
			insert.executeUpdate();
			insert.close();
		}catch(SQLException sqlE) {
			System.out.println("Database exception");
			sqlE.printStackTrace();
		}

	}

}
