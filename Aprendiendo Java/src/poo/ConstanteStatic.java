package poo;

public class ConstanteStatic {

	//void = no devuelve nada - public = se puede acceder al main desde fuera de la clase
	//static = main no actua sobre ningun objeto
	//parametros = es un arreglo de tipo String llamado args
	public static void main(String[] args) {

		Empleados trabajador1 = new Empleados("Juan");
		Empleados trabajador2 = new Empleados("Piter");
		
		trabajador1.cambiarSeccion("RRHH");
		System.out.println(trabajador1.devuelveDatos());
		System.out.println(trabajador2.devuelveDatos());
		
		//A continuación hacemos llamado al metodo static, como vemos no pertenece a ningun elemento
		// sino que pertenece a la clase, por eso lo tenemos que llamar con Empleado.
		System.out.println(Empleados.siguienteId());
		
	}
}

class Empleados{
	
	//le ponemos final por que no tiene mucho sentido que el nombre sea modificable una vez puesto
	private final String nombre;
	private String seccion;	
	
	//al ponerle static a una variable estamos haciendo referencia a una variable que va a ser igual
	// para todos los elementos de 'Empleados' y que al modificarla se modifica para todos. Es decir,
	// que una variable static no pertenece a ningun elemento.
	private int id;
	private static int nextId = 1;
	
	public Empleados(String nom) {
		
		nombre = nom;
		seccion = "Administración";
		id = nextId;
		nextId++;
	}
	
	public void cambiarSeccion(String seccion) { //setter
		
		this.seccion = seccion;
		
	}
	
	public String devuelveDatos() { //getter
		
		return "El nombre es: "+nombre+" y es de la seccion "+seccion+". El id es: "+id;
		
	}
	
	//metodo static - solamente podemos utilizar variables static en este metodo.
	public static String siguienteId() {
		
		return "El siguiente id es: "+nextId;
		
	}
	
	
}