package inventario;

import javax.swing.JOptionPane;

public class VentanaInventario_AgregarArticulo extends javax.swing.JFrame {

    public VentanaInventario_AgregarArticulo() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        areaTextoClave = new javax.swing.JTextField();
        areaTextoDescripcion = new javax.swing.JTextField();
        areaTextoPrecio = new javax.swing.JTextField();
        areaTextoCantidad = new javax.swing.JTextField();
        etiquetaClave = new javax.swing.JLabel();
        etiquetaDescripcion = new javax.swing.JLabel();
        etiquetaCantidad = new javax.swing.JLabel();
        agregarJButton = new javax.swing.JButton();
        cancelarJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        etiquetaPrecio = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Artículo");
        setResizable(false);

        areaTextoClave.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        areaTextoDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        areaTextoPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        areaTextoCantidad.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        etiquetaClave.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        etiquetaClave.setText("Clave");

        etiquetaDescripcion.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        etiquetaDescripcion.setText("Descripcion");

        etiquetaCantidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        etiquetaCantidad.setText("Cantidad");

        agregarJButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        agregarJButton.setText("Agregar");
        agregarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarJButtonActionPerformed(evt);
            }
        });

        cancelarJButton.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cancelarJButton.setText("Cancelar");
        cancelarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJButtonActionPerformed(evt);
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
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(etiquetaPrecio))
                                    .addComponent(etiquetaCantidad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(areaTextoDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(areaTextoCantidad)
                                    .addComponent(areaTextoPrecio)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaClave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(areaTextoClave)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(agregarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarJButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaTextoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaClave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaTextoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaTextoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaTextoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(etiquetaPrecio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarJButton)
                    .addComponent(cancelarJButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarJButtonActionPerformed
       try{
       ManejadorBD baseDeDatos = new ManejadorBD();
        baseDeDatos.conectarConMySQL("root", "", "ElCaballoDeHierro");
        baseDeDatos.insertarArticuloEnInventario("Articulos", areaTextoClave.getText(),
                areaTextoDescripcion.getText(),
                Integer.parseInt(areaTextoCantidad.getText()),
                Integer.parseInt(areaTextoPrecio.getText()));
        baseDeDatos.terminarConexionConMySQL();
        this.dispose();
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "Error al almacenar el artículo");
       }
    }//GEN-LAST:event_agregarJButtonActionPerformed

    private void cancelarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarJButton;
    private javax.swing.JTextField areaTextoCantidad;
    private javax.swing.JTextField areaTextoClave;
    private javax.swing.JTextField areaTextoDescripcion;
    private javax.swing.JTextField areaTextoPrecio;
    private javax.swing.JButton cancelarJButton;
    private javax.swing.JLabel etiquetaCantidad;
    private javax.swing.JLabel etiquetaClave;
    private javax.swing.JLabel etiquetaDescripcion;
    private javax.swing.JLabel etiquetaPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
