package obstetricianclinic.pojos;

import java.util.List;
import java.util.Objects;

public class LaboratoryStaff {
	private static final long serialVersionUID = -1079965302432167439L;
    private Integer id;private String name;
	private String surname;
    private List<LabReport> labReports;
    
    
	public LaboratoryStaff(List<LabReport> labReports) {
		super();
		this.labReports = labReports;
	}

	public LaboratoryStaff(Integer id, String name, String surname, List<LabReport> labReports) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.labReports = labReports;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<LabReport> getLabReports() {
		return labReports;
	}

	public void setLabReports(List<LabReport> labReports) {
		this.labReports = labReports;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, labReports, name, surname);
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
		return Objects.equals(id, other.id) && Objects.equals(labReports, other.labReports)
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "LaboratoryStaff [id=" + id + ", name=" + name + ", surname=" + surname + ", labReports=" + labReports
				+ "]";
	}

}
