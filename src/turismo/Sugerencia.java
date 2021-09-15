package turismo;

public abstract class Sugerencia {

	double tiempoDeLaOferta;
	double precioDeLaOferta;
	TipoAtraccion atraccionSugerida;
	Promocion promocionSugerida;
	//
	public Sugerencia(double tiempoDeLaOferta, double precioDeLaOferta, TipoAtraccion atraccionSugerida) {
		this.tiempoDeLaOferta = tiempoDeLaOferta;
		this.precioDeLaOferta = precioDeLaOferta;
		this.atraccionSugerida = atraccionSugerida;
	}

	public Sugerencia(double tiempoDeLaOferta, double precioDeLaOferta, Promocion promocionSugerida) {
		this.tiempoDeLaOferta = tiempoDeLaOferta;
		this.precioDeLaOferta = precioDeLaOferta;
		this.promocionSugerida = promocionSugerida;
	}

	/*
	 * public Sugerencia(double tiempoDeLaOferta, double precioDeLaOferta,
	 * TipoAtraccion atraccionSugerida, Promocion promocionSugerida) { super();
	 * this.tiempoDeLaOferta = tiempoDeLaOferta; this.precioDeLaOferta =
	 * precioDeLaOferta; this.atraccionSugerida = atraccionSugerida;
	 * this.promocionSugerida = promocionSugerida; }
	 */

	public double getTiempoDeLaOferta() {
		return tiempoDeLaOferta;
	}

	public double getPrecioDeLaOferta() {
		return precioDeLaOferta;
	}

	public TipoAtraccion getAtraccionSugerida() {
		return atraccionSugerida;
	}

	public Promocion getPromocionSugerida() {
		return promocionSugerida;
	}

	public boolean esPromocion() {
		return this.promocionSugerida != null;
	}

}
