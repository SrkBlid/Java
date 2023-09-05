package lista;

public class ListaEnlazada<T> implements Lista<T> {
	
	Object info;
	ListaEnlazada siguiente;
	
	//CONSTRUCTORES
	public ListaEnlazada() {
		info = null;
		siguiente = null;
	}
	
	public ListaEnlazada(Object item) {
		info = item;
		siguiente = null;
	}
	
	public ListaEnlazada(Object item, ListaEnlazada siguiente) {
		info = item;
		this.siguiente = siguiente;
	}
	
	//METODOS
	
}

