package poo;
import javax.swing.*;

public class UsoCoche {

	public static void main(String[] args) {
		
		Coche Renault = new Coche(); //Instanciar una clase, ejemplar de clase coche
		//Llamamos al getter
		System.out.println(Renault.datosGenerales());
		
		Renault.elegirColor(JOptionPane.showInputDialog("Introduce el color del coche"));
		System.out.println(Renault.dimeColor());
		
		Renault.configuraAsiento(JOptionPane.showInputDialog("¿Asientos de cuero? (si/no)"));
		System.out.println(Renault.dimeAsiento());
		
		Renault.configuraClima(JOptionPane.showInputDialog("¿Climatozador? (si/no)"));
		System.out.println(Renault.dimeClima());
		
		System.out.println(Renault.dimePeso());
		System.out.println("El precio final del coches es "+Renault.precioCoche()+" dolares.");
	}

}
