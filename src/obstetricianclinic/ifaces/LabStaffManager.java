package obstetricianclinic.ifaces;
import obstetricianclinic.pojos.*;

import java.util.List;

public  interface LabStaffManager {
	public void addLabStaff(String name, String surname);
	public void updateLabStaff(String name, String surname);
}