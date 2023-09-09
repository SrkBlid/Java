package pila;

public class PilaEnlazada<T> implements Pila<T>{
	
	private Object info;
	private PilaEnlazada siguiente;
	private int cantidad;
	
	//CONSTRUCTORES
	public PilaEnlazada() {
		this.info = null;
		this.siguiente = null;
		this.cantidad = 0;
	}
	
	public PilaEnlazada(T elem) {
		this.info = elem;
		this.siguiente = null;
		this.cantidad++;
	}
	
	//MÉTODOS
	public int longitud() {
		return this.cantidad;
	}
	
	public boolean apilar(T elem) {
		if (this.esVacia()) {
			this.info = elem;
			this.cantidad++;
			return true;
		}
		PilaEnlazada aux = new PilaEnlazada();
		PilaEnlazada nuevo = new PilaEnlazada(elem);
		aux = this;
		while (aux.siguiente != null) {
			aux = aux.siguiente;
		}
		aux.siguiente = nuevo;
		this.cantidad++;
		return true;
	}
	
	public T desapilar() {
		if (this.esVacia()) {
			throw new IllegalArgumentException("El arreglo no tiene elementos para desapilar.");
		}
		
		if (this.siguiente == null) {
			T info = (T)this.info;
			this.vaciar();
			return info;
		}
		
		PilaEnlazada aux = new PilaEnlazada();
		PilaEnlazada aux2 = new PilaEnlazada();
		aux = aux2 = this;
		while (aux.siguiente != null) {
			aux = aux.siguiente;
		}
		while (aux2.siguiente != aux) {
			aux2 = aux2.siguiente;
		}
		T info = (T)aux.info;
		aux2.siguiente = null;
		return info;
	}
	
	public boolean esVacia() {
		return (cantidad == 0);
	}
	
	public void vaciar() {
		this.info = null;
		this.siguiente = null;
		cantidad = 0;
	}
	
	public T tope() {
		if (this.esVacia()) {
			throw new IllegalArgumentException("El arreglo no tiene elementos.");
		}
		PilaEnlazada aux = new PilaEnlazada();
		aux = this;
		while (aux.siguiente != null) {
			aux = aux.siguiente;
		}
		return (T)aux.info;
	}
	
	public boolean repOK() {
		if (cantidad < 0)
			return false;
		PilaEnlazada aux = new PilaEnlazada();
		aux = this;
		while (aux.siguiente != null) {
			if (aux.info == null) {
				return false;
			}
			aux = aux.siguiente;
		}
		return true;
	}
	
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		PilaEnlazada aux = new PilaEnlazada();
		aux = this;
		while (aux != null) {
			cadena.append(String.valueOf(aux.info));
			if (aux.siguiente != null) {
				cadena.append(", ");
			}
			aux = aux.siguiente;
		}
		cadena.append("]");
		return cadena.toString();
	}
	
	public boolean equals(Object other) {
		if (this == null && other == null)
			return true;
		if (this == other)
			return true;
		PilaEnlazada otro = new PilaEnlazada();
		PilaEnlazada aux = new PilaEnlazada();
		aux = this;
		PilaEnlazada aux2 = new PilaEnlazada();
		aux2 = otro;
		if (this.cantidad != otro.cantidad)
			return false;
		while (aux.siguiente != null && aux2.siguiente != null) {
			if (aux.info != aux2.info) {
				return false;
			}
			aux = aux.siguiente;
			aux2 = aux2.siguiente;
		}
		return true;
	}
}
