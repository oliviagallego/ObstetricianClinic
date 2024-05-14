package obstetricianclinic.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import obstetricianclinic.ifaces.*;
import obstetricianclinic.pojos.*;

public class XMLManagerImpl implements XMLManager {

	@Override
	public File obstetrician2Xml (Obstetrician obstetrician) {
		
		try {
			// Create the JAXBContext
			JAXBContext jaxbContext = JAXBContext.newInstance(Obstetrician.class);
			// Get the marshaler
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("./xmls/External-Obstetrician.xml");
			marshaller.marshal(obstetrician, file);
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
	}

	@Override
	public Obstetrician xml2Obstetrician(File xml) {
		try {
			// Create the JAXBContext
			JAXBContext jaxbContext = JAXBContext.newInstance(Obstetrician.class);
			// Get the unmarshaler
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Obstetrician obs = (Obstetrician) unmarshaller.unmarshal(xml);
			return obs;

		} catch (JAXBException e) {
			System.out.println("Error: unable to load the XML file");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void obstetrician2Html(Obstetrician obstetrician) {
		File file = obstetrician2Xml(obstetrician);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File("./xmls/Obstetrician-Style.xslt")));
			transformer.transform(new StreamSource(file), new StreamResult(new File("./xmls/External-Obstetrician.html")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public File labstaff2Xml(LabStaff labstaff) {
		try {
			// Create the JAXBContext
			JAXBContext jaxbContext = JAXBContext.newInstance(LabStaff.class);
			// Get the marshaler
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File file = new File("./xmls/External-Labstaff.xml");
			marshaller.marshal(labstaff, file);
			return file;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return null;
		
		}
	public LabStaff xml2LabStaff(File xml){
		
		try {
			// Create the JAXBContext
			JAXBContext jaxbContext = JAXBContext.newInstance(LabStaff.class);

			// Get the unmarshaler
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			LabStaff labstaff = (LabStaff) unmarshaller.unmarshal(xml);
			return labstaff;

		} catch (JAXBException e) {
			System.out.println("Error: unable to load the XML file");
			e.printStackTrace();
			return null;
		}
		
		}
	public void labstaff2Html(LabStaff labstaff) {
		File file = labstaff2Xml (labstaff);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File("./xmls/Labstaff-Style.xslt")));
			transformer.transform(new StreamSource(file), new StreamResult(new File("./xmls/External-Labstaff.html")));
		} catch (Exception e) {
			e.printStackTrace();
		
			}

		}
	

}
