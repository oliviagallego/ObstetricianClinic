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

	/*@Override
	public void addLabStaff(LabStaff labStaff) {
	    try {
	        if (labStaff.getUsername() == null || labStaff.getUsername().trim().isEmpty()) {
	            throw new IllegalArgumentException("Username must not be null or empty");
	        }
	        if (labStaffExists(labStaff.getUsername())) {
	            System.out.println("A LabStaff with this username already exists. Please use a different username.");
	            return;
	        }

	        String sql = "INSERT INTO labStaffs (name, surname, username) VALUES (?, ?, ?);"; 
	        try (PreparedStatement insert = c.prepareStatement(sql)) {
	            insert.setString(1, labStaff.getName());
	            insert.setString(2, labStaff.getSurname());
	            insert.setString(3, labStaff.getUsername());
	            insert.executeUpdate();
	            System.out.println("LabStaff successfully added to the database.");
	        }
	    } catch (SQLException sqlE) {
	        System.out.println("Database exception");
	        sqlE.printStackTrace();
	    }
	}
	private boolean labStaffExists(String username) throws SQLException {
	    String query = "SELECT COUNT(*) FROM labStaffs WHERE username = ?";
	    try (PreparedStatement stmt = c.prepareStatement(query)) {
	        stmt.setString(1, username);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1) > 0;
	            }
	        }
	    }
	    return false;
	}*/
	
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


	
	@Override
	public void updateLabStaff(LabStaff labStaff) {
	    String sql = "UPDATE labStaffs SET name = ?, surname = ?, username = ? WHERE id = ?";
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
}
