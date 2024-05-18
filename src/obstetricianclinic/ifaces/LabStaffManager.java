package obstetricianclinic.ifaces;
import obstetricianclinic.pojos.*;

import java.util.List;

public  interface LabStaffManager {
	public void addLabStaff(LabStaff labStaff);
	public void updateLabStaff(LabStaff labStaff);
	List<LabStaff> searchLabStaffByNameAndSurname(String name, String username, String surname);
	public LabStaff getLabStaffFromUser(String username);
}