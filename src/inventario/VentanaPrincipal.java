package inventario;

public class VentanaPrincipal extends javax.swing.JFrame {

    OperacionesBDInventario db = new OperacionesBDInventario();
    

    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        verInventarioJMenuItem = new javax.swing.JMenuItem();
        agregarInventarioJMenuItem = new javax.swing.JMenuItem();
        eliminarInventarioJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Inventario");

        verInventarioJMenuItem.setText("Ver ");
        verInventarioJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInventarioJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(verInventarioJMenuItem);

        agregarInventarioJMenuItem.setText("Agregar");
        agregarInventarioJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarInventarioJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(agregarInventarioJMenuItem);

        eliminarInventarioJMenuItem.setText("Eliminar");
        eliminarInventarioJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarInventarioJMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(eliminarInventarioJMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarInventarioJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarInventarioJMenuItemActionPerformed
        // TODO add your handling code here:
        // Inv= inventario
        VentanaInventario_AgregarArticulo ventanaAgregarArticuloInv = new VentanaInventario_AgregarArticulo();
        ventanaAgregarArticuloInv.setVisible(true);
    }//GEN-LAST:event_agregarInventarioJMenuItemActionPerformed

    private void verInventarioJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInventarioJMenuItemActionPerformed
        // TODO add your handling code here:
        // Inv= inventario
        VentanaInventario_VerInventario ventanaVerInv= new VentanaInventario_VerInventario();
        ventanaVerInv.setVisible(true);
    }//GEN-LAST:event_verInventarioJMenuItemActionPerformed

    private void eliminarInventarioJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarInventarioJMenuItemActionPerformed
        // TODO add your handling code here:
        // Inv= inventario
        VentanaInventario_EliminarArticulo ventanaEliminarArticuloInv = new VentanaInventario_EliminarArticulo();
        ventanaEliminarArticuloInv.setVisible(true);
    }//GEN-LAST:event_eliminarInventarioJMenuItemActionPerformed

 
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem agregarInventarioJMenuItem;
    private javax.swing.JMenuItem eliminarInventarioJMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem verInventarioJMenuItem;
    // End of variables declaration//GEN-END:variables
}
