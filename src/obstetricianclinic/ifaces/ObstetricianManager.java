package obstetricianclinic.ifaces;
import java.util.List;

import obstetricianclinic.pojos.*;

public interface ObstetricianManager {
	public void addObstetrician(Obstetrician obstetrician);
    public void updateObstetrician(Obstetrician obstetrician);//yo lo borraba 
    public Obstetrician getObstetrician(int id);//he añadido este que nos faltaba
	//Habria que añadir una cuarta funcion para poder buscar al obstetrician:
    public List<Obstetrician> searchObstetrician();


    
}
