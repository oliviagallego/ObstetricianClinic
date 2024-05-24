package obstetricianclinic.ifaces;
import obstetricianclinic.pojos.*;

import java.util.List;

public  interface LabStaffManager {
	public void addLabStaff(LabStaff labStaff);
	public void updateLabStaff(LabStaff labStaff);
	List<LabStaff> searchLabStaffByNameAndSurname(String name, String surname, String username);
	public LabStaff getLabStaffFromUser(String username);
	public LabStaff getLabStaff(Integer id_labstaff);
}