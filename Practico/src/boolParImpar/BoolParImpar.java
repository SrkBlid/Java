package boolParImpar;

public class BoolParImpar {

	private int p;
	
	public BoolParImpar() {
		this.p = 0;
	}
	
	public BoolParImpar(int p) {
		this.p = p;
	}
	
	public int Mostrar() {
		return this.p;
	}
	
	public void CambiarValor(int p) {
		this.p = p;
		System.out.println("Valor cambiado a: "+this.p);
	}
	
	public boolean TrueFalse () {
		return ((this.p % 2) == 0);
	}
	
	public boolean Negacion () {
		return (((this.p+1) % 2) == 0);
	}
	
	public boolean Disyuncion(int q) {
		int res = (Math.floorMod(this.p, 2)*Math.floorMod(q, 2));
		return (Math.floorMod(res, 2) == 0);
	}
	
	public boolean Implicacion(int q) {
		int res = (this.p+1)*(Math.floorMod(q, 2));
		return (Math.floorMod(res, 2) == 0);
	}
	
}
