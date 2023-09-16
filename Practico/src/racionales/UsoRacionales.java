package racionales;
import racionales.Racionales;

public class UsoRacionales {
	public static void main (String[] args) {
		Racionales r1 = new Racionales(2, 4);
		Racionales r2 = new Racionales(4, 2);
		System.out.println(r1.suma(r2));
		System.out.println(r1.resta(r2));
		System.out.println(r1.equals(r2));
	}	
}
