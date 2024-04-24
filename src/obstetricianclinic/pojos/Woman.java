package obstetricianclinic.pojos;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

public class Woman implements Serializable{
    private String name;
    private String surname;
    private Integer id;
    private Date dob;
    private float weight;
    private List<Disease> diseases;
    private Obstetrician obstetrician;
    private List<Pregnancy> pregnancies;

    // Constructor
    public Woman(String name, String surname, Integer id, Date dob, Float weight, Obstetrician obstetrician, List<Disease> diseases, List<Pregnancy> pregnancies){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dob = dob;
        this.weight = weight;
        this.obstetrician = obstetrician;
        this.diseases = diseases;
        this.pregnancies = pregnancies;
    }
    
    public Woman() {
        this.name ="";
        this.surname ="";
        this.id = 0;
        this.dob = null;
        this.weight = 0;
        this.obstetrician = null;
        this.diseases = null;
        this.pregnancies = null;
    }

    // Getters
    public List<Pregnancy> getPregnancies(){
    	return pregnancies;
    }
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
    
    public Obstetrician getObstetrician() {
    	return obstetrician;
    }
    
    public List<Disease> getDisease(){
    	return diseases;
    }

    // Setters
    
    public void setPregnancies(List<Pregnancy> pregnancies) {
    	this.pregnancies = pregnancies;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public void setObstetrician(Obstetrician obstetrician) {
    	this.obstetrician = obstetrician;
    }
    
    public void setDisease(List<Disease> diseases) {
    	this.diseases = diseases;
    }
    
    public void addDisease(Disease disease) {
		if (!diseases.contains(disease)) {
			diseases.add(disease);
		}
	}
	
	public void removeDisease(Disease disease) {
		if (diseases.contains(disease)) {
			diseases.remove(disease);
		}
	}
    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", dob=" + dob +
                ", weight=" + weight +
                ", disease=" + diseases +
                ", pregnancy=" + pregnancies +
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
		Woman other = (Woman) obj;
		return Objects.equals(id, other.id);
	}
	
}

