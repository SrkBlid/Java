package poo;

//El extends nos sirve para decir que la clase nueva va a heredar de la siguiente a la extends.
// En este caso, la clase Furgoneta va a heredar de la clase Coche.
//Java NO admite herencia multiple.
public class Furgoneta extends Coche{

	//Ademas de las caracteristicas heredadas de coche, le podemos dar las nuestras
	int capacidadCarga;
	int plazasExtra;

	public Furgoneta(int plazasExtra, int capacidadCarga){
		
		//Con el super() llamamos al constructor de la clase padre/superclase
		super();
		this.plazasExtra = plazasExtra;
		this.capacidadCarga = capacidadCarga;
		
	}
	
	public String dimeDatosFurgoneta() {
		return "La capacidad de carga es: "+capacidadCarga+". Con "+plazasExtra+" plazas extras.";
	}
	
}