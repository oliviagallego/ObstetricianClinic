package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obstetricianclinic.ifaces.WomanManager;
import obstetricianclinic.pojos.Woman;

public class JDBCWomanManager implements WomanManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCWomanManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	@Override
	public void resgisterWoman(Woman woman) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteWoman(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Woman> searchWomanByNameAndSurname(String name, String surname) {
		List<Woman> women= new ArrayList<Woman>();
		try {
			String sql= "SELECT * FROM women WHERE name LIKE ? AND surname LIKE ?";
			PreparedStatement p;
			p= c.prepareStatement(sql);
			p.setString(1, "%" + name + "%");
			p.setString(2, "%" + surname + "%");
			ResultSet rs= p.executeQuery();
			while(rs.next()) {
				Integer id= rs.getInt("id");
				String womanName= rs.getString("name");
				String womanSurname= rs.getString("surname");
				Woman w = new Woman(id, womanName, womanSurname);
				women.add(w);
			}
			rs.close();
			p.close();
		}catch(SQLException e) {
			System.out.println("Error in the database");
			e.printStackTrace();
		}
		return women;
	}

	@Override
	public void updateWoman(Woman woman) {
		// TODO Auto-generated method stub

	}

}
