package ui;

import java.awt.EventQueue;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
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

<<<<<<< HEAD
	        contentPane = new JPanel(new BorderLayout());
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);

	        GridBagLayout gbl_panel = new GridBagLayout();
	        gbl_panel.rowWeights = new double[]{1.0};
	        gbl_panel.columnWeights = new double[]{1.0};
	        JPanel panel = new JPanel(gbl_panel); 
	        contentPane.add(panel, BorderLayout.CENTER);   
	        
	        JPanel panel_1 = new JPanel();
	        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	        gbc_panel_1.fill = GridBagConstraints.BOTH;
	        gbc_panel_1.gridx = 0;
	        gbc_panel_1.gridy = 0;
	        panel.add(panel_1, gbc_panel_1);
	        GridBagLayout gbl_panel_1 = new GridBagLayout();
	        gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	        gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
	        gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	        panel_1.setLayout(gbl_panel_1);
	        
	        JLabel lblNewLabel = new JLabel("New label");
	        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	        gbc_lblNewLabel.gridwidth = 9;
	        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
	        gbc_lblNewLabel.gridx = 0;
	        gbc_lblNewLabel.gridy = 0;
	        panel_1.add(lblNewLabel, gbc_lblNewLabel);
	        
	        JButton btnNewButton = new JButton("New button");
	        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
	        gbc_btnNewButton.gridx = 11;
	        gbc_btnNewButton.gridy = 0;
	        panel_1.add(btnNewButton, gbc_btnNewButton);
	        
	        JLabel lblNewLabel_1 = new JLabel("New label");
	        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	        gbc_lblNewLabel_1.gridwidth = 9;
	        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
	        gbc_lblNewLabel_1.gridx = 0;
	        gbc_lblNewLabel_1.gridy = 1;
	        panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("New label");
	        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	        gbc_lblNewLabel_2.gridwidth = 9;
	        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
	        gbc_lblNewLabel_2.gridx = 0;
	        gbc_lblNewLabel_2.gridy = 2;
	        panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
	        
	        JButton btnNewButton_1 = new JButton("New button");
	        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
	        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
	        gbc_btnNewButton_1.gridx = 11;
	        gbc_btnNewButton_1.gridy = 2;
	        panel_1.add(btnNewButton_1, gbc_btnNewButton_1);
	        
	        table = new JTable();
	        GridBagConstraints gbc_table = new GridBagConstraints();
	        gbc_table.gridheight = 4;
	        gbc_table.gridwidth = 13;
	        gbc_table.insets = new Insets(0, 0, 5, 5);
	        gbc_table.fill = GridBagConstraints.BOTH;
	        gbc_table.gridx = 0;
	        gbc_table.gridy = 3;
	        panel_1.add(table, gbc_table);
=======
	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
>>>>>>> fc02d0aa85506fb6cf8f9b9b5cfe9f677c45307c

	}

}
