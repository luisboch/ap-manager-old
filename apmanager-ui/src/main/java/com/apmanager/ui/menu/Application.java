/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.menu;

import com.apmanager.ui.menu.enums.WindowType;
import com.apmanager.ui.panels.AdminPanel;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
//import org.java.ayatana.ApplicationMenu;

/**
 *
 * @author ADMIN
 */
public class Application extends javax.swing.JFrame {

    private static final Logger log = Logger.getLogger(Application.class.getSimpleName());
    
    private static Application instance;

    private JMenuDinamic selected;

    private final JDialogLoading loading = new JDialogLoading(this);
    
    private Application() {
        initComponents();

        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        configureListeners();

        configureIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanelRootPane = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVenda = new javax.swing.JMenu();
        jMenuItem4 = new JMenuDinamic(this, WindowType.SALE);
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new JMenuDinamic(this, WindowType.SALES_SEARCH);
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new JMenuDinamic(this, WindowType.PRODUCT_CRUD);
        jMenuItem9 = new JMenuDinamic(this, WindowType.VEHICLE_CRUD);
        jMenuItemProductBrand =  new JMenuDinamic(this, WindowType.PRODUCT_BRAND_CRUD);
        jMenuItem7 = new JMenuDinamic(this, WindowType.VEHICLE_BRAND_CRUD);
        jMenuItem8 = new JMenuDinamic(this, WindowType.SHELF_CRUD);

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelRootPane.setLayout(new java.awt.BorderLayout());

        jLabelTitle.setFont(new java.awt.Font("Abyssinica SIL", 1, 14)); // NOI18N
        jPanel1.add(jLabelTitle);

        jMenuVenda.setText("Vendas");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem4.setText("Venda");
        jMenuVenda.add(jMenuItem4);

        jMenuBar1.add(jMenuVenda);

        jMenu4.setText("Administração");

        jMenuItem6.setText("Vendas");
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Cadastros");

        jMenuItem10.setText("Produtos");
        jMenu3.add(jMenuItem10);

        jMenuItem9.setText("Veiculos");
        jMenu3.add(jMenuItem9);

        jMenuItemProductBrand.setText("Marcas de Produtos");
        jMenu3.add(jMenuItemProductBrand);

        jMenuItem7.setText("Marcas de Veículos");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Prateleiras");
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanelRootPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRootPane, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemProductBrand;
    private javax.swing.JMenu jMenuVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelRootPane;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    // End of variables declaration//GEN-END:variables

    private void configureListeners() {
        InputMap iMap = jMenuBar1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        Object action = iMap.get(KeyStroke.getKeyStroke("F10"));
        ActionMap actionMap = jMenuBar1.getActionMap();
        actionMap.getParent().remove(action);
    }

    public JMenuDinamic getSelected() {
        return selected;
    }

    public void setSelected(JMenuDinamic selected) {
        this.selected = selected;
    }

    void setApplicationPanel(final JPanel panel) {
        if (this.jPanelRootPane.getComponents().length > 0) {
            this.jPanelRootPane.getComponent(0).setVisible(false);
        }
        this.jPanelRootPane.removeAll();
        this.jPanelRootPane.add(panel, java.awt.BorderLayout.CENTER);
        final Application frame = this;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                AdminPanel admPanel = (AdminPanel) panel;
                admPanel.loadContent();
            }
        };

        loading.action(runnable);
        loading.setVisible(true);

        frame.jPanelRootPane.getRootPane().revalidate();
        frame.jPanelRootPane.getRootPane().repaint();
        panel.setVisible(true);
        frame.revalidate();
        frame.repaint();
        log.log(
                Level.INFO, "panel '{'{0}'}' has add", panel.toString());
    }

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    private void configureIcon() {
        URL url = getClass().getResource("/autopecas/images/1352068202_applications-accessories.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        setIconImage(img);
        
        // Integrate to Unity menubar.
        try{
            //ApplicationMenu.tryInstall(this);
        }catch(Throwable e){
            log.log(Level.INFO, "Error on integrate to Ubuntu Unity: {0}",
                    e.getMessage());
        }
    }

    @Override
    public void setTitle(String title) {
        super.setTitle("APManager - " + title);
        jLabelTitle.setText(title);
    }
}
