package Main;

/**
 * Clase nodo para ListaSimple
 * @author rdbae
 * @param <T> 
 */
public class Nodo <T> {
    private T valor;
    private Nodo <T> siguiente;

    /**
     * Constructor nodo.
     * @param valor
     * @param siguiente 
     */
    public Nodo(T valor, Nodo<T> siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }

    /**
     * Constructor para nodo vacio.
     * 
     */
    public Nodo() {
        this.valor = null;
        this.siguiente = null;
        
    }

    /**
     * Devuelve el valor del nodo.
     * @return 
     */
    public T getValor() {
        return valor;
    }

    /**
     * Instancia el valor del nodo.
     * @param valor 
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * Devuelve el siguiente nodo.
     * @return 
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    /**
     * Instancia el siguiente nodo.
     * @param siguiente 
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    
}
