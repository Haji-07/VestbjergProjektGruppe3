package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.ProductController;
import model.Product;

public class GuiWarehouse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea displayArea;
    private JTextField searchField;
    private ProductController controller;

    public GuiWarehouse() {
        controller = new ProductController();

        setTitle("Warehouse Search Tool");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel mainContent = (JPanel) this.getContentPane();
        mainContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField("Search Function", 20);
        JButton searchButton = new JButton("Search Button");

        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Search Function")) {
                    searchField.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Search Function");
                }
            }
        });

        searchField.addActionListener(e -> performSearch());
        searchButton.addActionListener(e -> performSearch());

        topPanel.add(searchField);
        topPanel.add(searchButton);

        displayArea = new JTextArea();
        displayArea.setText("Searching......\n\nShows product name, quantity, location, model");
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeButton = new JButton("Close Button");
        
        closeButton.addActionListener(e -> System.exit(0));
        
        bottomPanel.add(closeButton);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void performSearch() {
        String barcodeInput = searchField.getText();
        Product p = controller.findProductByBarcode(barcodeInput);

        displayArea.setText("");

        if (p != null) {
            displayArea.append("Name:        " + p.getName() + "\n");
            displayArea.append("Description: " + p.getDescription() + "\n");
            displayArea.append("Category:    " + p.getCategory() + "\n");
            displayArea.append("Model:       " + p.getModel() + "\n");
            displayArea.append("Barcode:     " + p.getBarcode() + "\n");
            displayArea.append("Location:    " + p.getLocation() + "\n");
            displayArea.append("Price: " + p.getPrice() + "       Quantity: " + p.getQuantity() + "\n");
        } else {
            displayArea.append("Product not found with barcode: " + barcodeInput);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GuiWarehouse().setVisible(true);
        });
    }
}