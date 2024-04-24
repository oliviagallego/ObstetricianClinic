package obstetricianclinic.pojos;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Birth implements Serializable{
    private Integer id;
    private String report;
	private List<New_Born> bebies;
	
    // Constructor
    public Birth(Integer id, String report) {
        this.id = id;
        this.report = report;
    }
    public Birth() {
        this.id = 0;
        this.report ="";
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getReport() {
        return report;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setReport(String report) {
        this.report = report;
    }
    
    public void addBaby(New_Born baby) {
		if (!bebies.contains(baby)) {
			bebies.add(baby);
		}
	}
	
	public void removeBaby(New_Born baby) {
		if (bebies.contains(baby)) {
			bebies.remove(baby);
		}
	}
	
    @Override
    public String toString() {
        return "Birth{" +
                "id=" + id +
                ", report='" + report + '\'' +
                '}';
    }
    @Override
   	public int hashCode() {
   		return Objects.hash(id);
   	}
   	@Override
   	public boolean equals(Object obj) {
   		if (this == obj)
   			return true;
   		if (obj == null)
   			return false;
   		if (getClass() != obj.getClass())
   			return false;
   		Birth other = (Birth) obj;
   		return Objects.equals(id, other.id);
   	}
}
