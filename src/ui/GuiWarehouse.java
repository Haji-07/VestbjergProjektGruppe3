package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import controller.ProductController;
import model.Product;

public class GuiWarehouse extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPanel;

    private JTextField txtBarcode;
    private JTextArea txtResult;

    private JButton searchButton;

    private ProductController controller;

    public GuiWarehouse() {
        this.controller = new ProductController();

        setTitle("Warehouse Search");
        setBounds(100, 100, 500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPanel.setLayout(new BorderLayout(10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        createTitle();
        createCenter();
        createButtons();
    }

    private void createTitle() {
        JLabel lblTitle = new JLabel("Search Product by Barcode");
        contentPanel.add(lblTitle, BorderLayout.NORTH);
    }

    private void createCenter() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        contentPanel.add(panel, BorderLayout.CENTER);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblBarcode = new JLabel("Barcode");
        txtBarcode = new JTextField(20);

        searchPanel.add(lblBarcode);
        searchPanel.add(txtBarcode);

        panel.add(searchPanel, BorderLayout.NORTH);

        txtResult = new JTextArea();
        txtResult.setEditable(false);
        txtResult.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtResult.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JScrollPane scrollPane = new JScrollPane(txtResult);
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    private void createButtons() {
        JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchClicked());
        buttonPane.add(searchButton);
        getRootPane().setDefaultButton(searchButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            setVisible(false);
            dispose();
        });
        buttonPane.add(closeButton);
    }

    private void searchClicked() {
        String barcode = txtBarcode.getText();
        Product p = controller.findProductByBarcode(barcode);

        if (p == null) {
            txtResult.setText("Product not found with barcode: " + barcode);
            return;
        }

        txtResult.setText(formatProduct(p));
    }

    private String formatProduct(Product p) {
        return
            "Name:        " + p.getName() + "\n" +
            "Description: " + p.getDescription() + "\n" +
            "Category:    " + p.getCategory() + "\n" +
            "Model:       " + p.getModel() + "\n" +
            "Barcode:     " + p.getBarcode() + "\n" +
            "Location:    " + p.getLocation() + "\n" +
            "Price:       " + p.getPrice() + "\n" +
            "Quantity:    " + p.getQuantity();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GuiWarehouseOther().setVisible(true);
        });
    }
}
