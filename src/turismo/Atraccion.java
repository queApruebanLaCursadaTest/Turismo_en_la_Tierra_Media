package turismo;

public class Atraccion {

	String nombreAtraccion;
	double costoAtraccion;
	double tiempoRequerido;
	int cupoMaximo;
	int cupoActual;
	TipoAtraccion tipoDeAtraccion;
	
	public Atraccion(String nombreAtraccion, double costoAtraccion, double tiempoRequerido, int cupoMaximo,
			int cupoActual, TipoAtraccion tipoDeAtraccion) {
		super();
		this.nombreAtraccion = nombreAtraccion;
		this.costoAtraccion = costoAtraccion;
		this.tiempoRequerido = tiempoRequerido;
		this.cupoMaximo = cupoMaximo;
		this.cupoActual = cupoActual;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}
	
	
}
