package obstetricianclinic.ifaces;

import java.sql.Date;
import java.util.List;

import obstetricianclinic.jdbc.Report;
import obstetricianclinic.pojos.*;

public  interface LabStaffManager {
	//public void addLabStaff(LaboratoryStaff labStaff); añadiría un método para crear un labstaff
	public  void addLabReport(LabReport report);
	public LabReport getLabReport(int id); //no entiendo pq este método está aqui
	public void updateLabReport(LabReport report);
	public void deleteLabReport(int id);
	public List<LabReport> listAllLabReports(LaboratoryStaff staff);
	public List<LabReport> searchLabReportByDateOfTest(Date dateOfTest);//método que podemos borrar
}
