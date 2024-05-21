package obstetricianclinic.pojos;
import java.sql.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import obstetricianclinic.xml.SQLDateAdapter;

import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "LabReport")
@XmlType(propOrder = { "dateTest", "pregnant", "woman", "labStaff"}) 
public class LabReport implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1322009778992795425L;
	@XmlTransient
	private Integer id;
	@XmlElement
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
	private Date date_Test;
	@XmlElement
	private boolean pregnant;
	@XmlElement(name = "woman")
	private Woman woman;
	@XmlElement(name = "labStaff")
	private LabStaff labStaff;
	
	public LabReport() {
		super();
	}

	public LabReport(Integer id, Date date_Test, boolean pregnant, Woman woman, LabStaff labStaff) {
		super();
		this.id = id;
		this.date_Test = date_Test;
		this.pregnant = pregnant;
		this.woman = woman;
		this.labStaff = labStaff;
	}
	
	public LabReport(Integer id, Date date_Test, boolean pregnant) {
		super();
		this.id = id;
		this.date_Test = date_Test;
		this.pregnant = pregnant;
	}
	

	public LabReport(Date date_Test, boolean pregnant) {
		super();
		this.date_Test = date_Test;
		this.pregnant = pregnant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate_Test() {
		return date_Test;
	}

	public void setDate_Test(Date date_Test) {
		this.date_Test = date_Test;
	}

	public boolean isPregnant() {
		return pregnant;
	}

	public void setPregnant(boolean pregnant) {
		this.pregnant = pregnant;
	}

	public Woman getWoman() {
		return woman;
	}

	public void setWoman(Woman woman) {
		this.woman = woman;
	}


	public LabStaff getLabStaff() {
		return labStaff;
	}

	public void setLabStaff(LabStaff labStaff) {
		this.labStaff = labStaff;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date_Test, id, labStaff, pregnant, woman);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LabReport other = (LabReport) obj;
		return Objects.equals(date_Test, other.date_Test) && Objects.equals(id, other.id)
				&& Objects.equals(labStaff, other.labStaff) && pregnant == other.pregnant
				&& Objects.equals(woman, other.woman);
	}

	@Override
	public String toString() {
		return "LabReport [id=" + id + ", date_Test=" + date_Test + ", pregnant=" + pregnant + ", woman=" + woman
				+ ", laboratoryStaff=" + labStaff + "]";
	}
	
	
}
