package obstetricianclinic.pojos;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

public class Pregnancy implements Serializable{
	private Integer id;
	
	private Date dateTest;
	
	private Date dateConception;
	
	private String laboratoryResult;
	private List<New_Born> bebies;

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
	public void addBaby(New_Born baby) {
		if (!bebies.contains(baby)) {
			bebies.add(baby);
		}
	}
	
	public void removeBaby(New_Born baby) {
		if (bebies.contains(baby)) {
			bebies.remove(baby);
		}
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
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { // toby.equals(thor)
		if (this == obj) // Checks if both objects have the same memory reference (the same piece of paper)
			return true;
		if (obj == null) // If not, checks if the other object is null
			return false;
		if (getClass() != obj.getClass()) // If not, check if both objects are of the same class
			return false;
		Pregnancy other = (Pregnancy) obj; // If they are, cast the other object to this class
		return Objects.equals(id, other.id); // Compare the appropriate attributes
	}

}



