package turismo;

public abstract class Sugerencia {

	double tiempoDeLaOferta;
	double precioDeLaOferta;
	//Atraccion atraccionSugerida;
	TipoAtraccion atraccionSugerida;
	Promocion promocionSugerida;
	
	/*
	 * NOTA: 
	 * 
	 * Si se lo piensa bien, la clase Sugerencia no tendría que tener los
	 * atributos 
	 * 		double tiempoDeLaOferta 
	 * 		double precioDeLaOferta 
	 * 		TipoAtraccion atraccionSugerida 
	 * dado que éstos son atributos que se pueden obtener de la Atraccion misma que contiene la sugerencia
	 * 
	 * 
	 * Y como una Sugerencia puede ser tanto Promocion o Atraccion individual, se
	 * harían solo los dos contructores de manera más simple.
	 * 
	 * Quedaría: 
	 * 		> atributos: 
	 * 			Atraccion atraccionSugerida; 
	 * 			Promocion promocionSugerida; 
	 * 
	 * 		> constructores:
	 * 			public Sugerencia(Atraccion atraccionSugerida) { 
	 * 				this.atraccionSugerida = atraccionSugerida; 
	 * 			}
	 * 
	 * 			public Sugerencia(Promocion promocionSugerida) { 
	 * 				this.promocionSugerida = promocionSugerida; 
	 * 			}
	 */
	
	//TODO: MODIFICAR (ver NOTA mas arriba)
	public Sugerencia(double tiempoDeLaOferta, double precioDeLaOferta, Promocion promocionSugerida) {
		this.tiempoDeLaOferta = tiempoDeLaOferta;
		this.precioDeLaOferta = precioDeLaOferta;
		this.promocionSugerida = promocionSugerida;
	}

	//TODO: MODIFICAR (ver NOTA mas arriba)
	  public Sugerencia(double tiempoDeLaOferta, double precioDeLaOferta, TipoAtraccion atraccionSugerida, Promocion promocionSugerida) { 
		super();
		this.tiempoDeLaOferta = tiempoDeLaOferta; 
		this.precioDeLaOferta = precioDeLaOferta; 
		this.atraccionSugerida = atraccionSugerida;
		this.promocionSugerida = promocionSugerida; 
	  }
	 
	  //TODO: Borrar getters/setters. Éstos seran accedidos desde las clases Atracciones y Promociones (ver NOTA mas arriba)
	public double getTiempoDeLaOferta() {
		return tiempoDeLaOferta;
	}

	public void setTiempoDeLaOferta(double tiempoDeLaOferta) {
		this.tiempoDeLaOferta = tiempoDeLaOferta;
	}

	public double getPrecioDeLaOferta() {
		return precioDeLaOferta;
	}

	public void setPrecioDeLaOferta(double precioDeLaOferta) {
		this.precioDeLaOferta = precioDeLaOferta;
	}

	public TipoAtraccion getAtraccionSugerida() {
		return atraccionSugerida;
	}

	public void setAtraccionSugerida(TipoAtraccion atraccionSugerida) {
		this.atraccionSugerida = atraccionSugerida;
	}

	public Promocion getPromocionSugerida() {
		return promocionSugerida;
	}

	public boolean esPromocion() {
		return this.promocionSugerida != null;
	}

}
