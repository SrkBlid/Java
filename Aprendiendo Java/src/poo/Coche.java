package poo;

public class Coche {

	//Encapsulamiento: Que los datos solo puedan ser modificados desde la propia clase y no desde otra externa.
	// Esto se logra con el 'private', con este mismo se hace 'invisible la variable' y solo podremos acceder
	// a los datos en las variables a traves de métodos
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int pesoPlataforma;
	private String color;
	private int pesoTotal;
	private Boolean asientosCuero, climatizador;
	
	//Método constructor, es el estado inicial del objeto
	public Coche(){
		ruedas = 4;
		largo = 2000;
		ancho = 300;
		motor = 1600;
		pesoPlataforma = 500;
	}
	
	//Para poder ver cuantas ruedas tiene un coche, ya que las encapsulamos, hacemos uso de los
	// métodos getter (get, obtener un valor) y setters (setear, dar un valor)
	// A continuación hacemos un getter para ver las ruedas
	public String datosGenerales() {
		return "Este coche tiene "+ruedas+" ruedas. Mide "+largo/1000+" metros de largo. Mide "+"0."+ancho/100+
				" metros de ancho. El motor mide "+motor+" centimetros cúbicos. La plataforma pesa "+
				pesoPlataforma+" kg.";
	}
	
	// A continuación hacemos un setter
	public void elegirColor(String color_coche) {
		color = color_coche;
	}
	
	public String dimeColor() {
		return "El color del coche es "+color;
	}
	
	//Al tener un parametro con el mismo nombre que una variable podemos hacer referencia a la variable con
	// el comando 'this'.
	public void configuraAsiento(String asientosCuero) {
		if (asientosCuero.equalsIgnoreCase("si")) {
			this.asientosCuero = true;
		} else {
			this.asientosCuero = false;
		}
	}
	
	public String dimeAsiento() {
		if (asientosCuero == true) {
			return "El coche tiene asientos de cuero.";
		} else {
			return "El coche tiene asientos de tela.";
		}
	}
	
	public void configuraClima(String climatizador) {
		if (climatizador.equalsIgnoreCase("si")) {
			this.climatizador = true;
		} else {
			this.climatizador = false;
		}
	}
	
	public String dimeClima() {
		if (climatizador == true) {
			return "El coche tiene climatizador.";
		} else {
			return "El coche lleva aire acondicionado.";
		}
	}
	
	//Vamos a hacer un método setter y getter pero NO se recomienda esta practica
	public String dimePeso() {
		int pesoCarroceria = 500;
		pesoTotal = pesoPlataforma+pesoCarroceria;
		
		if (asientosCuero) {
			pesoTotal += 50;
		}
		if (climatizador) {
			pesoTotal += 20;
		}
		
		return "El peso del coche es "+pesoTotal+" kilogramos.";
		
	}
	
	public int precioCoche() {
		int precioFinal = 10000;
		
		if (asientosCuero) {
			precioFinal += 2000;
		}
		if (climatizador) {
			precioFinal += 1500;
		}
		
		return precioFinal;
		
	}
	
}
