package obstetricianclinic.xml;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SQLDateAdapter extends XmlAdapter<String, Date> {
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	@Override
	public String marshal(Date sqlDate) throws Exception {
		return sqlDate.toLocalDate().format(formatter);
	}

	@Override
	public Date unmarshal(String string) throws Exception {
		LocalDate localDate = LocalDate.parse(string, formatter);
		return Date.valueOf(localDate);
	}

}
