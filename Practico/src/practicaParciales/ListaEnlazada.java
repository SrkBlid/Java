package practicaParciales;

public class ListaEnlazada implements Lista{
	//VARIABLES
	private Object info;
	private ListaEnlazada next;
	private int cantElementos;
	
	//CONSTRUCTURES
	public ListaEnlazada() {
		this.info = null;
		this.next = null;
		this.cantElementos = 0;
	}
	
	public ListaEnlazada(Object elem) {
		this.info = elem;
		this.next = null;
		this.cantElementos++;
	}
	
	//MÉTODOS
	public int cardinalidad() {
		return this.cantElementos;
	}
	
	public void agregar(Object item, int pos) {
		if (pos < 0 || pos > this.cantElementos){
			throw new IllegalArgumentException("Fuera de rango.");
		}
		if (pos == 0) {
			ListaEnlazada aux = new ListaEnlazada();
			ListaEnlazada nuevo0 = new ListaEnlazada(item);
			aux = this;
			while (aux.next != null) {
				aux = aux.next;
			}
			aux.next = nuevo0;
			this.cantElementos++;
		}
		
		ListaEnlazada auxAntes = new ListaEnlazada();
		ListaEnlazada auxDsps = new ListaEnlazada();
		ListaEnlazada nuevo = new ListaEnlazada(item);
		
		auxAntes = auxDsps = this;
		for(int i = 0; i < pos; i++) {
			auxAntes = auxAntes.next;
			auxDsps = auxDsps.next;
		}
		
		auxDsps = auxDsps.next;
		auxAntes.next = nuevo;
		nuevo.next = auxDsps;
		this.cantElementos++;
	}
	
	public void rev() {
		ListaEnlazada aux = new ListaEnlazada();
		ListaEnlazada nuevo = new ListaEnlazada();
		nuevo.cantElementos = this.cantElementos;
		
		aux = this;
		int total = this.cantElementos;
		while(total > 0) {
			aux = this;
			aux.cantElementos = total;
			int i = 0;
			while (i < total) {
				aux = aux.next;
				i++;
			}
			nuevo.agregar(aux.info, 0);
			total--;
		}
		
		ListaEnlazada aux2 = new ListaEnlazada();
		aux = this;
		aux2 = nuevo;
		while(aux.next != null) {
			aux.info = aux2.info;
			aux = aux.next;
			aux2 = aux2.next;
		}
	}
	
	public void mostrar() {
		ListaEnlazada aux = new ListaEnlazada();
		aux = this;
		while(aux.next != null) {
			aux = aux.next;
			System.out.print(aux.info+" ");
		}
	}
	
	public static void main(String[] args) {
		ListaEnlazada l1 = new ListaEnlazada();
		for(int i = 0; i < 10; i++) {
			l1.agregar(i, 0);
		}
		l1.mostrar();
	}
	
}
