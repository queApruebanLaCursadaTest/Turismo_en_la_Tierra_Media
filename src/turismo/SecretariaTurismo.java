package turismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecretariaTurismo {
	private static List<Usuario> usuariosSistema = new ArrayList<Usuario>();
	private static Atraccion[] Atracciones = new Atraccion[8];

	public static void main(String[] args) {

		leerUsuarios();
		leerAtracciones(Atracciones);
	}

	public static void leerUsuarios() {
		/*
		 * Lectura de USUARIOS
		 */

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader("preferenciaUsuario.txt");
			br = new BufferedReader(fr);

			// lectura del fichero
			String linea = br.readLine();

			while (linea != null) {
				try {
					String[] datosUsuario = linea.split(";"); // Separo los datos

					// Se parsean los datos del archivo
					int dni = Integer.parseInt(datosUsuario[0]);
					String nombre = datosUsuario[1];
					double presupuesto = Double.parseDouble(datosUsuario[2]);
					double tiempo = Double.parseDouble(datosUsuario[3]);
					TipoAtraccion atrac = TipoAtraccion.valueOf(datosUsuario[4]);

					// Se extrae el usuario con dichos datos
					usuariosSistema.add(new Usuario(dni, nombre, presupuesto, tiempo, atrac));

				} catch (NumberFormatException e) {
					System.err.println("Uno o más valores no se han podido leer");

				} catch (IllegalArgumentException e) {
					System.err.println("No se ha podido leer la ateccion preferida"); // Cuando falla enum.valueOf()

				} finally {
					linea = br.readLine();// Continua la lectura del archivo
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leerAtracciones(Atraccion[] atracciones) {
		/*
		 * Lectura de Atracciones
		 */

		FileReader fr = null;
		BufferedReader br = null;
		int contador = 0;

		try {
			fr = new FileReader("archivoAtracciones.txt");
			br = new BufferedReader(fr);

			// lectura del fichero
			String linea = br.readLine();

			while (linea != null) {
				try {
					String[] datosUsuario = linea.split(";"); // Separo los datos

					// Se parsean los datos del archivo
					String nombre = datosUsuario[0];
					double costo = Double.parseDouble(datosUsuario[1]);
					double tiempo = Double.parseDouble(datosUsuario[2]);
					int cupo = (int) Double.parseDouble(datosUsuario[3]);
					TipoAtraccion atrac = TipoAtraccion.valueOf(datosUsuario[4]);
					// Se agregan las atracciones con dichos datos
					atracciones[contador] = new Atraccion(nombre, costo, tiempo, cupo, atrac);
					contador += 1;

				} catch (NumberFormatException e) {
					System.err.println("Uno o mas valores no se han podido leer");

				} catch (IllegalArgumentException e) {
					System.err.println("No se ha podido leer el tipo de atraccion preferida"); // Cuando falla
																								// enum.valueOf()

				} finally {
					linea = br.readLine();// Continua la lectura del archivo
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
