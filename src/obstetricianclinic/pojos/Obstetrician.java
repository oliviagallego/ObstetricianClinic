package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Obstetrician implements Serializable{
	private String name;
	private String surname;
	private String password;
	private int id;
	private List<Woman> women;
	private List<Drug> drugs;
	
	private Obstetrician(String name, String surname,String password, int id, List<Drug> drugs) {
		this.name=name;
		this.surname=surname;
		this.id=id;
		this.drugs = drugs;
	}
	private Obstetrician() {
		super();
	}
	
	
	//Getter and Setter
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
	
	 // Método público para crear instancias
    public static Obstetrician createObstetrician(String name, String surname, String password, int id, List<Drug> drugs) {
        return new Obstetrician(name, surname,password, id, drugs);
    }
    
   
	public void addWoman(Woman woman) {
		if (!women.contains(woman)) {
			women.add(woman);
		}
	}
	
	public void removeWoman(Woman woman) {
		if (women.contains(woman)) {
			women.remove(woman);
		}
	}
	
	
	//ToString 
	@Override
	public String toString() {
		return "Obstetrician [name=" + name + ", surname=" + surname + ", password=" + password + ", id=" + id
				+ ", women=" + women + ", drugs=" + drugs + "]";
	}
	
   
    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	@Override
	public boolean equals(Object obj) { // toby.equals(throw)
		if (this == obj) // Checks if both objects have the same memory reference (the same piece of paper)
			return true;
		if (obj == null) // If not, checks if the other object is null
			return false;
		if (getClass() != obj.getClass()) // If not, check if both objects are of the same class
			return false;
		Obstetrician other = (Obstetrician) obj; // If they are, cast the other object to this class
		return Objects.equals(id, other.id); // Compare the appropriate attributes
	}
}
