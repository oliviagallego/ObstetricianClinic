package obstetricianclinic.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.pojos.*;

public class XMLManagerImpl implements XMLManager {

	@Override
	public void obstetrician2Xml(Obstetrician o) {
		try {
			// Create the JAXBContext
			JAXBContext jaxbContext = JAXBContext.newInstance(Obstetrician.class);
			// Get the marshaler
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("./xmls/Obstetrician.xml");
			marshaller.marshal(o, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Obstetrician xml2Obstetrician(File xml) {
		
		return null;
	}

	@Override
	public void obstetrician2Html(Obstetrician o) {
		
		
	}

}
