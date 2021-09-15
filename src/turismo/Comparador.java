package turismo;

import java.util.Comparator;

public class Comparador implements Comparator<Sugerencia> {
	TipoAtraccion atraccionFavorita;

	public Comparador(TipoAtraccion atraccionFavorita) {
		this.atraccionFavorita = atraccionFavorita;
	}

	@Override
	public int compare(Sugerencia o1, Sugerencia o2) {
		// Prioridad promocion
		if (o2.esPromocion() && !o1.esPromocion()) {
			return 1;
		}
		if (!o2.esPromocion() && o1.esPromocion()) {
			return -1;
		}

		// Prioridad atraccion favorita
		if (o2.getAtraccionSugerida() == atraccionFavorita && o1.getAtraccionSugerida() != atraccionFavorita) {
			return 1;
		}
		if (o2.getAtraccionSugerida() != atraccionFavorita && o1.getAtraccionSugerida() == atraccionFavorita) {
			return -1;
		}

		// Prioridad por dinero
		double diferenciaCosto = o2.getPrecioDeLaOferta() - o1.getPrecioDeLaOferta();
		if (diferenciaCosto != 0) {
			return diferenciaCosto > 0 ? 1 : (diferenciaCosto < 0 ? -1 : 0);
		}

		// Prioridad por tiempo
		double diferenciaTiempo = o2.getTiempoDeLaOferta() - o1.getTiempoDeLaOferta();
		return diferenciaTiempo > 0 ? 1 : (diferenciaTiempo < 0 ? -1 : 0);
	}

}
