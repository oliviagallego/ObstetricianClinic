package obstetricianclinic.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import obstetricianclinic.xml.SQLDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "women")
@XmlType(propOrder = { "name", "surname", "dob", "weight", "obstetrician"})
public class Woman implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3355504574744043511L;
	@XmlTransient
    private Integer id;
	@XmlElement
	private String name;
	@XmlElement
    private String surname;
	@XmlElement
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
    private Date dob;
	@XmlElement
    private Float weight;
    @XmlTransient
    private List<Disease> diseases;
    @XmlElement(name = "obstetrician")
    private Obstetrician obstetrician;
    @XmlTransient
    private List<Pregnancy> pregnancies;
    @XmlTransient
    private List<LabReport> labReports;

    // Constructor
    public Woman() {
    	super();
    	this.diseases = new ArrayList<Disease>();
        this.pregnancies = new ArrayList<Pregnancy>();
        this.labReports= new ArrayList<LabReport>();
    }
    
    public Woman(String name, String surname, Integer id, Date dob, Float weight, Obstetrician obstetrician){
    	super();
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dob = dob;
        this.weight = weight;
        this.obstetrician = obstetrician;
        this.diseases = new ArrayList<Disease>();
        this.pregnancies = new ArrayList<Pregnancy>();
        this.labReports= new ArrayList<LabReport>();
    }
    public Woman(String name, String surname, Date dob, Float weight, Obstetrician obstetrician){
    	super();
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.weight = weight;
        this.obstetrician = obstetrician;
        this.diseases = new ArrayList<Disease>();
        this.pregnancies = new ArrayList<Pregnancy>();
        this.labReports= new ArrayList<LabReport>();
    }
    
    public Woman(Integer id, String name, String surname,  Date dob, Float weight){
    	super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.weight = weight;
    }
    
	public Woman(String name, String surname, Date dob, Float weight) {
		super();
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.weight = weight;
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

	public List<LabReport> getLabReports() {
		return labReports;
	}

	public void setLabReports(List<LabReport> labReports) {
		this.labReports = labReports;
	}


	@Override
	public int hashCode() {
		return Objects.hash(diseases, dob, id, labReports, name, obstetrician, pregnancies, surname, weight);
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
				&& Objects.equals(id, other.id) && Objects.equals(labReports, other.labReports)
				&& Objects.equals(name, other.name) && Objects.equals(obstetrician, other.obstetrician)
				&& Objects.equals(pregnancies, other.pregnancies) && Objects.equals(surname, other.surname)
				&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}
	
	@Override
	public String toString() {
		return "Woman [name=" + name + ", surname=" + surname + ", id=" + id + ", dob=" + dob + ", weight=" + weight
				+ ", diseases=" + diseases + ", obstetrician=" + obstetrician + ", pregnancies=" + pregnancies
				+ ", labReports=" + labReports + "]";
	}

}