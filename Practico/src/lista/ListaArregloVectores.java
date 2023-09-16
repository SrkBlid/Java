package lista;
import lista.Vector;

public class ListaArregloVectores{
	
	public static final int CAPACIDAD_BASE = 20;
	private Vector[] arreglo;
	private int cantidadElem = 0;
	
	//CONSTRUCTORES
	public ListaArregloVectores() {
		arreglo = new Vector[CAPACIDAD_BASE];
	}
	
	public ListaArregloVectores(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("La capacidad del arreglo debe de ser positiva. ("+cantidad+")");
		}
		arreglo = new Vector[cantidad];
	}
	
	//METODOS
	public boolean agregar(Vector elem) {
		if (cantidadElem >= arreglo.length) {
			throw new IllegalArgumentException("El arreglo esta a su maxima capacidad.");
		}else {
			arreglo[cantidadElem]= elem;
			cantidadElem++;
			return true;
		}
	}
	/*
	public boolean insertar(Vector elem, int indice) {
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
		
	public Vector eliminar(int indice) {
		if (indice >= arreglo.length || indice < 0) {
			throw new IndexOutOfBoundsException("El indice indicado esta fuera del rango del arreglo.");
		}else {
			Vector valor = (Vector)arreglo[indice];
			for(int i = indice; i < cantidadElem-1; i++) {
				arreglo[i] = arreglo[i+1];
			}
			cantidadElem--;
			return valor;
		}
	}
	
	public Vector obtener(int indice) {
		if (indice > arreglo.length || indice < 0) {
			throw new IndexOutOfBoundsException("El indice indicado esta fuera del rango del arreglo.");
		}else {
			Vector aux = new Vector(arreglo[indice].x, arreglo[indice].y);
			return aux;
		}
	}
	
	public boolean contiene(Vector elem) {
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
		if (this.cantidadElem > this.arreglo.length) {
			return false;
		}
		for (int i = 0; i < this.cantidadElem; i++) {
			if (this.arreglo[i] == null) {
				return false;
			}
		}
		return true;
	}*/
		
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		for (int i = 0; i < this.cantidadElem; i++) {
			cadena.append(String.valueOf("("+this.arreglo[i].x+","+this.arreglo[i].y+")"));
			if(i < this.cantidadElem-1) {
				cadena.append(", ");
			}
		}
		cadena.append("]");
		return cadena.toString();
	}
	/*
	@Override
	public boolean equals(Object otro) {
			if (otro == null && arreglo == null)
				return true;
			if(otro == this)
				return true;
			ListaArregloVectores otroArreglo = (ListaArregloVectores) otro;
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
	}*/
	
	public ListaArregloVectores sumar(Vector vec) {
		for(int i = 0; i < this.cantidadElem; i++) {
			this.arreglo[i].x = this.arreglo[i].x+vec.x;
			this.arreglo[i].y = this.arreglo[i].y+vec.y;
		}
		return this;
	}
	
	public ListaArregloVectores escalar(float k) {
		for(int i = 0; i < this.cantidadElem; i++) {
			this.arreglo[i].x = this.arreglo[i].x*k;
			this.arreglo[i].y = this.arreglo[i].y*k;
		}
		return this;
	}
	
	public ListaArregloVectores producto(Vector vec) {
		for(int i = 0; i < this.cantidadElem; i++) {
			this.arreglo[i].x = this.arreglo[i].x*vec.x;
			this.arreglo[i].y = this.arreglo[i].y*vec.y;
		}
		return this;
	}

}
