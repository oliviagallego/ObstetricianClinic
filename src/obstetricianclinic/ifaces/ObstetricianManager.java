package obstetricianclinic.ifaces;
import java.sql.SQLException;
import java.util.List;

import obstetricianclinic.pojos.*;

public interface ObstetricianManager {
	public void addObstetrician(Obstetrician obstetrician) throws SQLException; 
    public Obstetrician getObstetrician(int id);
    public List<Obstetrician> searchObstetricianByNameAndSurname(String name, String username, String surname);
    public Obstetrician getObstetricianFromUser(String username);
    public String getUsername(Obstetrician obstetrician) throws SQLException;
}
