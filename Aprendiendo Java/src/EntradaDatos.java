import java.util.*;
public class EntradaDatos {
	public static void main(String[] args) {
		
		//Al usar Scanner tenemos que asignarle la palabra "new" para que cree un nuevo bloque de la clase 
		// Scanner, tambien tenemos que poner System.in para indicar que la entrada va a venir de la consola.
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Indica tu nombre: ");
		String nombre = entrada.nextLine();
		
		System.out.println("Indica tu edad: ");
		int edad = entrada.nextInt();
		
		//Lo que va a hacer con las instrucciones de arriba es esperar una entrada justamente en la variable
		// "entrada" y los va a almacenar en las variables nombre, edad o altura. El tipo de dato que pedimos 
		// tiene que coincidir con la variable a la que se lo va a almacenar (nextLine, nextInt, nextDouble)
		
		System.out.println("Hola "+nombre+", hoy en dia tienes "+edad+" años.");
		
	}

}
