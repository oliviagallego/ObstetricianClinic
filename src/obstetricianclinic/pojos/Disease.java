package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Disease implements Serializable{
    private Integer id;
    private TypeDisease type;//opcion 1
    private List<Drug> drugs;//opcion 2
    private List<Woman> women;

    // Constructor
    public Disease(int id, TypeDisease type, List<Woman> women, List<Drug> drugs) {
        this.id = id;
        this.type = type;
        this.women = women;
        this.drugs = drugs;
    }
    
    public Disease() {
    	super();
    }
    
    //Getter and Setter 
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypeDisease getType() {
		return type;
	}

	public void setType(TypeDisease type) {
		this.type = type;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public List<Woman> getWomen() {
		return women;
	}

	public void setWomen(List<Woman> women) {
		this.women = women;
	}
	
	//ToString
 	@Override
	public String toString() {
		return "Disease [id=" + id + ", type=" + type + ", drugs=" + drugs + ", women=" + women + "]";
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
   		Disease other = (Disease) obj;
   		return Objects.equals(id, other.id);
   	}
}
