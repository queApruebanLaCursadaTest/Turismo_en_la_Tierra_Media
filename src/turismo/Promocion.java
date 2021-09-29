package turismo;

import java.util.List;

public abstract class Promocion extends Sugerencia {

	protected double montoDescuento; // Cantidad de dinero descontado
	protected double montoTotalConDto; // Total a pagar con el descuento
	protected double montoTotalSinDto; // Total a pagar sin el descuento. Coresponde al total de atracciones del pack
								// sin la promo

	List<Atraccion> atraccionesContenidas;

	public Promocion(TipoAtraccion tipoDePromocion, String nombrePromocion,
			List<Atraccion> atraccionesContenidas) {
		super(tipoDePromocion, nombrePromocion, true);
		this.atraccionesContenidas = atraccionesContenidas;
		calcularTiempoRequeridoPromocion();
		calulcarCostoTotalSinPromo();
		}
	

	public abstract void calcularCostoPromocion();

	protected void calulcarCostoTotalSinPromo() {
		// Obtiene el costo de todas las atracciones contenidas dentro del pack sin
		// aplicar promo
		for (Atraccion atraccion : atraccionesContenidas) {
			montoTotalSinDto += atraccion.getCosto();
		}
	}
	
	private void calcularTiempoRequeridoPromocion() {
		double suma = 0;
		for(Atraccion atraccion : atraccionesContenidas) {
			suma += atraccion.getTiempoRequerido();
		}
		
		super.setTiempoRequerido(suma);
	}
	
	public double getMontoDescuento() {
		return montoDescuento;
	}

	public void setMontoDescuento(double montoDescuento) {
		this.montoDescuento = montoDescuento;
	}

	public double getMontoTotalConDto() {
		return montoTotalConDto;
	}

	public void setMontoTotalConDto(double montoTotalConDto) {
		this.montoTotalConDto = montoTotalConDto;
		super.setCosto(montoTotalConDto);
	}

}
