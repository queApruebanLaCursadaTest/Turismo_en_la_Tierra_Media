package test;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;
import turismo.*;

import org.junit.Test;

public class AdministradorArchivosTest {

	@Test
	public void lecturaUsuarios() {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		List<Usuario> usuariosEsperados = new LinkedList<Usuario>();
		
		usuarios = AdministradorArchivos.leerUsuarios();

		usuariosEsperados.add(new Usuario(42359363,"Dante Mogni", 5000, 90, TipoAtraccion.AVENTURA));
		usuariosEsperados.add(new Usuario(32541555,"Maria Eugenia", 1350, 30, TipoAtraccion.PAISAJE));
		usuariosEsperados.add(new Usuario(40700466,"Oscar Lopez", 100, 15, TipoAtraccion.DEGUSTACION));
		
		assertTrue(usuarios.containsAll(usuariosEsperados));
		
	}
	
	@Test
	public void lecturaAtracciones() {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		List<Atraccion> atraccionesEsperadas = new LinkedList<Atraccion>();
		
		atracciones = AdministradorArchivos.leerAtracciones();

		atraccionesEsperadas.add(new Atraccion(TipoAtraccion.AVENTURA, "Moria", 10, 2, 6));
		atraccionesEsperadas.add(new Atraccion(TipoAtraccion.PAISAJE, "Minas Tirith", 5, 2.5, 25));
		atraccionesEsperadas.add(new Atraccion(TipoAtraccion.DEGUSTACION, "La Comarca", 3, 6.5, 150));
		
		assertTrue(atracciones.containsAll(atraccionesEsperadas));
		
	}
	
	@Test
	public void leerPromociones() throws Exception {
		List<Promocion> promociones = new LinkedList<Promocion>();
		String[] atraccionesContenidas = {"Lothlorien", "La Comarca"};
		
		promociones = AdministradorArchivos.leerPromociones();
				
		Promocion promocionEsperada = new PromocionAbsoluta(TipoAtraccion.DEGUSTACION, "Pack Degustacion", SecretariaTurismo.traerAtracciones(atraccionesContenidas),36);

		assertTrue(promociones.contains(promocionEsperada));
		
	}

}
