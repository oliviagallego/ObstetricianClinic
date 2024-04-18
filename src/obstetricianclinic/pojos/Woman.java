package obstetricianclinic.pojos;
import java.util.Date;
import java.io.Serializable;

public class Woman implements Serializable{
    private String name;
    private String surname;
    private Integer id;
    private Date dob;
    private float weight;

    // Constructor
    public Woman(String name, String surname, Integer id, Date dob, Float weight){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dob = dob;
        this.weight = weight;
    }
    
    public Woman() {
        this.name ="";
        this.surname ="";
        this.id = 0;
        this.dob = null;
        this.weight = 0;
    }

    // Getters
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

    // Setters
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
    
    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", dob=" + dob +
                ", weight=" + weight +
                '}';
    }
}

