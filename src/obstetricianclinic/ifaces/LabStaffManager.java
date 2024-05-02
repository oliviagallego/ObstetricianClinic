package obstetricianclinic.ifaces;

import java.util.List;

import obstetricianclinic.pojos.*;

public  interface LabStaffManager {
	public  void addLabReport(LabReport report);
	public LabReport getLabReport(int id);
	public void updateLabReport(LabReport report);
	public void deleteLabReport(int id);
	public List<LabReport> listAllLabReports(LaboratoryStaff staff);
}
