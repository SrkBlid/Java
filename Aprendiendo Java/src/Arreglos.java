import java.util.*;
public class Arreglos {

	public static void main(String[] args) {
		int arreglo[] = new int[5];
		Scanner entrada = new Scanner(System.in);
		
		//Declararla de forma conjunta:
		//int arreglo[] = {1, 2, 3, 4, 5};
		
		for (int i = 0; i < arreglo.length ; i++) {
			System.out.print("Ingrese el valor que se guardara en la posición "+i+": ");
			arreglo[i] = entrada.nextInt();
		}
		
		System.out.print("Los valores que usted guardo en el arreglo son: ");
		for (int i = 0; i < arreglo.length ; i++) {
			System.out.print(arreglo[i]+" ");
		}
		
	}

}
