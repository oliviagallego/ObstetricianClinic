package obstetricianclinic.pojos;
import java.util.*;
import java.io.Serializable;

public class LabReport implements Serializable{
	private static final long serialVersionUID = -7562122036761305186L;
	private LabStaff labStaff;
	private Date dateTest;
	private boolean pregnant;
	private Disease disease;
	
	public LabReport(LabStaff labStaff, Date dateTest, boolean pregnant, Disease disease) {
		super();
		this.labStaff = labStaff;
		this.dateTest = dateTest;
		this.pregnant = pregnant;
		this.disease = disease;
	}

	public LabReport() {
		super();
	}

	public LabStaff getLabStaff() {
		return labStaff;
	}

	public void setLabStaff(LabStaff labStaff) {
		this.labStaff = labStaff;
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

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTest, disease, labStaff, pregnant);
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
		return Objects.equals(dateTest, other.dateTest) && Objects.equals(disease, other.disease)
				&& Objects.equals(labStaff, other.labStaff) && pregnant == other.pregnant;
	}

	@Override
	public String toString() {
		return "labReport [labStaff=" + labStaff + ", dateTest=" + dateTest + ", pregnant=" + pregnant + ", disease="
				+ disease + "]";
	}
	
	

}
