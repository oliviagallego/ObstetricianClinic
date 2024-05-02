package obstetricianclinic.ifaces;

import java.sql.Date;
import java.util.List;
import obstetricianclinic.pojos.*;

public interface NewbornManager {
	public void registerNewborn(Newborn newborn);
	public Newborn selectNewborn(int id);
	public void updateNewborn(Newborn newborn);
	public void deleteNewborn(int id);
	public List<Newborn> listNewbornsForPregnancy(int pregnancyId);
	}

