package obstetricianclinic.pojos;
import java.io.Serializable;

public class Drug implements Serializable{
	private int id;
	private DrugName name;
	private DrugType type;
	
	public Drug() {
		super();
	}
	
	public Drug(int id, DrugName name, DrugType type) {
		super();
		this.id=id;
		this.name=name;
		this.type=type;
	}
	
	// Getter para id
    public int getId() {
        return id;
    }
    
    // Setter para id
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter para name
    public DrugName getName() {
        return name;
    }
    
    // Setter para name
    public void setName(DrugName name) {
        this.name = name;
    }
    
    // Getter para type
    public DrugType getType() {
        return type;
    }
    
    // Setter para type
    public void setType(DrugType type) {
        this.type = type;
    }
    
    //Método toString
    @Override
    public String toString() {
        return "Drug [id=" + id + ", name=" + name + ", type=" + type + "]";
    }

}
