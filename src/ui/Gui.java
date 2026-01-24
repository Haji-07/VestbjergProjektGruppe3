package ui;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.OrderController;
import javax.swing.table.DefaultTableModel;


public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_CustomerId;
	private JTextField textField_Barcode;
	private JTextField textField_Quantity;
	private JTable table;
	private JTextField textField_Total;
	private DefaultTableModel tableModel;
	private OrderController orderController;


	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 public Gui() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 450, 300);

	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(new BorderLayout(0, 0));
	        
	        orderController = new OrderController();
	        orderController.createOrder();
	        System.out.println("Order created? " + (orderController.getOrder() != null));

	        
	        JPanel TopPanel = new JPanel();
	        contentPane.add(TopPanel, BorderLayout.NORTH);
	        GridBagLayout gbl_TopPanel = new GridBagLayout();
	        gbl_TopPanel.columnWidths = new int[]{60, 86, 0, 65, 82, 86, 42, 86, 79, 0};
	        gbl_TopPanel.rowHeights = new int[]{23, 0, 0, 0};
	        gbl_TopPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	        gbl_TopPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	        TopPanel.setLayout(gbl_TopPanel);
	        
	        JLabel lblCustomerId = new JLabel("Customer ID");
	        GridBagConstraints gbc_lblCustomerId = new GridBagConstraints();
	        gbc_lblCustomerId.insets = new Insets(5, 5, 5, 5);
	        gbc_lblCustomerId.gridx = 0;
	        gbc_lblCustomerId.gridy = 0;
	        TopPanel.add(lblCustomerId, gbc_lblCustomerId);
	        
	        textField_CustomerId = new JTextField();
	        GridBagConstraints gbc_textField_CustomerId = new GridBagConstraints();
	        gbc_textField_CustomerId.gridwidth = 6;
	        gbc_textField_CustomerId.weightx = 1.0;
	        gbc_textField_CustomerId.fill = GridBagConstraints.HORIZONTAL;
	        gbc_textField_CustomerId.anchor = GridBagConstraints.WEST;
	        gbc_textField_CustomerId.insets = new Insets(5, 5, 5, 5);
	        gbc_textField_CustomerId.gridx = 1;
	        gbc_textField_CustomerId.gridy = 0;
	        TopPanel.add(textField_CustomerId, gbc_textField_CustomerId);
	        textField_CustomerId.setColumns(10);
	        
	        JButton btnCustomerId = new JButton("Search");
	        GridBagConstraints gbc_btnCustomerId = new GridBagConstraints();
	        gbc_btnCustomerId.anchor = GridBagConstraints.NORTHWEST;
	        gbc_btnCustomerId.insets = new Insets(5, 5, 5, 5);
	        gbc_btnCustomerId.gridx = 7;
	        gbc_btnCustomerId.gridy = 0;
	        TopPanel.add(btnCustomerId, gbc_btnCustomerId);
	        
	        btnCustomerId.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		orderController.createAndAddWalkInCustomerToOrder();
	        		
	        		JOptionPane.showMessageDialog(
	        				Gui.this,
	        				"Customer oprettet og tilføjet til ordren."
	        				);
	        		textField_CustomerId.setEditable(false);
	        		btnCustomerId.setEnabled(false);
	        	}
	        });
	        
	        JLabel lblBarcode = new JLabel("Product Barcode ");
	        GridBagConstraints gbc_lblBarcode = new GridBagConstraints();
	        gbc_lblBarcode.insets = new Insets(0, 0, 5, 5);
	        gbc_lblBarcode.gridx = 0;
	        gbc_lblBarcode.gridy = 1;
	        TopPanel.add(lblBarcode, gbc_lblBarcode);
	        
	        JLabel lblQuantity = new JLabel("Quantity");
	        GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
	        gbc_lblQuantity.insets = new Insets(0, 0, 0, 5);
	        gbc_lblQuantity.gridx = 0;
	        gbc_lblQuantity.gridy = 2;
	        TopPanel.add(lblQuantity, gbc_lblQuantity);
	        
	        textField_Quantity = new JTextField();
	        GridBagConstraints gbc_textField_Quantity = new GridBagConstraints();
	        gbc_textField_Quantity.gridwidth = 6;
	        gbc_textField_Quantity.weightx = 1.0;
	        gbc_textField_Quantity.fill = GridBagConstraints.HORIZONTAL;
	        gbc_textField_Quantity.anchor = GridBagConstraints.WEST;
	        gbc_textField_Quantity.insets = new Insets(5, 5, 5, 5);
	        gbc_textField_Quantity.gridx = 1;
	        gbc_textField_Quantity.gridy = 2;
	        TopPanel.add(textField_Quantity, gbc_textField_Quantity);
	        textField_Quantity.setColumns(10);
	        
	        textField_Barcode = new JTextField();
	        GridBagConstraints gbc_textField_Barcode = new GridBagConstraints();
	        gbc_textField_Barcode.gridwidth = 6;
	        gbc_textField_Barcode.weightx = 1.0;
	        gbc_textField_Barcode.fill = GridBagConstraints.HORIZONTAL;
	        gbc_textField_Barcode.anchor = GridBagConstraints.WEST;
	        gbc_textField_Barcode.insets = new Insets(5, 5, 5, 5);
	        gbc_textField_Barcode.gridx = 1;
	        gbc_textField_Barcode.gridy = 1;
	        TopPanel.add(textField_Barcode, gbc_textField_Barcode);
	        textField_Barcode.setColumns(10);
	        
	        JButton btnAddItem = new JButton("Add Item");
	        GridBagConstraints gbc_btnAddItem = new GridBagConstraints();
	        gbc_btnAddItem.insets = new Insets(0, 0, 0, 5);
	        gbc_btnAddItem.anchor = GridBagConstraints.NORTHWEST;
	        gbc_btnAddItem.gridx = 7;
	        gbc_btnAddItem.gridy = 2;
	        TopPanel.add(btnAddItem, gbc_btnAddItem);
	        
	        TopPanel.add(btnAddItem, gbc_btnAddItem);

	        btnAddItem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String barcode = textField_Barcode.getText().trim();
	                String qtyText = textField_Quantity.getText().trim();

	                if (barcode.isEmpty() || qtyText.isEmpty()) {
	                    JOptionPane.showMessageDialog(Gui.this, "Udfyld både barcode og quantity.");
	                    return;
	                }

	                int qty;
	                try {
	                    qty = Integer.parseInt(qtyText);
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(Gui.this, "Quantity skal være et tal.");
	                    return;
	                }

	                if (qty <= 0) {
	                    JOptionPane.showMessageDialog(Gui.this, "Quantity skal være større end 0.");
	                    return;
	                }

	                orderController.addProductToOrder(barcode, qty);

	             // Hvis barcode ikke findes, sker der intet fordi controller tjekker p != null
	             // Så denne kan tjekke om der kom en ny line:
	             refreshTableAndTotal();

	                textField_Barcode.setText("");
	                textField_Quantity.setText("");
	                textField_Barcode.requestFocus();
	            }
	        });

	        
	        JScrollPane scrollPane = new JScrollPane();
	        contentPane.add(scrollPane, BorderLayout.CENTER);
	        
	        tableModel = new DefaultTableModel(
	        	    new Object[]{"Barcode", "Name", "Quantity", "Unit price", "Line total"}, 0
	        	) {
	        	    @Override
	        	    public boolean isCellEditable(int row, int column) {
	        	        return false;
	        	    }
	        	};

	        	table = new JTable(tableModel);
	        	table.setFillsViewportHeight(true);
	        	scrollPane.setViewportView(table);

	        
	        JPanel BottomPanel = new JPanel();
	        BottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	        contentPane.add(BottomPanel, BorderLayout.SOUTH);
	        BottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	        
	        JButton btnSaveOrder = new JButton("Save Order");
	        btnSaveOrder.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		orderController.saveOrder();
	        		
	        		JOptionPane.showMessageDialog(Gui.this, "Order Saved.");
	        		
	        		orderController.createOrder();
	        		
	        		tableModel.setRowCount(0);
	        		textField_Total.setText("");
	        		
	        		textField_CustomerId.setEditable(true);
	        		btnCustomerId.setEnabled(true);
	        		textField_CustomerId.setText("");
	        	}
	        });
	        btnSaveOrder.setHorizontalAlignment(SwingConstants.LEFT);
	        BottomPanel.add(btnSaveOrder);
	        
	        JLabel lblTotal = new JLabel("Total:");
	        BottomPanel.add(lblTotal);
	        
	        textField_Total = new JTextField();
	        textField_Total.setHorizontalAlignment(SwingConstants.RIGHT);
	        textField_Total.setEditable(false);
	        BottomPanel.add(textField_Total);
	        textField_Total.setColumns(10);
	        
	        JButton btnExit = new JButton("Exit");
	        BottomPanel.add(btnExit);
	        btnExit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose(); 
	            }
	        });
}
	 private void refreshTableAndTotal() {
		 tableModel.setRowCount(0);
		 
		 for (model.OrderLine line : orderController.getOrder().getOrderLines()) {
			 model.Product p = line.getProduct();
			 
			 String barcode = p.getBarcode();
			 String name = p.getName();
			 int qty= line.getQuantity();
			 double unitPrice =p.getPrice();
			 double lineTotal = line.calculateTotal();
			 
			 tableModel.addRow(new Object[] {barcode, name, qty, unitPrice, lineTotal });
		 }
		 double total = orderController.calculateOrderTotal();
		 textField_Total.setText(String.format("%.2f", total));
	 }
	 
}