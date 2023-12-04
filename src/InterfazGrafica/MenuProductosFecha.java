/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazGrafica;

import Data.Producto;
import Data.Serializador;
import EstructurasCorte3.ChainingHashTableString;
import Estructure_DoubleLinkedList.DoubleLinkedList;
import Trees.AVLTree;
import Trees.BinaryHeap;
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
public class MenuProductosFecha extends javax.swing.JFrame {
    private DefaultTableModel mt = new DefaultTableModel();
    private int selectedRow = -1;
    private DoubleLinkedList<Producto> listaProductos;
    //private Map<String, String> productEmailMap = new HashMap<>(); // Asocia nombres de productos con correos electrónicos
    private ChainingHashTableString<String> productEmailMap = new ChainingHashTableString<>(10);
    /**
     * Creates new form MenuProductosFecha
     */
    public MenuProductosFecha() {
        //BinaryHeap hc=new BinaryHeap();
        initComponents();
        applyCustomDesign();
        listaProductos = Serializador.deserializarObjeto("productos.dat");
        BinaryHeap hc=new BinaryHeap();
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto producto = listaProductos.get(i);
            String nombre = producto.getNameProduct();
            String email=producto.getEmailDonor();
            productEmailMap.insert(nombre, email);

            if (producto instanceof Producto) {
                Producto comida = (Producto) producto; // Realiza un casting a Comida
                hc.insert(comida); // Agrega la comida a la pila prioritaria
                
            }
        }
        //hc.printHeap();
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
        jTable1.setModel(mt);
        
        // Configurar el renderizador y editor para la columna de casillas de verificación
        addCheckBox(4, jTable1);
        
        
        // Agrega los productos de la cola prioritaria a la tabla
        while (!hc.isEmpty()) {
            Producto producto = hc.deleteMin(); // Extrae el producto con la mayor prioridad
            // Agrega el producto a la tabla
            mt.addRow(new Object[]{producto.getNameProduct(), producto.getTypeProduct(), producto.getQuantity(), producto.getExpirationDate(), false});
        }

        jTable1.setModel(mt);

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_botton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Productos por Fecha Vencimiento");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calendario.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(359, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_botton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_botton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
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
                .addGap(0, 625, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
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
            java.util.logging.Logger.getLogger(MenuProductosFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuProductosFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuProductosFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuProductosFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuProductosFecha().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton txt_botton;
    // End of variables declaration//GEN-END:variables
}
