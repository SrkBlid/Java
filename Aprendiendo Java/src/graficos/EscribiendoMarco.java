package graficos;
import javax.swing.*;
import java.awt.*;

public class EscribiendoMarco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoConTexto marco1 = new MarcoConTexto();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

class MarcoConTexto extends JFrame{
	
	public MarcoConTexto() {
		
		setVisible(true);
		setSize(600, 450);
		setLocation(650, 200);
		setTitle("Primer texto");
		
		//Ahora agregamos la lamina llamandola
		Lamina milamina = new Lamina();
		add(milamina);
		
	}
	
}

//Para hacer una lamina esta siempre tendra que heredar de JPanel
class Lamina extends JPanel{
	
	//Sobrescribimos el metodo paintComponent para escribir lo que nosotros queramos
	public void paintComponent(Graphics g) {
		
		//Primero hay que invocar el paintComponent de JPanel para que haga su trabajo
		super.paintComponent(g);
		//Luego lo modificamos: g.drawString(texto, x, y)
		g.drawString("Estamos aprendiendo swing", 100, 100);
		
	}
	
}