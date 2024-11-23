package Main;

/**
 * Clase Persona que guarda los datos de las personas que pertenecen a la Casa cargada.
 * @author rdbae
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String numeral;
    private ListaSimple padres;
    private String mote;
    private String titulo;
    private String conyuge;
    private String color_ojos;
    private String color_pelo;
    private ListaSimple hijos;
    private String notas;
    private String destino;
    private int indiceHash;

    /**
     * Constructor persona vacia.
     * 
     */
    public Persona() {
    }
    
    /**
     * Constructor de la clase Persona.
     * @param nombre
     * @param apellido
     * @param numeral
     * @param padres
     * @param mote
     * @param titulo
     * @param conyuge
     * @param color_ojos
     * @param color_pelo
     * @param hijos
     * @param notas
     * @param destino 
     */
    public Persona(String nombre, String apellido, String numeral, ListaSimple padres, String mote, String titulo, String conyuge, String color_ojos, String color_pelo, ListaSimple hijos, String notas, String destino) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeral = numeral;
        this.padres = padres;
        this.mote = mote;
        this.titulo = titulo;
        this.conyuge = conyuge;
        this.color_ojos = color_ojos;
        this.color_pelo = color_pelo;
        this.hijos = hijos;
        this.notas = notas;
        this.destino = destino;
        this.indiceHash = 0;
    }

    /**
     * Devuelve el nombre
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Instancia el nombre.
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el numeral.
     * @return the numeral
     */
    public String getNumeral() {
        return numeral;
    }

    /**
     * Instancia el numeral.
     * @param numeral the numeral to set
     */
    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    /**
     * Devuelve la lista simple de padres.
     * @return the padres
     */
    public ListaSimple getPadres() {
        return padres;
    }

    /**
     * Instancia los padres.
     * @param padres the padres to set
     */
    public void setPadres(ListaSimple padres) {
        this.padres = padres;
    }

    /**
     * Devuelve el mote.
     * @return the mote
     */
    public String getMote() {
        return mote;
    }

    /**
     * Instancia el mote.
     * @param mote the mote to set
     */
    public void setMote(String mote) {
        this.mote = mote;
    }

    /**
     * Devuelve el título nobilario.
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Instancia el título nobilario.
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el conyuge.
     * @return the conyuge
     */
    public String getConyuge() {
        return conyuge;
    }

    /**
     * Instancia el conyuge.
     * @param conyuge the conyuge to set
     */
    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }

    /**
     * Devuelve el color de los ojos.
     * @return the color_ojos
     */
    public String getColor_ojos() {
        return color_ojos;
    }

    /**
     * Instancia el color de los ojos.
     * @param color_ojos the color_ojos to set
     */
    public void setColor_ojos(String color_ojos) {
        this.color_ojos = color_ojos;
    }

    /**
     * Devuelve el color del pelo.
     * @return the color_pelo
     */
    public String getColor_pelo() {
        return color_pelo;
    }

    /**
     * Instancia el color del pelo.
     * @param color_pelo the color_pelo to set
     */
    public void setColor_pelo(String color_pelo) {
        this.color_pelo = color_pelo;
    }

    /**
     * Devuelve la lista simple de hijos.
     * @return the hijos
     */
    public ListaSimple getHijos() {
        return hijos;
    }

    /**
     * Instancia la lista simple de hijos.
     * @param hijos the hijos to set
     */
    public void setHijos(ListaSimple hijos) {
        this.hijos = hijos;
    }

    /**
     * Devuelve las notas.
     * @return the notas
     */
    public String getNotas() {
        return notas;
    }

    /**
     * Instancia las notas.
     * @param notas the notas to set
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * Devuelve el destino.
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * Instancia el destino.
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    /**
     * Devuelve el índice que tiene en el hash table.
     * @return 
     */
    public int getIndiceHash() {
        return indiceHash;
    }
    
    /**
     * Instancia el indice que tiene en el hash table.
     * @param indiceHash the indiceHash to set 
     */
    public void setIndiceHash(int indiceHash) {
        this.indiceHash = indiceHash;
    }


    /**
     * Devuelve el apellido.
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }
    
    
    
    
    
    
    
        
    
    
    
    
    
    
    
    
    
}
