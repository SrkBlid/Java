package poo;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;

public class PruebaTemporizador {

	public static void main(String[] args) {
		
		DameHora oyente = new DameHora(); // = ActionListener oyente = new DameHora();
		Timer temporizador = new Timer(1000, oyente);
		temporizador.start();
		
		//A continuación usamos un JOptionPane para que el programa corra constantemente, sino se detiene.
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
		
		//Instrucción que detiene la ejecución del programa:
		System.exit(0);
	}

}


class DameHora implements ActionListener{
	
	//Método necesario segun la interfaz ActionListener, es lo que se va a repetir.
	public void actionPerformed(ActionEvent e) {
		//Toma la fecha actual y la almacena en la variable 'ahora'.
		Date ahora = new Date();
		System.out.println("Hora actual: "+ahora);
		//Toolkit relaciona todo lo que hay en java con nuestro equipo, con toolkit podemos hacer sonidos
		// y hasta cambiar la resolución.
		Toolkit.getDefaultToolkit().beep();
	}
}