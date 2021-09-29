package turismo;

public abstract class Sugerencia {

	protected TipoAtraccion tipo;
	protected String nombre;
	protected double costo;
	protected double tiempoRequerido;
	protected boolean promocion;
	
	public Sugerencia(TipoAtraccion tipo, String nombre, Double costo, 
			Double tiempoRequerido, boolean promocion) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoRequerido = tiempoRequerido;
		this.promocion = promocion;
	}
	
	public Sugerencia(TipoAtraccion tipo, String nombre, boolean promocion) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.promocion = promocion;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCosto() {
		return costo;
	}

	public double getTiempoRequerido() {
		return tiempoRequerido;
	}

	public void setTiempoRequerido(double tiempoRequerido) {
		this.tiempoRequerido = tiempoRequerido;
	}

	public boolean esPromocion() {
		return promocion;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	


}
