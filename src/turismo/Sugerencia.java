package turismo;

public abstract class Sugerencia {

	double tiempoDeLaOferta;
	double precioDeLaOferta;
	Atraccion atraccionSugerida;
	Promocion promocionSugerida;
	
	public Sugerencia(double tiempoDeLaOferta, double precioDeLaOferta, Atraccion atraccionSugerida,
			Promocion promocionSugerida) {
		super();
		this.tiempoDeLaOferta = tiempoDeLaOferta;
		this.precioDeLaOferta = precioDeLaOferta;
		this.atraccionSugerida = atraccionSugerida;
		this.promocionSugerida = promocionSugerida;
	}
	
	


}
