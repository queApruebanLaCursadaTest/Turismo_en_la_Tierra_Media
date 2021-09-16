package turismo;

public class Usuario {

	int dni;
	String nombreDeUsuario;
	double presupuesto;
	double tiempoDisponible;
	Itinerario itinerarioPersonal;
	TipoAtraccion preferenciaDelUsuario;

	public Usuario(int dni, String nombreDeUsuario, double presupuesto, double tiempoDisponible,
			TipoAtraccion preferenciaDelUsuario) {

		this.dni = dni;
		this.nombreDeUsuario = nombreDeUsuario;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.preferenciaDelUsuario = preferenciaDelUsuario;
	}
	
	public boolean aceptarSugerencia(Sugerencia nueva) {
		return itinerarioPersonal.aceptarSugerencia(nueva); //devuelve true si se añadió
	}
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
}
