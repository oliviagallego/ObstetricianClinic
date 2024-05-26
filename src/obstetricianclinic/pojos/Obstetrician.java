package obstetricianclinic.pojos;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Obstetrician")
@XmlType(propOrder = { "name", "surname","username","women"})
public class Obstetrician implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7562122036761305186L;
	@XmlElement
	private String name;
	@XmlElement
	private String username;
	@XmlElement
	private String surname;
	@XmlAttribute
	private Integer id;
	@XmlElementWrapper(name = "women")
    @XmlElement(name = "woman")
	private List<Woman> women;
	
	
	
	//Mil constructores otra vez
	public Obstetrician() {
		super();
		this.women = new ArrayList<Woman>();
	}
	
	public Obstetrician(String username) {
		super();
		this.username=username;
		this.women = new ArrayList<Woman>();
	}

	public Obstetrician(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	

	public Obstetrician(String name, String surname,String username) {
		super();
		this.name = name;
		this.username = username;
		this.surname = surname;
		this.women = new ArrayList<Woman>();
	}

	public Obstetrician(String name,  String surname, String username,Integer id) {
		super();
		this.name = name;
		this.username= username;
		this.surname = surname;
		this.id = id;
		this.women = new ArrayList<Woman>();
	}
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Woman> getWomen() {
		return women;
	}

	public void setWomen(List<Woman> women) {
		this.women = women;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, name, surname, username, women);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Obstetrician other = (Obstetrician) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(surname, other.surname) && Objects.equals(username, other.username)
				&& Objects.equals(women, other.women);
	}


	@Override
	public String toString() {
		return "Obstetrician [name=" + name + ", username=" + username + ", surname=" + surname + ", id=" + id
				+ ", women=" + women + "]";
	}


	

	
}
