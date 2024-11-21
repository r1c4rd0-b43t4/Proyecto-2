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
    static Arbol subArbol;
    /**
     * Creates new form BusquedaNombre
     * @param hashTableT_Param
     * @param arbolPrincipal_Param
     */
    public UI_BusquedaNombre(HashTable hashTableT_Param, Arbol arbolPrincipal_Param) {
        initComponents();
        hashTableT = hashTableT_Param;
        arbolPrincipal = arbolPrincipal_Param;
        
    }
    
    public void ArbolDescendencia(Persona padre, String nombrePersona, String numeral, boolean isPadre){
        try{
            //System.out.println("DESCENDENCIA");
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
                                /*if(nombreHijo.equals(padre.getNombre()))
                                    hijo = this.hashTableT.getArregloHash()[a].BuscarNombreIndividualNumeral(nombreHijo, auxPersona.getNumeral(), true);
                                else
                                    hijo = this.hashTableT.getArregloHash()[a].BuscarNombreIndividual(nombreHijo);*/
                                hijo = this.hashTableT.getArregloHash()[a].BuscarHijoXNombre(nombreHijo, auxPersona);
                            }
                                
                                
                            if(hijo == null){
                                hijo = new Persona();
                                hijo.setNombre(nombreHijo); 
                            }

                            if(hijo.getNombre()!=null)
                                this.ArbolDescendencia(auxPersona, hijo.getNombre(), hijo.getNumeral(), false);

                            //System.out.println(hijo.getNombre());
                            auxNodo = auxNodo.getSiguiente();
                        }
                    }
                }
                else{
                    auxPersona = new Persona();
                    auxPersona.setNombre(nombrePersona); 
                    subArbol.agregarNodo(padre, auxPersona);
                    
                    System.out.println(auxPersona.getNombre());
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void BusquedaPersona(){
        Persona auxPersona;
        ListaSimple lista_personas;
        Nodo auxNodo;
        //Nodo auxNodo;
        // Esta busqueda tiene que devolver una persona que luego sera utilizada para buscar 
        // sus descendientes en la clase arbol
        if (!this.NombrePersonaTxt.getText().equals("")){
            for (int i = 0; i < this.hashTableT.getSize(); i++){
                if (this.hashTableT.getArregloHash()[i] != null){
                    //this.hashTableT.getArregloHash()[i].limpiarResumenes_encontrados();
                    lista_personas = this.hashTableT.getArregloHash()[i].BuscarNombreLista(this.NombrePersonaTxt.getText());
                    if (lista_personas == null){
                        JOptionPane.showMessageDialog(null, "No hay una persona con este nombre" );
                        return;
                    }
                        
                    auxNodo = lista_personas.getpFirst();
                    //Hay que validar cuando no se encuentra una persona    
                    while(auxNodo!=null){
                        auxPersona = (Persona)auxNodo.getValor();
                        if (auxPersona != null)
                            this.ComboBox.addItem(auxPersona.getNombre() + " - " + auxPersona.getNumeral());
                        auxNodo = auxNodo.getSiguiente();
                    } 
                }
            }    
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe ingresar alguna persona, intente nuevamente" );
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
        NombrePersonaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DescendenciaPersonaBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Busqueda por Mote");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        BusquedaBtn.setText("Buscar");
        BusquedaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(BusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, 30));

        jButton2.setText("Atrás");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));
        getContentPane().add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 200, -1));
        getContentPane().add(NombrePersonaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 170, -1));

        jLabel2.setText("Ingrese el nombre de la persona a buscar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        DescendenciaPersonaBtn.setText("Descendencia");
        DescendenciaPersonaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescendenciaPersonaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(DescendenciaPersonaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, -1, -1));

        jLabel3.setText("Seleccione una persona:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BusquedaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaBtnActionPerformed
        this.ComboBox.removeAllItems();
        this.BusquedaPersona();
        //this.lista_resumenes.clear();
        //this.limpiarPantalla();
        
    }//GEN-LAST:event_BusquedaBtnActionPerformed

    private void DescendenciaPersonaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescendenciaPersonaBtnActionPerformed
        try{
            String nom1 = this.ComboBox.getSelectedItem().toString();
            String[] persona = nom1.split("-"); 
            String nombrePersona = persona[0].trim();
            //Arbol subArbol = new Arbol();
            System.out.println("INICIO");
            this.ArbolDescendencia(null, nombrePersona, persona[1].substring(1), true);
            System.out.println("FINAL");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar alguna persona, intente nuevamente" );
        }
    }//GEN-LAST:event_DescendenciaPersonaBtnActionPerformed

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
    private javax.swing.JButton BusquedaBtn;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton DescendenciaPersonaBtn;
    private javax.swing.JTextField NombrePersonaTxt;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
