/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario;

import javax.swing.JOptionPane;

/**
 *
 * @author Antony
 */
public class VentanaInventario_EliminarArticulo extends javax.swing.JFrame {

    /**
     * Creates new form Window_Delete
     */
    public VentanaInventario_EliminarArticulo() {
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

        jLabel3 = new javax.swing.JLabel();
        claveJTextField = new javax.swing.JTextField();
        borrarArticuloJButton = new javax.swing.JButton();
        cancelarJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar artículo");
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Clave");

        claveJTextField.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        borrarArticuloJButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        borrarArticuloJButton.setText("Borrar Artículo");
        borrarArticuloJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarArticuloJButtonActionPerformed(evt);
            }
        });

        cancelarJButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cancelarJButton.setText("Cancelar");
        cancelarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(borrarArticuloJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarJButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(claveJTextField)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrarArticuloJButton)
                    .addComponent(cancelarJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrarArticuloJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarArticuloJButtonActionPerformed
       try{
       OperacionesBDInventario baseDeDatos = new OperacionesBDInventario();
       baseDeDatos.conectarConMySQL("root", "", "ElCaballoDeHierro");
       baseDeDatos.eliminarArticuloDeInventario("Articulos", claveJTextField.getText());
       baseDeDatos.terminarConexionConMySQL();
       this.dispose();
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "Artículo no encontrado");
       }
    }//GEN-LAST:event_borrarArticuloJButtonActionPerformed

    private void cancelarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJButtonActionPerformed
     this.dispose();
    }//GEN-LAST:event_cancelarJButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarArticuloJButton;
    private javax.swing.JButton cancelarJButton;
    private javax.swing.JTextField claveJTextField;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
