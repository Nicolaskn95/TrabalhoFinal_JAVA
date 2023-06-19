package fatec.poo.view;

public class GuiMenu extends javax.swing.JFrame {


    public GuiMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuClientes = new javax.swing.JMenuItem();
        jMenuVendedores = new javax.swing.JMenuItem();
        jMenuProdutos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuSair = new javax.swing.JMenuItem();
        jMenuEmitirPedido = new javax.swing.JMenu();
        jMenuPedidos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de Vendas");
        setLocation(new java.awt.Point(600, 400));

        jMenuCadastros.setText("Cadastros");

        jMenuClientes.setText("Clientes");
        jMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClientesActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuClientes);

        jMenuVendedores.setText("Vendedores");
        jMenuVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVendedoresActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuVendedores);

        jMenuProdutos.setText("Produtos");
        jMenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuProdutos);
        jMenuCadastros.add(jSeparator1);

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuSair);

        jMenuBar1.add(jMenuCadastros);

        jMenuEmitirPedido.setText("Pedido");

        jMenuPedidos.setText("Emitir Pedido");
        jMenuPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPedidosActionPerformed(evt);
            }
        });
        jMenuEmitirPedido.add(jMenuPedidos);

        jMenuBar1.add(jMenuEmitirPedido);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutosActionPerformed
        GuiProduto objProdutos = new GuiProduto();
        objProdutos.setVisible(true);
    }//GEN-LAST:event_jMenuProdutosActionPerformed

    private void jMenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClientesActionPerformed
        GuiCliente objClientes = new GuiCliente();
        objClientes.setVisible(true);
    }//GEN-LAST:event_jMenuClientesActionPerformed

    private void jMenuVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVendedoresActionPerformed
        GuiVendedor objVendedores = new GuiVendedor();
        objVendedores.setVisible(true);
    }//GEN-LAST:event_jMenuVendedoresActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPedidosActionPerformed
        GuiEmitirPedido objEmitirPedido = new GuiEmitirPedido();
        objEmitirPedido.setVisible(true);
    }//GEN-LAST:event_jMenuPedidosActionPerformed

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
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuClientes;
    private javax.swing.JMenu jMenuEmitirPedido;
    private javax.swing.JMenuItem jMenuPedidos;
    private javax.swing.JMenuItem jMenuProdutos;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JMenuItem jMenuVendedores;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
