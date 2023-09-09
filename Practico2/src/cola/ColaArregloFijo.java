package cola;

import java.util.Collection;

public class ColaArregloFijo<T> implements Cola<T> {

	//VARIABLES
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int primero, ultimo = 0;

	//CONSTRUCTORES
	public ColaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
	}

	//METODOS
	@Override
	public boolean esVacia() {
		if (this.primero == this.ultimo) {
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
		if (this.ultimo < this.arreglo.length) {
			this.arreglo[ultimo] = elem;
			ultimo++;
			return true;
		}
		return false;
	}

	@Override
	public T desencolar() {
		if (this.esVacia()) {
			throw new UnsupportedOperationException("La cola se encuenta vacia");
		}
		T aux = (T)this.arreglo[0];
		for (int i = 0; i < this.ultimo; i++) {
			this.arreglo[i] = this.arreglo[i+1];
		}
		ultimo--;
		return aux;
	}

	@Override
	public T primero() {
		return (T)this.arreglo[primero];	
	}

	@Override
	public void vaciar() {
		this.ultimo = this.primero;
	}

	@Override
	public boolean repOK() {
		if (this.arreglo == null)
			return false;
		if (ultimo < primero)
			return false;
		if (primero > ultimo)
			return false;
		for (int i = 0; i < ultimo; i++) {
			if (this.arreglo[i] == null) {
				return false;
			}
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
		for (int i = 0; i < this.ultimo; i++) {
			cadena.append(String.valueOf(this.arreglo[i]));
			if(i < this.ultimo-1) {
				cadena.append(", ");
			}
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
		ColaArregloFijo otro = new ColaArregloFijo();
		if (this.ultimo != otro.ultimo) {
			return false;
		}
		for (int i = 0; i < this.ultimo; i++) {
			if (this.arreglo[i] != otro.arreglo[i]) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
   	public T elemento(int index) {
		if (index < primero || index > this.ultimo) {
			throw new UnsupportedOperationException("El index que ingreso se va de rango.");
		}
        	return (T)this.arreglo[index-1];
    	}

}
