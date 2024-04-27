package obstetricianclinic.ifaces;

import obstetricianclinic.pojos.*;

public interface NewBornManager {
	public void addNewBorn(String name, String surname, float weight, Gender gender);
	public void addNewBornReport(String text, Newborn newborn);
}