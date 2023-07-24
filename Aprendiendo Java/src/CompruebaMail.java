import javax.swing.*;
public class CompruebaMail {

	public static void main(String[] args) {
		
		int arroba = 0;
		int posArroba = 0;
		boolean punto = false;
		String email = JOptionPane.showInputDialog("Ingrese su email"); 

		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				posArroba = i;
				arroba++;
			}
		}
		
		for (int i = posArroba; i < email.length(); i++) {
			if (email.charAt(i) == '.') {	
				punto = true;
			}
		}
		
		if (arroba == 1 && punto) {
			System.out.println("El email es correcto");
		} else {
			System.out.println("El email es incorrecto");
		}
		
	}

}
