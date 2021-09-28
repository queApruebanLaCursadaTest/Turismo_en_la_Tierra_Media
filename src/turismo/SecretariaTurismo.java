package turismo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SecretariaTurismo {
	private static List<Usuario>    usuarios;
	private static List<Atraccion>  atracciones;
	private static List<Promocion>  promociones;
	private static List<Sugerencia> sugerencias;
	
	public static void main(String[] args) throws Exception {
		
		usuarios 	= new LinkedList<Usuario>();
		promociones = new LinkedList<Promocion>();
		atracciones = new LinkedList<Atraccion>();
		
		// Levanto los datos desde los archivos
		usuarios    = AdministradorArchivos.leerUsuarios();
		atracciones = AdministradorArchivos.leerAtracciones();
		promociones = AdministradorArchivos.leerPromociones();

		// Preparo para leer desde la consola 
		Scanner in = new Scanner(System.in);
		int opcion = 0;
		System.out.println("##################################################################################\n"
						 + "##                             BIENVENIDO A TIERRA MEDIA                        ##\n"
						 + "##################################################################################");
		
		for(Usuario usuario : usuarios) {
			// Ordeno segun las preferencias del usuario
			Collections.sort(atracciones, new ComparadorDeSugerencias(usuario.getPreferenciaDelUsuario()));
			Collections.sort(promociones, new ComparadorDeSugerencias(usuario.getPreferenciaDelUsuario()));

			
			sugerencias = new LinkedList<Sugerencia>();
			// A�ado todo a las sugerencias
			sugerencias.addAll(promociones);
			sugerencias.addAll(atracciones);
			
			System.out.println("\nSESION INICIADA POR: \n" + usuario);
			System.out.println("-----------------------------------------------------------------------------------");
			usuario.imprimirSugerencias(sugerencias);
		}
		
	}
	
	public static List<Atraccion> traerAtracciones(String[] nombres){
		/*
		 * Dado un array de nombres, devuelve una lista con las atracciones y todos sus atributos
		 */
		List<Atraccion> atrac =  new LinkedList<Atraccion>();
		
		for (int i = 0; i < nombres.length; i++) {
			for(int j = 0; j < atracciones.size(); j++) {
				if(atracciones.get(j).getNombre().contains(nombres[i])) {
					atrac.add(atracciones.get(j));
				}
			}
		}
		
		return atrac;
	}
}
