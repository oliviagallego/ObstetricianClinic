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
	
	private Obstetrician(String name, String surname,String password, int id) {
		this.name=name;
		this.surname=surname;
		this.id=id;
	}
	private Obstetrician() {
		super();
		this.name=" ";
		this.surname=" ";
		this.id=0;
	}
	 // Método público para crear instancias
    public static Obstetrician createObstetrician(String name, String surname, String password, int id) {
        return new Obstetrician(name, surname,password, id);
    }
    
    // Setter para el nombre
    public void setName(String name) {
        this.name = name;
    }
 // Setter para la contraseña
    public void setPassword(String password) {
        this.password = password;
    }
    // Getter para el nombre
    public String getName() {
        return name;
    }

    // Setter para el apellido
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    // Getter para el apellido
    public String getSurname() {
        return surname;
    }
    
    // Getter para la contraseña
    public String getP() {
        return password;
    }
    
    // Setter para el ID
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter para el ID
    public int getId() {
        return id;
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
    // Método toString para representar el objeto como cadena
    @Override
    public String toString() {
        return "Obstetrician:" +
                "Name:'" + name + '\'' +
                ", surname:'" + surname + '\'' +
                ", id:" + id;
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
		Obstetrician other = (Obstetrician) obj; // If they are, cast the other object to this class
		return Objects.equals(id, other.id); // Compare the appropriate attributes
	}
}
