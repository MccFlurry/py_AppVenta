package capa_presentacion;

import capa_negocio.clsCategoria;
import capa_negocio.clsMarca;
import capa_negocio.clsProducto;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class jdMantProducto extends javax.swing.JDialog {

    clsProducto objProducto = new clsProducto();
    clsCategoria objCategoria = new clsCategoria();
    clsMarca objMarca = new clsMarca();

    public jdMantProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void listarMarcas() {
        ResultSet rsMar = null;
        DefaultComboBoxModel modeloMar = new DefaultComboBoxModel();
        cbMarca.setModel(modeloMar);
        try {
            rsMar = objMarca.listarMarcas();
            while (rsMar.next()) {
                modeloMar.addElement(rsMar.getString("nommarca"));
            }
        } catch (Exception e) {

        }
    }

    private void listarCategorias() {
        ResultSet rsCat = null;
        DefaultComboBoxModel modeloCat = new DefaultComboBoxModel();
        cbCategoria.setModel(modeloCat);
        try {
            rsCat = objCategoria.listarCategorias();
            while (rsCat.next()) {
                modeloCat.addElement(rsCat.getString("nomcat"));
            }
        } catch (Exception e) {

        }
    }

    private void listarProductos() {
        ResultSet rsPro = null;
        String vigencia = "";
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Vigencia");
        modelo.addColumn("Marca");
        modelo.addColumn("Categoria");
        tblProductos.setModel(modelo);

        try {
            rsPro = objProducto.listarProductos();  // Retrieve the ResultSet
            while (rsPro.next()) {
                if (rsPro.getString("vigencia").equals("t")) {
                    vigencia = "SI";
                } else {
                    vigencia = "NO";
                }
                modelo.addRow(new Object[]{
                    rsPro.getInt("codproducto"),
                    rsPro.getString("nomproducto"),
                    rsPro.getString("descripcion"),
                    rsPro.getString("precio"),
                    rsPro.getString("stock"),
                    vigencia,
                    rsPro.getString("nommarca"),
                    rsPro.getString("nomcat")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar productos!: " + e.getMessage());
        } finally {
            // Close the ResultSet after processing is completed
            try {
                if (rsPro != null) {
                    rsPro.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al cerrar ResultSet: " + e.getMessage());
            }
        }
    }

    private void limpiarControles() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDes.setText("");
        txtPrecio.setText("");
        spStock.setValue(0);
        chkVigencia.setSelected(false);
        txtCodigo.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        chkVigencia = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spStock = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbMarca = new javax.swing.JComboBox<>();
        cbCategoria = new javax.swing.JComboBox<>();
        btnNuevoMarca = new javax.swing.JButton();
        btnNuevoCategoria = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBaja = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        chkVigencia.setForeground(new java.awt.Color(0, 0, 0));
        chkVigencia.setText("(Vigente)");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscarMarca.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Descripcion:");

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Código: ");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre: ");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Vigencia: ");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Precio");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Stock");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Marca");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Categoria");

        cbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNuevoMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/nuevo.png"))); // NOI18N
        btnNuevoMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMarcaActionPerformed(evt);
            }
        });

        btnNuevoCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/nuevo.png"))); // NOI18N
        btnNuevoCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDes))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecio)
                                    .addComponent(spStock)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkVigencia)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevoCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevoMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(chkVigencia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnNuevoMarca))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNuevoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/registrarMarca.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 255, 255));
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/modificarMarca.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eliminarMarca.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBaja.setBackground(new java.awt.Color(255, 255, 255));
        btnBaja.setForeground(new java.awt.Color(0, 0, 0));
        btnBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/darBajaMarca.png"))); // NOI18N
        btnBaja.setText("Dar Baja");
        btnBaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/limpiarMarca.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salirMarca.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(153, 255, 255));

        tblProductos.setBackground(new java.awt.Color(255, 255, 255));
        tblProductos.setForeground(new java.awt.Color(0, 0, 0));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        try {
            if (btnNuevo.getText().equals("Nuevo")) {
                btnNuevo.setText("Guardar");
                limpiarControles();
                txtCodigo.setText(objProducto.generarCodigoProducto().toString());
                txtNombre.requestFocus();
            } else {
                btnNuevo.setText("Nuevo");
                objProducto.registrarProducto(Integer.parseInt(txtCodigo.getText()), txtNombre.getText(), txtDes.getText(), Double.parseDouble(txtPrecio.getText()), (int) spStock.getValue(), chkVigencia.isSelected(), objMarca.obtenerCodigoMarca(cbMarca.getSelectedItem().toString()), objCategoria.obtenerCodigoCategoria(cbCategoria.getSelectedItem().toString()));
                limpiarControles();
                listarProductos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar el producto" + e.getMessage());
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        try {
            ResultSet rs = objProducto.buscarProducto(Integer.parseInt(txtCodigo.getText()));

            if (rs.next()) {
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Está seguro de que desea modificar este producto?",
                        "Confirmar modificación", JOptionPane.YES_NO_OPTION);

                if (confirmacion == JOptionPane.YES_OPTION) {
                    // If the user confirms, proceed with the modification
                    objProducto.modificarProducto(
                            Integer.parseInt(txtCodigo.getText()),
                            txtNombre.getText(),
                            txtDes.getText(),
                            Double.parseDouble(txtPrecio.getText()),
                            (int) spStock.getValue(),
                            chkVigencia.isSelected(),
                            objMarca.obtenerCodigoMarca(cbMarca.getSelectedItem().toString()),
                            objCategoria.obtenerCodigoCategoria(cbCategoria.getSelectedItem().toString())
                    );

                    limpiarControles();
                    listarProductos();

                    JOptionPane.showMessageDialog(this, "Producto modificado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Modificación cancelada.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            }

            rs.close(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar el producto: " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtCodigo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un codigo a eliminar");
            } else {
                int confirmacion = JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar este producto?", "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    int cod = Integer.parseInt(txtCodigo.getText());
                    objProducto.eliminarProducto(cod);
                    JOptionPane.showMessageDialog(this, "producto eliminado correctamente");
                    limpiarControles();
                    listarProductos();
                } else {
                    JOptionPane.showMessageDialog(this, "Operación cancelada");

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaActionPerformed
        // TODO add your handling code here:
        try {
            ResultSet rs = objProducto.buscarProducto(Integer.parseInt(txtCodigo.getText()));

            if (rs.next()) {
                boolean vigente = rs.getBoolean("vigencia");

                if (!vigente) {
                    JOptionPane.showMessageDialog(this, "Este producto ya estaba dado de baja.");
                } else {
                    int confirmacion = JOptionPane.showConfirmDialog(this, "Esta seguro de dar de baja este producto?", "Confirmar dar de baja", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        objProducto.darBajaProducto(Integer.parseInt(txtCodigo.getText()));
                        limpiarControles();
                        listarProductos();
                        JOptionPane.showMessageDialog(this, "Producto dado de baja correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Operación cancelada.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrada.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de baja el producto: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBajaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarControles();
        listarProductos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        ResultSet rsProducto = null;
        try {
            if (txtCodigo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un codigo para buscar");
            } else {
                rsProducto = objProducto.buscarProducto(Integer.parseInt(txtCodigo.getText()));
                if (rsProducto.next()) {
                    txtNombre.setText(rsProducto.getString("nomproducto"));
                    txtDes.setText(rsProducto.getString("descripcion"));
                    txtPrecio.setText(rsProducto.getString("precio"));
                    spStock.setValue(rsProducto.getObject("stock"));
                    chkVigencia.setSelected(rsProducto.getBoolean("vigencia"));
                    cbMarca.setSelectedItem(rsProducto.getString("nommarca"));
                    cbCategoria.setSelectedItem(rsProducto.getString("nomcat"));
                    rsProducto.close();
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo de producto no existe");
                    limpiarControles();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al listar productos!: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblProductos.getSelectedRow();

        if (selectedRow != -1) {
            txtCodigo.setText(tblProductos.getValueAt(selectedRow, 0).toString());
            txtNombre.setText(tblProductos.getValueAt(selectedRow, 1).toString());
            txtDes.setText(tblProductos.getValueAt(selectedRow, 2).toString());
            txtPrecio.setText(tblProductos.getValueAt(selectedRow, 3).toString());
            spStock.setValue(Integer.parseInt(tblProductos.getValueAt(selectedRow, 4).toString()));

            if (tblProductos.getValueAt(selectedRow, 5).toString().equals("SI")) {
                chkVigencia.setSelected(true);
            } else {
                chkVigencia.setSelected(false);
            }

            cbMarca.setSelectedItem(tblProductos.getValueAt(selectedRow, 6).toString());
            cbCategoria.setSelectedItem(tblProductos.getValueAt(selectedRow, 7).toString());
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnNuevoMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMarcaActionPerformed
        // TODO add your handling code here:
        jdMantMarca ma = new jdMantMarca(null, true);
        ma.setLocationRelativeTo(this);
        ma.setVisible(true);
    }//GEN-LAST:event_btnNuevoMarcaActionPerformed

    private void btnNuevoCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCategoriaActionPerformed
        // TODO add your handling code here:
        jdMantCat mc = new jdMantCat(null,true);
        mc.setLocationRelativeTo(this);
        mc.setVisible(true);
    }//GEN-LAST:event_btnNuevoCategoriaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        listarProductos();
        listarMarcas();
        listarCategorias();
    }//GEN-LAST:event_formWindowActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaja;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoCategoria;
    private javax.swing.JButton btnNuevoMarca;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbMarca;
    private javax.swing.JCheckBox chkVigencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spStock;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
