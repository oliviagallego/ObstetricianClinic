package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Drug implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2639895737396554649L;
	private int id;
	private String drugName;
	private String drugType;
	private List<Disease> diseases;
	private Obstetrician obstetrician;
	
	
	public Drug() {
		super();
		this.diseases = new ArrayList<Disease>();
	}


	public Drug(int id, String drugName, String drugType, Obstetrician obstetrician) {
		super();
		this.id = id;
		this.drugName = drugName;
		this.drugType = drugType;
		this.diseases = new ArrayList<Disease>();
		this.obstetrician = obstetrician;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDrugName() {
		return drugName;
	}


	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}


	public String getDrugType() {
		return drugType;
	}


	public void setDrugType(String drugType) {
		this.drugType = drugType;
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


	@Override
	public int hashCode() {
		return Objects.hash(diseases, drugName, drugType, id, obstetrician);
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
		return Objects.equals(diseases, other.diseases) && Objects.equals(drugName, other.drugName)
				&& Objects.equals(drugType, other.drugType) && id == other.id
				&& Objects.equals(obstetrician, other.obstetrician);
	}


	@Override
	public String toString() {
		return "Drug [id=" + id + ", drugName=" + drugName + ", drugType=" + drugType + ", diseases=" + diseases
				+ ", obstetrician=" + obstetrician + "]";
	}
	
	
}
