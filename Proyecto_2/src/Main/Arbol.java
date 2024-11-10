/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author reneb
 */
public class Arbol {
    NodoArbol raiz;
    
    /**
     * Constructor
     * @param nombreRaiz 
     */
    public Arbol(String nombreRaiz) {
        this.raiz = new NodoArbol(nombreRaiz);
    }
    
    /**
     * Metodo para buscar solo por nombre
     * @param nombre
     * @return 
     */
    public NodoArbol buscarNodo(String nombre) {
        return buscarNodoRecursivo(raiz, nombre);
    }
    
    /**
     * Metodo que recorre todo el arbol para encontrar un nodo
     * @param nodo
     * @param nombre
     * @return 
     */
    private NodoArbol buscarNodoRecursivo(NodoArbol nodo, String nombre) {
        if (nodo == null) {
            return null;
        }
        if (nodo.nombre.equals(nombre)) {
            return nodo;
        }
        for (NodoArbol hijo : nodo.obtenerHijos()) {
            NodoArbol resultado = buscarNodoRecursivo(hijo, nombre);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }
    
    /**
     * Metodo para agregar un Nodo hijo (el que se crea) asignandole un padre (existente)
     * @param nombrePadre
     * @param nombreHijo 
     */
    public void agregarNodo(String nombrePadre, String nombreHijo) {
        NodoArbol padre = buscarNodo(nombrePadre);
        if (padre != null) {
            NodoArbol hijo = new NodoArbol(nombreHijo);
            padre.agregarHijo(hijo);
        } else {
            //padre no encontrado
        }
    }
    
    /**
     * Metodo para Obtener el padre de un nodo
     * @param nombre
     * @return 
     */
    public NodoArbol obtenerPadre(String nombre) {
        NodoArbol nodo = buscarNodo(nombre);
        if (nodo != null) {
            return nodo.obtenerPadre();
        } 
        else {
            return null;
        }
    }
    
    /**
     * Metodo para obtener el array de hijos de un nodo
     * @param nombre
     * @return 
     */
    public NodoArbol[] obtenerHijos(String nombre) {
        NodoArbol nodo = buscarNodo(nombre);
        if (nodo != null) {
            return nodo.obtenerHijos();
        }
        else {
            return null;
        }
    }
    /**
     * Metodo que devuelve el array de los antepasados del nodo buscado
     * @param nombre
     * @return 
     */
    public String[] obtenerAntepasados(String nombre) {
        NodoArbol nodo;
        nodo = buscarNodo(nombre);
        if (nodo == null) {
            return new String[0]; // No encontrado
        }

        String[] antepasados = new String[10]; // por poner un numero
        int index = 0;

        while (nodo.obtenerPadre() != null) {
            nodo = nodo.obtenerPadre();
            antepasados[index++] = nodo.nombre;
        }

        String[] result = new String[index];
        //copia el array antepasados a result, pero sin los null
        System.arraycopy(antepasados, 0, result, 0, index);

        return result;
    }
    
    /**
     * Devuelve un array con todos los integrantes de una generacion (Misma profundidad)
     * @param nombre
     * @return 
     */
    public String[] obtenerMismaGeneracion(String nombre) {
        NodoArbol nodo = buscarNodo(nombre);
        if (nodo == null) {
            return new String[0]; 
        }

        int nivel = obtenerNivel(nodo, 0); 
        ListaSimple mismaGeneracion = new ListaSimple();
        obtenerNodosEnNivel(raiz, nivel, 0, mismaGeneracion);

        // Convertir la lista enlazada a array
        return mismaGeneracion.aArray();
    }
    
    /**
     * Obtiene el nivel del Nodo buscado
     * @param nodo
     * @param nivelActual
     * @return 
     */
    private int obtenerNivel(NodoArbol nodo, int nivelActual) {
        if (nodo == null) {
            return -1; 
        }
        if (nodo == raiz) {
            return nivelActual;
        }
        return obtenerNivel(nodo.obtenerPadre(), nivelActual + 1);
    }
    
    /**
     * agrega a la lista ingresada todos los nodos pertenecientes al mismo nivel objetivo
     * @param nodo
     * @param nivelObjetivo
     * @param nivelActual
     * @param resultado 
     */
    private void obtenerNodosEnNivel(NodoArbol nodo, int nivelObjetivo, int nivelActual, ListaSimple resultado) {
        if (nodo == null) {
            return;
        }
        if (nivelActual == nivelObjetivo) {
            resultado.insertarAlPrincipio(nodo.nombre);
        } else {
            for (NodoArbol hijo : nodo.obtenerHijos()) {
                obtenerNodosEnNivel(hijo, nivelObjetivo, nivelActual + 1, resultado);
            }
        }
    }

}
