package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Drug implements Serializable{
	private int id;
	private DrugName name;
	private DrugType type;
	private List<Disease> diseases;
	private Obstetrician obstetrician;
	
	
	public Drug() {
		super();
	}
	
	public Drug(int id, DrugName name, DrugType type, List<Disease> diseases, Obstetrician obstetrician) {
		super();
		this.id=id;
		this.name=name;
		this.type=type;
		this.diseases = diseases;
		this.obstetrician = obstetrician;
	}
	
	
	
	//Getter and Setter
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DrugName getName() {
		return name;
	}

	public void setName(DrugName name) {
		this.name = name;
	}

	public DrugType getType() {
		return type;
	}

	public void setType(DrugType type) {
		this.type = type;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public Obstetrician getObstetrician() {
		return obstetrician;
	}

	public void setObstetrician(Obstetrician obstetrician) {
		this.obstetrician = obstetrician;
	}
	
	//ToString
   	@Override
	public String toString() {
		return "Drug [id=" + id + ", name=" + name + ", type=" + type + ", diseases=" + diseases + ", obstetrician="
				+ obstetrician + "]";
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
