/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazGrafica;

import Data.Producto;
import Data.Serializador;
import EstructurasCorte3.ChainingHashTableString;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Estructure_LinkedList.LinkedList;
import Trees.AVLTree;
import Trees.NodoAVL;
import java.awt.Color;
import java.awt.Font;
//import java.util.HashMap;
//import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author die_a
 */
public class MenuProductosAVL extends javax.swing.JFrame {
    private DoubleLinkedList<Producto> listaProductos;
    //private Map<String, String> productEmailMap = new HashMap<>();
    private ChainingHashTableString<String> productEmailMap = new ChainingHashTableString<>(10);
    private int selectedRow = -1;
    private DefaultTableModel mt = new DefaultTableModel();
    private AVLTree avlTree;
    /**
     * Creates new form MenuProductosAVL
     */
    public MenuProductosAVL() {
        initComponents();
        applyCustomDesign();
        listaProductos = Serializador.deserializarObjeto("productos.dat");
     
        // Copia la lista original al inicio de tu aplicación
        avlTree = new AVLTree();
        // Recorre la lista de productos y agrégalos al árbol AVL
            for (int i = 0; i < listaProductos.size(); i++) {
                Producto producto = listaProductos.get(i);
                avlTree.root = avlTree.insert(avlTree.root, producto);
                String nombre = producto.getNameProduct();
                String email=producto.getEmailDonor();
                productEmailMap.insert(nombre, email);
            }
            // Asegúrate de que el árbol se mantenga equilibrado
            avlTree.root = avlTree.rebalance(avlTree.root);
            
            String ids[] = {"Nombre", "Categoría", "Cantidad", "Expiración", "Seleccionar"};
        mt = new DefaultTableModel(ids, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) {
                    return Boolean.class;
                }
                return Object.class;
            }
        };
        // Agrega los productos del árbol AVL a la tabla
        addAVLTreeElementsToTable(avlTree.root, mt);
        jTable1.setModel(mt);
        
        // Configurar el renderizador y editor para la columna de casillas de verificación
        addCheckBox(4, jTable1);
        // Añade un listener para manejar la selección de productos
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                selectedRow = jTable1.getSelectedRow();
                // Aquí puedes realizar acciones en función de la selección de productos
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_botton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Productos por Fecha Vencimiento");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Productos por Fecha Vencimiento");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Productos por Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(555, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(90, 213, 198));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Categoría", "Cantidad", "Expiracion"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        txt_botton.setBackground(new java.awt.Color(0, 102, 102));
        txt_botton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_botton.setForeground(new java.awt.Color(255, 255, 255));
        txt_botton.setText("Apartar");
        txt_botton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bottonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Restaurar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Productos por Nombre");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ordenar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(11, 11, 11))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setText("Buscar:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 84, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_botton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(71, 71, 71))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_botton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 624, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bottonActionPerformed
        // TODO add your handling code here:
        int selectedCount = 0;
        int selectedProductIndex = -1;
        String selectedProductName = null;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if ((Boolean) jTable1.getValueAt(i, 4)) {
                selectedCount++;
                selectedProductIndex = i;
                selectedProductName = (String) jTable1.getValueAt(i, 0);
            }
        }

        if (selectedCount == 0) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún producto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (selectedCount > 1) {
            JOptionPane.showMessageDialog(this, "Solo se permite seleccionar un producto a la vez.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Obtén el correo electrónico asociado al producto seleccionado
            String selectedProductEmail = productEmailMap.find(selectedProductName);

            // Muestra la información del producto seleccionado y el correo electrónico
            System.out.println("Producto seleccionado: " + selectedProductName);
            System.out.println("Correo electrónico del donador: " + selectedProductEmail);
            JOptionPane.showMessageDialog(this, "Producto '" + selectedProductName + "' apartado con éxito. Contacta a " + selectedProductEmail+" que fue el donador", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Actualiza la cantidad de productos en la lista
            listaProductos.removeProductByQuantity(selectedProductName);

            // Actualiza la tabla jTable1
            int selectedProductIndex2 = -1;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (selectedProductName.equals((String) jTable1.getValueAt(i, 0))) {
                    selectedProductIndex2 = i;
                    break;
                }
            }

            if (selectedProductIndex2 != -1) {
                int currentQuantity = (int) jTable1.getValueAt(selectedProductIndex2, 2);
                if (currentQuantity > 1) {
                    jTable1.setValueAt(currentQuantity - 1, selectedProductIndex2, 2);
                } else {
                    mt.removeRow(selectedProductIndex2);
                }
            }

            Serializador.serializarObjeto(listaProductos, "productos.dat");

            // Agrega aquí la lógica adicional que desees para el producto seleccionado
        }
        
    }//GEN-LAST:event_txt_bottonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MenuBeneficiario menuben=new MenuBeneficiario();
        menuben.setSize(1100, 730);  // Establece las dimensiones fijas (ancho x alto) que desees
        menuben.setLocationRelativeTo(null);
        menuben.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
         // Obtiene el texto ingresado por el usuario en el JTextField
    String searchTerm = jTextField1.getText().trim();

    // Limpia la tabla actual
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);

    boolean productsFound = false; // Variable para rastrear si se encontraron productos

    // Verifica si el término de búsqueda no está vacío
    if (!searchTerm.isEmpty()) {
        // Recorre el árbol AVL y agrega los productos que coinciden con el término de búsqueda
        productsFound = addProductsBySearchTerm(avlTree.root, model, searchTerm);
    }

    // Muestra un mensaje si no se encontraron productos
    if (!productsFound) {
        JOptionPane.showMessageDialog(this, "No se encontraron productos que coincidan con la búsqueda.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        initializeTableWithOriginalData();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuProductosAVL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuProductosAVL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuProductosAVL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuProductosAVL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuProductosAVL().setVisible(true);
            }
        });
    }
    
    public void addCheckBox(int column, JTable table) {
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
    }

    public boolean isSelected(int row, int column, JTable table) {
        Boolean s = (Boolean) table.getValueAt(row, column);
        return s != null && s;
    }

    public int checkSelectedProducts() {
        int selectedCount = 0;

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            if (isSelected(i, 4, jTable1)) {
                selectedCount++;
            }
        }

        if (selectedCount == 0) {
            JOptionPane.showMessageDialog(this, "No has seleccionado ningún producto.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (selectedCount > 2) {
            JOptionPane.showMessageDialog(this, "Solo se permite seleccionar un máximo de dos productos a la vez.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Realiza acciones con los productos seleccionados
            System.out.println("Productos seleccionados:");
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (isSelected(i, 4, jTable1)) {
                    String nombre = (String) jTable1.getValueAt(i, 0);
                    String categoria = (String) jTable1.getValueAt(i, 1);
                    int cantidad = (int) jTable1.getValueAt(i, 2);
                    String diaVencimiento = (String) jTable1.getValueAt(i, 3);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Categoría: " + categoria);
                    System.out.println("Cantidad: " + cantidad);
                    System.out.println("Expiración: " + diaVencimiento);
                }
            }
        }

        return selectedCount;
    }
    
    private void addAVLTreeElementsToTable(NodoAVL node, DefaultTableModel model) {
    if (node != null) {
        addAVLTreeElementsToTable(node.izquierdo, model); // Recorre el subárbol izquierdo

        Producto product = node.producto;
        // Agrega el producto a la tabla
        model.addRow(new Object[]{
            product.getNameProduct(),
            product.getTypeProduct(),
            product.getQuantity(),
            product.getExpirationDate(),
            false
        });

        addAVLTreeElementsToTable(node.derecho, model); // Recorre el subárbol derecho
    }
}
    
private boolean addProductsBySearchTerm(NodoAVL node, DefaultTableModel model, String searchTerm) {
    boolean productsFound = false; // Variable para rastrear si se encontraron productos

    if (node != null) {
        productsFound |= addProductsBySearchTerm(node.izquierdo, model, searchTerm);

        Producto product = node.producto;
        // Si el nombre del producto contiene el término de búsqueda (ignorando mayúsculas y minúsculas)
        if (product.getNameProduct().toLowerCase().contains(searchTerm.toLowerCase())) {
            model.addRow(new Object[]{
                product.getNameProduct(),
                product.getTypeProduct(),
                product.getQuantity(),
                product.getExpirationDate(),
                false
            });
            productsFound = true; // Se encontró al menos un producto
        }

        productsFound |= addProductsBySearchTerm(node.derecho, model, searchTerm);
    }

    return productsFound;
}

public void initializeTableWithOriginalData() {
    // Copia la lista original al inicio de tu aplicación
    listaProductos = Serializador.deserializarObjeto("productos.dat");

    avlTree = new AVLTree();
    // Recorre la lista de productos y agrégalos al árbol AVL
    for (int i = 0; i < listaProductos.size(); i++) {
        Producto producto = listaProductos.get(i);
        avlTree.root = avlTree.insert(avlTree.root, producto);
        String nombre = producto.getNameProduct();
        String email = producto.getEmailDonor();
        productEmailMap.insert(nombre, email);
    }
    // Asegúrate de que el árbol se mantenga equilibrado
    avlTree.root = avlTree.rebalance(avlTree.root);

    String ids[] = {"Nombre", "Categoría", "Cantidad", "Expiración", "Seleccionar"};
    mt = new DefaultTableModel(ids, 0) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 4) {
                return Boolean.class;
            }
            return Object.class;
        }
    };
    
    // Agrega los productos del árbol AVL a la tabla
    addAVLTreeElementsToTable(avlTree.root, mt);
    jTable1.setModel(mt);
}

   private void applyCustomDesign() {
    // Configuración de diseño de la tabla
    jTable1.setBackground(new Color(255, 255, 255));
    jTable1.setForeground(new Color(0, 0, 0));
    jTable1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

    // Configurar la alineación del texto en las celdas
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    jTable1.setDefaultRenderer(Object.class, centerRenderer);

    // Configuración del borde y espaciado entre celdas
    jTable1.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102), 2));
    jTable1.setRowHeight(30);

    // Configuración de los encabezados de la tabla
    JTableHeader header = jTable1.getTableHeader();
    header.setBackground(new Color(0, 102, 102));
    header.setForeground(Color.BLACK);
    header.setFont(new Font("Segoe UI", Font.BOLD, 18));

    // Configuración de diseño de las casillas de verificación
    UIManager.put("CheckBox.font", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("CheckBox.foreground", new Color(0, 0, 0));

    // Configuración de diseño de los botones
    txt_botton.setBackground(new Color(0, 102, 102));
    txt_botton.setForeground(Color.WHITE);
    txt_botton.setFont(new Font("Segoe UI", Font.BOLD, 16));
    txt_botton.setFocusPainted(false); // Quitar el borde de enfoque

    //jButton1.setBackground(new Color(0, 102, 102));
    jButton1.setForeground(Color.WHITE);
    jButton1.setFont(new Font("Segoe UI", Font.BOLD, 16));
    jButton1.setFocusPainted(false); // Quitar el borde de enfoque

    // Agregar efecto de resaltado al pasar el ratón sobre la tabla
    jTable1.setSelectionBackground(new Color(0, 102, 102));
    jTable1.setSelectionForeground(Color.WHITE);
    jTable1.setShowGrid(true);
    jTable1.setGridColor(new Color(0, 102, 102));
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton txt_botton;
    // End of variables declaration//GEN-END:variables
}
