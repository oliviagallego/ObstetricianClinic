package obstetricianclinic.ifaces;

import java.sql.Date;
import java.util.List;

import obstetricianclinic.pojos.*;

public interface NewbornManager {
		public void addNewBorn(String name, String surname, float weight, String gender);
		public List<Newborn> searchNewbornByDOB(Date dob);
	}

