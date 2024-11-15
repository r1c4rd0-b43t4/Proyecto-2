
package Main;
import Main.Persona;
/**
 *
 * @author 
 */
public class ListaSimple {
    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    private ListaSimple personas_encontradas;

    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
        this.personas_encontradas = new ListaSimple();
    }

    public boolean EsVacio(){
        return (pFirst == null);   
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public int getSize() {
        return size;
    }

    public ListaSimple getPersonas_encontradas() {
        return personas_encontradas;
    }
    
    public <T> Nodo getValue( T value){
        Nodo aux = this.pFirst;
        while (aux != null){
            if (aux.getValor().equals(value))
                return aux;
            else
                aux = aux.getSiguiente();
        } 
        return aux;        
    }
   
    public <T> void insertarAlFinal(T value){
        
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        if (this.EsVacio()){
            this.pFirst = newNodo;
        }
        else{
            Nodo aux = this.pLast;
            aux.setSiguiente(newNodo);
        
        }
        this.pLast = newNodo;
        this.size += 1;
    }
    
    public <T> void insertarAlPrincipio(T value){
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        if (this.EsVacio()){
            this.pLast = newNodo;
        }
        newNodo.setSiguiente(this.pFirst);
        this.pFirst = newNodo;
        this.size += 1;
    }
    
    public <T> void eliminar (T value){
        Nodo ant = null;
        Nodo aux = this.pFirst;
        while (aux != null){
            if (aux.getValor().equals(value)){
                if (ant == null){
                    this.pFirst = aux.getSiguiente();
                    break;
                }
                ant.setSiguiente(aux.getSiguiente());
                break;
            }
            else{
                ant = aux;
                aux = aux.getSiguiente();
            }    
        }  
    }
    
    public void showList(){
        Nodo aux = this.pFirst;
        while (aux != null){
            System.out.println(aux.getValor().toString());
            aux = aux.getSiguiente();
        }
    } 
    
    public void BuscarNombre (String value){
        
        Nodo aux = this.pFirst;
        while (aux != null){
            Persona res = (Persona) aux.getValor();
            if (res.getMote().equals(value)){
                this.personas_encontradas.insertarAlFinal((Persona)aux.getValor());
            }   
            aux = aux.getSiguiente();  
        }
        
    }
}
