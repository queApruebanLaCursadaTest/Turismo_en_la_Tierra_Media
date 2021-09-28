package turismo;

import java.util.LinkedList;
import java.util.List;

public class Itinerario {
	
	List <Sugerencia> listadoSugerenciasAceptadas = new LinkedList<Sugerencia>();

	public Itinerario(List<Sugerencia> listadoSugerenciasAceptadas) {
		this.listadoSugerenciasAceptadas = listadoSugerenciasAceptadas;
	}
	
	public boolean aceptarSugerencia(Sugerencia nueva) {
		return listadoSugerenciasAceptadas.add(nueva); // devuelve true si se agregó
	}

}
