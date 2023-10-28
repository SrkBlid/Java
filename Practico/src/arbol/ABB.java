package arbol;
import java.util.Comparator;
import java.util.List;
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
        if (r.getIzquierdo() == null && r.getDerecho() == null) {
            NodoBinario<T> nuevo = new NodoBinario<T>(n);
            if (comparador.compare(n, r.getValor()) > 0){
                r.setIzquierdo(nuevo);;
                r.setAltura(1+Math.max(r.getDerecho().getAltura(), r.getIzquierdo().getAltura()));
                return r;
            } else {
                r.setDerecho(nuevo);
                r.setAltura(1+Math.max(r.getDerecho().getAltura(), r.getIzquierdo().getAltura()));
                return r;
            }
        }

        //Caso recursivo para ir hasta el lugar correcto.
        if ((comparador.compare(n, r.getValor())) > 0){
            insertarRecursivo(r.getIzquierdo(), n);
        } else {
            insertarRecursivo(r.getDerecho(), n);
        }
        throw new UnsupportedOperationException("El elemento ya esta agregado.");
    }


    /**
     * {@inheritDoc}
     */
    public boolean pertenece(T elem) {
        boolean res = false;
        if (perteneceRecursivo(null, elem, res)){
            res = true;
        }
        return res;
    }

    private boolean perteneceRecursivo(NodoBinario<T> r, T n, Boolean f){
        //Vemos recursivamente si el elemento se encuentra, en caso de que no devolvemos false.
        if (comparador.compare(r.getValor(), null) == 0){
            return f;
        }
        if (comparador.compare(n, r.getValor()) > 0){
            perteneceRecursivo(r.getIzquierdo(), n, f);
        }
        if (comparador.compare(n, r.getValor()) < 0){
            perteneceRecursivo(r.getDerecho(), n, f);
        }
        f = true;
        return f;
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
        if (comparador.compare(null, r.getValor()) == 0){
            throw new UnsupportedOperationException("El elemento no se encuentra en el arbol.");
        }
        if (comparador.compare(n, r.getValor()) > 0){
            borrarRecursivo(r.getIzquierdo(), n);
        }
        if (comparador.compare(n, r.getValor()) < 0){
            borrarRecursivo(r.getDerecho(), n);
        }
        
        //En caso de encontrarlo pasa a ver de que tipo es:
        if (r.getIzquierdo() == null && r.getDerecho() == null){
            r.setValor(null);
        }
        if (r.getIzquierdo() == null){
            r.setValor(r.getDerecho().getValor());
        }
        if (r.getDerecho() == null){
            r.setValor(r.getIzquierdo().getValor());
        }
                //ESTE ÚLTIMO ESTA MAL, CORREGIR
        if (r.getIzquierdo() != null && r.getDerecho() != null){
            NodoBinario<T> aux = new NodoBinario<T>();
            aux = r.getIzquierdo();
            while (aux.getDerecho() != null){
                aux = aux.getDerecho();
            }
        }

        //Una vez eliminado volvemos a calcular la altura del arbol y lo devolvemos.
        r.setAltura(1+Math.max(r.getDerecho().getAltura(), r.getIzquierdo().getAltura()));
        return r;
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
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolIzquierdo() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolDerecho() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int elementos() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int altura() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean esVacio() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    public T mayorValor(){
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T menorValor() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T sucesor(T elem) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T predecesor(T elem) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean repOK() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("TODO: implementar");
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
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido pre order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPreOrder(NodoBinario<T> raiz, List<T> elementos) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido post order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPostOrder(NodoBinario<T> raiz, List<T> elementos) {
        throw new UnsupportedOperationException("TODO: implementar");
    }


}
