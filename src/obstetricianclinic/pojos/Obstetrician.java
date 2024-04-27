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
	private String password;
	private int id;
	private List<Woman> women;
	private List<Drug> drugs;
	
	public Obstetrician() {
		super();
		this.women = new ArrayList<Woman>();
		this.drugs = new ArrayList<Drug>();
	}
	
	public Obstetrician(String name, String surname, String password, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.id = id;
		this.women = new ArrayList<Woman>();
		this.drugs = new ArrayList<Drug>();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(drugs, id, name, password, surname, women);
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
		return Objects.equals(drugs, other.drugs) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(surname, other.surname)
				&& Objects.equals(women, other.women);
	}

	@Override
	public String toString() {
		return "Obstetrician [name=" + name + ", surname=" + surname + ", password=" + password + ", id=" + id
				+ ", women=" + women + ", drugs=" + drugs + "]";
	}
	
	
}
