package capa_presentacion;

import java.sql.*;

import capa_negocio.clsProducto;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class jdAnadirProducto extends javax.swing.JDialog {

    clsProducto objProducto = new clsProducto();

    private int prod = 0;
    private int cant = 0;
    private int desc = 0;

    public int getCod() {
        return prod;
    }

    public int getCant() {
        return cant;
    }

    public int getDesc() {
        return desc;
    }

    /**
     * Creates new form jdA�adirProducto
     */
    public jdAnadirProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void listarProductos() {
        ResultSet rsProductos = null;
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("C�DIGO");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCI�N");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("MARCA");
        modelo.addColumn("CATEGOR�A");

        try {
            rsProductos = objProducto.filtrar(txtNombreProducto.getText());
            while (rsProductos.next()) {
                modelo.addRow(new Object[]{
                    rsProductos.getInt("codProducto"),
                    rsProductos.getString("nomProducto"),
                    rsProductos.getString("descripcion"),
                    rsProductos.getString("precio"),
                    rsProductos.getString("stock"),
                    rsProductos.getString("nommarca"),
                    rsProductos.getString("nomcategoria")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        tblProductos.setModel(modelo);
    }

    private void pasarDatos(int cod, int ctd) {
        try {
            int stock = objProducto.getStock(cod);

            if (ctd <= stock) {
                prod = cod;
                cant = ctd;
                String descuento = String.valueOf(JOptionPane.showInputDialog(rootPane,
                        "Ingrese el porcentaje de descuento:", "0"));
                try {
                    desc = Integer.parseInt(descuento);
                } catch (Exception e) {
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Stock Insuficiente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnBusquedaAvanzada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyReleased(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        btnBusquedaAvanzada.setText("BÚSQUEDA AVANZADA");
        btnBusquedaAvanzada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaAvanzadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreProducto)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addComponent(btnBusquedaAvanzada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBusquedaAvanzada)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listarProductos();
    }//GEN-LAST:event_formWindowActivated

    private void txtNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyReleased
        listarProductos();
    }//GEN-LAST:event_txtNombreProductoKeyReleased

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked

        int cod = Integer.parseInt(String.valueOf(tblProductos.getValueAt(tblProductos.getSelectedRow(), 0)));
        String ctd = String.valueOf(JOptionPane.showInputDialog(rootPane, "Ingrese la cantidad: "));

        if (ctd != "null") {
            try {
                pasarDatos(cod, Integer.parseInt(ctd));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Cantidad no v�lida");
            }
        }

    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnBusquedaAvanzadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaAvanzadaActionPerformed
        // TODO add your handling code here:
        jdBusquedaAvanzada objConsulta = new jdBusquedaAvanzada((Frame) SwingUtilities.getWindowAncestor(this), true);
        objConsulta.setBuscando(true);
        objConsulta.setLocationRelativeTo(this);
        objConsulta.setVisible(true);
        int cod = objConsulta.getCod();
        if (cod > 0) {
            String ctd = String.valueOf(JOptionPane.showInputDialog(this, "Ingrese la cantidad:"));

            if (ctd != null) {
                try {
                    pasarDatos(cod, Integer.parseInt(ctd));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Cantidad no válida");
                }
            }
        }
    }//GEN-LAST:event_btnBusquedaAvanzadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusquedaAvanzada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
