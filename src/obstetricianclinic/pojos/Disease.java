package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Disease")
@XmlType(propOrder = { "diseaseType", "date"})
public class Disease implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1079965302432167439L;
	@XmlAttribute
	private Integer id;
	@XmlElement
    private String diseaseType;
	@XmlTransient
    private List<Woman> women;
    
    public Disease() {
    	super();
    	this.women = new ArrayList<Woman>();
    }
    
	public Disease(Integer id, String diseaseType) {
		super();
		this.id = id;
		this.diseaseType = diseaseType;
		this.women = new ArrayList<Woman>();
	}
	
	public Disease(String diseaseType) {
		super();
		this.diseaseType = diseaseType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public List<Woman> getWomen() {
		return women;
	}

	public void setWomen(List<Woman> women) {
		this.women = women;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(diseaseType,id, women);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disease other = (Disease) obj;
		return Objects.equals(diseaseType, other.diseaseType)
				&& Objects.equals(id, other.id) && Objects.equals(women, other.women);
	}

	@Override
	public String toString() {
		return "Disease [id=" + id + ", diseaseType=" + diseaseType+ ", women=" + women + "]";
	}
}
