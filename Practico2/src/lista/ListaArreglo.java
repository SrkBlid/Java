package lista;

public class ListaArreglo<T> implements Lista<T> {

	public static final int CAPACIDAD_BASE = 20;
	private Object[] arreglo;
	private int cantidadElem = 0;
	
	//CONSTRUCTORES
	public ListaArreglo() {
		arreglo = new Object[CAPACIDAD_BASE];
	}
	
	public ListaArreglo(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("La capacidad del arreglo debe de ser positiva. ("+cantidad+")");
		}
		arreglo = new Object[cantidad];
	}
	
	//METODOS
	public boolean agregar(T elem) {
		if (cantidadElem >= arreglo.length) {
			throw new IllegalArgumentException("El arreglo esta a su maxima capacidad.");
		}else {
			arreglo[cantidadElem] = elem;
			cantidadElem++;
			return true;
		}
	}
	
	public boolean agregarTodos(Lista<T> otraLista) {
		if (cantidadElem+otraLista.elementos() > arreglo.length) {
			throw new IllegalArgumentException("El arreglo esta a su maxima capacidad.");
		} else {
			for (int i = 0; i < otraLista.elementos(); i++) {
				this.agregar(otraLista.obtener(i));
			}
			return true;
		}
	}
		
	public boolean insertar(T elem, int indice) {
		if (indice > arreglo.length || indice < 0) {
			throw new IndexOutOfBoundsException("El indice indicado esta fuera del rango del arreglo.");
		}
		if (this.esVacia() && indice == cantidadElem) {
			this.agregar(elem);
			return true;
		}else {
			for (int i = cantidadElem-1; i >= indice; i--) {
				arreglo[i+1] = arreglo[i];
			}
			arreglo[indice] = elem;
			cantidadElem++;
			return true;
		}
	}
		
	public T eliminar(int indice) {
		if (indice >= arreglo.length || indice < 0) {
			throw new IndexOutOfBoundsException("El indice indicado esta fuera del rango del arreglo.");
		}else {
			T valor = (T)arreglo[indice];
			for(int i = indice; i < cantidadElem-1; i++) {
				arreglo[i] = arreglo[i+1];
			}
			cantidadElem--;
			return valor;
		}
	}
	
	public T obtener(int indice) {
		if (indice > arreglo.length || indice < 0) {
			throw new IndexOutOfBoundsException("El indice indicado esta fuera del rango del arreglo.");
		}else {
			T valor = (T)arreglo[indice];
			return valor;
		}
	}
	
	public Lista<T> subLista(int desdeInd, int hastaInd){
		if (desdeInd > arreglo.length || desdeInd < 0 || hastaInd > arreglo.length || hastaInd < 0) {
			throw new IndexOutOfBoundsException("El indice indicado esta fuera del rango del arreglo.");
		}
		if (desdeInd == hastaInd) {
			return new ListaArreglo<T>();
		}
		ListaArreglo<T> subarreglo = new ListaArreglo<T>();
		for (int i = desdeInd; i <= hastaInd; i++){
			subarreglo.agregar(this.obtener(i));
		}
		return subarreglo;	
	}
	
	public boolean contiene(T elem) {
		for (int i = 0; i < arreglo.length; i++) {
			if (elem.equals(arreglo[i])) {
				return true;
			}
		}
		return false;
	}
		
	public void vaciar() {
		this.cantidadElem = 0;
	}
	
	public int elementos() {
		int cantidad = 0;
		for (int i = 0; i < this.cantidadElem; i++) {
			if (arreglo[i] != null) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public boolean esVacia() {
		return this.cantidadElem == 0;
	}
	
	public boolean repOK() {
		if (this.cantidadElem < 0) {
			return false;
		}
		if (this.cantidadElem > CAPACIDAD_BASE) {
			return false;
		}
		if (arreglo.length < this.cantidadElem) {
			return false;
		}
		for (int i = 0; i < this.cantidadElem; i++) {
			if (this.arreglo[i] == null) {
				return false;
			}
		}
		return true;
	}
		
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		for (int i = 0; i < this.cantidadElem; i++) {
			cadena.append(String.valueOf(this.arreglo[i]));
			if(i < this.cantidadElem-1) {
				cadena.append(", ");
			}
		}
		cadena.append("]");
		return cadena.toString();
	}
	
	@Override
	public boolean equals(Object otro) {
			if (otro == null && arreglo == null)
				return true;
			if(otro == this)
				return true;
			ListaArreglo otroArreglo = (ListaArreglo) otro;
			if (otroArreglo.cantidadElem > 0 && arreglo.length > 0) {
				if (otroArreglo.cantidadElem == arreglo.length) {
					for (int i = 0; i < arreglo.length; i++) {
						if (arreglo[i] != otroArreglo.obtener(i)) {
							return false;
						}
					}
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
	}

}
