package capa_presentacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class FrmPrincipal extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdd = new SimpleDateFormat("HH:mm:ss");

    public FrmPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(getIconImage());
        iniciarReloj();

    }

    private void iniciarReloj() {
        Timer timer = new Timer(1000, (ActionEvent e) -> {
            Date fechaHora1 = new Date();
            lblfecha.setText(sdf.format(fechaHora1));
            lblHora.setText(sdd.format(fechaHora1));
        });
        timer.start(); // Iniciar el Timer
    }

    @Override
    public final Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos/icono.png"));
        return retValue;
    }

    public void setUsuarioLogueado(String nombreUsuario) {
        lbluser.setText(nombreUsuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mnuMantUsuario = new javax.swing.JMenuItem();
        mnuMantMarcas = new javax.swing.JMenuItem();
        mnuMantCategoria = new javax.swing.JMenuItem();
        mnuMantProducto = new javax.swing.JMenuItem();
        mnuMantCliente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pagina Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/iniciar.png"))); // NOI18N
        jButton1.setText("Iniciar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cambiarUsuario.png"))); // NOI18N
        jButton2.setText("Cambiar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cerrar.png"))); // NOI18N
        jButton3.setText("Cerrar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        jToolBar1.add(jSeparator1);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        jButton4.setText("Consultar");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/vender.png"))); // NOI18N
        jButton5.setText("Venta");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cliente.png"))); // NOI18N
        jButton6.setText("Cliente");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pagar.png"))); // NOI18N
        jButton7.setText("Pagar");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton7);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/usuario.png"))); // NOI18N

        jLabel2.setText("Usuario");

        lbluser.setBackground(new java.awt.Color(255, 255, 255));
        lbluser.setForeground(new java.awt.Color(0, 0, 0));
        lbluser.setOpaque(true);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fecha.png"))); // NOI18N

        jLabel4.setText("Fecha");

        lblfecha.setBackground(new java.awt.Color(255, 255, 255));
        lblfecha.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(0, 0, 0));
        lblfecha.setOpaque(true);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/hora.png"))); // NOI18N

        jLabel6.setText("Hora");

        lblHora.setBackground(new java.awt.Color(255, 255, 255));
        lblHora.setFont(new java.awt.Font("sansserif", 0, 17)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 0, 0));
        lblHora.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbluser, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(84, 84, 84)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, lblHora, lblfecha, lbluser});

        jMenu1.setText("Login");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Mantenimiento");

        mnuMantUsuario.setText("Usuario");
        jMenu2.add(mnuMantUsuario);

        mnuMantMarcas.setText("Marcas");
        mnuMantMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantMarcasActionPerformed(evt);
            }
        });
        jMenu2.add(mnuMantMarcas);

        mnuMantCategoria.setText("Categoria");
        mnuMantCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantCategoriaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuMantCategoria);

        mnuMantProducto.setText("Producto");
        mnuMantProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantProductoActionPerformed(evt);
            }
        });
        jMenu2.add(mnuMantProducto);

        mnuMantCliente.setText("Cliente");
        mnuMantCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMantClienteActionPerformed(evt);
            }
        });
        jMenu2.add(mnuMantCliente);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ventas");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Procedimientos");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        iniciarReloj();
        jdInicioSesion is = new jdInicioSesion(this, true);
        is.setLocationRelativeTo(this);
        is.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

    private void mnuMantMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantMarcasActionPerformed
        // TODO add your handling code here:
        jdMantMarca ma;
        ma = new jdMantMarca(this, true);
        ma.setLocationRelativeTo(this);
        ma.setVisible(true);

    }//GEN-LAST:event_mnuMantMarcasActionPerformed

    private void mnuMantProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantProductoActionPerformed
        // TODO add your handling code here:
        jdMantProducto mp;
        mp = new jdMantProducto(this,true);
        mp.setLocationRelativeTo(this);
        mp.setVisible(true);
    }//GEN-LAST:event_mnuMantProductoActionPerformed

    private void mnuMantCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantCategoriaActionPerformed
        // TODO add your handling code here:
        jdMantCat ma;
        ma = new jdMantCat(this,true);
        ma.setLocationRelativeTo(this);
        ma.setVisible(true);
    }//GEN-LAST:event_mnuMantCategoriaActionPerformed

    private void mnuMantClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMantClienteActionPerformed
        // TODO add your handling code here:
        jdMantCliente mc;
        mc = new jdMantCliente(this, true);
        mc.setLocationRelativeTo(this);
        mc.setVisible(true);
    }//GEN-LAST:event_mnuMantClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lbluser;
    private javax.swing.JMenuItem mnuMantCategoria;
    private javax.swing.JMenuItem mnuMantCliente;
    private javax.swing.JMenuItem mnuMantMarcas;
    private javax.swing.JMenuItem mnuMantProducto;
    private javax.swing.JMenuItem mnuMantUsuario;
    // End of variables declaration//GEN-END:variables
}
