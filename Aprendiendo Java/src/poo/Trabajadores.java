package poo;

public interface Trabajadores {

	//No hace falta poner public abstract, por default viene asi.
	double estableceBonus(double valor);
	
	//Las constantes en las interfaces son public static final.
	//Este valor lo usamos para dar un minimo.
	double bonusbase = 2500;
}
