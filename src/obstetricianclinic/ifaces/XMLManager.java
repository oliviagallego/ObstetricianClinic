package obstetricianclinic.ifaces;

import java.io.File;

import obstetricianclinic.pojos.*;

public interface XMLManager {
	public File obstetrician2Xml(Obstetrician obstetrician);
	public Obstetrician xml2Obstetrician(File xml);
	public void obstetrician2Html(Obstetrician obstetrician);
	
	public File labstaff2Xml(LabStaff labstaff);
	public LabStaff xml2LabStaff(File xml);
	public void labstaff2Html(LabStaff labstaff);

}
