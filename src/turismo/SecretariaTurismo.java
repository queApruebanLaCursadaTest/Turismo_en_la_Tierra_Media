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
		String opcion = null;
		String mensaje = null;
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
			
			// Muestro los datos del usuario y las sugerencias que el sistema encontr�
			System.out.println("\nSESION INICIADA POR: \n" + usuario);
			System.out.println("-----------------------------------------------------------------------------------");
			usuario.imprimirSugerencias(sugerencias);
			System.out.println("-----------------------------------------------------------------------------------");

			Iterator<Sugerencia> itr = sugerencias.iterator();
			do {
				Sugerencia sugerenciaCursor = itr.next();
				System.out.println("[ Dinero en la cuenta: " + usuario.getPresupuesto() + ", Tiempo Max. Programado: (min) " + usuario.getTiempoDisponible() + " ]\n");
				System.out.println("�Desea comprar " + sugerenciaCursor.getNombre() + "?\n"
						+ "[s] - si \t [n] - no \t [q] - salir");
				opcion = in.next();
				switch(opcion) {
					case "s":
						if(usuario.aceptarSugerencia(sugerenciaCursor)) 
							mensaje = "##################################################################################\n"
									 + "##                         �Compra realizada con exito!                        ##\n"
									 + "##################################################################################";
						else 
							 mensaje = "##################################################################################\n"
									 + "##                Lo sentimos, no se pudo efectual la compra                    ##\n"
									 + "##################################################################################";
						
						break;
						
					case "n":
						mensaje =  "##################################################################################\n"
								 + "##            Sugerencia no aceptada. Pasando a la siguiente opcion...          ##\n"
								 + "##################################################################################";;
						break;
					
					case "q":
						mensaje =  "##################################################################################\n"
								 + "##                         Usted ha salido. Hasta luego!                        ##\n"
								 + "##################################################################################";;
						break;
				}
				
				System.out.println(mensaje);
				System.out.println("-----------------------------------------------------------------------------------");
			} while(itr.hasNext() && !opcion.equalsIgnoreCase("q"));
			AdministradorArchivos.escribirUsuario(usuario);
		}
		System.out.println("------------------ Atencion: No hay mas usuarios en el sistema. Fin del proceso ------------------");
		in.close();
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
