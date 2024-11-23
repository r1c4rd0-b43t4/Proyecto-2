package Main;

/**
 *Clase HashTable
 * 
 */
public class HashTable {
    int size;
    ListaSimple[] arregloHash ;

    /**
     * Constructor de HashTable.
     * 
     */
    public HashTable() {
        this.size = 3;
        this.arregloHash = new ListaSimple[this.size];
        for (int i = 0; i < this.arregloHash.length; i++){
            this.arregloHash[i] = new ListaSimple();
        }
    }

    /**
     * Devuelve el size.
     * @return 
     */
    public int getSize() {
        return size;
    }

    /**
     * Instancia el size.
     * @param size 
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Devuelve una lista simple como un arreglo del hash.
     * @return 
     */
    public ListaSimple[] getArregloHash() {
        return arregloHash;
    }

    /**
     * Instancia el ArregloHash
     * @param arregloHash 
     */
    public void setArregloHash(ListaSimple[] arregloHash) {
        this.arregloHash = arregloHash;
    }
    
    /**
     * Inserta un objeto en el hash, en este caso un objeto Persona.
     * @param personaObj 
     */
    public void insertarHash(Persona personaObj){
        
        int ascii = this.returnAsciiCode(personaObj.getNombre()); // Se usa el mote como prueba
        int indice = this.getIndice(ascii);
        personaObj.setIndiceHash(indice);
        this.arregloHash[indice].insertarAlFinal(personaObj);
        
    }
    
    /**
     * Devuleve un asciicode de la palabra ingresada.
     * @param palabra
     * @return 
     */
    public int returnAsciiCode(String palabra){
        int suma = 0;
        for (int i = 0; i < palabra.length(); i++){
            suma += (int) palabra.charAt(i);
        }
        return suma;
    }
    
    /**
     * Devuelve el índice del codigo ascii.
     * @param codigoAscii
     * @return 
     */
    public int getIndice(int codigoAscii){
        int hashCode = codigoAscii % this.arregloHash.length;
        return hashCode;    
    }
    
    /**
     * Método que por medio de la lista simple de objetos personas carga el HashTable.
     * @param lista_personas 
     */
    public void CargarHashTable(ListaSimple lista_personas){
        Nodo aux = new Nodo();
        aux = lista_personas.getpFirst();
        Persona personaObj = new Persona();
        while (aux != null){
            personaObj = (Persona)aux.getValor();
            this.insertarHash(personaObj);
            aux = aux.getSiguiente();
        }
    }
    
    /**
     * Método que vacia el HashTable.
     * 
     */
    public void limpiarHashTable(){
        for(int i=0;i<this.getArregloHash().length;i++){
            this.getArregloHash()[i].limpiarLista();
        }
    }
    
    
    /**
     * Al ingresar el mote lo encuentra en el HashTable.
     * @param value
     * @return 
     */
    public Persona BuscarMote(String value){
        Persona auxPersona = null;
    
        for(int a=0;a<this.getArregloHash().length;a++){
            if (this.getArregloHash()[a] != null){
                auxPersona = this.getArregloHash()[a].BuscarMoteIndividual(value);
                if(auxPersona!=null)
                    break;
            }
        }
        return auxPersona;
    }
}
