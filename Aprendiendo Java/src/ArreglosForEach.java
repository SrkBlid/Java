import javax.swing.*;
public class ArreglosForEach {

	public static void main(String[] args) {
		/*String paises[] = new String[8];
		
		for (int i = 0; i < paises.length; i++) {
			paises[i] = JOptionPane.showInputDialog("Ingrese el pais "+(i+1));
		}
		
		//El siguiente es un for each, tiene sus ventajas y desventajas
		for(String elemento: paises) {
			System.out.println("Pais: "+elemento);
		}
		
		for (int i = 0 ; i < paises.length; i++) {
		System.out.println("Pais "+(i+1)+": "+paises[i]);
		}*/
		
		int numeros[] = new int[100];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) Math.round(Math.random()*100);
		}
		
		for (int elem: numeros) {
			System.out.print(elem + " ");
		}		
		
	}

}
