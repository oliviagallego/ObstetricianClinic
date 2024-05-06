package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Disease;

public interface DiseaseManager {
	void addDisease(Disease disease);
	void updateDisease(Disease disease);
	void assignDiseaseToWoman(int diseaseId, int womanId);
}
