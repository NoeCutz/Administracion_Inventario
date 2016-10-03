package Vista.Inventario;

import Modelo.Articulo;
import Controlador.AdministradorInventario;


public class VentanaInventario_AgregarArticulo extends javax.swing.JFrame {

    public VentanaInventario_AgregarArticulo() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoTextoClave = new javax.swing.JTextField();
        campoTextoDescripcion = new javax.swing.JTextField();
        campoTextoPrecio = new javax.swing.JTextField();
        campoTextoCantidad = new javax.swing.JTextField();
        etiquetaClave = new javax.swing.JLabel();
        etiquetaDescripcion = new javax.swing.JLabel();
        etiquetaCantidad = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        etiquetaPrecio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Artículo");
        setResizable(false);

        campoTextoClave.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        campoTextoDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        campoTextoPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        campoTextoCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        etiquetaClave.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        etiquetaClave.setText("Clave");

        etiquetaDescripcion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        etiquetaDescripcion.setText("Descripcion");

        etiquetaCantidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        etiquetaCantidad.setText("Cantidad");

        botonAgregar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonCancelar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        etiquetaPrecio.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        etiquetaPrecio.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaDescripcion)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(etiquetaPrecio))
                                    .addComponent(etiquetaCantidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoTextoDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(campoTextoCantidad)
                                    .addComponent(campoTextoPrecio)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaClave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTextoClave)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTextoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaPrecio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar)
                    .addComponent(botonCancelar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
       
        Articulo articulo= new Articulo(campoTextoClave.getText(), campoTextoDescripcion.getText(), Integer.parseInt(campoTextoCantidad.getText()), Integer.parseInt(campoTextoPrecio.getText()));
        AdministradorInventario admin= new AdministradorInventario();
        admin.agregarArticulo(articulo);
        this.dispose();
       
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoTextoCantidad;
    private javax.swing.JTextField campoTextoClave;
    private javax.swing.JTextField campoTextoDescripcion;
    private javax.swing.JTextField campoTextoPrecio;
    private javax.swing.JLabel etiquetaCantidad;
    private javax.swing.JLabel etiquetaClave;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaPrecio;
    // End of variables declaration//GEN-END:variables
}
