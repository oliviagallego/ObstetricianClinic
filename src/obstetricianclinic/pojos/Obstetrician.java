package obstetricianclinic.pojos;
import java.io.Serializable;

public class Obstetrician implements Serializable{
	private String name;
	private String surname;
	private int id;
	
	private Obstetrician(String name, String surname, int id) {
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
    public static Obstetrician createObstetrician(String name, String surname, int id) {
        return new Obstetrician(name, surname, id);
    }
    
    // Setter para el nombre
    public void setName(String name) {
        this.name = name;
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

    // Setter para el ID
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter para el ID
    public int getId() {
        return id;
    }

    // Método toString para representar el objeto como cadena
    @Override
    public String toString() {
        return "Obstetrician:" +
                "Name:'" + name + '\'' +
                ", surname:'" + surname + '\'' +
                ", id:" + id;
    }

}
