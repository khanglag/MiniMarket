/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.ThuKho;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class MainFrameTest extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public MainFrameTest() {
        setTitle("Main Frame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Price");
        table = new JTable(tableModel);

        JButton selectButton = new JButton("Select Product");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openProductSelectionDialog();
            }
        });

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);
    }

    private void openProductSelectionDialog() {
        ProductSelectionDialog dialog = new ProductSelectionDialog(this);
        dialog.setVisible(true);

        // Nhận thông tin sản phẩm từ dialog và cập nhật bảng ban đầu
        Product selectedProduct = dialog.getSelectedProduct();
        if (selectedProduct != null) {
            Vector<Object> row = new Vector<>();
            row.add(selectedProduct.getName());
            row.add(selectedProduct.getPrice());
            tableModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrameTest mainFrame = new MainFrameTest();
                mainFrame.setVisible(true);
            }
        });
    }
}

class ProductSelectionDialog extends JDialog {
    private Product selectedProduct;

    public ProductSelectionDialog(Frame owner) {
        super(owner, "Select Product", true);
        setSize(300, 200);

        JTable productTable = new JTable();
        DefaultTableModel productTableModel = new DefaultTableModel();
        productTableModel.addColumn("Product Name");
        productTableModel.addColumn("Price");

        // Điền dữ liệu sản phẩm vào bảng
        productTableModel.addRow(new Object[]{"Product 1", 10.0});
        productTableModel.addRow(new Object[]{"Product 2", 20.0});
        productTable.setModel(productTableModel);

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String productName = (String) productTable.getValueAt(selectedRow, 0);
                    double price = (Double) productTable.getValueAt(selectedRow, 1);
                    selectedProduct = new Product(productName, price);
                    setVisible(false);
                }
            }
        });

        add(new JScrollPane(productTable), BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
