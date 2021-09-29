package turismo;

import java.util.List;

public class PromocionAxB extends Promocion {

	private List<Atraccion> atraccionesGratis;

	public PromocionAxB(TipoAtraccion tipoPromocion, String nombrePromocion,
			List<Atraccion> atraccionesContenidas, List<Atraccion> atraccionesGratis) {
		
		super(tipoPromocion, nombrePromocion, atraccionesContenidas);
		this.atraccionesGratis = atraccionesGratis;
		
		calcularCostoPromocion();
	}
	
	@Override
	public void calcularCostoPromocion() {
		double montoTotal = 0;
		double montoNetoDescuento = 0;
		double precioConDescuento = 0;
		
		for(Atraccion atraccion : atraccionesContenidas) {
			montoTotal += atraccion.getCosto(); //sumo el costo total sin dto.
		}
		
		for(Atraccion atraccion : atraccionesGratis) {
			montoNetoDescuento += atraccion.getCosto(); //monto a descontar
		}
		
		precioConDescuento = montoTotal - montoNetoDescuento;
		
		setMontoDescuento(montoNetoDescuento);
		setMontoTotalConDto(precioConDescuento);
	}
	 
	
	@Override
	public String toString() {
		String mensaje = ">>> Promocion '" + super.nombre + "'\n";
		
		mensaje += "\tCosto sin descuento: " + super.montoTotalSinDto + '\n';
		mensaje += "\tDescuento total: " + super.montoDescuento + '\n';
		mensaje += "\tNuevo costo (c/dto): " + super.montoTotalConDto + "\n\n";
		
		mensaje += "\tAtracciones Gratuitas: \n";
		for(Atraccion atraccion : this.atraccionesGratis) {
			mensaje += "\t\t> " + atraccion.getNombre() + " (-$" + atraccion.getCosto()+ ")\n";
		}
		mensaje += "\tTotal atracciones: \n";
		for(Atraccion atraccion : super.atraccionesContenidas) {
			mensaje += "\t\t> " + atraccion.getNombre() + '\n';
		}
		mensaje += "\n\tTiempo Requerido (min): " + super.tiempoRequerido + "\n";

		return mensaje;
	}
	
}
