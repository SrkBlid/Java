package poo;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;

//La diferencia con PruebaTemporizador es que realizamos lo mismo pero usando la clase interna

public class PruebaTemporizador2 {

	public static void main(String[] args) {
		
		Reloj miReloj = new Reloj(3000, true);
		miReloj.enMarcha();
		JOptionPane.showMessageDialog(null, "Haz click en aceptar para cerrar el mensaje");

	}

}

class Reloj {
	private int intervalo;
	private boolean sonido;
	
	public Reloj (int intervalo, boolean sonido) {
		
		this.intervalo = intervalo;
		this.sonido = sonido;
		
	}
	
	public void enMarcha () {
		
		//Clase interna local = Es como una clase interna pero dentro de un metodo, es util cuando solo
		// llamamos a un metodo una vez, como en este.
		class DameHora2 implements ActionListener{
			
			public void actionPerformed (ActionEvent evento) {
				
				Date ahora = new Date();
				System.out.println("Hora actual: "+ahora);
				
				if (sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
				
			}
			
		}
		
		ActionListener oyente = new DameHora2();
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start();
		
	}
	
	//Clase interna = clase dentro de otra clase. Cambiado por la clase interna local
	/*private class DameHora2 implements ActionListener{
		
		public void actionPerformed (ActionEvent evento) {
			
			Date ahora = new Date();
			System.out.println("Hora actual: "+ahora);
			
			if (sonido) {
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
		
	}*/
	
}
