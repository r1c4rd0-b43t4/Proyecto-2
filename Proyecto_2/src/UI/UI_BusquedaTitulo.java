package UI;

import Main.ListaSimple;
import Main.HashTable;
import Main.Nodo;
import Main.Arbol;
import Main.ArbolGraphJGraphT;
import Main.Persona;
import javax.swing.JOptionPane;

/**
 * Clase UI_BusquedaTitulo JForm.
 * 
 */
public class UI_BusquedaTitulo extends javax.swing.JFrame {
    static HashTable hashTableT;
    static Arbol arbolPrincipal;
    static Arbol subArbol;
    static ListaSimple lista_personas;
    static ListaSimple personas;
    
    /**
     * Creates new form BusquedaNombre
     * @param hashTableT_Param
     * @param arbolPrincipal_Param
     */
    public UI_BusquedaTitulo(HashTable hashTableT_Param, Arbol arbolPrincipal_Param, ListaSimple personas_Param) {
        initComponents();
        hashTableT = hashTableT_Param;
        arbolPrincipal = arbolPrincipal_Param;
        personas = personas_Param;
        lista_personas = new ListaSimple();

        
    }
    
    
    /**
     * Método que busqueda tiene que devolver una persona que luego sera utilizada para buscar sus descendientes en el Arbol.
     * 
     */
    public void BusquedaPersona(){
        Persona auxPersona;
        ListaSimple personas;
        Nodo auxNodo;

        if (!this.TituloPersonaTxt.getText().equals("")){
            int i = this.hashTableT.getIndice(this.hashTableT.returnAsciiCode(this.TituloPersonaTxt.getText()));
            personas = this.hashTableT.getArregloHash()[i].BuscarTituloLista(this.TituloPersonaTxt.getText());
            
            if(personas == null){
                JOptionPane.showMessageDialog(null, "No hay una persona con este titulo" );
                return;
            }
            auxNodo = personas.getpFirst();  
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
        TituloPersonaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        MostrarDatos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Busqueda por Titulo");
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
        getContentPane().add(BusquedaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 80, 40));

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
        getContentPane().add(Atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 70, 40));
        getContentPane().add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 230, 40));
        getContentPane().add(TituloPersonaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 230, 40));

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el titulo de la persona a buscar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        MostrarDatos.setBackground(new java.awt.Color(204, 204, 204));
        MostrarDatos.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        MostrarDatos.setForeground(new java.awt.Color(0, 0, 0));
        MostrarDatos.setText("Mostrar Datos");
        MostrarDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarDatosActionPerformed(evt);
            }
        });
        getContentPane().add(MostrarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 140, 40));

        jLabel3.setFont(new java.awt.Font("SansSerif", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione una persona:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/fondo.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón Busqueda.
     * @param evt 
     */
    private void BusquedaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaBtnActionPerformed
        this.ComboBox.removeAllItems();
        this.BusquedaPersona();
        //this.lista_resumenes.clear();
        //this.limpiarPantalla();
        
    }//GEN-LAST:event_BusquedaBtnActionPerformed

    /**
     * Botón para mostrar datos.
     * @param evt 
     */
    private void MostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarDatosActionPerformed
        try{
            String nom1 = this.ComboBox.getSelectedItem().toString();
            String[] auxPersona = nom1.split("-"); 
            String nombrePersona = auxPersona[0].trim();
            String numeral = auxPersona[1].substring(1);
            int indice = hashTableT.getIndice(hashTableT.returnAsciiCode(nombrePersona));
            ListaSimple<Persona> listaPersonas = hashTableT.getArregloHash()[indice];
            Persona persona = listaPersonas.BuscarNombreIndividualNumeral(nombrePersona, numeral, false);

            if (persona != null) {
                StringBuilder info = new StringBuilder();
                info.append("Nombre: ").append(persona.getNombre()).append("\n");
                info.append("Apellido: ").append(persona.getApellido()).append("\n");
                info.append("Numeral: ").append(persona.getNumeral()).append("\n");
                info.append("Mote: ").append(persona.getMote()).append("\n");
                info.append("Título: ").append(persona.getTitulo()).append("\n");
                info.append("Cónyuge: ").append(persona.getConyuge()).append("\n");
                info.append("Color de Ojos: ").append(persona.getColor_ojos()).append("\n");
                info.append("Color de Pelo: ").append(persona.getColor_pelo()).append("\n");
                info.append("Destino: ").append(persona.getDestino()).append("\n");
                info.append("Notas: ").append(persona.getNotas()).append("\n");

                info.append("Padres:\n");
                Nodo<String> padreNodo = persona.getPadres().getpFirst();
                while (padreNodo != null) {
                    String padre = padreNodo.getValor();
                    info.append("\t").append(padre).append("\n");
                    padreNodo = padreNodo.getSiguiente();
                }

                info.append("Hijos:\n");
                Nodo<String> hijoNodo = persona.getHijos().getpFirst();
                while (hijoNodo != null) {
                    String hijo = hijoNodo.getValor();
                    info.append("\t").append(hijo).append("\n");
                    hijoNodo = hijoNodo.getSiguiente();
                }

                JOptionPane.showMessageDialog(null, info.toString(), "Información de " + persona.getNombre(), JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró información asociada al nodo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar alguna persona, intente nuevamente" );
        }
    }//GEN-LAST:event_MostrarDatosActionPerformed

    private void AtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasActionPerformed
        this.setVisible(false);
        UI_Menu_Principal ui = new UI_Menu_Principal(personas, hashTableT, arbolPrincipal);
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
    }//GEN-LAST:event_AtrasActionPerformed

    /**
     * Main UI.
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
            java.util.logging.Logger.getLogger(UI_BusquedaTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_BusquedaTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_BusquedaTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_BusquedaTitulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_BusquedaTitulo(hashTableT, arbolPrincipal, personas).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton BusquedaBtn;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton MostrarDatos;
    private javax.swing.JTextField TituloPersonaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
