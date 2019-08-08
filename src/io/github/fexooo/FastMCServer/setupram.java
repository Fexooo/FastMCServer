package io.github.fexooo.FastMCServer;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

public class setupram {

	private JFrame frame;
	private JTextField textField;
	public static Integer errorram = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("This is not supposed to happen!");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public setupram(String os, boolean sfile, boolean screen) {
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
		lblFastmcserverSetup.setBounds(0, 1, 450, 60);
		lblFastmcserverSetup.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblFastmcserverSetup.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblFastmcserverSetup);
		
		JLabel lblRaminGb = new JLabel("RAM (in GB):");
		lblRaminGb.setBounds(10, 56, 76, 27);
		frame.getContentPane().add(lblRaminGb);
		
		textField = new JTextField();
		textField.setBounds(6, 81, 438, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(0, 199, 444, 35);
		frame.getContentPane().add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(0, 237, 444, 35);
		frame.getContentPane().add(btnCancel);
		
		btnNext.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(os.equalsIgnoreCase("win")) {
					
					List<String> lineswin = Arrays.asList("java -Xmx" + textField.getText() + "G -jar server.jar nogui", "pause");
					Path filewin = Paths.get("start.bat");
					
					try {
						Files.write(filewin, lineswin, StandardCharsets.UTF_8);
						System.out.println("Successfully created start.bat!");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("start.bat could not be created! Redownload Program, check GitHub or contact the Developer, if the Programs still occures!");
						errorram = 33;
					}
					
					frame.dispose();
					
					setup.properties(os, sfile, screen);
					
				} else if(os.equalsIgnoreCase("linux")) {
					
					List<String> lineslinux;
					
					if(screen == true ) {
						
						lineslinux = Arrays.asList("screen -S mc java -Xmx" + textField.getText() + "G -jar server.jar nogui", "pause");
						
					} else {
						
						lineslinux = Arrays.asList("java -Xmx" + textField.getText() + "G -jar server.jar nogui", "pause");
						
					}
					Path filelinux = Paths.get("start.sh");
					
					try {
						Files.write(filelinux, lineslinux, StandardCharsets.UTF_8);
						System.out.println("Successfully created start.sh!");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("start.sh could not be created! Redownload Program, check GitHub or contact the Developer, if the Programs still occures!");
						errorram = 33;
					}
					
					frame.dispose();
					
					setup.properties(os, sfile, screen);
				
				} else {
					
					System.out.println("An unexpected Error occured! Please try redownloading it! If the Problem still occurs, contact the Developer over GitHub!");
					System.out.println("Error Code: 32");
					
					errorram = 32;
					
					frame.dispose();
					
					setup.properties(os, sfile, screen);
					
				}
				
			}          
	      });
		
		btnCancel.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					System.exit(0);
					
			}          
	    });
		
	}

}
