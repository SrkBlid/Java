package repasoSegundo;

public class mainSorters {

	public static void main(String[] args) {
		arraySorters a1 = new arraySorters(15);
		arraySorters aux = new arraySorters(15);
		a1.agregar(7);
		a1.agregar(2);
		a1.agregar(15);
		a1.agregar(9);
		a1.agregar(1);
		System.out.println(a1);
		aux.setArreglo(a1.selection(), a1.cantElementos());
		System.out.println("Selection: " + aux);
		aux.setArreglo(a1.bubble(), a1.cantElementos());
		System.out.println("Bubble: " + aux);
		aux.setArreglo(a1.insertion(), a1.cantElementos());
		System.out.println("Insertion: " + aux);
	}

}
