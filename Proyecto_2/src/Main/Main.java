package Main;
import Carga.Reader;
import Pantallas.BusquedaNombre;

public class Main {

    public static void main(String[] args) {
        
        ListaSimple lista_personas = new ListaSimple();
        HashTable tablaHash = new HashTable();
        Reader reader = new Reader();
        lista_personas = reader.Read();
        // Prueba de carga HashTable
        tablaHash.CargarHashTable(lista_personas);
        
        // Prueba carga Arbol
        Arbol arbolPrincipal = new Arbol();
        //arbolPrincipal.CargarArbol(lista_personas);
        
        //Prueba Busqueda Nombre
        BusquedaNombre pantallaBusqueda = new BusquedaNombre(tablaHash, arbolPrincipal);
        pantallaBusqueda.setVisible(true);
    }
    
    public void CrearArbol(Nodo aux, Persona personaObj){
        
    }
}
