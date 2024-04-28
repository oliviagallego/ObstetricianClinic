package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Woman;
import java.util.List;

public interface WomanManager {
	public void resgisterWoman(Woman woman);
	public void deleteWoman(int id);
	public List<Woman> searchWomanByNameAndSurname(String name, String surname); // Otra forma de hacer --> public void viewWoman(Woman[] womansList, int id); 
	public void updateWoman (Woman woman);
}
