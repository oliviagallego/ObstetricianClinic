package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.*;

import java.util.List;

public interface WomanManager {
	public void registerWoman(Woman woman);
	public List<Woman> searchWomanByObstetrician(int id);
	public void updateWoman (Woman woman);
	public void deleteWoman(int id);
	public void assignWomanToDisease(int woman_id, int disease_id);
	public Woman getWoman(int id);

}