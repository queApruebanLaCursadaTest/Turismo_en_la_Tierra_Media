package turismo;

public class Promocion {

	String nombrePromocion;
	double costoPromocion;
	TipoAtraccion tipoPromocion;
	Atraccion [] atraccionesContenidas;
	
	public Promocion(String nombrePromocion, double costoPromocion, TipoAtraccion tipoPromocion,
			Atraccion[] atraccionesContenidas) {
		super();
		this.nombrePromocion = nombrePromocion;
		this.costoPromocion = costoPromocion;
		this.tipoPromocion = tipoPromocion;
		this.atraccionesContenidas = atraccionesContenidas;
	}
	
	
}
