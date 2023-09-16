package racionales;
public class Racionales {

	private long numerador;
	private long denominador;
	
	//CONSTRUCTORES
	public Racionales() {
		numerador = 1;
		denominador = 1;
	}
	
	public Racionales(long numerador, long denominador) {
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	//METODOS
	public Racionales suma(Racionales n1) {
		Racionales aux = new Racionales();
		if(this.denominador == n1.denominador) {
			aux.numerador = this.numerador+n1.numerador;
			aux.denominador = this.denominador;
			return aux;
		} else {
			long i = this.denominador*n1.denominador;
			aux.numerador = (i/this.denominador)*this.numerador+(i/n1.denominador)*n1.numerador;
			aux.denominador = this.denominador*n1.denominador;
			return aux;
		}
	}
	
	public Racionales resta(Racionales n1) {
		Racionales aux = new Racionales();
		if(this.denominador == n1.denominador) {
			aux.numerador = this.numerador-n1.numerador;
			aux.denominador = this.denominador;
			return aux;
		} else {
			long i = this.denominador*n1.denominador;
			aux.numerador = (i/this.denominador)*this.numerador-(i/n1.denominador)*n1.numerador;
			aux.denominador = this.denominador*n1.denominador;
			return aux;
		}
	}
	
	//OVERRIDE
	public String toString() {
		return this.numerador+"/"+this.denominador;
	}
	
	public boolean equals(Object n1) {
		if (n1 == null)
			return false;
		if (n1 == this)
			return true;
		if (!(n1 instanceof Racionales))
			return false;
		Racionales otroRacional = (Racionales) n1;
		return otroRacional.numerador == numerador && otroRacional.denominador == denominador;
	}
	
}
