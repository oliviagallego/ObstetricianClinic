package obstetricianclinic.pojos;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "LabStaff")
@XmlType(propOrder = { "name", "surname", "reports"})
public class LabStaff implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7699206787024615940L;
	@XmlTransient
	private Integer id;
	@XmlElement
	private String name;
	@XmlElement
	private String username;
	@XmlElement
	private String surname;
	@XmlElementWrapper(name = "Reports")
	@XmlElement(name = "Report")
    private List<LabReport> labReports;
    
    
	public LabStaff() {
		super();
		this.labReports = new ArrayList<LabReport>();
	}
	
	public LabStaff(String username) {
		super();
		this.username=username;
		this.labReports = new ArrayList<LabReport>();
	}

	public LabStaff(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
		this.labReports = new ArrayList<LabReport>();
	}



	public LabStaff(Integer id, String name, String surname, String username) {
		super();
		this.id = id;
		this.name = name;
		this.username= username;
		this.surname = surname;
		this.labReports = new ArrayList<LabReport>();
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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
		return Objects.hash(id, labReports, name, surname, username);
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
				&& Objects.equals(name, other.name) && Objects.equals(surname, other.surname)
				&& Objects.equals(username, other.username);
	}



	@Override
	public String toString() {
		return "LabStaff [id=" + id + ", name=" + name +", surname=" + surname +", username=" + username 
				+ ", labReports=" + labReports + "]";
	}

	

}
