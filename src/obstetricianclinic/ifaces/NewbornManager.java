package obstetricianclinic.ifaces;
import obstetricianclinic.pojos.*;

import java.sql.Date;
import java.util.List;


public interface NewbornManager {
	public void addNewborn(Newborn newborn);
	public List<Newborn> searchNewbornByDOB(Date dob);
	
}

