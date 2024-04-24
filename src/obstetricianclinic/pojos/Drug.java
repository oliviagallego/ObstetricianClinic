package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Drug implements Serializable{
	private int id;
	private DrugName name;
	private DrugType type;
	private List<Disease> diseases;
	
	
	public Drug() {
		super();
		this.id=0;
		this.name = null;
		this.type = null;
		this.diseases = null;
	}
	
	public Drug(int id, DrugName name, DrugType type, List<Disease> diseases) {
		super();
		this.id=id;
		this.name=name;
		this.type=type;
		this.diseases = diseases;
	}
	
	//Getter para disease
	public List<Disease> getDiseases(){
		return diseases;
	}
	
	//Setter para disease
	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
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
        return "Drug [id=" + id + ", name=" + name + ", type=" + type + ", diseases=" + diseases +"]";
    }
    @Override
   	public int hashCode() {
   		return Objects.hash(id);
   	}
   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		Drug other = (Drug) obj;
   		return Objects.equals(id, other.id);
   	}
}
