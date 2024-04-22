package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class New_Born implements Serializable{
	
	private String name;
	
	private String surname;
	
	private Integer id;
	
	private Date dob;
	
	private Float weight;
	
	private Gender gender;
	
	  // Constructor
    public New_Born(String name, String surname, Integer id, Date dob, Float weight, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dob = dob;
        this.weight = weight;
        this.gender = gender;
    }
    
    public New_Born() {
        this.name ="";
        this.surname ="";
        this.id = 0;
        this.dob = null;
        this.weight = 0F;
        this.gender = null;
    }


	    // Getters
	    
	public String getName() {
	    
		return name;
	    
	}

	
	public String getSurname() {
	
		return surname;
	    
	}

	
	public Integer getId() {
	
		return id;
	    
	}

	
	public Date getDob() {
	
		return dob;
	    
	}

	
	public Float getWeight() {
	
		return weight;
	    
	}

	
	public Gender getGender() {
	
		return gender;
	    
	}

	    // Setters
	   
	public void setName(String name) {
	
		this.name = name;
	    
	}

	
	public void setSurname(String surname) {
	
		this.surname = surname;
	    
	}

	
	public void setId(Integer id) {
	
		this.id = id;
	    
	}

	
	public void setDob(Date dob) {
	
		this.dob = dob;
	    
	}

	
	public void setWeight(Float weight) {
	
		this.weight = weight;
	    
	}

	
	public void setGender(Gender gender) {
	
		this.gender = gender;
	    
	}
	
	@Override
    public String toString() {
        return "New_Born{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", dob=" + dob +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		New_Born other = (New_Born) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
