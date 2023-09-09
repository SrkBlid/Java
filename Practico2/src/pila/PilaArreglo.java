package pila;

public class PilaArreglo<T> implements Pila<T>{

	public static final int CAPACIDAD_BASE = 20;
	private Object[] arreglo;
	private int cantidadElem = 0; 
	
	//CONSTRUCTORES
	public PilaArreglo() {
		arreglo = new Object[CAPACIDAD_BASE];
	}
	
	public PilaArreglo(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("La capacidad del arreglo debe de ser positiva. ("+cantidad+")");
		}
		arreglo = new Object[cantidad];
	}
	
	//MÉTODOS
	public int longitud() {
		return this.cantidadElem;
	}
	
	public boolean apilar(T elem) {
		if (cantidadElem < this.arreglo.length) {
			this.arreglo[cantidadElem] = elem;
			cantidadElem++;
		} else {
			throw new IllegalArgumentException("El arreglo esta lleno.");
		}
		return true;
	}
	
	public T desapilar() {
		if (this.esVacia()) {
			throw new IllegalArgumentException("El arreglo no tiene elementos para desapilar.");
		}
		T info = (T)this.arreglo[cantidadElem-1];
		cantidadElem--;
		return info;
	}
	
	public boolean esVacia() {
		return (cantidadElem == 0);
	}
	
	public void vaciar() {
		cantidadElem = 0;
	}
	
	public T tope() {
		if (this.esVacia()) {
			throw new IllegalArgumentException("El arreglo no tiene elementos.");
		}
		return (T)arreglo[cantidadElem-1];
	}
	
	public boolean repOK() {
		if (cantidadElem > this.arreglo.length)
			return false;
		if (cantidadElem < 0)
			return false;
		for (int i = 0; i < this.cantidadElem; i++) {
			if (this.arreglo[i] == null) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		for (int i = 0; i < cantidadElem; i++) {
			cadena.append(String.valueOf(this.arreglo[i]));
			if (i < cantidadElem-1) {
				cadena.append(", ");
			}
		}
		cadena.append("]");
		return cadena.toString();
	}
	
	public boolean equals(Object other) {
		if (this == null && other == null)
			return true;
		if (this == other)
			return true;
		PilaArreglo otro = new PilaArreglo();
		if (this.cantidadElem != otro.cantidadElem)
			return false;
		for (int i = 0; i < this.cantidadElem; i++) {
			if (this.arreglo[i] != otro.arreglo[i]) {
				return false;
			}
		}
		return true;
	}
	
}
