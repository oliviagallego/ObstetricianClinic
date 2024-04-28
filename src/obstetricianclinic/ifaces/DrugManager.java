package obstetricianclinic.ifaces;

public interface DrugManager {
	public void addDrug(String name, String description);
    public void removeDrug(int id);
    public void updateDrug(int id, String newName, String newDescription);
}
