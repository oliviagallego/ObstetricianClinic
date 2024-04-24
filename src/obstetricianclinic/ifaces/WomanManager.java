package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Woman;
import java.util.List;

public interface WomanManager {
	public void resgisterWoman(int id);
	public void deleteWoman(int id);
	public List<Woman> searchWomanByNameAndSurname(int id); // Otra forma de hacer --> public void viewWoman(Woman[] womansList, int id); 
	public void updateWoman (int id);
}
