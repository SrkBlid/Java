package lista;
import lista.ListaArreglo;

public class MainListaArreglo {

	public static void main(String[] args) {
		ListaArreglo lista1 = new ListaArreglo();
		ListaArreglo lista2 = new ListaArreglo();
		ListaArreglo lista3 = new ListaArreglo();
		
		//AGREGAR
		for (int i = 0; i < 10; i++) {
			lista1.agregar(i);
		}
		System.out.println("La lista 1 esta compuesta por: "+lista1);
		for (int i = 10; i < 20; i++) {
			lista2.agregar(i);
		}
		System.out.println("La lista 2 esta compuesta por: "+lista2);
		
		//INSERTAR
		lista1.insertar("INSERCIÓN", 5);
		System.out.println("La lista 1 con inserción: "+lista1);
		
		//SUBLISTA Y AGREGARTODOS
		lista3.agregarTodos(lista1.subLista(5, 10));
		System.out.println("La lista 3, subconjunto de 1: "+lista3);
		
		//ELIMINAR
		lista3.eliminar(0);
		System.out.println("La lista 3 sin el primer elemento: "+lista3);
		
		//OBTENER
		System.out.println("Quinto (4) elemento de la lista 2: "+lista2.obtener(4));
		
		//CONTIENE
		System.out.println("¿La lista 2 contiene el 18? "+lista2.contiene(18));
		
		//VACIAR Y ESVACIA
		lista2.vaciar();
		System.out.println("¿La lista 2 esta vacia? "+lista2.esVacia());
		
		//ELEMENTOS
		System.out.println("¿Cuantos elementos tiene la lista 3? "+lista3.elementos());
		
		//REPOK
		System.out.println("¿Funciona bien la lista 1? "+lista1.repOK());
		
		//EQUALS
		ListaArreglo lista4 = new ListaArreglo();
		lista4 = lista1;
		System.out.println("¿La lista 1 es igual a la lista 4 recien creada? "+lista4.equals(lista1));
	}

}
