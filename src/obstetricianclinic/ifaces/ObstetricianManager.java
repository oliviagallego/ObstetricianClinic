package obstetricianclinic.ifaces;
import obstetricianclinic.pojos.*;

public interface ObstetricianManager {
	public void addObstetrician(Obstetrician obstetrician);
    public void removeObstetrician(int id);
    public void updateObstetrician(Obstetrician obstetrician);
}
