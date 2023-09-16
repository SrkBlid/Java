package pila;
import pila.PilaEnlazada;

public class MainPilaEnlazada {

	public static void main(String[] args) {
		//CREACION
		PilaEnlazada pila1 = new PilaEnlazada();
		PilaEnlazada pila2 = new PilaEnlazada();
		PilaEnlazada pila3 = new PilaEnlazada();
		
		//APILAR
		for (int i = 0; i < 10; i++) {
			pila1.apilar(i);
		}
		System.out.println("La pila 1 esta definida como: "+pila1);
		
		for (int i = 10; i < 15; i++) {
			pila2.apilar(i);
		}
		System.out.println("La pila 2 esta definida como: "+pila2);
		
		for (int i = 15; i < 20; i++) {
			pila3.apilar(i);
		}
		System.out.println("La pila 3 esta definida como: "+pila3);
		
		//LONGITUD
		System.out.println("La longitud de la pila 2 es: "+pila2.longitud());
		
		//DESAPILAR
		for (int i = 0; i < 5; i++) {
			pila1.desapilar();
		}
		System.out.println("Pila 1 luego de desapilarla 5 veces: "+pila1);
		
		//VACIAR Y ESVACIA
		pila3.vaciar();
		System.out.println("Vaciamos la pila 3, ¿es eso verdad?: "+pila3.esVacia());
		
		//TOPE
		System.out.println("El tope de la pila 2 es: "+pila2.tope());
		
		//REPOK
		System.out.println("¿Esta bien definida la pila 1?: "+pila1.repOK());
		System.out.println("¿Esta bien definida la pila 2?: "+pila2.repOK());
		System.out.println("¿Esta bien definida la pila 3?: "+pila3.repOK());
		
		//EQUALS
		System.out.println("¿La pila 1 es igual a la pila 2? "+pila1.equals(pila2));
		
	}

}
