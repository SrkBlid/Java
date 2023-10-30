package arbol;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ABB<Integer> arbol = new ABB<Integer>(Comparator.naturalOrder());

        // Insertar elementos
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        // Mostrar la raíz del árbol
        System.out.println("Raíz del árbol: " + arbol.raiz());

        // Verificar si un elemento está en el árbol
        System.out.println("¿El número 40 está en el árbol? " + arbol.pertenece(40));

        // Mostrar el número de elementos en el árbol
        System.out.println("Número de elementos en el árbol: " + arbol.elementos());

        // Mostrar subárbol izquierdo y derecho
        System.out.println("Subárbol izquierdo: " + arbol.subArbolIzquierdo());
        System.out.println("Subárbol derecho: " + arbol.subArbolDerecho());

        // Remover un elemento del árbol
        System.out.println(arbol);
        arbol.borrar(30);

        // Mostrar si el árbol está vacío
        System.out.println("¿El árbol está vacío? " + arbol.esVacio());

        // Vaciar el árbol
        arbol.vaciar();

        // Mostrar si el árbol está vacío después de vaciarlo
        System.out.println("¿El árbol está vacío después de vaciarlo? " + arbol.esVacio());
    }
}
