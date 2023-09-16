package cola;
import cola.ColaArregloFijo;

public class MainColaArreglo {
	public static void main(String[] args) {
		//CREAR
		ColaArregloFijo cola1 = new ColaArregloFijo();
		ColaArregloFijo cola2 = new ColaArregloFijo();
				
		//ENCOLAR
		for (int i = 0; i < 10; i++) {
			cola1.encolar(i);
		}
		System.out.println("Cola 1: "+cola1);
		for (int i = 10; i < 16; i++) {
			cola2.encolar(i);
		}
		System.out.println("Cola 2: "+cola2);
		
		//ELEMENTOS
		System.out.println("Cantidad de elementos en la cola 1: "+cola1.elementos());
		System.out.println("Cantidad de elementos en la cola 2: "+cola2.elementos());
		
		//PRIMERO
		System.out.println("Primer elemento de la cola 2: "+cola2.primero());
		
		//DESENCOLAR
		cola1.desencolar();
		System.out.println("Desencolando la cola 1 tenemos: "+cola1);
		
		//VACIAR Y ESVACIO
		cola2.vaciar();
		System.out.println("La cola 2, recien vaciada, ¿Esta vacia?: "+cola2.esVacia());
		
		//REPOK
		System.out.println("La cola 1, ¿funciona como corresponde?: "+cola1.repOK());
		System.out.println("La cola 2, ¿funciona como corresponde?: "+cola2.repOK());
		
		//EQUALS
		ColaArregloFijo cola3 = new ColaArregloFijo(5);
		for (int i = 0; i < 2; i++) {
			cola3.encolar(i);
		}
		System.out.println("La cola 3, recien creada, ¿es igual a la cola 1?: "+cola3.equals(cola1));
		
		//ELEMENTO
		System.out.println("Sexto elemento de la cola 1: "+cola1.elemento(6));
	}

}
