package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Obstetrician implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7562122036761305186L;
	private String name;
	private String surname;
	private Integer id;
	private List<Woman> women;
	
	public Obstetrician() {
		super();
		this.women = new ArrayList<Woman>();
	}
	

	public Obstetrician(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}


	public Obstetrician(String name, String surname, Integer id) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.women = new ArrayList<Woman>();
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
		return Objects.hash(id, name, surname, women);
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
				&& Objects.equals(surname, other.surname)&& Objects.equals(women, other.women);
	}

	@Override
	public String toString() {
		return "obstetrician [name=" + name + ", surname=" + surname + ", id=" + id+ ", women=" + women + "]";
	}

	
}
