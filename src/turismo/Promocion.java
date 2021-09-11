package turismo;

public abstract class Promocion {

	String nombrePromocion;
	
	double montoDescuento; // Cantidad de dinero descontado
	double montoTotalConDto; // Total a pagar con el descuento
	double montoTotalSinDto; // Total a pagar sin el descuento. Coresponde al total de atracciones del pack sin la promo
	
	TipoAtraccion tipoPromocion;
	Atraccion [] atraccionesContenidas;
	
	public Promocion(String nombrePromocion, TipoAtraccion tipoPromocion,
			Atraccion[] atraccionesContenidas) throws Exception {
		
		this.nombrePromocion = nombrePromocion;
		this.tipoPromocion = tipoPromocion;
		setAtraccionesContenidas(atraccionesContenidas);
		calulcarCostoTotalSinPromo();
	}
	
	public abstract void calcularCostoPromocion();

	protected void calulcarCostoTotalSinPromo() {
		//Obtiene el costo de todas las atracciones contenidas dentro del pack sin aplicar promo
		for(Atraccion i : atraccionesContenidas) {
			montoTotalSinDto += i.getCostoAtraccion();
		}			
	}
	
	public void setAtraccionesContenidas(Atraccion[] contenidas) throws Exception {
		for(Atraccion i : contenidas) {
			if(i.getTipoDeAtraccion() != this.tipoPromocion) {
				throw new Exception("Error, las atracciones deben ser del mismo tipo "
						+ "estipulado al momento de crear la promocion");
			}
		}
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
	}	
	
}
