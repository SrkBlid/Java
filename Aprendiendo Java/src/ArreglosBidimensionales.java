import java.util.*;
public class ArreglosBidimensionales {

	public static void main(String[] args) {
		
		//[][] significa que es bidimensional
		int matriz[][] = new int[4][5];
		Scanner entrada = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("Ingrese el elemento de la fila "+i+" en la posición "+j+": ");
				matriz[i][j] = entrada.nextInt();
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("El elemento en la fila "+i+" en la posición "+j+" es: "+matriz[i][j]);
			}
		}
		
	}

}
