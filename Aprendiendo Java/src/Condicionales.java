import java.util.*;
import javax.swing.*;
public class Condicionales {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		//System.out.println("Indica tu edad: ");
		//int edad = entrada.nextInt();
		
		//if (edad >= 18) {
		//	System.out.println("Eres mayor de edad");
		//} else {
		//	System.out.println("Eres menor de edad");
		//}
		
		/////////////////////////////////////////////////////
		
		System.out.println("Selecciona una de las siguiente opciones: \n1. Cuadrado \n2. Rectangulo \n3. Triangulo \n4. Circulo");
		System.out.print("Opcion: ");
		int opcion = entrada.nextInt();
		
		switch(opcion) {
		
		case 1: 
			int lado = Integer.parseInt(JOptionPane.showInputDialog("Indique el valor de un lado del cuadrado"));
			System.out.print("El area del cuadrado es: "+lado*lado);
			break;
			
		case 2:
			int base = Integer.parseInt(JOptionPane.showInputDialog("Indique el valor de la base del rectangulo"));
			int altura = Integer.parseInt(JOptionPane.showInputDialog("Indique el valor de altura del rectangulo"));
			System.out.println("El area del rectangulo es: "+base*altura);			
			break;
			
		case 3:
			int baseT = Integer.parseInt(JOptionPane.showInputDialog("Indique el valor de la base del triangulo"));
			int alturaT = Integer.parseInt(JOptionPane.showInputDialog("Indique el valor de altura del triangulo"));
			System.out.println("El area del triangulo es: "+(baseT*alturaT)/2);	
			break;
			
		case 4:
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Indique el valor del radio del circulo"));
			System.out.print("El area del circulo es: ");
			System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
			break;
			
		default:
			System.out.println("La opción indicada no existe, intente nuevamente.");
		}
		
	}

}
