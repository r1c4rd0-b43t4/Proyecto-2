
package UI;

import Carga.Reader;
import Main.ListaSimple;
import javax.swing.JOptionPane;
import Main.*;
 /**
 *
 * @author rdbae
 */
public class UI_Menu_Principal extends javax.swing.JFrame {
    static HashTable hashTablePrincipal;
    static Arbol arbolPrincipal;
    static ListaSimple personas;
    /**
     * Creates new form UI_Inicio
     * @param lista_personas
     * @param hashTablePrincipal_Param
     * @param arbolPrincipal_Param
     */
    public UI_Menu_Principal(ListaSimple lista_personas, HashTable hashTablePrincipal_Param, Arbol arbolPrincipal_Param) {
        initComponents();
        personas = lista_personas;
        hashTablePrincipal = hashTablePrincipal_Param;
        arbolPrincipal = arbolPrincipal_Param;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BuscarNombre = new javax.swing.JButton();
        ListaGeneracion = new javax.swing.JButton();
        nuevoJSON = new javax.swing.JButton();
        VerRegistro = new javax.swing.JButton();
        BuscarTitulo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BuscarNombre.setBackground(new java.awt.Color(204, 204, 204));
        BuscarNombre.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        BuscarNombre.setForeground(new java.awt.Color(0, 0, 0));
        BuscarNombre.setText("Buscar por nombre");
        BuscarNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarNombreActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 190, 50));

        ListaGeneracion.setBackground(new java.awt.Color(204, 204, 204));
        ListaGeneracion.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        ListaGeneracion.setForeground(new java.awt.Color(0, 0, 0));
        ListaGeneracion.setText("Lista de generación");
        ListaGeneracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ListaGeneracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaGeneracionActionPerformed(evt);
            }
        });
        jPanel1.add(ListaGeneracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 190, 50));

        nuevoJSON.setBackground(new java.awt.Color(204, 204, 204));
        nuevoJSON.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        nuevoJSON.setForeground(new java.awt.Color(0, 0, 0));
        nuevoJSON.setText("Cargar nueva Casa");
        nuevoJSON.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nuevoJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoJSONActionPerformed(evt);
            }
        });
        jPanel1.add(nuevoJSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 190, 50));

        VerRegistro.setBackground(new java.awt.Color(204, 204, 204));
        VerRegistro.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        VerRegistro.setForeground(new java.awt.Color(0, 0, 0));
        VerRegistro.setText("Ver Registro");
        VerRegistro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        VerRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(VerRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 190, 50));

        BuscarTitulo.setBackground(new java.awt.Color(204, 204, 204));
        BuscarTitulo.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        BuscarTitulo.setForeground(new java.awt.Color(0, 0, 0));
        BuscarTitulo.setText("Buscar por Título");
        BuscarTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BuscarTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarTituloActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 190, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/menu.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarNombreActionPerformed
        this.setVisible(false);
        UI_BusquedaNombre pantalla = new UI_BusquedaNombre(hashTablePrincipal, arbolPrincipal, personas);
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }//GEN-LAST:event_BuscarNombreActionPerformed

    private void ListaGeneracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaGeneracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListaGeneracionActionPerformed

    private void nuevoJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoJSONActionPerformed
          try{
          ListaSimple lista = new ListaSimple();
          hashTablePrincipal.limpiarHashTable();
          Reader reader = new Reader();
          lista = reader.Read();
          
          if(lista ==  null){
              throw new Exception("Error durante la carga");  
          }
          
          personas = lista;
          hashTablePrincipal.CargarHashTable(lista);
          arbolPrincipal.construirArbol(lista);
          
                  
          
          JOptionPane.showMessageDialog(this, "La carga fue un exito");  

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error durante la carga");  
        }
    }//GEN-LAST:event_nuevoJSONActionPerformed

    private void VerRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerRegistroActionPerformed
        Arbol arbol = new Arbol();
        arbol.construirArbol(personas);
        new ArbolGraphJGraphT(arbol, personas);
                
      
        
    }//GEN-LAST:event_VerRegistroActionPerformed

    private void BuscarTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarTituloActionPerformed
        this.setVisible(false);
        UI_BusquedaTitulo pantalla = new UI_BusquedaTitulo(hashTablePrincipal, arbolPrincipal, personas);
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }//GEN-LAST:event_BuscarTituloActionPerformed

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
            java.util.logging.Logger.getLogger(UI_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_Menu_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Menu_Principal(personas, hashTablePrincipal, arbolPrincipal).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarNombre;
    private javax.swing.JButton BuscarTitulo;
    private javax.swing.JButton ListaGeneracion;
    private javax.swing.JButton VerRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nuevoJSON;
    // End of variables declaration//GEN-END:variables
}
