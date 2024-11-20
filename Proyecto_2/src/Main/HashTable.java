
package Main;

/**
 *
 * @author 
 */
public class HashTable {
    int size;
    ListaSimple[] arregloHash ;

    public HashTable() {
        this.size = 3;
        this.arregloHash = new ListaSimple[this.size];
        for (int i = 0; i < this.arregloHash.length; i++){
            this.arregloHash[i] = new ListaSimple();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ListaSimple[] getArregloHash() {
        return arregloHash;
    }

    public void setArregloHash(ListaSimple[] arregloHash) {
        this.arregloHash = arregloHash;
    }
    
    public void insertarHash(Persona personaObj){
        
        int ascii = this.returnAsciiCode(personaObj.getNombre()); // Se usa el mote como prueba
        int indice = this.getIndice(ascii);
        personaObj.setIndiceHash(indice);
        this.arregloHash[indice].insertarAlFinal(personaObj);
        
    }
    
    public int returnAsciiCode(String palabra){
        int suma = 0;
        for (int i = 0; i < palabra.length(); i++){
            suma += (int) palabra.charAt(i);
        }
        return suma;
    }
    
    public int getIndice(int codigoAscii){
        int hashCode = codigoAscii % this.arregloHash.length;
        return hashCode;    
    }
    
    public void CargarHashTable(ListaSimple lista_personas){
        Nodo aux = new Nodo();
        aux = lista_personas.getpFirst();
        Persona personaObj = new Persona();
        while (aux != null){
            personaObj = (Persona)aux.getValor();
            this.insertarHash(personaObj);
            System.out.println(personaObj.getNombre());
            aux = aux.getSiguiente();
        }
    }
}
