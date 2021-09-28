package turismo;

import java.util.Collections;
import java.util.Iterator;
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
		String opcion = "";
		System.out.println("##################################################################################\n"
						 + "##                             BIENVENIDO A TIERRA MEDIA                        ##\n"
						 + "##################################################################################");
		
		for(Usuario usuario : usuarios) {
			// Ordeno segun las preferencias del usuario
			Collections.sort(atracciones, new ComparadorDeSugerencias(usuario.getPreferenciaDelUsuario()));
			Collections.sort(promociones, new ComparadorDeSugerencias(usuario.getPreferenciaDelUsuario()));

			
			sugerencias = new LinkedList<Sugerencia>();
			// Añado todo a las sugerencias
			sugerencias.addAll(promociones);
			sugerencias.addAll(atracciones);
			
			// Muestro los datos del usuario y las sugerencias que el sistema encontró
			System.out.println("\nSESION INICIADA POR: \n" + usuario);
			System.out.println("-----------------------------------------------------------------------------------");
			usuario.imprimirSugerencias(sugerencias);
			System.out.println("-----------------------------------------------------------------------------------");

			Iterator<Sugerencia> itr = sugerencias.iterator();
			
			do {
				Sugerencia sugerenciaCursor = itr.next();
				System.out.println("¿Desea comprar " + sugerenciaCursor.getNombre() + "? (s/n)");
				opcion = in.next();
				switch(opcion) {
					case "s":
						usuario.aceptarSugerencia(sugerenciaCursor);
						break;
						
					case "n":
						break;
					
					case "q":
						System.out.println("Usted ha salido.");
						break;
				}
				
			} while(itr.hasNext() && !opcion.equalsIgnoreCase("q"));
			
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
