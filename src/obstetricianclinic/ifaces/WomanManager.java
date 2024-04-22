package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Woman;

public interface WomanManager {
	public void resgisterWoman(Woman woman);
	public void deleteWoman(int id);
	public void viewWoman(Woman woman, int id);
	public void updateWoman (int id);
}
