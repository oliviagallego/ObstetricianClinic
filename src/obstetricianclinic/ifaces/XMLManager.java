package obstetricianclinic.ifaces;

import java.io.File;

import obstetricianclinic.pojos.*;

public interface XMLManager {
	public void obstetrician2Xml(Obstetrician o);
	public Obstetrician xml2Obstetrician(File xml);
	public void obstetrician2Html(Obstetrician o);

}
