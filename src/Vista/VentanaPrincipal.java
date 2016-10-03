package Vista;

import Vista.Inventario.VentanaInventario_AgregarArticulo;
import Vista.Inventario.VentanaInventario_EliminarArticulo;
import Vista.Inventario.VentanaInventario_VerInventario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VentanaPrincipal extends javax.swing.JFrame {

    InputStream imagenDeFondo;
    public VentanaPrincipal() {
      
            initComponents();
            imagenDeFondo= VentanaPrincipal.class.getResourceAsStream("/imagenes/imagenDeFondo.jpg");
            BufferedImage imagenDeFondoImg = null;
        try {
            imagenDeFondoImg = ImageIO.read(imagenDeFondo);
        } catch (IOException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        Image dimg = imagenDeFondoImg.getScaledInstance(666, 524, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        setContentPane(new JLabel(imageIcon));
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuInventario = new javax.swing.JMenuBar();
        subMenuInventario = new javax.swing.JMenu();
        menuItemVerInventario = new javax.swing.JMenuItem();
        menuItemAgregarInventario = new javax.swing.JMenuItem();
        menuItemeEliminarInventario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        subMenuInventario.setText("Inventario");

        menuItemVerInventario.setText("Ver ");
        menuItemVerInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVerInventarioActionPerformed(evt);
            }
        });
        subMenuInventario.add(menuItemVerInventario);

        menuItemAgregarInventario.setText("Agregar");
        menuItemAgregarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAgregarInventarioActionPerformed(evt);
            }
        });
        subMenuInventario.add(menuItemAgregarInventario);

        menuItemeEliminarInventario.setText("Eliminar");
        menuItemeEliminarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemeEliminarInventarioActionPerformed(evt);
            }
        });
        subMenuInventario.add(menuItemeEliminarInventario);

        menuInventario.add(subMenuInventario);

        setJMenuBar(menuInventario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAgregarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAgregarInventarioActionPerformed
        // TODO add your handling code here:
        // Inv= inventario
        VentanaInventario_AgregarArticulo ventanaAgregarArticuloInv = new VentanaInventario_AgregarArticulo();
        ventanaAgregarArticuloInv.setVisible(true);
    }//GEN-LAST:event_menuItemAgregarInventarioActionPerformed

    private void menuItemVerInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVerInventarioActionPerformed
        // TODO add your handling code here:
        // Inv= inventario
        VentanaInventario_VerInventario ventanaVerInv= new VentanaInventario_VerInventario();
        ventanaVerInv.setVisible(true);
    }//GEN-LAST:event_menuItemVerInventarioActionPerformed

    private void menuItemeEliminarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemeEliminarInventarioActionPerformed
        // TODO add your handling code here:
        // Inv= inventario
        VentanaInventario_EliminarArticulo ventanaEliminarArticuloInv = new VentanaInventario_EliminarArticulo();
        ventanaEliminarArticuloInv.setVisible(true);
    }//GEN-LAST:event_menuItemeEliminarInventarioActionPerformed

 
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menuInventario;
    private javax.swing.JMenuItem menuItemAgregarInventario;
    private javax.swing.JMenuItem menuItemVerInventario;
    private javax.swing.JMenuItem menuItemeEliminarInventario;
    private javax.swing.JMenu subMenuInventario;
    // End of variables declaration//GEN-END:variables
}
