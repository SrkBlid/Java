package arbol;

/**
 * Clase auxiliar para diccionarios implementados con nodos encadenados.
 */
public class NodoBinario<T>  {
    private T valor;
    private NodoBinario<T> izquierdo;
    private NodoBinario<T> derecho;
    private int altura;


    NodoBinario(T valor, NodoBinario<T> izquierdo, NodoBinario<T> derecho) {
    	this.valor = valor;
    	this.izquierdo = izquierdo;
    	this.derecho = derecho;
    	this.altura = 1+Math.max(izquierdo.altura, derecho.altura);
    }

    public NodoBinario(){
    	this.valor = null;
    	this.izquierdo = null;
    	this.derecho = null;
    	this.altura = 0;
    }

    public NodoBinario(T valor){
    	this.valor = valor;
    	this.izquierdo = null;
    	this.derecho = null;
    	this.altura = 1;
    }

    T getValor() {
        return valor;
    }

    void setValor(T nuevoValor) {
        valor = nuevoValor;
    }

    NodoBinario<T> getIzquierdo() {
        return izquierdo;
    }

    void setIzquierdo(NodoBinario<T> nuevoIzquierdo) {
        this.izquierdo = nuevoIzquierdo;
        this.altura = izquierdo.altura;
    }

    NodoBinario<T> getDerecho() {
        return derecho;
    }

    void setDerecho(NodoBinario<T> nuevoDerecho) {
        this.derecho = nuevoDerecho;
        this.altura = derecho.altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


}
