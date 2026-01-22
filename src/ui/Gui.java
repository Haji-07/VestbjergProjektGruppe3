package ui;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controller.OrderController;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_CustomerId;
	private JTextField textField_Barcode;
	private JTextField textField_Quantity;
	private JTable table;
	private JTextField textField_Total;
	
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
	        
	        JButton btnAddItem = new JButton("ADD Item");
	        GridBagConstraints gbc_btnAddItem = new GridBagConstraints();
	        gbc_btnAddItem.insets = new Insets(0, 0, 0, 5);
	        gbc_btnAddItem.anchor = GridBagConstraints.NORTHWEST;
	        gbc_btnAddItem.gridx = 7;
	        gbc_btnAddItem.gridy = 2;
	        TopPanel.add(btnAddItem, gbc_btnAddItem);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        contentPane.add(scrollPane, BorderLayout.CENTER);
	        
	        table = new JTable();
	        table.setFillsViewportHeight(true);
	        scrollPane.setViewportView(table);
	        
	        JPanel BottomPanel = new JPanel();
	        BottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	        contentPane.add(BottomPanel, BorderLayout.SOUTH);
	        BottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	        
	        JButton btnSaveOrder = new JButton("Save Order");
	        btnSaveOrder.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
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

}
}