package turismo;

import java.util.LinkedList;
import java.util.List;

public class Itinerario {
	
	List <Sugerencia> listadoSugerenciasAceptadas = new LinkedList<Sugerencia>();

	public boolean aceptarSugerencia(Sugerencia nueva) {
		return listadoSugerenciasAceptadas.add(nueva); // devuelve true si se agregó
	}

}
