package poo;

public class UsoVehiculo {

	public static void main(String[] args) {
		
		Coche micoche1 = new Coche();
		micoche1.elegirColor("verde");
		System.out.println(micoche1.datosGenerales()+" "+micoche1.dimeColor());
		
		Furgoneta mifurgoneta1 = new Furgoneta(7, 580);
		mifurgoneta1.elegirColor("amarillo");
		mifurgoneta1.configuraAsiento("si");
		mifurgoneta1.configuraClima("si");
		System.out.println(mifurgoneta1.datosGenerales()+" "+mifurgoneta1.dimeDatosFurgoneta());
	}

}
