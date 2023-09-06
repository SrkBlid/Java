package lista;

public class ListaEnlazada<T> implements Lista<T>{
	
	private Object info;
	private ListaEnlazada siguiente;
	private int cantidad;
	
	ListaEnlazada() {
		info = null;
		siguiente = null;
		cantidad = 0;
	}
	
	ListaEnlazada(T elem) {
		info = elem;
		siguiente = null;
		cantidad++;
	}
	
	public boolean agregar(T elem) {
		if (this.esVacia()) {
			this.info = elem;
			this.cantidad++;
			return true;
		}
		ListaEnlazada nuevo = new ListaEnlazada(elem);
		ListaEnlazada aux = new ListaEnlazada();
		aux = this;
		while(aux.siguiente != null) {
			aux = aux.siguiente;
		}
		aux.siguiente = nuevo;
		this.cantidad++;
		return true;
	}
		
	public boolean agregarTodos(Lista<T> otraLista) {
		ListaEnlazada aux = new ListaEnlazada();
		aux = this;
		while(aux.siguiente != null) {
			aux = aux.siguiente;
		}
		otraLista = (ListaEnlazada)otraLista;
		aux.siguiente = (ListaEnlazada)otraLista;
		this.cantidad = this.cantidad+otraLista.elementos();
		
		return true;
	}

	public boolean insertar(T elem, int indice) {
		if (indice > cantidad || indice < 0) {
			return false;
		}
		ListaEnlazada aux1 = new ListaEnlazada();
		ListaEnlazada aux2 = new ListaEnlazada();
		aux1 = aux2 = this;
		for (int i = 0; i < indice-1; i++) {
			aux1 = aux1.siguiente;
		}
		for (int i = 0; i < indice; i++) {
			aux2 = aux2.siguiente;
		}
		ListaEnlazada nuevo = new ListaEnlazada(elem);
		aux1.siguiente = nuevo;
		nuevo.siguiente = aux2;
		return true;
	}
	
	public T eliminar(int indice) {
		ListaEnlazada aux1 = new ListaEnlazada();
		ListaEnlazada aux2 = new ListaEnlazada();
		aux1 = aux2 = this;
		for (int i = 0; i < indice-1; i++) {
			aux1 = aux1.siguiente;
		}
		for (int i = 0; i <= indice; i++) {
			aux2 = aux2.siguiente;
		}
		T info = (T)aux1.siguiente.info;
		aux1.siguiente = aux2;
		return info;
	}

	public T obtener(int indice) {
		ListaEnlazada aux = new ListaEnlazada();
		aux = this;
		for (int i = 0; i < indice; i++) {
			aux = aux.siguiente;
		}
		return (T)aux.info;
	}

	public ListaEnlazada<T> subLista(int desdeInd, int hastaInd){
		ListaEnlazada aux1 = new ListaEnlazada();
		ListaEnlazada aux2 = new ListaEnlazada();
		aux1 = aux2 = this;
		
		for (int i = 0; i < desdeInd; i++) {
			aux1 = aux1.siguiente;
		}
		for (int i = 0; i < hastaInd; i++) {
			aux2 = aux2.siguiente;
		}
		
		ListaEnlazada nuevo = new ListaEnlazada(aux1.info);
		while (aux1 != aux2) {
			aux1 = aux1.siguiente;
			nuevo.agregar(aux1.info);
		}
		
		return nuevo;
	}

	public boolean contiene(T elem) {
		ListaEnlazada aux = new ListaEnlazada();
		aux = this;
		while (aux != null) {
			if (elem.equals(aux.info)) {
				return true;
			}
			aux = aux.siguiente;
		}
		return false;
	}

	public void vaciar() {
		this.info = null;
		this.siguiente = null;
		this.cantidad = 0;
	}
	
	public int elementos() {
		return this.cantidad;
	}

	public boolean esVacia() {
		return this.cantidad == 0;
	}

	public boolean repOK() {
		if (this.cantidad < 0)
			return false;
		ListaEnlazada aux = new ListaEnlazada();
		aux = this;
		while (aux != null) {
			if (aux.info == null) {
				return false;
			}
			aux = aux.siguiente;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		ListaEnlazada aux = new ListaEnlazada();
		aux = this;
		while (aux != null) {
			if(aux.siguiente == null) {
				cadena.append(String.valueOf(aux.info));
				aux = aux.siguiente;
			}else {
				cadena.append(String.valueOf(aux.info+", "));
				aux = aux.siguiente;
			}
		}
		cadena.append("]");
		return cadena.toString();
	}
	
	@Override
	public boolean equals(Object otro) {
		if (otro == this)
			return true;
		if (otro == null & this == null)
			return true;
		ListaEnlazada aux = (ListaEnlazada)otro;
		if (this.cantidad == aux.cantidad) {
			while (aux != null) {
				if (this.info != aux.info) {
					return false;
				}
				aux = aux.siguiente;
			}
			return true;
		}
		if (this.cantidad != aux.cantidad)
			return false;
		return true;
	}
}
