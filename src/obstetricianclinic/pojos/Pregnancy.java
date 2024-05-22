package obstetricianclinic.pojos;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
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
@XmlRootElement(name = "Pregnancy")
@XmlType(propOrder = { "dateConcepcion", "birthReport", "woman"})
public class Pregnancy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8679593455988548890L;
	@XmlTransient
	private Integer id;
	@XmlElement
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
	private Date dateConception;
	@XmlElement
	private String birthReport;
	@XmlTransient
	private List<Newborn> newborns;
	@XmlElement(name = "woman")
	private Woman woman;

	public Pregnancy(Integer id, Date dateConception, String birthReport, Woman woman) {
		super();
		this.id = id;
		this.dateConception = dateConception;
		this.birthReport = birthReport;
		this.newborns = new ArrayList<Newborn>();
		this.woman = woman;
	}
	public Pregnancy(Integer id, Date dateConception, String birthReport) {
		super();
		this.id = id;
		this.dateConception = dateConception;
		this.birthReport = birthReport;
	}
	
	public Pregnancy(Date dateConception, String birthReport, List<Newborn> newborns, Woman woman) {
		super();
		this.dateConception = dateConception;
		this.birthReport = birthReport;
		this.newborns = newborns;
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
		return Objects.hash(birthReport, dateConception, id, newborns, woman);
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
				&& Objects.equals(id, other.id) && Objects.equals(newborns, other.newborns)
				&& Objects.equals(woman, other.woman);
	}

	@Override
	public String toString() {
		return "Pregnancy [id=" + id + ", dateConception=" + dateConception + ", birthReport=" + birthReport
				+ ", newborns=" + newborns + ", woman=" + woman + "]";
	}

	

}



