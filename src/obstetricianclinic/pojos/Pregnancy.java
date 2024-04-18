package obstetricianclinic.pojos;
import java.util.Date;
import java.io.Serializable;

public class Pregnancy implements Serializable{
	private Integer id;
	
	private Date dateTest;
	
	private Date dateConception;
	
	private String laboratoryResult;

	    // Constructor
	
	public Pregnancy(Integer id, Date dateTest, Date dateConception, String laboratoryResult) {
	
		this.id = id;
	    
		this.dateTest = dateTest;
	    
		this.dateConception = dateConception;
	    
		this.laboratoryResult = laboratoryResult; 
	}
	
	
	//Constructor vacio
	public Pregnancy() {
		
		this.id = 0;
	    
		this.dateTest = null;
	    
		this.dateConception = null;
	    
		this.laboratoryResult =""; 
	}

	    // Getters
	
	public int getId() {
	        
		return id;
	
	}

	
	public Date getDateTest() {
	
		return dateTest;
	    
	}

	    
	public Date getDateConception() {
	
		return dateConception;
	    
	}

	
	public String getLaboratoryResult() {
	
		return laboratoryResult;
	    
	}
	    // Setters
	 
	public void setId(Integer id) {
	
		this.id = id;
	    
	}

	
	public void setDateTest(Date dateTest) {
	
		this.dateTest = dateTest;
	    
	}

	
	public void setDateConception(Date dateConception) {
	
		this.dateConception = dateConception;
	    
	}

	
	public void setLaboratoryResult(String laboratoryResult) {
	
		this.laboratoryResult = laboratoryResult;
	    
	}
	
	@Override
    public String toString() {
        return "Pregnancy{" +
                "id=" + id +
                ", dateTest=" + dateTest +
                ", dateConception=" + dateConception +
                ", laboratoryResult='" + laboratoryResult + '\'' +
                '}';
    }

}



