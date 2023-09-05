package biblioteca;

import biblioteca.Catalogo;
import biblioteca.Libro;

/**
* La clase {@code MainCatalogo} implementa una aplicación simple para mostrar el uso de {@code Catalogo} junto con {@code Libro}.
* Esta clase no usa parámetros, el comportamiento está completamente "hardcodeado" requiriendo modificiar y recompilar para hacer pruebas.
* @see catalogo.Catalogo
* @see datos.Libro
* @version 1.0
*/
public class MainCatalogo {

	/**
	* Experimenta con {@code Catalogo}, agregar libros, buscar, y mostrar el {@code Catalogo}.
	* @param args : arguments for this main method, not used in this implementation.
	*/
	public static void main(String[] args) {
		Libro libro1 = new Libro("Isaac Asimov", "The Caves of Steel", 42);
		Libro libro2 = new Libro("Isaac Asimov", "The Naked Sun", 47);
		Libro libro3 = new Libro("Joaquin Mezzano","El profundo rechazo a compartir", 125);
		Libro libro4 = new Libro("Joaquin Mezzano","La dopamina de la soledad", 170);
		//TODO: agregue más libros
		Catalogo catalogo = new Catalogo(10);
		//TODO: pruebe los métodos agregarLibro y buscarPorTitulo
		catalogo.agregarLibro(libro1);
		catalogo.agregarLibro(libro2);
		catalogo.agregarLibro(libro3);
		catalogo.agregarLibro(libro4);
		System.out.print("Catalogo:\n");
		System.out.println(catalogo);
		System.out.println();
		catalogo.buscarPorTitulo("la dopamina de la soledad");
	} 

}
