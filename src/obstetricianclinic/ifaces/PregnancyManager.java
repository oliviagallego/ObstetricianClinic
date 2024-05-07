package obstetricianclinic.ifaces;

import java.sql.Date;
import java.util.List;
import obstetricianclinic.pojos.*;



public interface PregnancyManager {
	public void addPregnancy (Pregnancy preganancy);
	public List<Pregnancy> searchPregnancyByDateOfConception(Date dateOfConception);//NO HACE FALTA
	public List<Pregnancy> searchPregnancyByWoman(int id);
	public void updatePregnancy(Pregnancy pregnancy);
}
