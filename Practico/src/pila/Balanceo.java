package pila;
import java.util.*;
 
public class Balanceo {
 
	static boolean estaBalanceado(String expresion){
		PilaArreglo<Character> pila = new PilaArreglo<Character>(expresion.length());
		PilaArreglo<Character> aux = new PilaArreglo<Character>(expresion.length());
		for (int i = 0; i < expresion.length(); i++) {
			aux.apilar(expresion.charAt(i));
		}
	
		for (int i = expresion.length()-1; i >= 0; i--) {
			char x = expresion.charAt(i);
			if (x == ')' || x == ']' || x == '}') {
				pila.apilar(x);
				aux.desapilar();
				continue;
			}
			if (pila.esVacia())
				return false;
		}
	
		for (int i = 0; i <= pila.longitud()+1; i++) {
			char x = pila.tope();
			switch(x) {
			case ')': 
				if (aux.tope() == '[' || aux.tope() == '{')
					return false;
					break;
			case ']': 
				if (aux.tope() == '(' || aux.tope() == '{')
					return false;
					break;
			case '}': 
				if (aux.tope() == '[' || aux.tope() == '(')
					return false;
					break;
				}
				pila.desapilar();
				aux.desapilar();
			}
	
			return true;
	}
 
    
	public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Indique la expresion que quiere verificar si esta balanceada: ");
        String expresion = entrada.next();
        
        for (int i = 0; i < expresion.length(); i++) {
        	char x = expresion.charAt(i);
        	if (x != '(' && x != '[' && x != '{' && x != ')' && x != ']' && x != '}') {
        		throw new IllegalArgumentException("La expresion dada contiene caracteres no validos.");
        	}
        }
 
        if (estaBalanceado(expresion))
            System.out.println("Balanceado");
        else
            System.out.println("No balanceado");
    }
}
