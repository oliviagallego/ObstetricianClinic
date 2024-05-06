package obstetricianclinic.ifaces;

import java.sql.Date;
import java.util.List;
import obstetricianclinic.pojos.*;



public interface PregnancyManager {
	public void addPregnancy (Pregnancy preganancy);
	public List<Pregnancy> searchPregnancyByDateOfConception(Date dateOfConception);
	public void addBirthReport(String birthReport, Pregnancy pregnancy);
	public void updatePregnancy(Pregnancy pregnancy);
	public void addPregnancyByWomanAndPregnancy(Woman woman, Pregnancy pregnancy);
}
