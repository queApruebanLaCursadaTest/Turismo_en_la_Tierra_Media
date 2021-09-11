package turismo;

public class PromocionPorcentual extends Promocion{
	
	double porcentajeDescuento;

	public PromocionPorcentual(String nombrePromocion, TipoAtraccion tipoPromocion,
			Atraccion[] atraccionesContenidas, double porcentajeDescuento) throws Exception {
		super(nombrePromocion, tipoPromocion, atraccionesContenidas);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public void calcularCostoPromocion() {
		setMontoDescuento((montoTotalSinDto / 100) * porcentajeDescuento);
		setMontoTotalConDto(montoTotalSinDto - montoDescuento);
	}
	
	@Override
	public String toString() {
		String mensaje = ">>> Promocion '" + nombrePromocion + "'\n\n";
		
		mensaje += "Costo sin descuento: " + montoTotalSinDto + '\n';
		mensaje += "Descuento total: " + montoDescuento + '\n';
		mensaje += "Nuevo costo (c/dto): " + montoTotalConDto + "\n";
		mensaje += "Porcentaje de descunto: " + porcentajeDescuento + "\n";
		
		mensaje += "Total atracciones: \n";
		for(Atraccion i : atraccionesContenidas) {
			mensaje += "\t> " + i.getNombreAtraccion() + '\n';
		}
		return mensaje;
	}

}
