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


	    // Constructor
	
	public Pregnancy(Integer id, Date dateTest, Date dateConception, String laboratoryResult) {
	
		this.id = id;
	    
		this.dateTest = dateTest;
	    
		this.dateConception = dateConception;
	    
		this.laboratoryResult = laboratoryResult; 
	}
	
	
	//Constructor vacio
	public Pregnancy() {
		super();
	}
	
	//Getter and Setter

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDateTest() {
		return dateTest;
	}


	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}


	public Date getDateConception() {
		return dateConception;
	}


	public void setDateConception(Date dateConception) {
		this.dateConception = dateConception;
	}


	public String getLaboratoryResult() {
		return laboratoryResult;
	}


	public void setLaboratoryResult(String laboratoryResult) {
		this.laboratoryResult = laboratoryResult;
	}

	//ToString
	@Override
	public String toString() {
		return "Pregnancy [id=" + id + ", dateTest=" + dateTest + ", dateConception=" + dateConception
				+ ", laboratoryResult=" + laboratoryResult + "]";
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



