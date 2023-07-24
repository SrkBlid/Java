import java.util.*;
public class AdivinarNumero {
	public static void main(String[] args) {

		int aleatorio = (int)(Math.random()*100);
		Scanner entrada = new Scanner(System.in);
		int numero = 101;
		int intentos = 0;
		
		while (numero != aleatorio) {
			System.out.print("Introduce un número: ");
			numero = entrada.nextInt();
			
			if (numero > aleatorio) {
				System.out.println("El número es menor que "+numero);
				intentos++;
			} else if (numero < aleatorio) {
				System.out.println("El número es mayor que "+numero);
				intentos++;
			} else {
				System.out.println("¡Felicidades!, encontraste el número correcto ("+aleatorio+")");
				intentos++;
			}	
		}
		
		System.out.println("Lograste adivinar el número en "+intentos+" intentos.");
		
	}
}
