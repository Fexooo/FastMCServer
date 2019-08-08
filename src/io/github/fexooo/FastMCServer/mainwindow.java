package io.github.fexooo.FastMCServer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class mainwindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainwindow window = new mainwindow();
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
	public mainwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblFastmcserver = new JLabel("FastMCServer");
		lblFastmcserver.setHorizontalAlignment(SwingConstants.CENTER);
		lblFastmcserver.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		frame.getContentPane().add(lblFastmcserver, BorderLayout.NORTH);
		
		JButton btnCreateANew = new JButton("Create a new Server");
		frame.getContentPane().add(btnCreateANew, BorderLayout.CENTER);
		
		btnCreateANew.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
					setupwindow setupwin = new setupwindow();	
					frame.dispose();
			}          
	      });
		
		JButton btnEditAnExisting = new JButton("Edit an existing Server");
		frame.getContentPane().add(btnEditAnExisting, BorderLayout.SOUTH);
	}

}
