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
	}
	
	public void imprimirSugerencias(List<Sugerencia> sugerencias) {
		System.out.println("\n• MOSTRANDO SUGERIDAS:");
		for(Sugerencia sugerencia : sugerencias) {
			System.out.println(sugerencia);
		}
	}
	
	public boolean aceptarSugerencia(Sugerencia nueva) {
		this.presupuesto -= nueva.getCosto();
		this.tiempoDisponible -= nueva.getTiempoRequerido();
		return itinerarioPersonal.aceptarSugerencia(nueva); //devuelve true si se añadió
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
				+ "\t> Tiempo: " + tiempoDisponible;
		return msg;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}
}
