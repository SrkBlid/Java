import javax.swing.*;
public class Bucles {
	public static void main(String[] args) {
		
		String clave = "Joaquin";
		String pass = "";
		
		//while de siempre, evalua la condición del mismo y si es verdadera entra en el bucle.
		while (clave.equals(pass) == false) {
			pass = JOptionPane.showInputDialog("Introduzca la contraseña");
			if (clave.equals(pass) == false) {
				System.out.println("La contraseña es incorrecta, intentelo nuevamente");
			} else {
				System.out.println("Contraseña correcta. Ingresando");
			}
		}
		
		//tambien tenemos el do while, se ejecuta 1 vez y luego evalua la condición.
		
		//el for, con inicialización, condicional y paso
		for (int i = 0; i < 10; i++) {
			System.out.println(clave);
		}
		
	}

}
