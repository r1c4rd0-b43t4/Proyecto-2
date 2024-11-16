

package UI;
import Carga.Reader;
import Main.ListaSimple;
import Main.ListaSimple;
import javax.swing.JOptionPane;

/**
 *
 * @author rdbae
 */
public class UI_Inicio extends javax.swing.JFrame {
    static ListaSimple personas;

    /**
     * Creates new form UI_Inicio
     */
    public UI_Inicio() {
        personas = new ListaSimple();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CargarJSON = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CargarJSON.setBackground(new java.awt.Color(204, 204, 204));
        CargarJSON.setFont(new java.awt.Font("SansSerif", 2, 18)); // NOI18N
        CargarJSON.setForeground(new java.awt.Color(0, 0, 0));
        CargarJSON.setText("Cargar");
        CargarJSON.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CargarJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarJSONActionPerformed(evt);
            }
        });
        jPanel1.add(CargarJSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 170, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/inicio.png"))); // NOI18N
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
        
    try{
        Reader reader = new Reader();
        personas = reader.Read();


        if(personas ==  null){
            throw new Exception("Error durante la carga");  
        }
          
        JOptionPane.showMessageDialog(this, "La carga fue un exito");  

        this.setVisible(false);
        UI_Menu_Principal ui = new UI_Menu_Principal(personas);
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error durante la carga");  
        }  
    }//GEN-LAST:event_CargarJSONActionPerformed

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
            java.util.logging.Logger.getLogger(UI_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CargarJSON;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
