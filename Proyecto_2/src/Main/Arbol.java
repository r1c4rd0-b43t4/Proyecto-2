package Main;

import javax.swing.JOptionPane;

/**
 * Clase Arbol con sus métodos.
 *
 */
public class Arbol {
    private NodoArbol raiz;
    
    /**
     * Constructor del Arbol.
     * @param personaRaiz 
     */
    public Arbol(Persona personaRaiz) {
        this.raiz = new NodoArbol(personaRaiz);
    }
    /**
     * Metodo que construye el árbol genealógico, crea una listaNodos con las Personas del Arbol, luego establece las relaciones entre ellos, para luego identificar la raiz.
     * @param listaPersonas 
     */
    public void construirArbol(ListaSimple<Persona> listaPersonas) {
        //revision de si el arbol tiene algun nodo con dos padres
        this.verificarDuplicados(listaPersonas);
        // Identificar la raíz
        Persona raizPersona = buscarRaiz(listaPersonas);
        if (raizPersona == null) {
            //no se encuentra
            JOptionPane.showMessageDialog(null, "No se encuentra raiz");
            throw new IllegalStateException("No se encuentra raiz");

        }
    
        // Crear la raiz
        NodoArbol raizNodo = new NodoArbol(raizPersona);
        this.setRaiz(raizNodo);

        procesarNodo(raizNodo, listaPersonas);
    }   

    /**
     * Método para procesar los elementos del JSON, crear el nodo que los contiene, asignar sus relaciones y si ya existe.
     * @param nodoPadre
     * @param listaPersonas 
     */
    private void procesarNodo(NodoArbol nodoPadre, ListaSimple<Persona> listaPersonas) {
        Persona personaPadre = nodoPadre.getPersona();

        Nodo<Persona> actual = listaPersonas.getpFirst();
        while (actual != null) {
            Persona persona = actual.getValor();
            if (!persona.equals(personaPadre)) {
                boolean aver = this.existePersona(persona);
                if (esHijoDe(persona, personaPadre)&& !aver) {
                    NodoArbol nodoHijo = new NodoArbol(persona);                   
                    nodoPadre.agregarHijo(nodoHijo);

                    // Recursivamente procesar los hijos del nuevo nodo
                    procesarNodo(nodoHijo, listaPersonas);
                }
            }
            actual = actual.getSiguiente();
        }
    }
    
    /**
     * Muestra las personas que hay en el Arbol.
     * @return 
     */    
    public int contarPersonas() {
        return contarPersonasRecursivo(raiz);
    }
    
    /**
     * Recorre el Arbol con un contador para devolver el número de nodos que hay en este.
     * @param nodo
     * @return 
     */
    private int contarPersonasRecursivo(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        }
        int count = 1; // Contar el nodo actual
        for (NodoArbol hijo : nodo.obtenerHijos()) {
            count += contarPersonasRecursivo(hijo);
        }
        return count;
    }
    
    /**
     * Método para ver si un nodo es hijo del otro.
     * @param hijo
     * @param padre
     * @return 
     */
    private boolean esHijoDe(Persona hijo, Persona padre) {
        Nodo<String> padreActual = hijo.getPadres().getpFirst();
        while (padreActual != null) {
            String nombrePadre = padreActual.getValor();
            String nombrePadreCompleto = padre.getNombre() + ", " + padre.getNumeral() + " of his name";

            String nombrePadreSinNumeral = padre.getNombre();
            if (nombrePadre.contains(",")) {
                nombrePadreSinNumeral = nombrePadre.split(",")[0].trim();
            }

            if (nombrePadre.equals(nombrePadreCompleto) || 
                nombrePadre.equals(nombrePadreSinNumeral) ||
                (padre.getMote() != null && nombrePadre.equals(padre.getMote()))) {
                return true;
            }
        padreActual = padreActual.getSiguiente();
        }
        return false;
    }

    /**
     * Revisa si una persona existe en el Arbol.
     * @param persona
     * @return 
     */
    public boolean existePersona(Persona persona) {
        return buscarNodo(persona) != null;
    }

    /**
     * Busca la raíz en el Json, verificando el que tenga como padre unknown.
     * @param listaPersonas
     * @return 
     */
    private Persona buscarRaiz(ListaSimple<Persona> listaPersonas) {
        Nodo<Persona> actual = listaPersonas.getpFirst();
            while (actual != null) {
                Persona persona = actual.getValor();
                Nodo<String> padreActual = persona.getPadres().getpFirst();
                if (padreActual != null && padreActual.getValor().equals("[Unknown]")) {
                    return persona;
                }
                actual = actual.getSiguiente();
            }
        return null;
    }
    
    /**
    * Verifica si hay duplicados en la lista de personas del Arbol.
    * @param listaPersonas La lista de personas a verificar.
    * @throws IllegalStateException si se encuentra una persona duplicada (mismo nombre y numeral).
    */
    public void verificarDuplicados(ListaSimple<Persona> listaPersonas) {
        Nodo<Persona> actual = listaPersonas.getpFirst();

        while (actual != null) {
            Persona persona1 = actual.getValor();
            Nodo<Persona> siguiente = actual.getSiguiente();

            while (siguiente != null) {
                Persona persona2 = siguiente.getValor();
                if (persona1.getNombre().equals(persona2.getNombre()) && 
                    persona1.getNumeral().equals(persona2.getNumeral())) {
                    JOptionPane.showMessageDialog(null, "Persona duplicada encontrada: " + persona1.getNombre() + "-" + persona1.getNumeral());
                    throw new IllegalStateException("Persona duplicada encontrada: " + persona1.getNombre() + "-" + persona1.getNumeral());
                }
                siguiente = siguiente.getSiguiente();
            }

            actual = actual.getSiguiente();
        }
    }

    /**
     * Constructor
     */
    public Arbol() {
    }
    
    /**
     * Pone la raiz.
     * @param raiz 
     */
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    /**
     * Método para buscar solo por persona.
     * @param persona
     * @return 
     */
    public NodoArbol buscarNodo(Persona persona) {
        return buscarNodoRecursivo(getRaiz(), persona);
    }
    
    /**
     * Método que recorre todo el Arbol para encontrar un nodo.
     * @param nodo
     * @param persona
     * @return 
     */
    private NodoArbol buscarNodoRecursivo(NodoArbol nodo, Persona persona) {
        //try{
            if (nodo == null) {
                return null;
            }
            if (nodo.getPersona().getNombre().equals(persona.getNombre())&& nodo.getPersona().getNumeral().equals(persona.getNumeral())&&nodo.getPersona().getPadres().getpFirst().getValor().equals(persona.getPadres().getpFirst().getValor())) {
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
     * Método para agregar un Nodo hijo (el que se crea) asignándole un padre (existente).
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
     * Método para Obtener el padre de un nodo.
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
     * Método para obtener el array de hijos de un nodo.
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
     * Método que devuelve el array de los antepasados del nodo buscado.
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
     * Devuelve un array con todos los integrantes de una generación (Misma profundidad).
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
        obtenerNodosEnNivel(getRaiz(), nivel, 0, mismaGeneracion);

        // Convertir la lista enlazada a array
        return mismaGeneracion.aArray();
    }
    
    /**
     * Obtiene el nivel del Nodo buscado.
     * @param nodo
     * @param nivelActual
     * @return 
     */
    private int obtenerNivel(NodoArbol nodo, int nivelActual) {
        if (nodo == null) {
            return -1; 
        }
        if (nodo == getRaiz()) {
            return nivelActual;
        }
        return obtenerNivel(nodo.obtenerPadre(), nivelActual + 1);
    }
    
    /**
     * Agrega a la lista ingresada todos los nodos pertenecientes al mismo nivel objetivo.
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
    
    /**
     * Método que obtiene los nodos de un Arbol por título nobilario.
     * @param titulo
     * @return 
     */
    public String[] obtenerPorTituloNobiliario(String titulo) {
        ListaSimple resultado = new ListaSimple();
        buscarPorTituloNobiliario(getRaiz(), titulo, resultado);
        return resultado.aArray();
    }

    
    /**
     * Método que busca un nodo en específico usando un título nobilario.
     * @param nodo
     * @param titulo
     * @param resultado 
     */
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
    
    /**
     * Crea un subarbol manteniendo la misma estructura del Arbol original pero con la persona que se le pasa como nodo raiz.
     * @param persona
     * @return 
     */
    public Arbol crearSubArbol(Persona persona) {
        NodoArbol Raiznueva = buscarNodo(persona);
        if (Raiznueva != null) {
            Arbol subArbol = new Arbol(Raiznueva.getPersona());
            copiarDescendientes(Raiznueva, subArbol.getRaiz());
            return subArbol;
        } else {
            //No se encuentra ese miembro en el arbol
            return null;
        }
    }
   
    /**
     * Método recursivo para mantener la jerarquía del arbol original en el subarbol, se pasan un nodo original y un nodo copia para así recorrer el Arbol original, mientras se crean nodos arbol que se añaden al subarbol.
     * @param nodoOriginal
     * @param nodoCopia 
     */
    private void copiarDescendientes(NodoArbol nodoOriginal, NodoArbol nodoCopia) {
        for (NodoArbol hijoOriginal : nodoOriginal.obtenerHijos()) {
            NodoArbol hijoCopia = new NodoArbol(hijoOriginal.getPersona());
            nodoCopia.agregarHijo(hijoCopia);
            copiarDescendientes(hijoOriginal, hijoCopia);
        }
    }

    /**
     * Devuelve la raiz del Arbol.
     * @return the raiz
     */
    public NodoArbol getRaiz() {
        return raiz;
    }
    
    

}
