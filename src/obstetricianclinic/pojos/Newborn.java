package obstetricianclinic.pojos;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Newborn")
@XmlType(propOrder = { "name", "surname", "dob", "weight", "gender", "pregnancy"})
public class Newborn implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7404209682399165641L;
	@XmlElement
	private String name;
	@XmlElement
	private String surname;
	@XmlTransient
	private Integer id;
	@XmlElement
	private Date dob;
	@XmlElement
	private Float weight;
	@XmlElement
	private String gender;
	@XmlElement
	private Pregnancy pregnancy;
	
	// Constructor
	public Newborn() {
		super();
	}
	public Newborn(String name, String surname, Integer id, Date dob, Float weight, String gender, Pregnancy pregnancy) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.dob = dob;
		this.weight = weight;
		this.gender = gender;
		this.pregnancy = pregnancy;
	}
	public Newborn(Integer id,String name, String surname,  Date dob, Float weight, String gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.dob = dob;
		this.weight = weight;
		this.gender = gender;
	}
	public Newborn(String name, String surname,  Date dob, Float weight, String gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.weight = weight;
		this.gender = gender;
	}
	
	
	public Newborn(String name, String surname, Date dob, Float weight, String gender, Pregnancy pregnancy) {
		super();
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.weight = weight;
		this.gender = gender;
		this.pregnancy = pregnancy;
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
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Pregnancy getPregnancy() {
		return pregnancy;
	}
	public void setPregnancy(Pregnancy pregnancy) {
		this.pregnancy = pregnancy;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dob, gender, id, name, pregnancy, surname, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Newborn other = (Newborn) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(gender, other.gender) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(pregnancy, other.pregnancy)
				&& Objects.equals(surname, other.surname) && Objects.equals(weight, other.weight);
	}
	@Override
	public String toString() {
		return "Newborn [name=" + name + ", surname=" + surname + ", id=" + id + ", dob=" + dob + ", weight=" + weight
				+ ", gender=" + gender + ", pregnancy=" + pregnancy + "]";
	}
	

	
    
	
}
