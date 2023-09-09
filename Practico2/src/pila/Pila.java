package pila;

public interface Pila<T> {
	public int longitud();
	public boolean apilar(T elem);
	public T desapilar();
	public boolean esVacia();
	public void vaciar();
	public T tope();
	public boolean repOK();
	public String toString();
	public boolean equals(Object other);
}
