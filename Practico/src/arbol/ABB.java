package arbol;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * Árbol binario de busqueda (ABB), es una implementación de {@code Diccionario} mediante nodos encadenados que preserva las propiedades de Diccionario.
 * @param <T> Tipo del valor asociado a los nodos del árbol, debe ser posible definir un orden total para los mismos.
 * @see NodoBinario
 */
public class ABB<T> implements Diccionario<T> {

    private NodoBinario<T> raiz;

    /**
     * Comparador usado para mantener el orden en un ABB, o null.
     */
    private final Comparator<? super T> comparador;

    /**
     * Construye un nuevo árbol vacío ordenado acorde al comparador dado.
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     */
    public ABB(Comparator<? super T> comparador) {
        this.comparador = comparador;
        this.raiz = null;
    }

    /**
     * Construye un nuevo árbol con un elemento en la raiz, ordenado acorde al comparador dado.
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     * @param valor de la raiz del nuevo arbol si no es null.
     */
    public ABB(Comparator<? super T> comparador, T valor) {
    	this.comparador = comparador;
    	this.raiz = new NodoBinario<T>(valor);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void insertar(T elem) {
        raiz = insertarRecursivo(raiz, elem);
    }

    private NodoBinario<T> insertarRecursivo(NodoBinario<T> r, T n){
        //Caso cuando ya no nos quedan elementos, es decir, estamos en el lugar correcto.
        if (r == null) {
            return new NodoBinario<T>(n);
        }

        //Caso recursivo para ir hasta el lugar correcto.
        if ((comparador.compare(n, r.getValor())) < 0){
            r.setIzquierdo(insertarRecursivo(r.getIzquierdo(), n));
        } else if ((comparador.compare(n, r.getValor())) > 0){
            r.setDerecho(insertarRecursivo(r.getDerecho(), n));
        } else {
            throw new UnsupportedOperationException("El elemento ya esta agregado.");
        }

        //Una vez eliminado volvemos a calcular la altura del arbol y lo devolvemos.
        int alturaIzq = (r.getIzquierdo() != null) ? r.getIzquierdo().getAltura() : 0;
        int alturaDer = (r.getDerecho() != null) ? r.getDerecho().getAltura() : 0;
        r.setAltura(1+Math.max(alturaIzq, alturaDer));
        return r;

    }


    /**
     * {@inheritDoc}
     */
    public boolean pertenece(T elem) {
        return perteneceRecursivo(raiz, elem);
    }

    private boolean perteneceRecursivo(NodoBinario<T> r, T n){
        //Vemos recursivamente si el elemento se encuentra, en caso de que no devolvemos false.
        if (r == null){
            return false;
        }
        if (comparador.compare(n, r.getValor()) < 0){
            return perteneceRecursivo(r.getIzquierdo(), n);
        }
        if (comparador.compare(n, r.getValor()) > 0){
            return perteneceRecursivo(r.getDerecho(), n);
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void borrar(T elem) {
        raiz = borrarRecursivo(raiz, elem);
    }

    private NodoBinario<T> borrarRecursivo(NodoBinario<T> r, T n){
        //Buscamos el elemento.
        if (r == null){
            return r;
        }

        if (comparador.compare(n, r.getValor()) == 0) {
            if (r.getIzquierdo() == null){
                return r.getDerecho();
            } else if (r.getDerecho() == null){
                return r.getIzquierdo();
            } else {
                r.setValor(encontrarMinimo(r.getDerecho()).getValor());
                r.setDerecho(eliminarMinimo(r.getDerecho()));
            }
        } 
        if (comparador.compare(n, r.getValor()) > 0 && r.getIzquierdo() != null){
            r.setIzquierdo(borrarRecursivo(r.getIzquierdo(), n));
        }
        if (comparador.compare(n, r.getValor()) < 0 && r.getDerecho() != null){
            r.setDerecho(borrarRecursivo(r.getDerecho(), n));
        }

        //Una vez eliminado volvemos a calcular la altura del arbol y lo devolvemos.
        int alturaIzq = (r.getIzquierdo() != null) ? r.getIzquierdo().getAltura() : 0;
        int alturaDer = (r.getDerecho() != null) ? r.getDerecho().getAltura() : 0;
        r.setAltura(1+Math.max(alturaIzq, alturaDer));
        return r;
    }

    private NodoBinario<T> encontrarMinimo (NodoBinario<T> nodo) {
        NodoBinario<T> actual = nodo;
        while (actual.getIzquierdo() != null){
            actual = actual.getIzquierdo();
        }
        return actual;
    }

    private NodoBinario<T> eliminarMinimo (NodoBinario<T> nodo) {
        if (nodo.getIzquierdo() == null) {
            return nodo.getDerecho();
        }
        nodo.setIzquierdo(eliminarMinimo(nodo.getIzquierdo()));
        return nodo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void vaciar() {
        raiz = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T raiz() {
        if (raiz != null){
            return raiz.getValor();
        } else {
            throw new NoSuchElementException("El árbol está vacío, no hay raíz.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolIzquierdo() {
        if (raiz != null && raiz.getIzquierdo() != null){
            ABB<T> aux = new ABB<T>(comparador);
            aux.raiz = raiz.getIzquierdo();
            return aux;
        } else {
            throw new NoSuchElementException("El árbol está vacío, no hay raíz.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolDerecho() {
        if (raiz != null && raiz.getDerecho() != null){
            ABB<T> aux = new ABB<T>(comparador);
            aux.raiz = raiz.getDerecho();
            return aux;
        } else {
            throw new NoSuchElementException("El árbol está vacío, no hay raíz.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int elementos() {
        return contarNodos(raiz);
    }

    private int contarNodos(NodoBinario<T> r){
        if (r == null) {
            return 0;
        } else {
            return 1+contarNodos(r.getIzquierdo())+contarNodos(r.getDerecho());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int altura() {
        if (r == null){
            throw new NoSuchElementException("El árbol está vacío.");
        }
        return raiz.getAltura();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean esVacio() {
        return raiz == null;
    }

    /**
     * {@inheritDoc}
     */
    public T mayorValor(){
        if (r == null){
            throw new NoSuchElementException("El árbol está vacío.");
        } else {
            return mayorRecursivo(raiz);
        }
    }

    private T mayorRecursivo(NodoBinario<T> r){
        if (r.getDerecho() != null) {
            return mayorRecursivo(r.getDerecho());
        }
        //Caso en el que derecho e izquierdo == null. Llegamos al elemento mayor.
        return r.getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T menorValor() {
        if (r == null){
            throw new NoSuchElementException("El árbol está vacío.");
        } else {
            return menorRecursivo(raiz);
        }
    }

    private T menorRecursivo (NodoBinario<T> r){
        if (r.getIzquierdo() != null) {
            return menorRecursivo (r.getIzquierdo());
        }
        return r.getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T sucesor(T elem) {
        if (raiz == null){
            throw new NoSuchElementException("El árbol está vacío.");
        }
        return sucesorRecursivo(raiz, elem);
    }

    private T sucesorRecursivo (NodoBinario<T> r, T n) {
        if (comparador.compare(n, r.getValor()) == 0){
            if (r.getIzquierdo() == null && r.getDerecho() == null) {
                throw new NoSuchElementException("No hay un sucesor disponible.");
            }
            if (r.getIzquierdo() == null){
                return r.getDerecho().getValor();
            }
            if (r.getDerecho() == null){
                return r.getIzquierdo().getValor();
            }
            //En caso de tener los 2 sucesores, devolvemos el más grande.
            return r.getDerecho().getValor();
        }

        if (comparador.compare(n, r.getValor()) > 0){
            return sucesorRecursivo(r.getDerecho(), n);
        } else {
            return sucesorRecursivo(r.getIzquierdo(), n);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T predecesor(T elem) {
        if (raiz == null){
            throw new NoSuchElementException("El árbol está vacío.");
        }
        return predecesorRecursivo(raiz, raiz.getValor(), elem);
    }

    private T predecesorRecursivo (NodoBinario<T> r, T aux, T n) {
        if (comparador.compare(n, r.getValor()) == 0){
            return aux;
        }

        if (comparador.compare(n, r.getValor()) > 0){
            return predecesorRecursivo(r.getDerecho(), r.getValor(), n);
        } else {
            return predecesorRecursivo(r.getIzquierdo(), r.getValor(), n);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean repOK() {
        return repOKRecursivo(raiz, null, null);
    }
    
    private boolean repOKRecursivo(NodoBinario<T> r, T minValue, T maxValue) {
        if (r == null) {
            return true; // Nodo vacío, es válido.
        }
    
        T valor = r.getValor();
    
        // Verificar si el valor actual cumple con la condición del ABB
        if ((minValue != null && comparador.compare(valor, minValue) <= 0) || (maxValue != null && comparador.compare(valor, maxValue) >= 0)) {
            return false;
        }
    
        // Verificar los subárboles
        return repOKRecursivo(r.getIzquierdo(), minValue, valor) && repOKRecursivo(r.getDerecho(), valor, maxValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringRecursivo(raiz, sb);
        return sb.toString();
    }
    
    private void toStringRecursivo(NodoBinario<T> r, StringBuilder sb) {
        if (r != null) {
            toStringRecursivo(r.getIzquierdo(), sb);
            sb.append(r.getValor()).append(" ");
            toStringRecursivo(r.getDerecho(), sb);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Verifica si es la misma instancia
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Verifica si el objeto es nulo o de una clase diferente
        }
    
        Diccionario<T> otherTree = (Diccionario<T>) obj;
        return equalsRecursivo(raiz, otherTree.raiz);
    }
    
    private boolean equalsRecursivo(NodoBinario<T> r1, NodoBinario<T> r2) {
        if (r1 == null && r2 == null) {
            return true; // Ambos son nulos, son iguales
        }
        if (r1 != null && r2 != null) {
            return r1.getValor().equals(r2.getValor()) &&
                   equalsRecursivo(r1.getIzquierdo(), r2.getIzquierdo()) &&
                   equalsRecursivo(r1.getDerecho(), r2.getDerecho());
        }
        return false; // Uno es nulo y el otro no, no son iguales
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> aLista() {
        return aLista(Orden.INORDER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> aLista(Orden orden) {
        List<T> elementos = new LinkedList<>();
        switch (orden) {
            case INORDER:
                return aListaInOrder(raiz, elementos);
            case PREORDER:
                return aListaPreOrder(raiz, elementos);
            case POSTORDER:
                return aListaPostOrder(raiz, elementos);
        }
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido in order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaInOrder(NodoBinario<T> raiz, List<T> elementos) {
        if (raiz != null) {
            aListaInOrder(raiz.getIzquierdo(), elementos);
            elementos.add(raiz.getValor());
            aListaInOrder(raiz.getDerecho(), elementos);
        }
        return elementos;
    }
    
    private List<T> aListaInOrderAlt (NodoBinario<T> raiz, List<T> elementos) {
        NodoBinario<T> actual = raiz;
        Deque<NodoBinario<T>> pila = new LinkedList<>();

        while (actual != null || !pila.isEmpty()) {
            while (actual != null) {
                pila.push(actual);
                actual = actual.getIzquierdo();
            }
            actual = pila.pop();
            elementos.add(actual.getValor());
            actual = actual.getDerecho();
        }

        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido pre order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPreOrder(NodoBinario<T> raiz, List<T> elementos) {
        if (raiz != null) {
            elementos.add(raiz.getValor());
            aListaInOrder(raiz.getIzquierdo(), elementos);
            aListaInOrder(raiz.getDerecho(), elementos);
        }
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido post order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPostOrder(NodoBinario<T> raiz, List<T> elementos) {
        if (raiz != null) {
            aListaInOrder(raiz.getIzquierdo(), elementos);
            aListaInOrder(raiz.getDerecho(), elementos);
            elementos.add(raiz.getValor());
        }
        return elementos;
    }


}
