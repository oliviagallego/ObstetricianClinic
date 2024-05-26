package obstetricianclinic.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import obstetricianclinic.ifaces.LabStaffManager;
import obstetricianclinic.pojos.*;

public class JDBCLabStaffManager implements LabStaffManager {
	private ConnectionManager conMan;
	Connection c;
	
	public JDBCLabStaffManager(ConnectionManager conMan) {
		this.conMan = conMan;
		this.c = conMan.getConnection();
	}

	
	
	/* 
	public void addLabStaff(LabStaff labStaff) {
	    if (checkUsernameExists(labStaff.getUsername())) {
	        System.out.println("Username already exists. Please choose a different username.");
	        return;
	    }
	    String sql = "INSERT INTO labStaffs (name, surname, username) VALUES (?, ?, ?)";
	    try (Connection conn = this.conMan.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement(sql)){
	        
	        pstmt.setString(1, labStaff.getName());
	        pstmt.setString(2, labStaff.getSurname());
	        pstmt.setString(3, labStaff.getUsername());
	        int affectedRows = pstmt.executeUpdate();
	        if (affectedRows > 0) {
	            System.out.println("LabStaff successfully added to the database.");
	        } else {
	            System.out.println("Failed to add the labStaff to the database.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Database error during labStaff registration.");
	        e.printStackTrace();
	    }
	    
	}
	
	*/
	
	//Tal cual como Rodrigo
	public void addLabStaff(LabStaff labStaff) {
	   
	    try{
		    String sql = "INSERT INTO labStaffs (name, surname, username) VALUES (?, ?, ?)";
		    PreparedStatement insert= c.prepareStatement(sql);
	        insert.setString(1, labStaff.getName());
	        insert.setString(2, labStaff.getSurname());
	        insert.setString(3, labStaff.getUsername());
	        insert.executeUpdate();
			insert.close();
	    	} catch (SQLException e) {
				System.out.println("Database exception.");
				e.printStackTrace();
			}	
	}

	/*
	public boolean checkUsernameExists(String username) {
		String sql = "SELECT COUNT(*) FROM users WHERE username = ?"; 
		try (Connection conn = this.conMan.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		    pstmt.setString(1, username);
		    ResultSet rs = pstmt.executeQuery();
		    if (rs.next()) {
		    	return rs.getInt(1) > 0;
		    }
		} catch (SQLException e) {
		    System.out.println("Database error during username check.");
		    e.printStackTrace();
		    throw new RuntimeException("Failed to check if username exists", e);
		}
		return false;
	}
	
	*/
	
	/*
	@Override
	public void updateLabStaff(LabStaff labStaff) {
	    String sql = "UPDATE labStaffs SET name = ?, surname = ?, username = ? WHERE labStaff_id = ?";// he cabiado id por labStaff_id
	    try (Connection conn = this.conMan.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, labStaff.getName());
	        pstmt.setString(2, labStaff.getSurname());
	        pstmt.setString(3, labStaff.getUsername());
	        pstmt.setInt(4, labStaff.getId());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	*/ 
	
	//Tal cual como Rodrigo
	@Override
	public void updateLabStaff(LabStaff labStaff) {
	    
	    try {
	    	String sql = "UPDATE labStaffs SET name = ?, surname = ?, username = ? WHERE id = ?";
	    	PreparedStatement pstmt = c.prepareStatement(sql);
	        pstmt.setString(1, labStaff.getName());
	        pstmt.setString(2, labStaff.getSurname());
	        pstmt.setString(3, labStaff.getUsername());
	        pstmt.setInt(4, labStaff.getId());
	        pstmt.executeUpdate();
	        pstmt.close();
	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	 @Override
	 public List<LabStaff> searchLabStaffByNameAndSurname(String name, String surname, String username) {
		    List<LabStaff> listLabStaffs = new ArrayList<LabStaff>();
		    try {
		        String sql = "SELECT * FROM labStaffs WHERE name = ? AND surname = ? AND username = ?";
		        PreparedStatement p = c.prepareStatement(sql);
		        p.setString(1, name);
		        p.setString(2, surname);
		        p.setString(3, username);
		        ResultSet rs = p.executeQuery();

		        while (rs.next()) {
		            Integer labStaff_id = rs.getInt("labStaff_id"); 
		            name = rs.getString("name");
		            surname = rs.getString("surname");
		            username = rs.getString("username");
		            LabStaff lab = new LabStaff(labStaff_id, name, surname, username);
		            listLabStaffs.add(lab);
		        }
		        rs.close();
		        p.close();
		    } catch (SQLException e) {
		        System.out.println("Database error.");
		        e.printStackTrace();
		    }
		    return listLabStaffs;
		}
	 
	 @Override
	    public LabStaff getLabStaffFromUser(String username) {
	        try {
	            String sql = "SELECT * FROM labStaffs WHERE username = ?";
	            PreparedStatement p = c.prepareStatement(sql);
	            p.setString(1, username);
	            ResultSet rs = p.executeQuery();
	            Integer labStaff_id = rs.getInt("labStaff_id");
	            String name = rs.getString("name");
	            String surname = rs.getString("surname");
	            LabStaff labs= new LabStaff(labStaff_id, name, surname, username);
	            rs.close();
	            p.close();
	            return labs;
	        } catch (SQLException e) {
	            System.out.println("Database error.");
	            e.printStackTrace();
	        }
	        return null;
	    }



	@Override
	public LabStaff getLabStaff(Integer labStaff_id) {
		try {
			String sql = "SELECT * FROM obstetricians WHERE labStaff_id = ?";
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, labStaff_id);
			ResultSet rs = p.executeQuery();
			rs.next();
			String name = rs.getString("name");
			String username= rs.getString("username");
			String surname = rs.getString("surname");
			LabStaff obs = new LabStaff(labStaff_id, name, surname, username);
			rs.close();
			p.close();
			return obs;
		} catch (SQLException e) {
			System.out.println("Database error.");
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public String getUsername(LabStaff labstaff) throws SQLException {
		String sql = "SELECT * FROM labStaffs WHERE username = ?";
		PreparedStatement p = c.prepareStatement(sql);
		p.setString(1, labstaff.getUsername());
		ResultSet rs = p.executeQuery();
		String name = rs.getString("username");
		rs.close();
		p.close();
		return name;
		

	}
	
}
