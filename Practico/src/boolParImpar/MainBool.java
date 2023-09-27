package boolParImpar;
import boolParImpar.BoolParImpar;

public class MainBool {

	public static void main(String[] args) {
		BoolParImpar par = new BoolParImpar(2);
		BoolParImpar impar = new BoolParImpar(3);
		
		System.out.println("VALOR DE VERDAD DEL PAR: "+par.TrueFalse());
		System.out.println("NEGACIÓN DE PAR: "+par.Negacion());		
		System.out.println("");
		System.out.println("VALOR DE VERDAD DEL PAR: "+impar.TrueFalse());
		System.out.println("NEGACIÓN DE IMPAR: "+impar.Negacion());
		System.out.println("");
		System.out.println("DISYUNCIÓN PAR PAR: "+par.Disyuncion(2));
		System.out.println("DISYUNCIÓN PAR IMPAR: "+par.Disyuncion(3));
		System.out.println("DISYUNCIÓN IMPAR PAR: "+impar.Disyuncion(2));
		System.out.println("DISYUNCIÓN IMPAR IMPAR: "+impar.Disyuncion(3));
		System.out.println("");
		System.out.println("IMPLICACIÓN PAR PAR: "+par.Implicacion(2));
		System.out.println("IMPLICACIÓN PAR IMPAR: "+par.Implicacion(3));
		System.out.println("IMPLICACIÓN IMPAR PAR: "+impar.Implicacion(2));
		System.out.println("IMPLICACIÓN IMPAR IMPAR: "+impar.Implicacion(3));
	}

}
