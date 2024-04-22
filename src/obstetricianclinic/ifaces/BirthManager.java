package obstetricianclinic.ifaces;

import java.util.Date;
import java.util.List;

import obstetricianclinic.pojos.Birth;

public interface BirthManager {
	public void addBirth (Date DOB);
	public List<Birth> searchBirthByDOB(int id);
}
