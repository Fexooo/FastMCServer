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
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class downloadwindow {

	private JFrame frame;
	private JTextField txtYourDownloadLink;
	public static int errordownload = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("This is not supposed to happen :/");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public downloadwindow(String os, boolean sfile, boolean screen) {
		initialize(os, sfile, screen);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String os, boolean sfile, boolean screen) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFastmcserverSetup = new JLabel("FastMCServer Setup");
		lblFastmcserverSetup.setBounds(0, 17, 450, 26);
		lblFastmcserverSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblFastmcserverSetup.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		frame.getContentPane().add(lblFastmcserverSetup);
		
		txtYourDownloadLink = new JTextField();
		txtYourDownloadLink.setText("Your Download Link here...");
		txtYourDownloadLink.setBounds(6, 73, 438, 26);
		frame.getContentPane().add(txtYourDownloadLink);
		txtYourDownloadLink.setColumns(10);
		
		JLabel lblDownloadLink = new JLabel("Download Link:");
		lblDownloadLink.setBounds(10, 55, 98, 16);
		frame.getContentPane().add(lblDownloadLink);
		
		JCheckBox chckbxIHaveMy = new JCheckBox("I have my Server Jar File already!");
		chckbxIHaveMy.setBounds(16, 102, 233, 23);
		frame.getContentPane().add(chckbxIHaveMy);
		
		JButton btnNewButton = new JButton("Download");
		btnNewButton.setBounds(0, 137, 444, 70);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxIHaveMy.isSelected()) {
					
					frame.dispose();
					
					setup.setupfiles(os, sfile, screen);
					
				} else {
					
					System.out.println("Downloading...");
					
					try {
						InputStream in = new URL(txtYourDownloadLink.getText()).openStream();
						Files.copy(in, Paths.get("server.jar"), StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Download finished!");
			
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("A Problem occured! It may be, that the Download Link you provided doesn't work, or something else happened!");
						System.out.println("Check the Download Link and if the Problem still occurs, please contact the developer or visit the GitHub Page of this Program!");
						System.out.println("The Setup will continue now, but the initial Jar File, to start the Server, is missing!");
						System.out.println("Error Code: 20");
						errordownload = 20;
						
					}
					
					frame.dispose();
					setup.setupfiles(os, sfile, screen);
					
				}
			}          
	      });
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(0, 209, 444, 63);
		frame.getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
					System.exit(0);		
			}          
	    });
	}
}
