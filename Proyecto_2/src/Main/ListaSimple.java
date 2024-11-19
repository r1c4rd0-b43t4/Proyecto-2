
package Main;
import Main.Persona;
/**
 *
 * @author 
 */
public class ListaSimple<T> {
    private Nodo <T> pFirst;
    private Nodo <T> pLast;
    private int size;
    private ListaSimple personas_encontradas;

    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
        this.personas_encontradas = null;
    }

    public boolean EsVacio(){
        return (pFirst == null);   
    }

    public Nodo <T> getpFirst() {
        return pFirst;
    }

    public Nodo <T> getpLast() {
        return pLast;
    }

    public int getSize() {
        return size;
    }

    public ListaSimple <T> getPersonas_encontradas() {
        return personas_encontradas;
    }
    
    public Nodo <T> getValue( T value){
        Nodo aux = this.pFirst;
        while (aux != null){
            if (aux.getValor().equals(value))
                return aux;
            else
                aux = aux.getSiguiente();
        } 
        return aux;        
    }
   
    public void insertarAlFinal(T value){
        
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
    
    public  void insertarAlPrincipio(T value){
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        if (this.EsVacio()){
            this.pLast = newNodo;
        }
        newNodo.setSiguiente(this.pFirst);
        this.pFirst = newNodo;
        this.size += 1;
    }
    
    public void eliminar (T value){
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
    
    // Se usa si necesitas saber que numeral tiene la persona elegida
    public Persona BuscarNombreIndividualNumeral (String value, String numeral){
        //try{
        //this.personas_encontradas = new ListaSimple();
        Persona res = new Persona();
        Nodo aux = this.pFirst;
        while (aux != null){
             res = (Persona) aux.getValor();
            if (res.getNombre().equals(value) && res.getNumeral().equals(numeral)){
                //this.personas_encontradas.insertarAlFinal(aux.getValor());
                //auxPersona = (Persona)aux.getValor();
                return res;
            }   
            aux = aux.getSiguiente();  
        }
        res = null;
        return res;
        //}
        /*catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        
    }
    
    
    // Se usa si no necesitas especificar cual numeral tiene
    public Persona BuscarNombreIndividual (String value){
        //try{
        //this.personas_encontradas = new ListaSimple();
        Persona auxPersona = new Persona();
        Nodo aux = this.pFirst;
        while (aux != null){
            Persona res = (Persona) aux.getValor();
            if (res.getNombre().equals(value)){
                //this.personas_encontradas.insertarAlFinal(aux.getValor());
                auxPersona = (Persona)aux.getValor();
                return auxPersona;
            }   
            aux = aux.getSiguiente();  
        }
        return auxPersona;
        //}
        /*catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        
    }
    
    public ListaSimple BuscarNombreLista (String value){
        //try{
        //this.personas_encontradas = new ListaSimple();
        ListaSimple lista_personas = new ListaSimple();
        Persona auxPersona = new Persona();
        Nodo aux = this.pFirst;
        while (aux != null){
            Persona res = (Persona) aux.getValor();
            if (res.getNombre().equals(value)){
                //this.personas_encontradas.insertarAlFinal(aux.getValor());
                auxPersona = (Persona)aux.getValor();
                lista_personas.insertarAlFinal(auxPersona);
            }   
            aux = aux.getSiguiente();  
        }
        return lista_personas;
        //}
        /*catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        
    }
    
    public String[] aArray() {
        int tamanio = 0;
        Nodo actual = pFirst;
        while (actual != null) {
            tamanio++;
            actual = actual.getSiguiente();
        }

        String[] resultado = new String[tamanio];
        actual = pFirst;
        int index = 0;
        while (actual != null) {
            resultado[index++] = actual.getValor().toString();
            actual = actual.getSiguiente();
        }

        return resultado;
    }
}
