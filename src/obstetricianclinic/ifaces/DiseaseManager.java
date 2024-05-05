package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Disease;

public interface DiseaseManager {
	void addDisease(Disease disease);
	void updateDisease(int id, String newName);
	void updateDisease2(Disease disease);
}
