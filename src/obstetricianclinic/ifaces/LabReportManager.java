package obstetricianclinic.ifaces;
import java.sql.Date;
import java.util.List;

import obstetricianclinic.pojos.*;

public interface LabReportManager {
	public void addLabReport(LabReport labReport);
	public void updateLabReport(LabReport labreport);
	public LabReport getLabReportById(int id);
	public List<LabReport> getLabReportsByWoman(Woman woman);
	public LabReport getLabReportsDOT(Date dot);
	public List<LabReport> listAllLabReports();
	public Date getDateTest(LabReport labReport);
}
