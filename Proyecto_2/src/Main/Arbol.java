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
     * @param personaRaiz 
     */
    public Arbol(Persona personaRaiz) {
        this.raiz = new NodoArbol(personaRaiz);
    }
    
    /**
     * Metodo para buscar solo por persona
     * @param persona
     * @return 
     */
    public NodoArbol buscarNodo(Persona persona) {
        return buscarNodoRecursivo(raiz, persona);
    }
    
    /**
     * Metodo que recorre todo el arbol para encontrar un nodo
     * @param nodo
     * @param persona
     * @return 
     */
    private NodoArbol buscarNodoRecursivo(NodoArbol nodo, Persona persona) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getPersona().getNombre().equals(persona.getNombre())) {
            return nodo;
        }
        for (NodoArbol hijo : nodo.obtenerHijos()) {
            NodoArbol resultado = buscarNodoRecursivo(hijo, persona);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }
    
    /**
     * Metodo para agregar un Nodo hijo (el que se crea) asignandole un padre (existente)
     * @param personaPadre
     * @param personaHijo 
     */
    public void agregarNodo(Persona personaPadre, Persona personaHijo) {
        NodoArbol padre = buscarNodo(personaPadre);
        if (padre != null) {
            NodoArbol hijo = new NodoArbol(personaHijo);
            padre.agregarHijo(hijo);
        } else {
            //padre no encontrado
        }
    }
    
    /**
     * Metodo para Obtener el padre de un nodo
     * @param persona
     * @return 
     */
    public NodoArbol obtenerPadre(Persona persona) {
        NodoArbol nodo = buscarNodo(persona);
        if (nodo != null) {
            return nodo.obtenerPadre();
        } 
        else {
            return null;
        }
    }
    
    /**
     * Metodo para obtener el array de hijos de un nodo
     * @param persona
     * @return 
     */
    public NodoArbol[] obtenerHijos(Persona persona) {
        NodoArbol nodo = buscarNodo(persona);
        if (nodo != null) {
            return nodo.obtenerHijos();
        }
        else {
            return null;
        }
    }
    /**
     * Metodo que devuelve el array de los antepasados del nodo buscado
     * @param persona
     * @return 
     */
    public Persona[] obtenerAntepasados(Persona persona) {
        NodoArbol nodo;
        nodo = buscarNodo(persona);
        if (nodo == null) {
            return new Persona[0]; // No encontrado
        }

        Persona[] antepasados = new Persona[10]; // por poner un numero
        int index = 0;

        while (nodo.obtenerPadre() != null) {
            nodo = nodo.obtenerPadre();
            antepasados[index++] = nodo.getPersona();
        }

        Persona[] result = new Persona[index];
        //copia el array antepasados a result, pero sin los null
        System.arraycopy(antepasados, 0, result, 0, index);

        return result;
    }
    
    /**
     * Devuelve un array con todos los integrantes de una generacion (Misma profundidad)
     * @param persona
     * @return 
     */
    public String[] obtenerMismaGeneracion(Persona persona) {
        NodoArbol nodo = buscarNodo(persona);
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
            resultado.insertarAlPrincipio(nodo.getPersona().getNombre());
            //despues veremos si hacer la lista de objetos Persona o de Strings
        } else {
            for (NodoArbol hijo : nodo.obtenerHijos()) {
                obtenerNodosEnNivel(hijo, nivelObjetivo, nivelActual + 1, resultado);
            }
        }
    }
    public String[] obtenerPorTituloNobiliario(String titulo) {
        ListaSimple resultado = new ListaSimple();
        buscarPorTituloNobiliario(raiz, titulo, resultado);
        return resultado.aArray();
    }

    private void buscarPorTituloNobiliario(NodoArbol nodo, String titulo, ListaSimple resultado) {
        if (nodo == null) {
            return;
        }
        if (titulo.equals(nodo.getPersona().getTitulo())) {
            resultado.insertarAlPrincipio(nodo.getPersona());
        }
        for (NodoArbol hijo : nodo.obtenerHijos()) {
            buscarPorTituloNobiliario(hijo, titulo, resultado);
        }
    }
    

}
