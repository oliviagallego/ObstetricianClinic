package obstetricianclinic.pojos;

public class LaboratoryStaff {
    private Integer id;
    private String userName;
    private String password;

    // Constructor por defecto
    public LaboratoryStaff(){
    	this.id = 0;
    	this.password = "";
    	this.userName = "";
    }
    	
    	
    // Constructor normal
    public LaboratoryStaff(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    // Getters y Setters
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

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "LaboratoryStaff{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}