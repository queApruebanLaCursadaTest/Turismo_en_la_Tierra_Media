package turismo;

import java.util.List;

public class Itinerario {
	
	List <Sugerencia> listadoSugerenciasAceptadas;

	public Itinerario(List<Sugerencia> listadoSugerenciasAceptadas) {
		super();
		this.listadoSugerenciasAceptadas = listadoSugerenciasAceptadas;
	}
	
	public boolean aceptarSugerencia(Sugerencia nueva) {
		return listadoSugerenciasAceptadas.add(nueva); // devuelve true si se agregó
	}

}
