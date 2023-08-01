import java.util.*;
public class UsoTallas {

	//Vamos a enumerar, esto quiere decir, que una variable solo pueda aceptar cierto rango o tipo
	// de valores, por ej: talla no pueda almacenar 'verde' o 'bicentenario'.
	
	//enum talla {Mini, Pequena, Mediana, Grande, Enorme}
	
	//o sino la podemos definir con un constructor de la forma:
	enum talla {
		
		MINI("S"), MEDIANA("M"), GRANDE("L"), ENORME("XL");
		
		private talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		
		public String dameAbreviatura() {
			return abreviatura;
		}
		
		private String abreviatura;
		
	}
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Escribe una talla (MINI, MEDIANA, GRANDE, ENORME): ");
		String entradaDatos = entrada.next().toUpperCase();
		
		talla laTalla = Enum.valueOf(talla.class, entradaDatos);
		System.out.println("Talla: "+laTalla);
		System.out.println("Abreviatura: "+laTalla.dameAbreviatura());
		
	}

}
