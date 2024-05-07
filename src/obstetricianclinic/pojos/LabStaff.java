package obstetricianclinic.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LabStaff implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7699206787024615940L;
	private Integer id;
	private String name;
	private String surname;
    private List<LabReport> labReports;
    
    
	public LabStaff() {
		super();
		this.labReports = new ArrayList<LabReport>();
	}

	public LabStaff(Integer id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.labReports = new ArrayList<LabReport>();
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
		LabStaff other = (LabStaff) obj;
		return Objects.equals(id, other.id) && Objects.equals(labReports, other.labReports)
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "LabStaff [id=" + id + ", name=" + name + ", surname=" + surname + ", labReports=" + labReports
				+ "]";
	}

}
