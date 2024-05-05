package obstetricianclinic.ifaces;
import java.util.List;

import obstetricianclinic.pojos.*;

public interface LabReportManager {
	public void addLabReport(LabReport labReport);
	public void updateLabReport(LabReport report);
	public LabReport getLabReportById(int id);
	public List<LabReport> getLabReportsByWoman(Woman woman);
	public List<LabReport> listAllLabReports();
}
