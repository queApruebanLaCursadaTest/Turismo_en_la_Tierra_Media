package turismo;

import java.util.List;

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
		this.itinerarioPersonal = new Itinerario();
	}
	
	public void imprimirSugerencias(List<Sugerencia> sugerencias) {
		System.out.println("\n• MOSTRANDO SUGERIDAS:");
		for(Sugerencia sugerencia : sugerencias) {
			System.out.println(sugerencia);
		}
	}
	
	public boolean aceptarSugerencia(Sugerencia nueva) {
		boolean agregada = false;
		if(puedoAceptar(nueva)) {
			this.presupuesto -= nueva.getCosto();
			this.tiempoDisponible -= nueva.getTiempoRequerido();
			
			agregada = itinerarioPersonal.aceptarSugerencia(nueva);
		}
		
		return agregada;
	}
	
	private boolean puedoAceptar(Sugerencia sugerencia) {
		return this.tiempoDisponible >= sugerencia.getTiempoRequerido()
				&& this.presupuesto >= sugerencia.getCosto();
	}
	
	public String getNombreDeUsuario() {
		return nombreDeUsuario;
	}

	public TipoAtraccion getPreferenciaDelUsuario() {
		return preferenciaDelUsuario;
	}

	@Override
	public String toString() {
		String msg = "\t> Nombre: " + nombreDeUsuario + "\n"
				+ "\t> Atraccion Preferida: " + preferenciaDelUsuario + "\n"
				+ "\t> Monedas: " + presupuesto + "\n"
				+ "\t> Tiempo (min): " + tiempoDisponible;
		return msg;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public Itinerario getItinerarioPersonal() {
		return itinerarioPersonal;
	}
}
