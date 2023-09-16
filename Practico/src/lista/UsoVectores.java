package lista;
import lista.ListaArregloVectores;

public class UsoVectores {

	public static void main(String[] args) {
		ListaArregloVectores lvec1 = new ListaArregloVectores();
		ListaArregloVectores lvec2 = new ListaArregloVectores();
		ListaArregloVectores lvec3 = new ListaArregloVectores();

		for(float i = 0; i < 10; i++) {
			Vector vec = new Vector(i, i+1);
			lvec1.agregar(vec);
		}
		System.out.println("lvec1 esta definido como: "+lvec1);
		for(float i = 10; i < 20; i++) {
			Vector vec = new Vector(i, i+1);
			lvec2.agregar(vec);
		}
		System.out.println("lvec2 esta definido como: "+lvec2);
		for(float i = 20; i < 25; i++) {
			Vector vec = new Vector(i, i+1);
			lvec3.agregar(vec);
		}
		System.out.println("lvec3 esta definido como: "+lvec3);
		
		Vector sum = new Vector(5, 6);
		System.out.println("La suma entre lvec3 y ("+sum.x+","+sum.y+") es: "+lvec1.sumar(sum));
		
		float esc = 3;
		System.out.println("La multiplicación entre lvec2 y el escalar "+esc+" es: "+lvec2.escalar(esc));
		
		Vector prod = new Vector(2, 3);
		System.out.println("El producto escalar entre lvec3 y ("+prod.x+","+prod.y+") es: "+lvec3.producto(prod));
		
	}

}
