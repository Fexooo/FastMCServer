package io.github.fexooo.FastMCServer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class finishwindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finishwindow window = new finishwindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public finishwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFastmcserverSetup = new JLabel("FastMCServer Setup");
		lblFastmcserverSetup.setBounds(0, 0, 450, 30);
		lblFastmcserverSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblFastmcserverSetup.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		frame.getContentPane().add(lblFastmcserverSetup);
		
		JLabel lblSetupFinishedThe = new JLabel("Setup finished! The Server is now created and can be run!");
		lblSetupFinishedThe.setBounds(44, 42, 359, 16);
		frame.getContentPane().add(lblSetupFinishedThe);
		
		JLabel lblErrors = new JLabel("Errors:");
		lblErrors.setBounds(6, 70, 61, 16);
		frame.getContentPane().add(lblErrors);
		
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton.setBounds(6, 243, 438, 29);
		frame.getContentPane().add(btnNewButton);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(6, 91, 438, 140);
		frame.getContentPane().add(editorPane);
		frame.setVisible(true);
		
		editorPane.setText(String.valueOf(downloadwindow.errordownload) + "\n" + String.valueOf(setupram.errorram) + "\n" + String.valueOf(propertieswindow.errorprop) + "\n" + String.valueOf(propertieswindow.errordif) + "\n" + String.valueOf(propertieswindow.errorgm));
		
	}
}
