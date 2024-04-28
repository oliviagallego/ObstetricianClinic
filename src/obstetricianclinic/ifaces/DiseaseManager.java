package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Disease;

public interface DiseaseManager {
	public void addDisease(String name);
	public void removeDisease(int id);
	public void updateDisease(int id, String newName);
}
