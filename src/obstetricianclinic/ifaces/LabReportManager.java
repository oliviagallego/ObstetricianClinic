package obstetricianclinic.ifaces;
import java.util.List;

import obstetricianclinic.pojos.*;

public interface LabReportManager {
	public void addLabReport(LabReport labReport);
	public void updateLabReport(LabReport labreport);
	public List<LabReport> searchLabReportByWoman(int id);
	public List<LabReport> searchLabReportByLabStaff(int id);
}
