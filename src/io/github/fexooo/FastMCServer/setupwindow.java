package io.github.fexooo.FastMCServer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class setupwindow {

	private JFrame frmFastmcserverSetup;
	private final JCheckBox chckbxNewCheckBox = new JCheckBox("I accept the Minecraft Server Eula!");
	private final JComboBox<String> comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setupwindow window = new setupwindow();
					
					window.frmFastmcserverSetup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public setupwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFastmcserverSetup = new JFrame();
		frmFastmcserverSetup.setVisible(true);
		frmFastmcserverSetup.setResizable(false);
		frmFastmcserverSetup.setTitle("FastMCServer Setup");
		frmFastmcserverSetup.setBounds(100, 100, 450, 300);
		frmFastmcserverSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFastmcserverSetup.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblFastmcserverSetup = new JLabel("FastMCServer Setup");
		lblFastmcserverSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblFastmcserverSetup.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		frmFastmcserverSetup.getContentPane().add(lblFastmcserverSetup);
		frmFastmcserverSetup.getContentPane().add(chckbxNewCheckBox);
		frmFastmcserverSetup.getContentPane().add(comboBox);
		
		JCheckBox chckbxStartFile = new JCheckBox("Start File");
		frmFastmcserverSetup.getContentPane().add(chckbxStartFile);
		
		JCheckBox chckbxScreenInstalledonly = new JCheckBox("Screen installed? (only Linux)");
		frmFastmcserverSetup.getContentPane().add(chckbxScreenInstalledonly);
		
		JButton btnNewButton = new JButton("Next");
		frmFastmcserverSetup.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxNewCheckBox.isSelected() == true) {
					
					if (comboBox.getSelectedItem().equals("Windows")) {
						frmFastmcserverSetup.dispose();
						download.owndl("win", chckbxStartFile.isSelected(), false);
					} else if(comboBox.getSelectedItem().equals("Linux")) {
						frmFastmcserverSetup.dispose();
						
						download.owndl("linux", chckbxStartFile.isSelected(), chckbxScreenInstalledonly.isSelected());
					}
				
				} else {
					
					System.out.println("The Eula has to be accepted!");
					
				}
			}          
	      });
		
		JButton btnCancel = new JButton("Cancel");
		frmFastmcserverSetup.getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
					System.exit(0);		
			}          
	      });
		
		comboBox.addItem("Windows");
		comboBox.addItem("Linux");
		
	}

}
