package pila;
import pila.PilaEnlazada;
import java.util.Scanner;

public class NumerosInversos {
	
	public static void main(String[] args) {
		PilaEnlazada pila1 = new PilaEnlazada();
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Indique el tamaño del arreglo: ");
		int tam = entrada.nextInt();
		
		for(int i = 0; i < tam; i++) {
			System.out.print("Ingrese el "+(i+1)+" elemento: ");
			int elem = entrada.nextInt();
			pila1.apilar(elem);
		}
		System.out.println("El arreglo original es: "+pila1);
		
		System.out.print("El arreglo al inverso es: ");
		System.out.print("[");
		for(int i = pila1.longitud(); i > 0; i--) {
			System.out.print(pila1.tope());
			pila1.desapilar();
			if (i > 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}

}
