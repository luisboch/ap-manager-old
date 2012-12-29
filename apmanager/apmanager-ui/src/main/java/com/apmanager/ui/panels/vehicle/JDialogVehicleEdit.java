/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.panels.vehicle;

import com.apmanager.domain.entity.Vehicle;
import com.apmanager.domain.entity.VehicleBrand;
import com.apmanager.domain.entity.VehicleModel;
import com.apmanager.service.impl.VehicleBrandService;
import com.apmanager.service.impl.VehicleService;
import com.apmanager.ui.components.Button;
import com.apmanager.ui.components.Table;
import com.apmanager.ui.formaters.EntityWrapper;
import com.apmanager.ui.listeners.ActionListener;
import com.apmanager.ui.listeners.MouseListener;
import com.apmanager.ui.panels.AbstractAdminPanel;
import com.apmanager.ui.panels.productbrand.JDialogEdit;
import com.apmanager.ui.panels.vehiclebrand.JDialogVehicleBrandEdit;
import com.towel.el.FieldResolver;
import com.towel.swing.table.ObjectTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author luis
 */
public class JDialogVehicleEdit extends JDialogEdit<Vehicle, VehicleService> {

    private JDialogVehicleBrandEdit brandEdit;
    private JDialogVehicleModelEdit modelEdit;
    private ObjectTableModel<VehicleModel> tableModel;
    private DefaultComboBoxModel<EntityWrapper<VehicleBrand>> brandModel;
    private VehicleBrandService brandService;

    /**
     * Creates new form JDialogVehicleEdit
     */
    public JDialogVehicleEdit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        init();

    }

    public JDialogVehicleEdit(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        init();
    }

    private void init() {

        initComponents();
        configureListener();
        brandService = new VehicleBrandService();

        brandEdit = new JDialogVehicleBrandEdit(this, true);
        modelEdit = new JDialogVehicleModelEdit(this, true);
        brandEdit.setService(brandService);

        brandModel = new DefaultComboBoxModel<>();

        createTableModel();

        jComboBoxBrand.setModel(brandModel);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabelId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxBrand = new javax.swing.JComboBox();
        jButtonAddBrand = new Button(this);
        jTextFieldName = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButtonAddModel = new Button(this);
        jButtonEdit = new Button(this);
        jButtonDel = new Button(this);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableModels = new Table();
        jPanel2 = new javax.swing.JPanel();
        jButtonCancel = new Button(this, KeyEvent.VK_F9);
        jButtonSave = new Button(this, KeyEvent.VK_F8);

        jLabel1.setText("Código:");

        jLabel2.setText("520");

        jLabel3.setText("Nome:");

        jTextField2.setText("General Motors");

        jLabel4.setText("Descrição:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Veículo");
        setMinimumSize(new java.awt.Dimension(889, 596));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Registro"));

        jLabelId.setText("520");

        jLabel8.setText("Descrição:");

        jLabel7.setText("Nome:");

        jLabel9.setText("Marca:");

        jLabel5.setText("ID:");

        jButtonAddBrand.setText("+");
        jButtonAddBrand.setToolTipText("Adicionar Nova Marca");
        jButtonAddBrand.setMaximumSize(new java.awt.Dimension(60, 30));
        jButtonAddBrand.setMinimumSize(new java.awt.Dimension(60, 30));
        jButtonAddBrand.setPreferredSize(new java.awt.Dimension(60, 30));

        jTextFieldName.setText("General Motors");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDescription);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Modelos"));

        jButtonAddModel.setText("Adicionar Modelo");

        jButtonEdit.setText("Editar");

        jButtonDel.setText("Excluir");

        jScrollPane1.setViewportView(jTableModels);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAddModel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDel)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonAddModel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelId)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jComboBoxBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonCancel.setText("Cancelar");

        jButtonSave.setText("Salvar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancel)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonSave))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddBrand;
    private javax.swing.JButton jButtonAddModel;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDel;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxBrand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableModels;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    private void configureListener() {

        final JDialogVehicleEdit dialog = this;
        jButtonAddBrand.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                dialog.setEnabled(false);
                VehicleBrand vehicleBrand = new VehicleBrand();
                brandEdit.setInstance(vehicleBrand);
                brandEdit.setVisible(true);
                brandModel.removeAllElements();
                populateBrands();
                // Se a instancia tem marca seleciona ela, se não seleciona a cadastrada.
                if (instance.getBrand() != null) {
                    brandModel.setSelectedItem(new EntityWrapper<>(instance.getBrand()));
                } else {
                    brandModel.setSelectedItem(new EntityWrapper<>(vehicleBrand));
                }

                dialog.setEnabled(true);
            }
        });

        jButtonAddModel.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                dialog.setEnabled(false);
                VehicleModel newModel = new VehicleModel();
                buildObject();
                newModel.setVehicle(instance);
                modelEdit.setVehicleModel(newModel);
                modelEdit.setEditing(false);
                modelEdit.setVisible(true);

                newModel = modelEdit.getVehicleModel();
                // se não cancelou e cadastrou uma nova marca 
                if (newModel != null) {
                    final List<VehicleModel> data = tableModel.getData();
                    createTableModel();
                    data.add(modelEdit.getVehicleModel());
                    tableModel.setData(data);
                    jTableModels.setModel(tableModel);
                }
                dialog.setEnabled(true);
            }
        });

        jButtonEdit.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                edit(((Table<VehicleModel>) jTableModels).getSelected());
            }
        });

        jTableModels.addMouseListener(new MouseListener(this) {
            @Override
            public void onMouseRelease(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    edit(((Table<VehicleModel>) jTableModels).getSelected());
                }
            }
        });

        jButtonSave.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                save();
            }
        });

        jButtonCancel.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                dialog.setVisible(false);
            }
        });
        jButtonDel.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                dialog.setEnabled(false);
                final List<VehicleModel> vehicleModels = ((Table<VehicleModel>) jTableModels).getSelecteds();
                if (AbstractAdminPanel.falseDelete(vehicleModels)) {
                    List<VehicleModel> data = tableModel.getData();
                    data.removeAll(vehicleModels);
                    createTableModel();
                    tableModel.setData(data);
                    jTableModels.setModel(tableModel);
                }
                dialog.setEnabled(true);
            }
        });
    }

    @Override
    protected void restoreFields(Vehicle instance) {
        createTableModel();
        List<VehicleModel> vehicleModels = instance.getVehicleModels();
        List<VehicleModel> activeModels = new ArrayList<>();
        for (VehicleModel m : vehicleModels) {
            if (m.isActive()) {
                activeModels.add(m);
            }
        }
        tableModel.setData(activeModels);
        jTableModels.setModel(tableModel);
        if (instance.getBrand() != null) {
            brandModel.setSelectedItem(new EntityWrapper<>(instance.getBrand()));
        }
        jTextFieldName.setText(instance.getName());
        jTextAreaDescription.setText(instance.getObservation());
    }

    @Override
    protected Vehicle buildObject() {
        instance.setBrand(((EntityWrapper<VehicleBrand>) brandModel.getSelectedItem()).getEntity());
        instance.setName(jTextFieldName.getText());
        instance.setObservation(jTextAreaDescription.getText());
        instance.setVehicleModels(tableModel.getData());
        return instance;
    }

    @Override
    protected void clear() {
        if (tableModel != null) {
            tableModel.clear();
        }

        if (brandModel != null) {
            brandModel.removeAllElements();
        }
        jTextAreaDescription.setText("");
        jTextFieldName.setText("");
        jLabelId.setText("");
        populateBrands();
    }

    private void populateBrands() {
        List<VehicleBrand> brands = brandService.search("");

        for (VehicleBrand brand : brands) {
            brandModel.addElement(new EntityWrapper<>(brand));
        }

    }

    private void createTableModel() {
        FieldResolver nameResolver = new FieldResolver(VehicleModel.class, "name", "Nome");
        FieldResolver yearResolver = new FieldResolver(VehicleModel.class, "year", "Ano");
        FieldResolver potencyResolver = new FieldResolver(VehicleModel.class, "potency", "Potencia");
        potencyResolver.setFormatter(new com.apmanager.ui.formaters.Float(
                com.apmanager.ui.formaters.Float.SeparatorChar.POINT));


        tableModel = new ObjectTableModel<>(new FieldResolver[]{
                    nameResolver, yearResolver, potencyResolver});
    }

    private void edit(VehicleModel vehicleModel) {
        this.setEnabled(false);
        buildObject();
        modelEdit.setVehicleModel(vehicleModel);
        modelEdit.setEditing(true);
        modelEdit.setVisible(true);

        vehicleModel = modelEdit.getVehicleModel();
        // se não cancelou e cadastrou uma nova marca 
        if (vehicleModel != null) {
            final List<VehicleModel> data = tableModel.getData();
            createTableModel();
            tableModel.setData(data);
            jTableModels.setModel(tableModel);
        }
        this.setEnabled(true);
    }
}
