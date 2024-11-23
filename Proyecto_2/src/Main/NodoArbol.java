package Main;

/**
 *Clase Nodo para Arbol.
 * 
 */
public class NodoArbol {
    private Persona persona;
    NodoArbol padre;
    NodoArbol[] hijos;
    int numeroHijos;

    /**
     * Constructor NodoArbol.
     * @param persona 
     */
    public NodoArbol(Persona persona) {
        this.persona = persona;
        this.hijos = new NodoArbol[10]; // No sé cuantos serían el máximo en el Json
        this.numeroHijos = 0;
    }
    /**
     * Metodo para agregar hijos.
     * @param hijo 
     */
    public void agregarHijo(NodoArbol hijo) {
        if (numeroHijos < hijos.length) {
            hijos[numeroHijos++] = hijo;
            hijo.padre = this;
        } else {
            //No se pueden agregar más hijos
        }
    }
    
    /**
     * Metodo para obtener el padre del NodoArbol.
     * @return 
     */
    public NodoArbol obtenerPadre() {
        return padre;
    }
    
    /**
     * Metodo para obtener el array de los hijos del NodoArbol.
     * @return 
     */
    public NodoArbol[] obtenerHijos() {
        NodoArbol[] result = new NodoArbol[numeroHijos];
        System.arraycopy(hijos, 0, result, 0, numeroHijos);
        return result;
    }
    
    /**
     * Getter de persona.
     * @return 
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Instancia persona en el nodo.
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    
}
