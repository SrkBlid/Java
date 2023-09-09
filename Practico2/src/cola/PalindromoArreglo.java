package cola;
import cola.ColaArregloFijo;
import java.util.Scanner;

public class PalindromoArreglo {
	private String palabra;	
	
	public PalindromoArreglo() {
		Scanner entrada = new Scanner(System.in);
		palabra = entrada.nextLine().toLowerCase();
	}

	public PalindromoArreglo(String entrada) {
		palabra = entrada.toLowerCase();
	}
	
	public String palabra() {
		return palabra;
	}
	
	public boolean esPalindromo() {
		ColaArregloFijo cola1 = new ColaArregloFijo(palabra.length());
		for (int i = 0; i < palabra.length(); i++) {
			cola1.encolar(palabra.charAt(i));
		}
		
		ColaArregloFijo cola2 = new ColaArregloFijo(palabra.length());
		for (int i = palabra.length()-1; i >= 0; i--) {
			cola2.encolar(palabra.charAt(i));
		}
		
		for (int i = 0; i < palabra.length(); i++) {
			if (cola1.elemento(i) != cola2.elemento(i)) {
				return false;
			}
		}
		return true;
	}
}
