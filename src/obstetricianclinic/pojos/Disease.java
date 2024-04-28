package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disease implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1079965302432167439L;
	private Integer id;
    private String diseaseType;
    private List<Woman> women;
    private List<Drug> drugs;
    
    public Disease() {
    	super();
    	this.women = new ArrayList<Woman>();
		this.drugs = new ArrayList<Drug>();
    }
    
	public Disease(Integer id, String diseaseType) {
		super();
		this.id = id;
		this.diseaseType = diseaseType;
		this.women = new ArrayList<Woman>();
		this.drugs = new ArrayList<Drug>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
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
		return Objects.hash(diseaseType, drugs, id, women);
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
		return Objects.equals(diseaseType, other.diseaseType) && Objects.equals(drugs, other.drugs)
				&& Objects.equals(id, other.id) && Objects.equals(women, other.women);
	}

	@Override
	public String toString() {
		return "Disease [id=" + id + ", diseaseType=" + diseaseType + ", women=" + women + ", drugs=" + drugs + "]";
	}

    
}
