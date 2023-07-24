import javax.swing.*;
public class PesoIdeal {

	public static void main(String[] args) {
		
		String genero = "";
		
		do {
			genero = JOptionPane.showInputDialog("Seleccione su genero (H/M)");
		} while (genero.equalsIgnoreCase("H") == false && genero.equalsIgnoreCase("M") == false);

		int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu altura en centimetros"));
		int pesoIdeal = 0;
				
		if (genero.equalsIgnoreCase("H")) {
			pesoIdeal = altura-110;
		} else {
			pesoIdeal = altura-120;
		}
		
		System.out.println("Su peso ideal es "+pesoIdeal+"kg");
		
	}

}
