package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.*;

import java.util.List;

public interface WomanManager {
	public void resgisterWoman(Woman woman);
	public void deleteWoman(int id);
	public List<Woman> searchWomanByNameAndSurname(String name, String surname);
	public void updateWoman (Woman woman);
	public void viewWoman(Woman woman);
}
