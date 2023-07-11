import java.lang.Integer;
import javax.swing.*;
public class EntradaDatosJPanel {
	public static void main(String[] args) {
		
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		
		String edad = JOptionPane.showInputDialog("Introduce tu edad");
		int edad_usuario = Integer.parseInt(edad);
		
		System.out.println("Hola "+nombre+", espero que tengas un buen dia.");
		System.out.println("Recuerda que el año que viene tendra "+(edad_usuario+1)+" años!");
	}

}
