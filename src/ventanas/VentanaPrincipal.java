/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;


/**
 *
 * @author rodrigopeniche
 */
public class VentanaPrincipal extends JFrame {
    
    JMenuBar barraMenuPrincipal;
    JMenu menuInventario;
    JMenu menuProveedores;
    JMenuItem menuItemVerInventario;
    JMenuItem menuItemAgregarInventario;
    JMenuItem menuItemVerProveedores;
    JMenuItem menuItemAgregarProveedor;
    PanelAgregarArticulo panelAgregarArticulo;
    PanelVerInventario panelVerInventario;
    PanelBuscarArticulo panelBuscarArticulo; 
    PanelEliminarArticulo panelEliminarArticulo; 
    PanelActualizarArticulo panelActualizarArticulo;
    PanelAgregarProveedor panelAgregarProveedor;
    PanelVerProveedores panelVerProveedores;
    PanelBuscarProveedor panelBuscarProveedor;
    PanelEliminarProveedor panelEliminarProveedor;
    PanelActualizarProveedor panelActualizarProveedor;
    
    
    
    public VentanaPrincipal(){
       
        barraMenuPrincipal = new javax.swing.JMenuBar();
        menuInventario = new javax.swing.JMenu();
        menuProveedores= new javax.swing.JMenu();
        menuItemVerProveedores= new javax.swing.JMenuItem();
        menuItemAgregarProveedor= new javax.swing.JMenuItem();
        menuItemVerInventario = new javax.swing.JMenuItem();
        menuItemAgregarInventario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuInventario.setText("Inventario");

        menuItemVerInventario.setText("Ver ");
        menuItemVerInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickEnVerInventario(evt);
            }
        });
        menuInventario.add(menuItemVerInventario);

        menuItemAgregarInventario.setText("Agregar");
        menuItemAgregarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickEnAgregarArticulo(evt);
            }
        });
        menuInventario.add(menuItemAgregarInventario);

        barraMenuPrincipal.add(menuInventario);
        
        menuProveedores.setText("Proveedores");

        menuItemVerProveedores.setText("Ver");
        menuItemVerProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickEnVerProveedores(evt);
            }
        });
        menuProveedores.add(menuItemVerProveedores);

        menuItemAgregarProveedor.setText("Agregar");
        menuItemAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickEnAgregarProveedor(evt);
            }
        });
        menuProveedores.add(menuItemAgregarProveedor);

        barraMenuPrincipal.add(menuProveedores);

        setJMenuBar(barraMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 877, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }
    
    private void clickEnVerInventario(ActionEvent evt) {
        panelVerInventario= new PanelVerInventario(this);
        
        if(panelAgregarArticulo != null){
           panelAgregarArticulo.setVisible(false);
           }
        if(panelAgregarProveedor != null){
            panelAgregarProveedor.setVisible(false);
        }
        if(panelVerProveedores != null){
            panelVerProveedores.setVisible(false);
        }
        else{
            //
        }
        
        initPanelVerInventario();
     }
     
     
     private void clickEnAgregarArticulo(ActionEvent evt) {
         panelAgregarArticulo = new PanelAgregarArticulo();
         
         if(panelVerInventario != null){
             panelVerInventario.setVisible(false);
             if(panelBuscarArticulo != null){
                 panelBuscarArticulo.setVisible(false);
             }
             if(panelEliminarArticulo != null){
                 panelEliminarArticulo.setVisible(false);
             }
         }
         if(panelVerProveedores != null){
             panelVerProveedores.setVisible(false);
         }
         if(panelAgregarProveedor != null){
             panelAgregarProveedor.setVisible(false);
         }
         else{
            //
         }
         
         initPanelAgregarArticulo();
     }
     
     void clickEnBuscarArticulo(MouseEvent evt){
         panelBuscarArticulo= new PanelBuscarArticulo();
         
         if(panelActualizarArticulo != null){
             panelActualizarArticulo.setVisible(false);
         }
         if(panelBuscarProveedor != null){
             panelBuscarProveedor.setVisible(false);
         }
         
         initPanelBuscarArticulo();
         // falta agregar actualizar proveedor
     }
     
     void clickEnEliminarArticulo(MouseEvent evt){
         panelEliminarArticulo= new PanelEliminarArticulo(panelVerInventario);
         if(panelEliminarProveedor != null){
             panelEliminarProveedor.setVisible(false);
         }
         initPanelEliminarArticulo();
     }
     
     void clickEnActualizarArticulo(MouseEvent evt){
         panelActualizarArticulo= new PanelActualizarArticulo(panelVerInventario);
         
         if(panelBuscarArticulo != null){
             panelBuscarArticulo.setVisible(false);
         }
         if(panelBuscarProveedor != null){
             panelBuscarProveedor.setVisible(false);
         }
         if(panelActualizarProveedor != null){
             panelActualizarProveedor.setVisible(false);
         }
         initPanelActualizarArticulo();
     }
   
     private void clickEnVerProveedores(ActionEvent evt){
         panelVerProveedores= new PanelVerProveedores(this);
         
         if(panelVerInventario != null){
             panelVerInventario.setVisible(false);
         }
         if(panelAgregarArticulo != null){
             panelAgregarArticulo.setVisible(false);
         }
         if(panelAgregarProveedor != null){
             panelAgregarProveedor.setVisible(false);
         }
         
         initPanelVerProveedores();
     }
     
     private void clickEnAgregarProveedor(ActionEvent evt){
         panelAgregarProveedor= new PanelAgregarProveedor();
         
         if(panelVerInventario != null){
             panelVerInventario.setVisible(false);
         }
         if(panelVerProveedores != null){
             panelVerProveedores.setVisible(false);
         }
         if(panelAgregarArticulo != null){
             panelAgregarArticulo.setVisible(false);
         }
         
         initPanelAgregarProveedor();
     }
     
     void clickEnBuscarProveedor(MouseEvent evt){
         panelBuscarProveedor= new PanelBuscarProveedor();
         
         if(panelBuscarArticulo != null){
             panelBuscarArticulo.setVisible(false);
         }
         if(panelActualizarArticulo != null){
             panelActualizarArticulo.setVisible(false);
         }
         if(panelActualizarProveedor != null){
             panelActualizarProveedor.setVisible(false);
         }
        
         initPanelBuscarProveedor();
     }
     
     void clickEnEliminarProveedor(MouseEvent evt){
         panelEliminarProveedor= new PanelEliminarProveedor(panelVerProveedores);
         
         if(panelEliminarArticulo != null){
             panelEliminarArticulo.setVisible(false);
         }
         
         initPanelEliminarProveedor();
     }
     
     void clickEnActualizarProveedor(MouseEvent evt){
         panelActualizarProveedor= new PanelActualizarProveedor(panelVerProveedores);
         
         if(panelBuscarProveedor != null){
             panelBuscarProveedor.setVisible(false);
         }
         if(panelBuscarArticulo != null){
             panelBuscarArticulo.setVisible(false);
         }
         if(panelActualizarArticulo != null){
             panelActualizarArticulo.setVisible(false);
         }
         
         initPanelActualizarProveedor();
     }
     
     private void initPanelAgregarArticulo() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(panelAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
    }
     
     private void initPanelVerInventario(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelVerInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
     }
     
     private void initPanelBuscarArticulo(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(panelBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
     }
     
     private void initPanelEliminarArticulo(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(panelEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
     }
     
     private void initPanelActualizarArticulo(){
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(465, Short.MAX_VALUE)
                .addComponent(panelActualizarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(panelActualizarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
     }
     
     private void initPanelAgregarProveedor(){
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(panelAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );
     }
     
     private void initPanelVerProveedores(){
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelVerProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelVerProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
     }
     
     private void initPanelBuscarProveedor(){
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(panelBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
     }
     
     private void initPanelEliminarProveedor(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(panelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(panelEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
     }
     
     private void initPanelActualizarProveedor(){
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(465, Short.MAX_VALUE)
                .addComponent(panelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(panelActualizarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        ); 
     }
   
    
}
