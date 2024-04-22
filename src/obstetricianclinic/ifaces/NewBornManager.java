package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.Gender;

public interface NewBornManager {
	public void addNewBorn(String name, String surname, float weight, Gender gender);
	public void addReport(String text);
}