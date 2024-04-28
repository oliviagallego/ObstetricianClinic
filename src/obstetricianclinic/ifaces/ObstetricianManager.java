package obstetricianclinic.ifaces;

public interface ObstetricianManager {
	public void addObstetrician(String name, String specialization);
    public void removeObstetrician(int id);
    public void updateObstetrician(int id, String newName, String newSpecialization);
}
