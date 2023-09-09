package cola;
import java.util.Collection;

import lista.ListaEnlazada;

public class ColaEnlazada<T> implements Cola<T> {

	//VARIABLES
	private Object info;
	private ColaEnlazada siguiente;
	private int primero, ultimo = 0;

	//CONSTRUCTORES
	public ColaEnlazada() {
		this.info = null;
		this.siguiente = null;
		this.primero = 0;
		this.ultimo = 0;
	}

	public ColaEnlazada(T elem) {
		this.info = elem;
		this.siguiente = null;
		this.ultimo++;
	}

	//METODOS
	@Override
	public boolean esVacia() {
		if (this.ultimo == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int elementos() {
		return this.ultimo;
	}

	@Override
	public boolean encolar(T elem) {
		if (this.esVacia()) {
			this.info = elem;
			this.ultimo++;
			return true;
		}
		ColaEnlazada aux = new ColaEnlazada();
		ColaEnlazada nuevo = new ColaEnlazada(elem);
		aux = this;
		while (aux.siguiente != null) {
			aux = aux.siguiente;
		}
		aux.siguiente = nuevo;
		this.ultimo++;
		return true;
	}

	@Override
	public T desencolar() {
		if (this.esVacia()) {
			throw new UnsupportedOperationException("La cola se encuenta vacia");
		}
		ColaEnlazada aux = new ColaEnlazada();
		aux = this;
		T info = (T)aux.info;
		if (aux.siguiente == null) {
			this.info = null;
			this.siguiente = null;
			this.ultimo = this.primero;
		} else {
			aux = aux.siguiente;
			this.siguiente = aux;
			this.ultimo--;
		}
		return info;
		
	}

	@Override
	public T primero() {
		ColaEnlazada aux = new ColaEnlazada();
		aux = this;
		return (T)aux.info;
	}

	@Override
	public void vaciar() {
		this.ultimo = this.primero;
	}

	@Override
	public boolean repOK() {
		if (this == null)
			return false;
		if (this.ultimo < this.primero)
			return false;
		ColaEnlazada aux = new ColaEnlazada();
		aux = this;
		while (aux.siguiente != null) {
			if (aux.info == null) {
				return false;
			}
			aux = aux.siguiente;
		}
		return true;
	}

	@Override
	public String toString() {
		if (this.esVacia()) {
			return "La cola no contiene elementos.";
		}
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		ColaEnlazada aux = new ColaEnlazada();
		aux = this;
		while(aux != null){
			cadena.append(String.valueOf(aux.info));
			if(aux.siguiente != null) {
				cadena.append(", ");
			}
			aux = aux.siguiente;
		}
		cadena.append("]");
		return cadena.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (this == null && other == null)
			return true;
		if (this == other)
			return true;
		ColaEnlazada otro = new ColaEnlazada();
		if (this.ultimo != otro.ultimo) {
			return false;
		}
		ColaEnlazada aux = new ColaEnlazada();
		aux = this;
		while (aux.siguiente != null) {
			if (aux.info != otro.info) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
   	public T elemento(int index) {
		if (index < this.primero || index > this.ultimo) {
			throw new UnsupportedOperationException("El index que ingreso se va de rango.");
		}
			ColaEnlazada aux = new ColaEnlazada();
			aux = this;
			for (int i = 0; i < index; i++) {
				aux = aux.siguiente;
			}
        	return (T)aux.info;
    	}

}