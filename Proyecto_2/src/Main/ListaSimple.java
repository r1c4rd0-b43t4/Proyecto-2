
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
    public Persona BuscarNombreIndividualNumeral (String value, String numeral, boolean excluirNumeral){
        //try{
        //this.personas_encontradas = new ListaSimple();
        Persona res = new Persona();
        Nodo aux = this.pFirst;
        while (aux != null){
            res = (Persona) aux.getValor();
            if(!excluirNumeral){
                if (res.getNombre().equals(value) && res.getNumeral().equals(numeral)){
                    return res;
                } 
            }
            else{
                if (res.getNombre().equals(value) && !res.getNumeral().equals(numeral)){
                    return res;
                }
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
    
    // Se usa si necesitas saber que numeral tiene la persona elegida
    public Persona BuscarHijoXNombre (String value, Persona padre){
        //try{
        //this.personas_encontradas = new ListaSimple();
        Persona res = new Persona();
        Nodo aux = this.pFirst;
        Nodo nodoPadre;
        boolean encontrado;
        String auxPadre;
        
        while (aux != null){
            res = (Persona) aux.getValor();
            
            if (res.getNombre().equals(value))
            {
                encontrado = false;
                nodoPadre = res.getPadres().getpFirst();
                
                while (nodoPadre!=null && !encontrado){
                    auxPadre = (String) nodoPadre.getValor();
                    if(auxPadre.contains(padre.getNombre()) || (auxPadre.contains(padre.getMote()) && !padre.getMote().equals(""))){
                        encontrado = true;
                    }
                    nodoPadre = nodoPadre.getSiguiente();
                }
                
                if (encontrado)
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
        Persona auxPersona;
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
        return null;
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
        if (lista_personas.getpFirst()!=null)
            return lista_personas;
        else
            return null;
        //}
        /*catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        
    }
    
    public Persona BuscarMoteIndividual (String value){
        //try{
        //this.personas_encontradas = new ListaSimple();
        Persona auxPersona;
        Nodo aux = this.pFirst;
        while (aux != null){
            Persona res = (Persona) aux.getValor();
            if (res.getMote().equals(value)){
                //this.personas_encontradas.insertarAlFinal(aux.getValor());
                auxPersona = (Persona)aux.getValor();
                return auxPersona;
            }   
            aux = aux.getSiguiente();  
        }
        return null;
        //}
        /*catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        
    }
    
    public ListaSimple BuscarTituloLista (String value){
        //try{
        //this.personas_encontradas = new ListaSimple();
        ListaSimple lista_personas = new ListaSimple();
        Persona auxPersona = new Persona();
        Nodo aux = this.pFirst;
        while (aux != null){
            Persona res = (Persona) aux.getValor();
            if (res.getTitulo().equals(value)){
                //this.personas_encontradas.insertarAlFinal(aux.getValor());
                auxPersona = (Persona)aux.getValor();
                lista_personas.insertarAlFinal(auxPersona);
            }   
            aux = aux.getSiguiente();  
        }
        if (lista_personas.getpFirst()!=null)
            return lista_personas;
        else
            return null;
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
    
    public boolean contiene(T value) {
        Nodo<T> aux = this.pFirst;
        while (aux != null) {
            if (aux.getValor().equals(value)) {
                return true; 
            }
            aux = aux.getSiguiente();
        }
        return false; 
    }
    
    public void limpiarLista(){
        Nodo aux = this.pFirst;
        while(aux!=null){
            Nodo prev = aux;
            aux = aux.getSiguiente();
            prev.setSiguiente(null);
        }
        this.pFirst = null;
    }
    
    public Persona BuscarPadreXNombre (String value, Persona hijo){
        //try{
        //this.personas_encontradas = new ListaSimple();
        Persona res;
        Nodo aux = this.pFirst;
        Nodo nodoHijo;
        boolean encontrado;
        String auxHijo;
        
        
        while (aux != null){
            res = (Persona) aux.getValor();
            
            if (res.getNombre().equals(value))
            {
                encontrado = false;
                nodoHijo = res.getHijos().getpFirst();
                
                while (nodoHijo!=null && !encontrado){
                    auxHijo = (String) nodoHijo.getValor();
                    if(hijo.getNombre().contains(auxHijo)){
                        encontrado = true;
                    }
                    nodoHijo = nodoHijo.getSiguiente();
                }
                
                if (encontrado)
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

}
