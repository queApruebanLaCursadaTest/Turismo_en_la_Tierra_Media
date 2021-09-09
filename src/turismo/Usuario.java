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

		// TODO: intinerarioPersonal ?
	}

}
