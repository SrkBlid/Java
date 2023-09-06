package lista;
import lista.ListaEnlazada;

public class MainListaEnlazada {

	public static void main(String[] args) {
		
		ListaEnlazada lista1 = new ListaEnlazada();
		ListaEnlazada lista2 = new ListaEnlazada();
		ListaEnlazada lista3 = new ListaEnlazada();
		
		//AGREGAR
		for (int i = 20; i < 30; i++) {
			lista1.agregar(i);
		}
		System.out.println("Lista 1: "+lista1);
		for (int i = 30; i < 40; i++) {
			lista2.agregar(i);
		}
		System.out.println("Lista 2: "+lista2);		
		for (int i = 40; i < 45; i++) {
			lista3.agregar(i);
		}
		System.out.println("Lista 3: "+lista3);	
		
		//AGREGARTODOS
		lista2.agregarTodos(lista3);
		System.out.println("Conbimación entre lista 2 con lista 3: "+lista2);
		
		//INSERTAR
		lista1.insertar(23.14, 4);
		System.out.println("Inserción entre 23 y 24: "+lista1);
		
		//ELIMINAR
		lista1.eliminar(4);
		System.out.println("Eliminación de la inserción: "+lista1);
		
		//OBTENER
		System.out.println("Tercer elemento de la lista 3: "+lista3.obtener(2));
		
		//SUBLISTA
		ListaEnlazada lista4 = lista2.subLista(5, 9);
		System.out.println("Nueva lista con la mitad de elementos de la lista 2, lista 4: "+lista4);
		
		//CONTIENE
		System.out.println("¿La lista 4 contiene el 30? "+lista4.contiene(30));
		
		//ELEMENTOS
		System.out.println("Cantidad de elementos lista 4: "+lista4.elementos());
		
		//VACIAR Y ESVACIA
		lista4.vaciar();
		System.out.println("La lista 4 fue vaciada, ¿Esto es correcto?: "+lista4.esVacia());
		
		//REPOK
		System.out.println("¿La lista 1 es correcta en su estructura?: "+lista1.repOK());
		System.out.println("¿La lista 4 es correcta en su estructura?: "+lista4.repOK());
		
		//EQUALS
		System.out.println("¿La lista 1 y 2 son equivalentes?: "+lista1.equals(lista2));
	}
}
