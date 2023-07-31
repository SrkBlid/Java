package poo;
import java.util.*;
import javax.swing.*;

//Esta class de empleado es un ejemplo de como hacer todo lo mismo que en coche pero en 1 solo archivo fuente.

public class UsoEmpleado {

	public static void main(String[] args) {
		
		/*Empleado empleado1 = new Empleado("Joaquin Mezzano", 85000, 1999, 12, 3);
		Empleado empleado2 = new Empleado("Roberto Pereira", 100000, 1995, 9, 23);
		Empleado empleado3 = new Empleado("Ana Rupiere", 75000, 2001, 1, 15);
		
		empleado1.subirSueldo(5);
		empleado2.subirSueldo(5);
		empleado3.subirSueldo(5);
		
		System.out.println("Nombre: "+empleado1.darNombre()+". Sueldo: "+empleado1.darSueldo()+
				". Fecha de alta: "+empleado1.darFecha());
		System.out.println("Nombre: "+empleado2.darNombre()+". Sueldo: "+empleado2.darSueldo()+
				". Fecha de alta: "+empleado2.darFecha());
		System.out.println("Nombre: "+empleado3.darNombre()+". Sueldo: "+empleado3.darSueldo()+
				". Fecha de alta: "+empleado3.darFecha());
		*/
		
		Empleado[] misEmpleados = new Empleado[3];
		for (int i = 0; i < misEmpleados.length; i++) {
			misEmpleados[i] = new Empleado(JOptionPane.showInputDialog("Nombre del empleado"),
					Integer.parseInt(JOptionPane.showInputDialog("Sueldo del empleado")),
					Integer.parseInt(JOptionPane.showInputDialog("Año de ingreso")),
					Integer.parseInt(JOptionPane.showInputDialog("Mes de ingreso")),
					Integer.parseInt(JOptionPane.showInputDialog("Dia de ingreso")));
		}
		
		for (Empleado e: misEmpleados) {
			e.subirSueldo(5);
		}
		
		for (int i = 0; i < misEmpleados.length; i++) {
			System.out.println("Nombre: "+misEmpleados[i].darNombre());
			System.out.println("Sueldo: "+misEmpleados[i].darSueldo());
			System.out.println("Fecha de alta: "+misEmpleados[i].darFecha());
		}
		
	}

}

class Empleado {
	
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
	
	public Date darFecha() {
		return fechaAlta;
	}
	
}

class Jefatura extends Empleado {
	
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
	
	private double incentivo;
	
}