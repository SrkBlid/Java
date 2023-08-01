package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoPersona {

	public static void main(String[] args) {
		Persona[] lasPersonas = new Persona[2];
		
		lasPersonas[0] = new Empleado2("Jorge Demichelis", 25000, 2001, 2, 1);
		lasPersonas[1] = new Alumno("Julieta Parra", "Comunicación social");
		
		System.out.println(lasPersonas[0].darNombre()+". "+lasPersonas[0].darDescripcion());
		System.out.println(lasPersonas[1].darNombre()+". "+lasPersonas[1].darDescripcion());
		
	}

}

//Al tener un metodo abstracto, la clase tiene que ser definida tambien como abstracto, aunque sea 1 solo.
abstract class Persona {
	
	private String nombre;
	
	public Persona (String nom){
		nombre = nom;
	}
	
	public String darNombre(){
		return nombre;
	}
	
	//Al ser un metodo abstracto tenemos que definirlo nosotros en cada uso que le demos, ya sea heredado
	// o llamado.
	public abstract String darDescripcion();
	
	
	
}


class Empleado2 extends Persona{
	
	private double sueldo;
	private Date fechaAlta;
	
	public Empleado2 (String nom, int sal, int anno, int mes, int dia) {
		super(nom);
		sueldo = sal;
		GregorianCalendar fecha = new GregorianCalendar(anno, mes-1, dia);
		fechaAlta = fecha.getTime();
	}
	
	public String darDescripcion() {
		return "El empleado tiene un sueldo de "+sueldo+" pesos.";
	}
	
	//Setters
	public void subirSueldo(double porcentaje) {
		double aumento = sueldo*porcentaje/100;
		sueldo += aumento;
	}
	
	public double darSueldo() {
		return sueldo;
	}
	
	//Si yo quiero que no se pueda modificar un método con una subclase, es decir, que se reemplaze teniendo
	// el mismo nombre, como pasa con darSueldo, lo declaro como final.
	public final Date darFecha() {
		return fechaAlta;
	}
	
}

class Alumno extends Persona{
	
	private String carrera;
	
	public Alumno(String nom, String car) {
		super(nom);
		carrera = car;
	}
	
	public String darDescripcion() {
		return "Este alumno pertenece a la carrera de "+carrera+".";
	}
	
}


