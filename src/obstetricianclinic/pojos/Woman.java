package obstetricianclinic.pojos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

public class Woman implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3355504574744043511L;
	private String name;
    private String surname;
    private Integer id;
    private Date dob;
    private float weight;
    private List<Disease> diseases;
    private Obstetrician obstetrician;
    private List<Pregnancy> pregnancies;

    // Constructor
    public Woman() {
    	super();
    	this.diseases = new ArrayList<Disease>();
        this.pregnancies = new ArrayList<Pregnancy>();
    }
    
    public Woman(String name, String surname, Integer id, Date dob, Float weight, Obstetrician obstetrician){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dob = dob;
        this.weight = weight;
        this.obstetrician = obstetrician;
        this.diseases = new ArrayList<Disease>();
        this.pregnancies = new ArrayList<Pregnancy>();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public Obstetrician getObstetrician() {
		return obstetrician;
	}

	public void setObstetrician(Obstetrician obstetrician) {
		this.obstetrician = obstetrician;
	}

	public List<Pregnancy> getPregnancies() {
		return pregnancies;
	}

	public void setPregnancies(List<Pregnancy> pregnancies) {
		this.pregnancies = pregnancies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diseases, dob, id, name, obstetrician, pregnancies, surname, weight);
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
		return Objects.equals(diseases, other.diseases) && Objects.equals(dob, other.dob)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(obstetrician, other.obstetrician) && Objects.equals(pregnancies, other.pregnancies)
				&& Objects.equals(surname, other.surname)
				&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}

	@Override
	public String toString() {
		return "Woman [name=" + name + ", surname=" + surname + ", id=" + id + ", dob=" + dob + ", weight=" + weight
				+ ", diseases=" + diseases + ", obstetrician=" + obstetrician + ", pregnancies=" + pregnancies + "]";
	}
    
 
   
}

