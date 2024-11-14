
package Main;


public class Persona {
    private String nombre;
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

    public Persona(String nombre, String numeral, ListaSimple padres, String mote, String titulo, String conyuge, String color_ojos, String color_pelo, ListaSimple hijos, String notas, String destino) {
        this.nombre = nombre;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numeral
     */
    public String getNumeral() {
        return numeral;
    }

    /**
     * @param numeral the numeral to set
     */
    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    /**
     * @return the padres
     */
    public ListaSimple getPadres() {
        return padres;
    }

    /**
     * @param padres the padres to set
     */
    public void setPadres(ListaSimple padres) {
        this.padres = padres;
    }

    /**
     * @return the mote
     */
    public String getMote() {
        return mote;
    }

    /**
     * @param mote the mote to set
     */
    public void setMote(String mote) {
        this.mote = mote;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the conyuge
     */
    public String getConyuge() {
        return conyuge;
    }

    /**
     * @param conyuge the conyuge to set
     */
    public void setConyuge(String conyuge) {
        this.conyuge = conyuge;
    }

    /**
     * @return the color_ojos
     */
    public String getColor_ojos() {
        return color_ojos;
    }

    /**
     * @param color_ojos the color_ojos to set
     */
    public void setColor_ojos(String color_ojos) {
        this.color_ojos = color_ojos;
    }

    /**
     * @return the color_pelo
     */
    public String getColor_pelo() {
        return color_pelo;
    }

    /**
     * @param color_pelo the color_pelo to set
     */
    public void setColor_pelo(String color_pelo) {
        this.color_pelo = color_pelo;
    }

    /**
     * @return the hijos
     */
    public ListaSimple getHijos() {
        return hijos;
    }

    /**
     * @param hijos the hijos to set
     */
    public void setHijos(ListaSimple hijos) {
        this.hijos = hijos;
    }

    /**
     * @return the notas
     */
    public String getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
         
    /**
     * get indiceHash 
     */
    public int getIndiceHash() {
        return indiceHash;
    }
    
    /**
     * @param indiceHash the indiceHash to set 
     */
    public void setIndiceHash(int indiceHash) {
        this.indiceHash = indiceHash;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", numeral=" + numeral + ", padres=" + padres + ", mote=" + mote + ", titulo=" + titulo + ", conyuge=" + conyuge + ", color_ojos=" + color_ojos + ", color_pelo=" + color_pelo + ", hijos=" + hijos + ", notas=" + notas + ", destino=" + destino + '}';
    }
    
    
    
    
    
    
    
        
    
    
    
    
    
    
    
    
    
}
