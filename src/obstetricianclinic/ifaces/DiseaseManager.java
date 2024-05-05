package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Disease;

public interface DiseaseManager {
	public Disease getDisease();
	void addDisease(Disease disease);
	void removeDisease(int id);
	void updateDisease(int id, String newName);
	void updateDisease2(Disease disease);//la que yo haría en vez de la de arriba
}
