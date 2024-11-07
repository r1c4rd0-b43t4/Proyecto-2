/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author reneb
 */
public class NodoArbol {

    String nombre;
    NodoArbol padre;
    NodoArbol[] hijos;
    int numeroHijos;

    /**
     * Constructor NodoArbol
     * @param nombre 
     */
    public NodoArbol(String nombre) {
        this.nombre = nombre;
        this.hijos = new NodoArbol[10]; // No sé cuantos serían el máximo en el Json
        this.numeroHijos = 0;
    }
    /**
     * Metodo para agregar hijos
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
     * Metodo para obtener el padre del NodoArbol
     * @return 
     */
    public NodoArbol obtenerPadre() {
        return padre;
    }
    
    /**
     * Metodo para obtener el array de los hijos del NodoArbol
     * @return 
     */
    public NodoArbol[] obtenerHijos() {
        NodoArbol[] result = new NodoArbol[numeroHijos];
        System.arraycopy(hijos, 0, result, 0, numeroHijos);
        return result;
    }
}
