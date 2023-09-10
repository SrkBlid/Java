package lista;

public class ListaEnlazadaCompras<T>{
	
	private Object producto;
	private int productoCant;
	private ListaEnlazadaCompras siguiente;
	private int cantidad;
	
	ListaEnlazadaCompras() {
		producto = null;
		productoCant = 0;
		siguiente = null;
		cantidad = 0;
	}
	
	ListaEnlazadaCompras(T elem) {
		producto = elem;
		productoCant = 1;
		siguiente = null;
		cantidad++;
	}
	
	ListaEnlazadaCompras(T elem, int cant) {
		producto = elem;
		productoCant = cant;
		siguiente = null;
		cantidad++;
	}
	
	public boolean agregar(T elem, int cant) {
		if (this.esVacia()) {
			this.producto = elem;
			this.productoCant = cant;
			this.cantidad++;
			return true;
		}
		ListaEnlazadaCompras nuevo = new ListaEnlazadaCompras(elem, cant);
		ListaEnlazadaCompras aux = new ListaEnlazadaCompras();
		aux = this;
		while(aux.siguiente != null) {
			aux = aux.siguiente;
		}
		aux.siguiente = nuevo;
		this.cantidad++;
		return true;
	}
		
	public boolean agregarTodos(Lista<T> otraLista) {
		ListaEnlazadaCompras aux = new ListaEnlazadaCompras();
		aux = this;
		while(aux.siguiente != null) {
			aux = aux.siguiente;
		}
		otraLista = (Lista)otraLista;
		aux.siguiente = (ListaEnlazadaCompras)otraLista;
		this.cantidad = this.cantidad+otraLista.elementos();
		
		return true;
	}

	public boolean insertar(T elem, int indice) {
		if (indice > cantidad || indice < 0) {
			return false;
		}
		ListaEnlazadaCompras aux1 = new ListaEnlazadaCompras();
		ListaEnlazadaCompras aux2 = new ListaEnlazadaCompras();
		aux1 = aux2 = this;
		for (int i = 0; i < indice-1; i++) {
			aux1 = aux1.siguiente;
		}
		for (int i = 0; i < indice; i++) {
			aux2 = aux2.siguiente;
		}
		ListaEnlazadaCompras nuevo = new ListaEnlazadaCompras(elem);
		aux1.siguiente = nuevo;
		nuevo.siguiente = aux2;
		return true;
	}
	
	public T eliminar(int indice) {
		ListaEnlazadaCompras aux1 = new ListaEnlazadaCompras();
		ListaEnlazadaCompras aux2 = new ListaEnlazadaCompras();
		aux1 = aux2 = this;
		for (int i = 0; i < indice-1; i++) {
			aux1 = aux1.siguiente;
		}
		for (int i = 0; i <= indice; i++) {
			aux2 = aux2.siguiente;
		}
		T info = (T)aux1.siguiente.producto;
		aux1.siguiente = aux2;
		return info;
	}

	public T obtener(int indice) {
		ListaEnlazadaCompras aux = new ListaEnlazadaCompras();
		aux = this;
		for (int i = 0; i < indice; i++) {
			aux = aux.siguiente;
		}
		return (T)aux.producto;
	}

	public ListaEnlazadaCompras<T> subLista(int desdeInd, int hastaInd){
		ListaEnlazadaCompras aux1 = new ListaEnlazadaCompras();
		ListaEnlazadaCompras aux2 = new ListaEnlazadaCompras();
		aux1 = aux2 = this;
		
		for (int i = 0; i < desdeInd; i++) {
			aux1 = aux1.siguiente;
		}
		for (int i = 0; i < hastaInd; i++) {
			aux2 = aux2.siguiente;
		}
		
		ListaEnlazadaCompras nuevo = new ListaEnlazadaCompras(aux1.producto);
		while (aux1 != aux2) {
			aux1 = aux1.siguiente;
			nuevo.agregar(aux1.producto, aux1.productoCant);
		}
		
		return nuevo;
	}

	public boolean contiene(T elem) {
		ListaEnlazadaCompras aux = new ListaEnlazadaCompras();
		aux = this;
		while (aux != null) {
			if (elem.equals(aux.producto)) {
				return true;
			}
			aux = aux.siguiente;
		}
		return false;
	}

	public void vaciar() {
		this.producto = null;
		this.productoCant = 0;
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
		if (this.productoCant < 0)
			return false;
		ListaEnlazadaCompras aux = new ListaEnlazadaCompras();
		aux = this;
		while (aux != null) {
			if (aux.producto == null) {
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
		ListaEnlazadaCompras aux = new ListaEnlazadaCompras();
		aux = this;
		while (aux != null) {
			if(aux.siguiente == null) {
				cadena.append(String.valueOf(aux.productoCant+" unidades de "+aux.producto));
				aux = aux.siguiente;
			}else {
				cadena.append(String.valueOf(aux.productoCant+" unidades de "+aux.producto+", "));
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
		ListaEnlazadaCompras aux = (ListaEnlazadaCompras)otro;
		if (this.cantidad == aux.cantidad) {
			while (aux != null) {
				if (this.producto != aux.producto) {
					return false;
				} else {
					if (this.productoCant != this.productoCant) {
						return false;
					}
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
