package obstetricianclinic.pojos;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;

public class Pregnancy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8679593455988548890L;

	private Integer id;
	
	private Date dateTest;
	
	private Date dateConception;
	
	private String birthReport;
	
	private List<Newborn> newborns;
	
	private Woman woman;

	public Pregnancy(Integer id, Date dateTest, Date dateConception, String birthReport, Woman woman) {
		super();
		this.id = id;
		this.dateTest = dateTest;
		this.dateConception = dateConception;
		this.birthReport = birthReport;
		this.newborns = new ArrayList<Newborn>();
		this.woman = woman;
	}

	public Pregnancy() {
		super();
		this.newborns = new ArrayList<Newborn>();
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

	public Date getDateConception() {
		return dateConception;
	}

	public void setDateConception(Date dateConception) {
		this.dateConception = dateConception;
	}

	public String getBirthReport() {
		return birthReport;
	}

	public void setBirthReport(String birthReport) {
		this.birthReport = birthReport;
	}

	public List<Newborn> getNewborns() {
		return newborns;
	}

	public void setNewborns(List<Newborn> newborns) {
		this.newborns = newborns;
	}

	public Woman getWoman() {
		return woman;
	}

	public void setWoman(Woman woman) {
		this.woman = woman;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthReport, dateConception, dateTest, id, newborns, woman);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pregnancy other = (Pregnancy) obj;
		return Objects.equals(birthReport, other.birthReport) && Objects.equals(dateConception, other.dateConception)
				&& Objects.equals(dateTest, other.dateTest) && Objects.equals(id, other.id)
				&& Objects.equals(newborns, other.newborns) && Objects.equals(woman, other.woman);
	}

	@Override
	public String toString() {
		return "Pregnancy [id=" + id + ", dateTest=" + dateTest + ", dateConception=" + dateConception
				+ ", birthReport=" + birthReport + ", newborns=" + newborns + ", woman=" + woman + "]";
	}
	
	

}



