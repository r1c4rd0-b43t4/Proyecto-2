package Main;
import Carga.Reader;

public class Main {

    public static void main(String[] args) {
        // Prueba de carga HashTable
        ListaSimple lista_personas = new ListaSimple();
        HashTable tablaHash = new HashTable();
        Nodo aux = new Nodo();
        Reader reader = new Reader();
        lista_personas = reader.Read();
        aux = lista_personas.getpFirst();
        Persona personaObj = new Persona();
        while (aux != null){
            personaObj = (Persona)aux.getValor();
            tablaHash.insertarHash(personaObj);
            System.out.println(personaObj.getNombre());
            aux = aux.getSiguiente();
        }
    }
}
