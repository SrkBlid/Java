package graficos;
import java.awt.Toolkit;
import java.awt.*;

import javax.swing.*;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		
		MarcoCentrado miMarco = new MarcoCentrado();

	}
	
}

class MarcoCentrado extends JFrame{
	
	public MarcoCentrado() {
		
		//Para sacar la resolución de nuestra pantalla lo hacemos con Toolkit
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		
		setVisible(true);
		setSize(anchoPantalla/2, alturaPantalla/2);
		setLocation(anchoPantalla/4, alturaPantalla/4);
		setTitle("Mi marco centrado");
		
		//Ponerle un icono. Puede ser con un url o con una imagen de la pc
		//En ubuntu no sirve por que no tienen iconos las ventanas xd
		Image miIcono = miPantalla.getImage("src/graficos/icono.png");
		setIconImage(miIcono);
		
	}
	
}