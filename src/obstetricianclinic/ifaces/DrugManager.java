package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Drug;

public interface DrugManager {
	public void addDrug(Drug drug);
    public void removeDrug(int id);
    public void updateDrug(int id, String newName, String newDescription);
}
