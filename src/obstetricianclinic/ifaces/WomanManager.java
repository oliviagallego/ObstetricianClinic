package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Woman;

public interface WomanManager {
	public void resgisterWoman(int id);
	public void deleteWoman(int id);
	public void viewWoman(Woman woman, int id);
	public void updateWoman (int id);
}
