package turismo;

public class Atraccion {

	String nombreAtraccion;
	double costoAtraccion;
	double tiempoRequerido;
	int cupoMaximo;
	int cupoActual = 0;
	TipoAtraccion tipoDeAtraccion;

	public Atraccion(String nombreAtraccion, double costoAtraccion, double tiempoRequerido, int cupoMaximo,
			TipoAtraccion tipoDeAtraccion) {

		this.nombreAtraccion = nombreAtraccion;
		this.costoAtraccion = costoAtraccion;
		this.tiempoRequerido = tiempoRequerido;
		this.cupoMaximo = cupoMaximo;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	public String getNombreAtraccion() {
		return nombreAtraccion;
	}

	public void setNombreAtraccion(String nombreAtraccion) {
		this.nombreAtraccion = nombreAtraccion;
	}

	public double getCostoAtraccion() {
		return costoAtraccion;
	}

	public void setCostoAtraccion(double costoAtraccion) {
		this.costoAtraccion = costoAtraccion;
	}

	public TipoAtraccion getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	public void setTipoDeAtraccion(TipoAtraccion tipoDeAtraccion) {
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

}
