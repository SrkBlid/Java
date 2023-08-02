package poo;
import java.util.*;
import javax.swing.*;

//Esta class de empleado es un ejemplo de como hacer todo lo mismo que en coche pero en 1 solo archivo fuente.

public class UsoEmpleado {

	public static void main(String[] args) {
		
		Jefatura jefeRRHH = new Jefatura("Violeta Parra", 105000, 1998, 5, 2);
		jefeRRHH.estableceIncentivo(15000);
		jefeRRHH.darSueldo();
		
		Empleado[] misEmpleados = new Empleado[6];
		misEmpleados[0] = new Empleado("Joaquin Mezzano", 85000, 1999, 12, 3);
		misEmpleados[1] = new Empleado("Roberto Pereira", 100000, 1995, 9, 23);
		misEmpleados[2] = new Empleado("Ana Rupiere", 75000, 2001, 1, 15);
		misEmpleados[3] = new Empleado("Jose Temarola", 75000, 2002, 5, 1);
		misEmpleados[4] = jefeRRHH; //Poliformismo en acción. Esto es valido por que un Jefe es un Empleado.
		misEmpleados[5] = new Jefatura("Maria Caceres", 95000, 2001, 5, 20);
		
		//Para poder usar el establecerIncentivo con Maria tenemos que transformar misEmpleados[5] en Jefatura
		// haciendo uso de la refundición/casting.
		Jefatura jefeFinanzas = (Jefatura)misEmpleados[5];
		jefeFinanzas.estableceIncentivo(12500);
		
		/*Empleado[] misEmpleados = new Empleado[3];
		for (int i = 0; i < misEmpleados.length; i++) {
			misEmpleados[i] = new Empleado(JOptionPane.showInputDialog("Nombre del empleado"),
					Integer.parseInt(JOptionPane.showInputDialog("Sueldo del empleado")),
					Integer.parseInt(JOptionPane.showInputDialog("Año de ingreso")),
					Integer.parseInt(JOptionPane.showInputDialog("Mes de ingreso")),
					Integer.parseInt(JOptionPane.showInputDialog("Dia de ingreso")));
		}
		
		//Por el principio de sustitución podemos instanciar una Jefatura desde un tipo Empleado.
		Empleado directorComercial = new Jefatura("Sandra Bullock", 89000, 2000, 7, 1);
		//Por el mismo principio de sustitución y al tener definida la clase Empleado con la interfaz de
		// Comparable, podemos instanciar un Empleado a traves de un Comparable.
		Comparable ejemplo = new Empleado("Jose Rupertinsky", 70000, 2003, 12, 2);
		
		//Al tener un programa complejo podemos comprobar si una instancia pertenece a una clase o no:
		if (directorComercial instanceof Empleado) {
			System.out.println("Es de tipo Jefatura");
		}
		if (ejemplo instanceof Comparable) {
			System.out.println("Implementa la interfaz comparable");
		}*/
		
		//Ponemos en uso la interfaz que creamos de Jefes con el tomarDecision
		System.out.println(jefeFinanzas.tomarDecisiones("Subir el sueldo un 5% a todos los empleados por el "
				+ "buen desempeño."));
		
		System.out.println(jefeRRHH.darNombre()+" tiene un bonus de: "+jefeRRHH.estableceBonus(1000));
		
		for (Empleado e: misEmpleados) {
			e.subirSueldo(5);
		}
		
		//Ordenamos el array por sueldo, para hacerlo hay que implementar a la clase la interfaz Comparable
		Arrays.sort(misEmpleados);
		
		for (int i = 0; i < misEmpleados.length; i++) {
			System.out.println("");
			System.out.println("Nombre: "+misEmpleados[i].darNombre());
			System.out.println("Sueldo: "+misEmpleados[i].darSueldo());
			System.out.println("Fecha de alta: "+misEmpleados[i].darFecha());
		}
		
	}

}

class Empleado implements Comparable, Trabajadores {
	
	private String nombre;
	private double sueldo;
	private Date fechaAlta;
	
	public Empleado (String nom, int sal, int anno, int mes, int dia) {
		nombre = nom;
		sueldo = sal;
		GregorianCalendar fecha = new GregorianCalendar(anno, mes-1, dia);
		fechaAlta = fecha.getTime();
	}
	
	//Sobrecarga de constructores = esto quiere decir que una clase puede tener muchos metodos constructores
	// puede haber varios constructores y se utilizara el que cumpla que tiene todos los parametros que
	// pide el mismo constructor. No puede haber constructores con la misma cant de parametros.
	
	public Empleado (String nom) {
		
		//nombre = nom;
		
		//Otra opción que tenemos es utilizar el this, en este uso del this lo que va a hacer es tomar
		// los valores de los parametros que tenemos y rellenarlo con los que les pasemos, llamando al otro
		// constructor para eso. Al constructor que concuerde con la cant de parametros que le pasamos.
		this(nom, 30000, 2000, 1, 1);
		
	}
	
	//Setters
	public void subirSueldo(double porcentaje) {
		double aumento = sueldo*porcentaje/100;
		sueldo += aumento;
	}
	
	//Getters	
	public String darNombre() {
		return nombre;
	}
	
	public double darSueldo() {
		return sueldo;
	}
	
	//Si yo quiero que no se pueda modificar un método con una subclase, es decir, que se reemplaze teniendo
	// el mismo nombre, como pasa con darSueldo, lo declaro como final.
	public final Date darFecha() {
		return fechaAlta;
	}
	
	//Para usar la interfaz 'Comparable' tenemos que definir los métodos requeridos en Comparable, el cual
	// es compareTo. Para ver que requisitos tienen las interfaces hay que ver la API de Java.
	public int compareTo(Object miObjeto) {
		
		//Refundimos el objeto miObjeto a tipo Empleado para poder comparar.
		Empleado otroEmpleado = (Empleado) miObjeto;
		
		//Aca comparamos el parametro pasado con el elemento del array.
		//Podemos ver que estamos comparando por sueldo, por esto es por lo que vamos a shortear, pero
		// podemos shortearlo por cualquier campo del array para tener distintos shorts.
		
		if (this.sueldo < otroEmpleado.sueldo) {
			return -1;
		} else if (this.sueldo > otroEmpleado.sueldo) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public double estableceBonus(double gratificacion) {
		return Trabajadores.bonusbase+gratificacion;
	}
	
	
}

//Al usar final en una clase estamos diciendo que ninguna otra clase puede heredar de esta.
final class Jefatura extends Empleado implements Jefes {
	
	private double incentivo;
	
	public Jefatura(String nom, int sal, int anno, int mes, int dia) {
		
		super(nom, sal, anno, mes, dia);
		
	}
	
	public void estableceIncentivo(double cant) {
		
		incentivo = cant;
		
	}
	
	//Cómo no podemos utilizar el dameSueldo de empleado, lo que hacemos es crear un getter que se llame
	// de la misma manera para sobreescribirlo y poder usarlo en el jefe.
	public double darSueldo() {
		
		//al poner el super antes de darSueldo estamos diciendo que use el del metodo padre
		double sueldoJefe = super.darSueldo();
		return sueldoJefe+incentivo;
		
	}
	
	//Aca ponemos los requisitos de la interfaz Jefes
	public String tomarDecisiones(String decision) {
		return "Un miembro del comite de Jefatura ("+this.darNombre()+") a tomado la decisión de: "+decision;
	}
	
	public double estableceBonus(double gratificacion) {
		double prima = 2000;
		return Trabajadores.bonusbase+gratificacion+prima;
	}
	
}