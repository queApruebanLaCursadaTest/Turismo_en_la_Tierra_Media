package turismo;

public class PromocionAxB extends Promocion {

	Atraccion [] atraccionesGratis;

	public PromocionAxB(String nombrePromocion, double costoPromocion, TipoAtraccion tipoPromocion,
			Atraccion[] atraccionesContenidas, Atraccion[] atraccionesGratis) {
		super(nombrePromocion, costoPromocion, tipoPromocion, atraccionesContenidas);
		this.atraccionesGratis = atraccionesGratis;
	}
	
	
	
	
}
