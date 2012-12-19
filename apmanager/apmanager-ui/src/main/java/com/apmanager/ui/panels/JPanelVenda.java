package com.apmanager.ui.panels;

import com.apmanager.ui.beans.ProductCart;
import com.apmanager.ui.components.Button;
import com.apmanager.ui.components.ConfirmDialog;
import com.apmanager.ui.components.Table;
import com.apmanager.ui.formaters.Currency;
import com.apmanager.ui.listeners.ActionListener;
import com.apmanager.ui.menu.Application;
import com.apmanager.ui.menu.JDialogSearchProduct;
import com.towel.el.FieldResolver;
import com.towel.swing.table.ObjectTableModel;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class JPanelVenda extends javax.swing.JPanel implements AdminPanel {

    private static final Logger log = Logger.getLogger(JPanelVenda.class.getSimpleName());
    private final JDialogSearchProduct dialog = new JDialogSearchProduct(Application.getInstance(), true);
    private final JDialogAlterQuantity dialogQuantity = new JDialogAlterQuantity(Application.getInstance(), true);

    /**
     * Creates new form JPanelVenda
     */
    public JPanelVenda() {
        initComponents();
        configureJTableProducts();
        configureListener();

        addButtonListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new Table();
        jPanel1 = new javax.swing.JPanel();
        jButtonCloseSale = new Button(this, KeyEvent.VK_F8);
        jButtonAlterQuantity = new Button(this, KeyEvent.VK_F7);
        jButtonRemove = new Button(this, KeyEvent.VK_DELETE);
        jButton1 = new Button(this, KeyEvent.VK_F6);

        jTable1.setBackground(new java.awt.Color(245, 245, 245));
        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 51, 51));
        jTable1.setGridColor(new java.awt.Color(152, 177, 255));
        jTable1.setSelectionBackground(new java.awt.Color(225, 220, 84));
        jTable1.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonCloseSale.setText("Fechar Venda");

        jButtonAlterQuantity.setText("Alterar Quantidade");

        jButtonRemove.setText("Remover");

        jButton1.setText("Orçamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAlterQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCloseSale)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCloseSale)
                    .addComponent(jButtonAlterQuantity)
                    .addComponent(jButtonRemove)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAlterQuantity;
    private javax.swing.JButton jButtonCloseSale;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void configureJTableProducts() {
        
        FieldResolver nameResolver = new FieldResolver(ProductCart.class, "name", "Nome");
        FieldResolver unitaryValueResolver = new FieldResolver(ProductCart.class, "unitaryValue", "Preço Unitário (R$)");
        unitaryValueResolver.setFormatter(new Currency());
        FieldResolver quantityResolver = new FieldResolver(ProductCart.class, "quantity", "Quantidade");

        FieldResolver totalResolver = new FieldResolver(ProductCart.class, "total", "Total (R$)");
        totalResolver.setFormatter(new Currency());

        ObjectTableModel<ProductCart> towel = new ObjectTableModel<>(
                new FieldResolver[]{nameResolver, unitaryValueResolver, quantityResolver, totalResolver}
                );
        
        java.util.List<ProductCart> produtoCarts = new ArrayList<>();
        produtoCarts.add(new ProductCart(1595l, "Lampada frontal", 10.00f, 150f, 15));
        produtoCarts.add(new ProductCart());
        produtoCarts.add(new ProductCart(1595l, "Lampada frontal", 10.00f, 150f, 15));
        towel.setData(produtoCarts);

        jTable1.setModel(towel);
    }

    private void configureListener() {
        final JPanelVenda jPanel = this;
        Toolkit.getDefaultToolkit().addAWTEventListener(
                new AWTEventListener() {
                    @Override
                    public void eventDispatched(AWTEvent event) {
                        // Verifica se este painel está sendo exibido
                        if (jPanel.isVisible()) {
                            KeyEvent ev = (KeyEvent) event;
                            // Verifica se foi um key Released
                            if (ev.getID() == KeyEvent.KEY_RELEASED) {
                                if (!dialog.isVisible() && jPanel.isEnabled()) {
                                    jPanel.setEnabled(false);
                                    if (ev.getKeyCode() == KeyEvent.VK_F1) {

                                        JOptionPane.showMessageDialog(jPanel, "Texto de ajuda");

                                    } else if (ev.getID() == KeyEvent.KEY_RELEASED && checkKeyAction(ev)) {
                                        dialog.setText(ev.getKeyChar() + "");
                                        dialog.setVisible(true);
                                    } else if (ev.getKeyCode() == KeyEvent.VK_F5) {
                                        dialog.setText("");
                                        dialog.setVisible(true);
                                    }
                                    jPanel.setEnabled(true);
                                }
                            }

                        }
                    }
                }, AWTEvent.KEY_EVENT_MASK);
    }

    private boolean checkKeyAction(KeyEvent ev) {
        if (ev.getKeyCode() == KeyEvent.VK_F1
                || ev.getKeyCode() == KeyEvent.VK_F2
                || ev.getKeyCode() == KeyEvent.VK_F3
                || ev.getKeyCode() == KeyEvent.VK_F4
                || ev.getKeyCode() == KeyEvent.VK_F5
                || ev.getKeyCode() == KeyEvent.VK_F6
                || ev.getKeyCode() == KeyEvent.VK_F7
                || ev.getKeyCode() == KeyEvent.VK_F8
                || ev.getKeyCode() == KeyEvent.VK_F9
                || ev.getKeyCode() == KeyEvent.VK_F10
                || ev.getKeyCode() == KeyEvent.VK_F11
                || ev.getKeyCode() == KeyEvent.VK_F12
                || ev.getKeyCode() == KeyEvent.VK_TAB
                || ev.getKeyCode() == KeyEvent.VK_UP
                || ev.getKeyCode() == KeyEvent.VK_DOWN
                || ev.getKeyCode() == KeyEvent.VK_LEFT
                || ev.getKeyCode() == KeyEvent.VK_RIGHT
                || ev.getKeyCode() == KeyEvent.VK_ALT_GRAPH
                || ev.getKeyCode() == KeyEvent.VK_ALT
                || ev.getKeyCode() == KeyEvent.VK_CONTROL
                || ev.getKeyCode() == KeyEvent.VK_INSERT
                || ev.getKeyCode() == KeyEvent.VK_HOME
                || ev.getKeyCode() == KeyEvent.VK_NUM_LOCK
                || ev.getKeyCode() == KeyEvent.VK_DELETE
                || ev.getKeyCode() == KeyEvent.VK_PRINTSCREEN
                || ev.getKeyCode() == KeyEvent.VK_SCROLL_LOCK
                || ev.getKeyCode() == KeyEvent.VK_PAUSE
                || ev.getKeyCode() == KeyEvent.VK_PAGE_DOWN
                || ev.getKeyCode() == KeyEvent.VK_PAGE_UP
                || ev.getKeyCode() == KeyEvent.VK_END
                || ev.getKeyCode() == KeyEvent.VK_ENTER
                || ev.getKeyCode() == KeyEvent.VK_CAPS_LOCK
                || ev.getKeyCode() == KeyEvent.VK_SHIFT
                || ev.getKeyCode() == KeyEvent.VK_CONTEXT_MENU
                || ev.getKeyCode() == KeyEvent.VK_WINDOWS
                || ev.getKeyCode() == KeyEvent.VK_ESCAPE) {
            return false;
        }
        return true;
    }

    @Override
    public void loadContent() {
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }

    private void addButtonListeners() {
        final JPanelVenda panel = this;
        jButtonCloseSale.addActionListener(new ActionListener(jPanel1) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                ConfirmDialog confirm = new ConfirmDialog(Application.getInstance());
                confirm.setText("Você deseja realmente fechar a venda?<br>Esta ação não pode ser desfeita");
                panel.setEnabled(false);
                confirm.setVisible(true);
                panel.setEnabled(true);
                if (confirm.getResponse()) {
                    log.info("Closing Sale");
                }
            }
        });
        jButtonRemove.addActionListener(new ActionListener(this){

            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                ConfirmDialog confirm = new ConfirmDialog(Application.getInstance());
                confirm.setText("Você deseja realmente remover estes itens?<br>Esta ação não pode ser desfeita");
                panel.setEnabled(false);
                confirm.setVisible(true);
                panel.setEnabled(true);
                if (confirm.getResponse()) {
                    log.info("Removing Itens");
                }
            }
            
        });
        
        jButtonAlterQuantity.addActionListener(new ActionListener(this){

            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                panel.setEnabled(false);
                dialogQuantity.setVisible(true);
                panel.setEnabled(true);
            }
            
        });
    }
}
