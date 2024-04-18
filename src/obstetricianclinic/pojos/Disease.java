package obstetricianclinic.pojos;
import java.io.Serializable;

public class Disease implements Serializable{
    private Integer id;
    private TypeDisease type;

    // Constructor
    public Disease(int id, TypeDisease type) {
        this.id = id;
        this.type = type;
    }
    
    public Disease() {
        this.id = 0;
        this.type = null;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public TypeDisease getType() {
        return type;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(TypeDisease type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
