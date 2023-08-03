package graficos;
import java.awt.Frame;

import javax.swing.*;

public class CreandoMarcos {

	public static void main(String[] args) {
		
		miMarco marco1 = new miMarco();
		
	}

}

//Para crear las interfaces, la clase tiene que heredar de JFrame
class miMarco extends JFrame{
	
	public miMarco() {
		
		//setVisible nos deja ver el marco
		setVisible(true);
		
		//setDefaultCloseOperation nos deja decir que hacer cuando cerramos la ventana
		//Para ver por que usamos EXIT_ON_CLOSE hay que ver la API
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setSize es para darle un tamaño en pixeles y setLocation es para la posición en pantalla en pixeles
		//setSize(500, 300);
		//setLocation(500, 300);
		
		//setBounds hace lo mismo que setSize y setLocation pero en una sola variable
		//setBounds(posX, posY, tamX, tamY);
		setBounds(500,300,550,250);
		
		//setResizable permite que el usuario extienda la pantalla
		setResizable(true);
		
		//setExtendedState(Frame.MAXIMIZED_BOTH) hace que ocupe los maximos pixeles, es decir, toda la pantalla
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		
		setTitle("Mi ventana");
		
	}
	
}