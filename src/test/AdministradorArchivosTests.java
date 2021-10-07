package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import turismo.*;

import org.junit.Test;

public class AdministradorArchivosTests {

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
	
	@Test
	public void escribirUsuario() throws Exception {
		/**
		 * Testea el primer usuario (en este caso "Dante Mogni"), aceptando las dos primeras sugerencias que surgen
		 */
		List<Usuario> usuarios = new LinkedList<Usuario>();
		List<Sugerencia> sugerencias = new LinkedList<Sugerencia>();
		List<Atraccion>  atracciones = new LinkedList<Atraccion>(); 
		List<Promocion>  promociones = new LinkedList<Promocion>();
		
		// Genero el proceso por el cual se generan las sugerencias para hacer el test
		usuarios = AdministradorArchivos.leerUsuarios();
		atracciones = AdministradorArchivos.leerAtracciones();
		promociones = AdministradorArchivos.leerPromociones();

		//Se testea sobre el priemr usuario
		Usuario userTest = usuarios.get(0);
		
		Collections.sort(atracciones, new ComparadorDeSugerencias(userTest.getPreferenciaDelUsuario()));
		Collections.sort(promociones, new ComparadorDeSugerencias(userTest.getPreferenciaDelUsuario()));

		sugerencias.addAll(promociones);
		sugerencias.addAll(atracciones);
		
		// Acepta las dos primeras sugerencias
		userTest.aceptarSugerencia(sugerencias.get(0));
		userTest.aceptarSugerencia(sugerencias.get(1));
		
		// Escribe el archivo del primer usuario (en este caso, "Dante Mogni")
		AdministradorArchivos.escribirUsuario(userTest);
		
		String textoArchivoTest = null;
		String textoArchivoSalida = null;
		
		FileReader fr = null;
		BufferedReader br = null;
		
		// Lee el archivo test y almacena el valor en una variable String
		try {
			fr = new FileReader("archivos-test/testDelPrimerUsuario.txt");
			br = new BufferedReader(fr);

			// lectura del fichero
			String linea = br.readLine();
			
			while (linea != null) {
				try {
					textoArchivoTest += linea;
				} finally {
					linea = br.readLine();// Continua la lectura del archivo
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Lee el archvio salida del primer usuario y lo almacena en un String
		try {
			fr = new FileReader("archivos-salida/Dante Mogni.txt");
			br = new BufferedReader(fr);

			// lectura del fichero
			String linea = br.readLine();
			
			
			while (linea != null) {
				try {
					textoArchivoSalida += linea;
				} finally {
					linea = br.readLine();// Continua la lectura del archivo
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(textoArchivoSalida, textoArchivoTest);
	}

}
