package turismo;

public class PromocionPorcentual extends Promocion{
	
	double porcentajeDescuento;

	public PromocionPorcentual(String nombrePromocion, double costoPromocion, TipoAtraccion tipoPromocion,
			Atraccion[] atraccionesContenidas, double porcentajeDescuento) {
		super(nombrePromocion, costoPromocion, tipoPromocion, atraccionesContenidas);
		this.porcentajeDescuento = porcentajeDescuento;
	}
	

}
