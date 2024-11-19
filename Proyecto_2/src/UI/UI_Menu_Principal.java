
package UI;

import Carga.Reader;
import Main.ListaSimple;
import javax.swing.JOptionPane;
import Main.*;

import Main.NodoArbol;
import Main.Persona;
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
        CargarJSON = new javax.swing.JButton();
        CargarJSON1 = new javax.swing.JButton();
        nuevoJSON = new javax.swing.JButton();
        VerRegistro = new javax.swing.JButton();
        CargarJSON5 = new javax.swing.JButton();
        CargarJSON6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CargarJSON.setBackground(new java.awt.Color(204, 204, 204));
        CargarJSON.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        CargarJSON.setForeground(new java.awt.Color(0, 0, 0));
        CargarJSON.setText("Buscar por nombre");
        CargarJSON.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CargarJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarJSONActionPerformed(evt);
            }
        });
        jPanel1.add(CargarJSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 190, 50));

        CargarJSON1.setBackground(new java.awt.Color(204, 204, 204));
        CargarJSON1.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        CargarJSON1.setForeground(new java.awt.Color(0, 0, 0));
        CargarJSON1.setText("Lista de generación");
        CargarJSON1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CargarJSON1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarJSON1ActionPerformed(evt);
            }
        });
        jPanel1.add(CargarJSON1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 190, 50));

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

        CargarJSON5.setBackground(new java.awt.Color(204, 204, 204));
        CargarJSON5.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        CargarJSON5.setForeground(new java.awt.Color(0, 0, 0));
        CargarJSON5.setText("Mostrar antepasados");
        CargarJSON5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CargarJSON5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarJSON5ActionPerformed(evt);
            }
        });
        jPanel1.add(CargarJSON5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 190, 50));

        CargarJSON6.setBackground(new java.awt.Color(204, 204, 204));
        CargarJSON6.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        CargarJSON6.setForeground(new java.awt.Color(0, 0, 0));
        CargarJSON6.setText("Buscar por Título");
        CargarJSON6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CargarJSON6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarJSON6ActionPerformed(evt);
            }
        });
        jPanel1.add(CargarJSON6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 190, 50));

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

    private void CargarJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarJSONActionPerformed
        UI_BusquedaNombre pantalla = new UI_BusquedaNombre(hashTablePrincipal, arbolPrincipal);
        pantalla.setLocationRelativeTo(null);
        pantalla.setVisible(true);
    }//GEN-LAST:event_CargarJSONActionPerformed

    private void CargarJSON1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarJSON1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarJSON1ActionPerformed

    private void nuevoJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoJSONActionPerformed
          try{
          ListaSimple lista = new ListaSimple();
          Reader reader = new Reader();
          lista = reader.Read();
          
          if(lista ==  null){
              throw new Exception("Error durante la carga");  
          }
          personas = lista;
          
          JOptionPane.showMessageDialog(this, "La carga fue un exito");  

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error durante la carga");  
        }
    }//GEN-LAST:event_nuevoJSONActionPerformed

    private void VerRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerRegistroActionPerformed
        Arbol arbol = new Arbol();
        arbol.construirArbol(personas);
        ArbolGraphStream arbolgt = new ArbolGraphStream(arbol);
        arbolgt.mostrar();
                
      
        
    }//GEN-LAST:event_VerRegistroActionPerformed

    private void CargarJSON5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarJSON5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarJSON5ActionPerformed

    private void CargarJSON6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarJSON6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarJSON6ActionPerformed

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
    private javax.swing.JButton CargarJSON;
    private javax.swing.JButton CargarJSON1;
    private javax.swing.JButton CargarJSON5;
    private javax.swing.JButton CargarJSON6;
    private javax.swing.JButton VerRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nuevoJSON;
    // End of variables declaration//GEN-END:variables
}
