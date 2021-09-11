package turismo;

public class PromocionAxB extends Promocion {

	Atraccion [] atraccionesGratis;

	public PromocionAxB(String nombrePromocion, TipoAtraccion tipoPromocion,
			Atraccion[] atraccionesContenidas, Atraccion[] atraccionesGratis) throws Exception {
		
		super(nombrePromocion, tipoPromocion, atraccionesContenidas);
		this.atraccionesGratis = atraccionesGratis;
		
		calcularCostoPromocion();
	}
	
	@Override
	public void calcularCostoPromocion() {
		double montoTotal = 0;
		double montoNetoDescuento = 0;
		double precioConDescuento = 0;
		
		for(Atraccion i : atraccionesContenidas) {
			montoTotal += i.costoAtraccion; //sumo el costo total sin dto.
		}
		
		for(Atraccion i : atraccionesGratis) {
			montoNetoDescuento += i.costoAtraccion; //monto a descontar
		}
		
		precioConDescuento = montoTotal - montoNetoDescuento;
		
		setMontoDescuento(montoNetoDescuento);
		setMontoTotalConDto(precioConDescuento);
	}
	 
	
	@Override
	public String toString() {
		String mensaje = ">>> Promocion '" + nombrePromocion + "'\n\n";
		
		mensaje += "Costo sin descuento: " + montoTotalSinDto + '\n';
		mensaje += "Descuento total: " + montoDescuento + '\n';
		mensaje += "Nuevo costo (c/dto): " + montoTotalConDto + "\n\n";
		
		mensaje += "Atracciones Gratuitas: \n";
		for(Atraccion i : atraccionesGratis) {
			mensaje += "\t> " + i.getNombreAtraccion() + " -$" + i.getCostoAtraccion() + '\n';
		}
		mensaje += "Total atracciones: \n";
		for(Atraccion i : atraccionesContenidas) {
			mensaje += "\t> " + i.getNombreAtraccion() + '\n';
		}
		return mensaje;
	}
	
}
