package obstetricianclinic.pojos;

import java.util.List;
import java.util.Objects;

public class LaboratoryStaff {
	private static final long serialVersionUID = -1079965302432167439L;
    private Integer id;
    private String userName;
    private String password;
    private List<LabReport> labReports;
    
	public LaboratoryStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LaboratoryStaff(Integer id, String userName, String password, List<LabReport> labReports) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.labReports = labReports;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<LabReport> getLabReports() {
		return labReports;
	}

	public void setLabReports(List<LabReport> labReports) {
		this.labReports = labReports;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(id, labReports, password, userName);
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
				&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "laboratoryStaff [id=" + id + ", userName=" + userName + ", password=" + password + ", labReports="
				+ labReports + "]";
	}
    
    

}
