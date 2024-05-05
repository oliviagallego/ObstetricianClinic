package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.*;

import java.util.List;

public interface WomanManager {
	public void registerWoman(Woman woman);//cogijo register q estaba mal escrito
	public void deleteWoman(int id);
	public List<Woman> searchWomanByNameAndSurname(String name, String surname);
	public void updateWoman (Woman woman);
	public Woman viewWoman(int id);
}