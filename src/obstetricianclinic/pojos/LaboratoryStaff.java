package obstetricianclinic.pojos;

import java.util.Objects;

public class LaboratoryStaff {
    private Integer id;
    private String userName;
    private String password;

    // Constructor por defecto
    public LaboratoryStaff(){
    	super();
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
	
	
	

	//ToString
	@Override
	public String toString() {
		return "LaboratoryStaff [id=" + id + ", userName=" + userName + ", password=" + password + "]";
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
		LaboratoryStaff other = (LaboratoryStaff) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
