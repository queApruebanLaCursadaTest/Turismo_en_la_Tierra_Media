package turismo;

public class PromocionAbsoluta extends Promocion{

	double descuentoTotal;

	public PromocionAbsoluta(String nombrePromocion, double costoPromocion, TipoAtraccion tipoPromocion,
			Atraccion[] atraccionesContenidas, double descuentoTotal) {
		super(nombrePromocion, costoPromocion, tipoPromocion, atraccionesContenidas);
		this.descuentoTotal = descuentoTotal;
	}
}
