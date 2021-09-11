package turismo;

public class PromocionAbsoluta extends Promocion{

	double descuentoTotal;

	public PromocionAbsoluta(String nombrePromocion, TipoAtraccion tipoPromocion,
			Atraccion[] atraccionesContenidas, double descuentoTotal) throws Exception {
		super(nombrePromocion, tipoPromocion, atraccionesContenidas);
		this.descuentoTotal = descuentoTotal;
	}

	@Override
	public void calcularCostoPromocion() {
		super.setMontoDescuento(descuentoTotal);
		super.setMontoTotalConDto(super.montoTotalSinDto - descuentoTotal);
	}
	
	@Override
	public String toString() {
		String mensaje = ">>> Promocion '" + nombrePromocion + "'\n\n";
		
		mensaje += "Costo sin descuento: " + montoTotalSinDto + '\n';
		mensaje += "Descuento total: " + montoDescuento + '\n';
		mensaje += "Nuevo costo (c/dto): " + montoTotalConDto + "\n";
		
		mensaje += "Total atracciones: \n";
		for(Atraccion i : atraccionesContenidas) {
			mensaje += "\t> " + i.getNombreAtraccion() + '\n';
		}
		return mensaje;
	}
}
