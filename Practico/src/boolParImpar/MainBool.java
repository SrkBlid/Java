package boolParImpar;
import boolParImpar.BoolParImpar;

public class MainBool {

	public static void main(String[] args) {
		BoolParImpar prueba = new BoolParImpar(3);
		BoolParImpar prueba2 = new BoolParImpar(6);
		System.out.println("Valor de verdad de "+prueba.Mostrar()+": "+prueba.TrueFalse());
		System.out.println("Negación de "+prueba.Mostrar()+": "+prueba.Negacion());
		System.out.println("Disyunción entre "+prueba.Mostrar()+" y "+prueba2.Mostrar()+": "+prueba.Disyuncion(prueba2.Mostrar()));
		System.out.println("Implicación entre "+prueba.Mostrar()+" y "+prueba2.Mostrar()+": "+prueba.Implicacion(prueba2.Mostrar()));
	}

}
