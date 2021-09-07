package turismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  SecretariaTurismo {
	private static List<Usuario> usuariosSistema = new ArrayList<Usuario>();

	public static void main(String[] args) {
		
		leerPreferenciaUsuarios();
	}

	public static void leerPreferenciaUsuarios() {
		/*
		 * Lectura de USUARIOS
		 */
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader ("preferenciaUsuario.txt");
			br = new BufferedReader(fr);
			
			//lectura del fichero
			String linea = br.readLine();
			
			while(linea!=null) {
				try {
					String[] datosUsuario = linea.split(";"); //Separo los datos	
					
					//Se parsean los datos del archivo
					int dni 			= Integer.parseInt(datosUsuario[0]);
					String nombre 		= datosUsuario[1];
					double presupuesto 	= Double.parseDouble(datosUsuario[2]);
					double tiempo 		= Double.parseDouble(datosUsuario[3]);
					TipoAtraccion atrac = TipoAtraccion.valueOf(datosUsuario[4]);
					
					//Se añade el usuario con dichos datos
					usuariosSistema.add(new Usuario(dni,nombre,presupuesto,tiempo,atrac));
					
				} catch(NumberFormatException e) {
					System.err.println("Uno o más valores no se han podido leer"); 
					
				} catch(IllegalArgumentException e) {
					System.err.println("No se ha podido leer la ateccion preferida"); //Cuando falla enum.valueOf()
					
				} finally {
					linea = br.readLine(); // Continua la lectura del archivo
				}
			}
		} catch(IOException e) {
			e.printStackTrace(); 
		}	
	}
}
