/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;
import Main.ListaSimple;
import Main.HashTable;
import Main.Nodo;
import Main.Arbol;
import Main.NodoArbol;
import Main.Persona;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class UI_BusquedaNombre extends javax.swing.JFrame {
    static HashTable hashTableT;
    static Arbol arbolPrincipal;
    private ListaSimple lista_personas;
    /**
     * Creates new form BusquedaNombre
     */
    public UI_BusquedaNombre(HashTable hashTableT, Arbol arbolPrincipal ) {
        initComponents();
        this.hashTableT = hashTableT;
        this.arbolPrincipal = arbolPrincipal;
        this.lista_personas = new ListaSimple();
        
    }
    
    public void ArbolDescendencia(Arbol subArbol, String motePersona, boolean isPadre){
        try{
            System.out.println("DESCENDENCIA");
            Persona auxPersona;
            Nodo auxNodo;
            String nombreHijo;
            Persona hijo;
            if (!motePersona.equals("")){
                int i = this.hashTableT.getIndice(this.hashTableT.returnAsciiCode(motePersona));
                auxPersona = this.hashTableT.getArregloHash()[i].BuscarMote(this.MotePersonaTxt.getText());
                if (auxPersona != null){
                    if (isPadre)
                        subArbol = new Arbol(auxPersona);
                    else
                        subArbol.agregarNodo(subArbol.obtenerPadre(auxPersona).getPersona(), auxPersona);

                    if(auxPersona.getHijos()!=null){
                        auxNodo = auxPersona.getHijos().getpFirst();
                        

                        while(auxNodo != null){
                            nombreHijo = auxNodo.getValor().toString() + auxPersona.getApellido();
                            hijo = this.hashTableT.getArregloHash()[i].BuscarNombre(nombreHijo);
                            if(hijo.getNombre()== null)
                                hijo.setNombre(nombreHijo);
                            
                            if(hijo.getMote()!=null)
                                this.ArbolDescendencia(subArbol, hijo.getMote() , false);
                            
                            System.out.println(hijo.getNombre());
                            auxNodo = auxNodo.getSiguiente();
                        }
                        

                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No existe una persona con este mote" );
                    throw new IllegalArgumentException("No existe una persona con este mote");    
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void BusquedaDescendencia(){
        Persona auxPersona;
        Nodo auxNodo;
        Persona hijo;
        String nombreHijo;
        //Nodo auxNodo;
        // Esta busqueda tiene que devolver una persona que luego sera utilizada para buscar 
        // sus descendientes en la clase arbol
        if (!this.MotePersonaTxt.getText().equals("")){
            for (int i = 0; i < this.hashTableT.getSize(); i++){
                if (this.hashTableT.getArregloHash()[i] != null){
                    //this.hashTableT.getArregloHash()[i].limpiarResumenes_encontrados();
                    auxPersona = this.hashTableT.getArregloHash()[i].BuscarNombre(this.MotePersonaTxt.getText());
                    if (auxPersona != null){
                        this.ComboBox.addItem(auxPersona.getNombre());
                        if(auxPersona.getHijos()!=null){
                            auxNodo = auxPersona.getHijos().getpFirst();
                            Arbol subArbol = new Arbol(auxPersona);
                            while(auxNodo != null){
                                nombreHijo = auxNodo.getValor().toString() + auxPersona.getApellido();
                                hijo = this.hashTableT.getArregloHash()[i].BuscarNombre(nombreHijo);
                                if(hijo.getNombre()== null)
                                    hijo.setNombre(nombreHijo);

                                subArbol.agregarNodo(auxPersona, hijo);
                                System.out.println("Hijo : " + hijo.getNombre());
                                auxNodo = auxNodo.getSiguiente();
                        }
                            
                        }
                        
                        //this.lista_personas.insertarAlFinal(auxPersona);
                        /*for (int n = 0; n < this.hashTableT.getArregloHash()[i].getPersonas_encontradas().getSize(); n++){
                            auxNodo = this.hashTableT.getArregloHash()[i].getPersonas_encontradas().get(n);
                            this.ComboBox.addItem(auxResumen.getTitulo());
                            this.lista_resumenes.add(auxResumen);
                        }*/
                    }
                }

            }
            if (this.lista_personas.getSize() > 0){
                //this.llenarInformacionTxt(this.lista_personas.get(0));
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe ingresar alguna persona" );
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
        jButton2 = new javax.swing.JButton();
        ComboBox = new javax.swing.JComboBox<>();
        MotePersonaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BusquedaArbolBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Busqueda por Mote");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        BusquedaBtn.setText("Buscar HashTable");
        BusquedaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(BusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        jButton2.setText("Atrás");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));
        getContentPane().add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 200, -1));
        getContentPane().add(MotePersonaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 170, -1));

        jLabel2.setText("Ingrese el mote de la persona a buscar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        BusquedaArbolBtn.setText("Buscar Arbol");
        BusquedaArbolBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaArbolBtnActionPerformed(evt);
            }
        });
        getContentPane().add(BusquedaArbolBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BusquedaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaBtnActionPerformed
        this.ComboBox.removeAllItems();
        String motePersona = this.MotePersonaTxt.getText();
        Arbol subArbol = new Arbol();
        
        this.ArbolDescendencia(subArbol, motePersona, true);
        //this.lista_resumenes.clear();
        //this.limpiarPantalla();
        
    }//GEN-LAST:event_BusquedaBtnActionPerformed

    private void BusquedaArbolBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaArbolBtnActionPerformed
        this.ComboBox.removeAllItems();
        this.BusquedaDescendencia();
        
    }//GEN-LAST:event_BusquedaArbolBtnActionPerformed

    /**
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
                new UI_BusquedaNombre(hashTableT, arbolPrincipal).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BusquedaArbolBtn;
    private javax.swing.JButton BusquedaBtn;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JTextField MotePersonaTxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
