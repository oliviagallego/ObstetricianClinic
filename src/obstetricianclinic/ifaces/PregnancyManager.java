package obstetricianclinic.ifaces;

import java.util.Date;
import java.util.List;
import obstetricianclinic.pojos.Pregnancy;


public interface PregnancyManager {
	public void addPregnancy (Date dateOfConception);
	public List<Pregnancy> searchPregnancyByDateOfConception(Date dateOfConception);
	public void addBirthReport(String birthReport, Pregnancy pregnancy);//???
}
