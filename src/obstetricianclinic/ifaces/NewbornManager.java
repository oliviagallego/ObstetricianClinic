package obstetricianclinic.ifaces;

import java.sql.Date;
import java.util.List;
import obstetricianclinic.pojos.*;

public interface NewbornManager {
		public void addNewborn(Newborn newborn);
		public List<Newborn> searchNewbornByDOB(Date dob);
	}

