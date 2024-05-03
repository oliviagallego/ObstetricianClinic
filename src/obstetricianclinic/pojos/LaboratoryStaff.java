package obstetricianclinic.pojos;

import java.util.List;
import java.util.Objects;

public class LaboratoryStaff {
	private static final long serialVersionUID = -1079965302432167439L;
    private Integer id;
    private List<LabReport> labReports;
    
	public LaboratoryStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LaboratoryStaff(Integer id, List<LabReport> labReports) {
		super();
		this.id = id;
		this.labReports = labReports;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<LabReport> getLabReports() {
		return labReports;
	}

	public void setLabReports(List<LabReport> labReports) {
		this.labReports = labReports;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id, labReports);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LaboratoryStaff other = (LaboratoryStaff) obj;
		return Objects.equals(id, other.id) && Objects.equals(labReports, other.labReports);
	}

	@Override
	public String toString() {
		return "laboratoryStaff [id=" + id + ", userName=" + ", labReports="+ labReports + "]";
	}
    
    

}
