package obstetricianclinic.pojos;
import java.util.*;
import java.io.Serializable;

public class LabReport implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1322009778992795425L;
	private Integer id;
	private Date dateTest;
	private boolean pregnant;
	private Woman woman;
	private LaboratoryStaff laboratoryStaff;
	
	public LabReport() {
		super();
	}

	public LabReport(Integer id, Date dateTest, boolean pregnant, Woman woman, LaboratoryStaff laboratoryStaff) {
		super();
		this.id = id;
		this.dateTest = dateTest;
		this.pregnant = pregnant;
		this.woman = woman;
		this.laboratoryStaff = laboratoryStaff;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateTest() {
		return dateTest;
	}

	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
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

	public LaboratoryStaff getLaboratoryStaff() {
		return laboratoryStaff;
	}

	public void setLaboratoryStaff(LaboratoryStaff laboratoryStaff) {
		this.laboratoryStaff = laboratoryStaff;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTest, id, laboratoryStaff, pregnant, woman);
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
		return Objects.equals(dateTest, other.dateTest) && Objects.equals(id, other.id)
				&& Objects.equals(laboratoryStaff, other.laboratoryStaff) && pregnant == other.pregnant
				&& Objects.equals(woman, other.woman);
	}

	@Override
	public String toString() {
		return "LabReport [id=" + id + ", dateTest=" + dateTest + ", pregnant=" + pregnant + ", woman=" + woman
				+ ", laboratoryStaff=" + laboratoryStaff + "]";
	}
	
	
}
