package obstetricianclinic.ifaces;
import java.util.*;
import obstetricianclinic.pojos.Disease;

public interface DiseaseManager {
	void addDisease(Disease disease);
	void updateDisease(Disease disease);//para?
	public Disease searchDiseaseByName(String diseaseType);
}
