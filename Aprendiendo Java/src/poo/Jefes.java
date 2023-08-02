package poo;

//Al decir extends Trabajadores estamos creando una jerarquia en las interfaces.
public interface Jefes extends Trabajadores {

	//Esta es la forma de declarar metodos en una interfaz, se dicen como son pero no se desarrollan.
	public abstract String tomarDecisiones(String decision);
	
}
