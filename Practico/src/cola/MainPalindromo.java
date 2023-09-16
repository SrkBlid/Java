package cola;
import cola.PalindromoArreglo;

public class MainPalindromo {

	public static void main(String[] args) {
		PalindromoArreglo palabra1 = new PalindromoArreglo();
		System.out.println("¿La palabra '"+palabra1.palabra()+"' es palindroma? "+palabra1.esPalindromo());
		PalindromoArreglo palabra2 = new PalindromoArreglo("ReCoNOceR");
		System.out.println("¿La palabra '"+palabra2.palabra()+"' es palindroma? "+palabra2.esPalindromo());
	}

}
