package UI;

import Main.ListaSimple;
import Main.HashTable;
import Main.Nodo;
import Main.Arbol;
import Main.ArbolGraphJGraphT;
import Main.Persona;
import javax.swing.JOptionPane;

/**
 *Clase UI_BusquedaNombre JForm.
 * 
 */
public class UI_BusquedaNombre extends javax.swing.JFrame {
    static HashTable hashTableT;
    static Arbol arbolPrincipal;
    static Arbol subArbol;
    static ListaSimple lista_personas;
    static ListaSimple personas;
    
    /**
     * Creates new form BusquedaNombre.
     * @param hashTableT_Param
     * @param arbolPrincipal_Param
     */
    public UI_BusquedaNombre(HashTable hashTableT_Param, Arbol arbolPrincipal_Param, ListaSimple personas_Param) {
        initComponents();
        hashTableT = hashTableT_Param;
        arbolPrincipal = arbolPrincipal_Param;
        personas = personas_Param;
        lista_personas = new ListaSimple();

        
    }
    
    /**
     * Método que crea un SubArbol según la descendencia de un objeto Persona en el Arbol principal.
     * @param padre
     * @param nombrePersona
     * @param numeral
     * @param isPadre 
     */
    public void ArbolDescendencia(Persona padre, String nombrePersona, String numeral, boolean isPadre){
        try{
            ListaSimple lista_personas;
            Persona auxPersona;
            Nodo auxNodo;
            String nombreHijo;
            Persona hijo;
            String auxPadre;
            Nodo nodoPadre;
            boolean encontrado;
            if (!nombrePersona.equals("") ){
                int i = this.hashTableT.getIndice(this.hashTableT.returnAsciiCode(nombrePersona));
                auxPersona = this.hashTableT.getArregloHash()[i].BuscarNombreIndividualNumeral(nombrePersona, numeral, false);
                
                if (auxPersona != null){
                    if(!isPadre){
                        encontrado = false;
                        nodoPadre = auxPersona.getPadres().getpFirst();
                        
                        while (nodoPadre!=null && !encontrado){
                            auxPadre = (String) nodoPadre.getValor();
                            if(auxPadre.contains(padre.getNombre()) || (auxPadre.contains(padre.getMote()) && !padre.getMote().equals(""))){
                                encontrado = true;
                            }
                            nodoPadre = nodoPadre.getSiguiente();
                        }
                        
                        if(!encontrado)
                            return;
                    }
                    
                    if (isPadre)
                        subArbol = new Arbol(auxPersona);
                    else{
                        subArbol.agregarNodo(padre, auxPersona); 
                        this.lista_personas.insertarAlFinal(auxPersona);
                        System.out.println(auxPersona.getNombre());
                    }

                    if(auxPersona.getHijos()!=null){
                        auxNodo = auxPersona.getHijos().getpFirst();
                        while(auxNodo != null){
                            if(!auxNodo.getValor().toString().contains(auxPersona.getApellido()))
                                nombreHijo = auxNodo.getValor().toString() + auxPersona.getApellido();
                            else
                                nombreHijo = auxNodo.getValor().toString();
                                
                            int a = this.hashTableT.getIndice(this.hashTableT.returnAsciiCode(nombreHijo));
                            
                            if(isPadre){
                                hijo = this.hashTableT.getArregloHash()[a].BuscarNombreIndividualNumeral(nombreHijo, auxPersona.getNumeral(), true);
                            }
                            else{
                                hijo = this.hashTableT.getArregloHash()[a].BuscarHijoXNombre(nombreHijo, auxPersona);
                            }
                                
                                
                            if(hijo == null){
                                hijo = new Persona();
                                hijo.setNombre(nombreHijo); 
                            }

                            if(hijo.getNombre()!=null)
                                this.ArbolDescendencia(auxPersona, hijo.getNombre(), hijo.getNumeral(), false);

                            auxNodo = auxNodo.getSiguiente();
                        }
                    }
                }
                else{
                    auxPersona = new Persona();
                    auxPersona.setNombre(nombrePersona); 
                    subArbol.agregarNodo(padre, auxPersona);
                    this.lista_personas.insertarAlFinal(auxPersona);
                    System.out.println(auxPersona.getNombre());
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Método que busca una persona en la Lista Simple de personas principal.
     * 
     */
    public void BusquedaPersona(){
        Persona auxPersona;
        ListaSimple lista_personas;
        Nodo auxNodo;
        if (!this.NombrePersonaTxt.getText().equals("")){
            int i = this.hashTableT.getIndice(this.hashTableT.returnAsciiCode(this.NombrePersonaTxt.getText()));
            lista_personas = this.hashTableT.getArregloHash()[i].BuscarNombreLista(this.NombrePersonaTxt.getText());
            if (lista_personas == null){
                JOptionPane.showMessageDialog(null, "No hay una persona con este nombre, intente nuevamente" );
                return;
            }

            auxNodo = lista_personas.getpFirst();   
            while(auxNodo!=null){
                auxPersona = (Persona)auxNodo.getValor();
                if (auxPersona != null)
                    this.ComboBox.addItem(auxPersona.getNombre() + " - " + auxPersona.getNumeral());
                auxNodo = auxNodo.getSiguiente();
            }         
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe ingresar alguna persona, intente nuevamente" );
        }
    }
    
    /**
     * Metodo que llena un subArbol con la ascendencia de la persona elegida y la muestra
     * @param datoPersona
     * @param numeral
     * @param hijo 
     */
    public void ArbolAscendencia(String datoPersona, String numeral, Persona hijo){
        try{
            Persona auxPersona;
            String auxPadre;
            Nodo nodoPadre;
            int postCom;
            if (!datoPersona.equals("") ){
                int i = this.hashTableT.getIndice(this.hashTableT.returnAsciiCode(datoPersona));
                if(!numeral.equals(""))
                    auxPersona = this.hashTableT.getArregloHash()[i].BuscarNombreIndividualNumeral(datoPersona, numeral, false);
                else{
                    postCom = datoPersona.indexOf(",");
                    if(postCom!= -1){
                        datoPersona = datoPersona.substring(0, postCom);
                        i = this.hashTableT.getIndice(this.hashTableT.returnAsciiCode(datoPersona));
                    }
                    auxPersona = this.hashTableT.getArregloHash()[i].BuscarPadreXNombre(datoPersona, hijo);
                }
                if(auxPersona == null){
                    auxPersona = this.hashTableT.BuscarMote(datoPersona);
                }
                
                if (auxPersona != null){
                    if (hijo==null){
                        subArbol = new Arbol(auxPersona);
                        
                    }
                    else{
                        this.subArbol.agregarNodo(hijo, auxPersona );
                        
                    }
                    
                    nodoPadre = auxPersona.getPadres().getpFirst();    
                    while (nodoPadre!=null){
                        auxPadre = (String) nodoPadre.getValor();
                        this.ArbolAscendencia(auxPadre, "", auxPersona);
                        nodoPadre = nodoPadre.getSiguiente();
                    }
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage() );
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BusquedaBtn = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        ComboBox = new javax.swing.JComboBox<>();
        NombrePersonaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DescendenciaPersonaBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        MostrarAntepasados = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busqueda por Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        BusquedaBtn.setBackground(new java.awt.Color(204, 204, 204));
        BusquedaBtn.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        BusquedaBtn.setForeground(new java.awt.Color(0, 0, 0));
        BusquedaBtn.setText("Buscar");
        BusquedaBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BusquedaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(BusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 140, 40));

        Atras.setBackground(new java.awt.Color(204, 204, 204));
        Atras.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        Atras.setForeground(new java.awt.Color(0, 0, 0));
        Atras.setText("Atrás");
        Atras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasActionPerformed(evt);
            }
        });
        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 70, 40));
        getContentPane().add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 230, 50));
        getContentPane().add(NombrePersonaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 40));

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el nombre de la persona a buscar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        DescendenciaPersonaBtn.setBackground(new java.awt.Color(204, 204, 204));
        DescendenciaPersonaBtn.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        DescendenciaPersonaBtn.setForeground(new java.awt.Color(0, 0, 0));
        DescendenciaPersonaBtn.setText("Descendencia");
        DescendenciaPersonaBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DescendenciaPersonaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescendenciaPersonaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(DescendenciaPersonaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 120, 40));

        jLabel3.setFont(new java.awt.Font("SansSerif", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione una persona:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        MostrarAntepasados.setBackground(new java.awt.Color(204, 204, 204));
        MostrarAntepasados.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        MostrarAntepasados.setForeground(new java.awt.Color(0, 0, 0));
        MostrarAntepasados.setText("Mostrar Antepasados");
        MostrarAntepasados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MostrarAntepasados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarAntepasadosActionPerformed(evt);
            }
        });
        getContentPane().add(MostrarAntepasados, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 180, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fondo.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón para iniciar la búsqueda con un ComboBox.
     * @param evt 
     */
    private void BusquedaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaBtnActionPerformed
        this.ComboBox.removeAllItems();
        this.BusquedaPersona();
    }//GEN-LAST:event_BusquedaBtnActionPerformed

    /**
     * Botón para buscar la descendencia de una persona en el Arbol.
     * @param evt 
     */
    private void DescendenciaPersonaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescendenciaPersonaBtnActionPerformed
        try{
            String nom1 = this.ComboBox.getSelectedItem().toString();
            String[] persona = nom1.split("-"); 
            String nombrePersona = persona[0].trim();
            this.ArbolDescendencia(null, nombrePersona, persona[1].substring(1), true);
            ArbolGraphJGraphT Graf_subArbol = new ArbolGraphJGraphT(subArbol, personas);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar alguna persona, intente nuevamente" );
        }
    }//GEN-LAST:event_DescendenciaPersonaBtnActionPerformed

    /**
     * Botón para volver al menú principal.
     * @param evt 
     */
    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        this.setVisible(false);
        UI_Menu_Principal ui = new UI_Menu_Principal(personas, hashTableT, arbolPrincipal);
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
    }//GEN-LAST:event_AtrasActionPerformed
    
    /**
     * Botón que inica la acción de mostrar los antepasados de un objeto persona en el Arbol principal.
     * @param evt 
     */
    private void MostrarAntepasadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarAntepasadosActionPerformed
        try{
            String nom1 = this.ComboBox.getSelectedItem().toString();
            String[] persona = nom1.split("-"); 
            String nombrePersona = persona[0].trim();
            //Arbol subArbol = new Arbol();
            System.out.println("INICIO");
            this.ArbolAscendencia(nombrePersona , persona[1].substring(1), null);
            System.out.println("FINAL");
            ArbolGraphJGraphT Graf_subArbol = new ArbolGraphJGraphT(subArbol, personas);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar alguna persona, intente nuevamente" );
        }
    }//GEN-LAST:event_MostrarAntepasadosActionPerformed

    /**
     * Main UI
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI_BusquedaNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_BusquedaNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_BusquedaNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_BusquedaNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_BusquedaNombre(hashTableT, arbolPrincipal, personas).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton BusquedaBtn;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton DescendenciaPersonaBtn;
    private javax.swing.JButton MostrarAntepasados;
    private javax.swing.JTextField NombrePersonaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
