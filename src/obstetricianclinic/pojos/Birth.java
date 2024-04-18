package obstetricianclinic.pojos;
import java.io.Serializable;


public class Birth implements Serializable{
    private Integer id;
    private String report;

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
    
    @Override
    public String toString() {
        return "Birth{" +
                "id=" + id +
                ", report='" + report + '\'' +
                '}';
    }
}
