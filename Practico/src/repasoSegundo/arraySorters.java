package repasoSegundo;

public class arraySorters {

	private int[] arreglo;
	private int elems;
	private static final int MAX = 25;
	
	public arraySorters() {
		arreglo = new int[MAX];
	}
	
	public arraySorters(int cantidad) {
		if (cantidad < 0) {
			throw new IllegalArgumentException("Cantidad negativa.");
		}
		arreglo = new int[cantidad];
	}
	
	public boolean agregar(int elem) {
		if (elems >= arreglo.length) {
			throw new IllegalArgumentException("El arreglo esta a su maxima capacidad.");
		}else {
			arreglo[elems] = elem;
			elems++;
			return true;
		}
	}
	
	public int[] selection() {
		int[] array = this.arreglo;
		int n = elems;
		for(int i = 0; i < n-1; i++) {
			int menor = i;
			for(int j = i+1; j < n; j++) {
				if(array[j] < array[menor]) {
					menor = j;
				}
			}
			int aux = array[menor];
			array[menor] = array[i];
			array[i] = aux;
		}
		return array;
	}

	public int[] bubble() {
		int[] array = this.arreglo;
		int n = elems;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n-i-1; j++){
				if (array[j] > array[j+1]){
					int aux = array[j];
					array[j] = array[j+1];
					array[j+1] = aux;
				}
			}
		}
		return array;
	}

	public int[] insertion() {
		int[] array = this.arreglo;
		int n = elems;
		for (int i = 1; i < n; i++){
			int clave = array[i];
			int j = i-1;
			while (j >= 0 && array[j] > clave){
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = clave;
		}
		return array;
	}

	public void setArreglo(int[] nuevoArreglo, int cantElems) {
        this.arreglo = nuevoArreglo;
		this.elems = cantElems;
    }

	public int cantElementos(){
		return elems;
	}
	
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("[");
		for (int i = 0; i < this.elems; i++) {
			cadena.append(String.valueOf(this.arreglo[i]));
			if(i < this.elems-1) {
				cadena.append(", ");
			}
		}
		cadena.append("]");
		return cadena.toString();
	}
	
}
