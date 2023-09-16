package pila;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;
import pila.PilaArreglo;

public class FinArchivo {

	private static final String AYUDA = "--ayuda";

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Indique la ruta del archivo: ");
		///home/joaquin/Escritorio/Java/Practico2/src/pila/ejemplo.txt
		String ruta = entrada.nextLine();
			if (ruta.length() == 0) {
				System.err.println("Se espera al menos un argumento");
				mostrarUso();
				System.exit(1);
			}
			if (ruta.compareToIgnoreCase(AYUDA) == 0) {
				mostrarUso();
				System.exit(0);
			}
				Path rutaAlArchivo = Paths.get(ruta);
				if (!rutaAlArchivo.toFile().exists()) {
					System.err.println("El archivo " + rutaAlArchivo.toString() + " no existe");
					System.exit(2);
				}
				if (!rutaAlArchivo.toFile().isFile()) {
					System.err.println("La ruta " + rutaAlArchivo.toString() + " no representa un archivo");
					System.exit(2);
				}
				if (!rutaAlArchivo.toFile().canRead()) {
					System.err.println("No se tienen permisos de lectura para el archivo " + rutaAlArchivo.toString());
					System.exit(2);
				}
				Integer n = null;
				try {
					System.out.print("Indique cuantas ultimas lineas quiere ver: ");
					n = entrada.nextInt();
				} catch (NumberFormatException nfe) {
					System.err.println("Formato incorrecto para el argumento n (" + args[1] + "), se espera un entero");
					System.exit(2);
				}
				mostrarUltimasNLineas(rutaAlArchivo, n);
			}
	
	private static void mostrarUltimasNLineas(Path rutaAlArchivo, Integer n) {
		try {
			PilaArreglo aux = new PilaArreglo();
			PilaArreglo aux2 = new PilaArreglo();
			
			//Llenamos el primer arreglo con todas las lineas dentro del archivo, de tal manera que
			//tengamos en el tope de la pila a la ultima linea del mismo.
			for (String linea : Files.readAllLines(rutaAlArchivo)) {
				aux.apilar(linea);
			}
			
			//Ahora lo que hacemos es colocar en un nuevo arreglo todos las ultimas n lineas.
			for(int i = 0; i < n; i++) {
				aux2.apilar(aux.desapilar());
			}
			
			//Por ultimo los vamos mostrando uno a uno.
			for(int i = 0; i < n; i++) {
				System.out.println(aux2.tope());
				aux2.desapilar();
			}
			
		} catch (IOException ioe) {
			System.err.println("Ocurrió un problema durante la lectura del archivo");
			ioe.printStackTrace(System.err);
			System.exit(2);
		}
	}
	
	private static void mostrarUso() {
		String uso = 	"FinArchivo\n" +
				"Muestra las últimas n líneas de un archivo.\n" +
				"Uso:\n" +
				"java FinArchivo --ayuda					:	muestra este mensaje.\n" +
				"java FinArchivo <ruta a un archivo> <entero mayor a 0>	:	imprime las últimas n de un archivo.\n"
		;
		System.out.println(uso);
	}

}
