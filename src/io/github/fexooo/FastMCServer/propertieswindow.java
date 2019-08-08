package io.github.fexooo.FastMCServer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class propertieswindow {

	private JFrame frame;
	private JTextField sp;
	private JTextField maxp;
	private JTextField ip;
	private JTextField mbh;
	private JTextField seed;
	private String gm;
	private String difstring;
	public static Integer errorprop = 0;
	public static Integer errorgm = 0;
	public static Integer errordif = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					propertieswindow window = new propertieswindow();
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
	public propertieswindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblFastmcserverSetup = new JLabel("FastMCServer Setup");
		lblFastmcserverSetup.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblFastmcserverSetup.setBounds(111, 6, 229, 30);
		frame.getContentPane().add(lblFastmcserverSetup);
		
		JLabel lblSpawnProtection = new JLabel("Spawn Protection");
		lblSpawnProtection.setBounds(6, 47, 108, 16);
		frame.getContentPane().add(lblSpawnProtection);
		
		JLabel lblNether = new JLabel("Nether");
		lblNether.setBounds(6, 91, 42, 16);
		frame.getContentPane().add(lblNether);
		
		JLabel lblGamemode = new JLabel("Gamemode");
		lblGamemode.setBounds(6, 138, 70, 16);
		frame.getContentPane().add(lblGamemode);
		
		JLabel lblMonster = new JLabel("Monster");
		lblMonster.setBounds(6, 188, 51, 16);
		frame.getContentPane().add(lblMonster);
		
		JLabel lblPvp = new JLabel("PVP");
		lblPvp.setBounds(6, 245, 61, 16);
		frame.getContentPane().add(lblPvp);
		
		JLabel lblHardcore = new JLabel("Hardcore");
		lblHardcore.setBounds(6, 301, 61, 16);
		frame.getContentPane().add(lblHardcore);
		
		JLabel lblCommandBlocks = new JLabel("Command Blocks");
		lblCommandBlocks.setBounds(6, 354, 119, 16);
		frame.getContentPane().add(lblCommandBlocks);
		
		JLabel lblMaximumPlayers = new JLabel("Maximum Players");
		lblMaximumPlayers.setBounds(259, 47, 119, 16);
		frame.getContentPane().add(lblMaximumPlayers);
		
		JLabel lblCustomIp = new JLabel("Custom IP");
		lblCustomIp.setBounds(258, 91, 70, 16);
		frame.getContentPane().add(lblCustomIp);
		
		JLabel lblNpc = new JLabel("NPC");
		lblNpc.setBounds(259, 138, 26, 16);
		frame.getContentPane().add(lblNpc);
		
		JLabel lblAnimals = new JLabel("Animals");
		lblAnimals.setBounds(259, 188, 61, 16);
		frame.getContentPane().add(lblAnimals);
		
		JLabel lblStructures = new JLabel("Structures");
		lblStructures.setBounds(259, 245, 70, 16);
		frame.getContentPane().add(lblStructures);
		
		JLabel lblOnlineMode = new JLabel("Online Mode");
		lblOnlineMode.setBounds(259, 301, 79, 16);
		frame.getContentPane().add(lblOnlineMode);
		
		JLabel lblMaximumBuildHeight = new JLabel("Maximum Build Height");
		lblMaximumBuildHeight.setBounds(259, 354, 143, 16);
		frame.getContentPane().add(lblMaximumBuildHeight);
		
		JLabel lblSeed = new JLabel("Seed");
		lblSeed.setBounds(6, 407, 29, 16);
		frame.getContentPane().add(lblSeed);
		
		sp = new JTextField();
		sp.setBounds(6, 64, 130, 26);
		frame.getContentPane().add(sp);
		sp.setColumns(10);
		
		JCheckBox na = new JCheckBox("Allowed");
		na.setBounds(6, 110, 91, 23);
		frame.getContentPane().add(na);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(7, 157, 127, 27);
		frame.getContentPane().add(comboBox);
		
		JCheckBox ms = new JCheckBox("Spawn");
		ms.setBounds(7, 209, 128, 23);
		frame.getContentPane().add(ms);
		
		JCheckBox pvpa = new JCheckBox("Allowed");
		pvpa.setBounds(6, 266, 128, 23);
		frame.getContentPane().add(pvpa);
		
		JCheckBox ha = new JCheckBox("Enabled");
		ha.setBounds(7, 323, 128, 23);
		frame.getContentPane().add(ha);
		
		JCheckBox cba = new JCheckBox("Enabled");
		cba.setBounds(6, 372, 128, 23);
		frame.getContentPane().add(cba);
		
		maxp = new JTextField();
		maxp.setBounds(259, 64, 119, 26);
		frame.getContentPane().add(maxp);
		maxp.setColumns(10);
		
		ip = new JTextField();
		ip.setBounds(259, 109, 130, 26);
		frame.getContentPane().add(ip);
		ip.setColumns(10);
		
		JCheckBox npca = new JCheckBox("Spawn");
		npca.setBounds(259, 157, 128, 23);
		frame.getContentPane().add(npca);
		
		JCheckBox aa = new JCheckBox("Spawn");
		aa.setBounds(259, 209, 128, 23);
		frame.getContentPane().add(aa);
		
		JCheckBox sg = new JCheckBox("Generated");
		sg.setBounds(259, 266, 128, 23);
		frame.getContentPane().add(sg);
		
		JCheckBox om = new JCheckBox("Enabled");
		om.setBounds(259, 319, 128, 23);
		frame.getContentPane().add(om);
		
		mbh = new JTextField();
		mbh.setText("256");
		mbh.setBounds(259, 371, 130, 26);
		frame.getContentPane().add(mbh);
		mbh.setColumns(10);
		
		seed = new JTextField();
		seed.setBounds(5, 424, 130, 26);
		frame.getContentPane().add(seed);
		seed.setColumns(10);
		
		JComboBox<String> difbox = new JComboBox<String>();
		difbox.setBounds(135, 157, 112, 27);
		frame.getContentPane().add(difbox);
		
		comboBox.addItem("Survival");
		comboBox.addItem("Creative");
		
		difbox.addItem("Peaceful");
		difbox.addItem("Easy");
		difbox.addItem("Normal");
		difbox.addItem("Hard");
		
		
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(309, 407, 117, 46);
		frame.getContentPane().add(btnCreate);
		
		btnCreate.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox.getSelectedItem().equals("Survival")) {
					
					gm = "survival";
					
				} else if(comboBox.getSelectedItem().equals("Creative")) {
					
					gm = "creative";
					
				} else {
					
					errorgm = 45;
					
				}
				
				if(difbox.getSelectedItem().equals("Peaceful")) {
					
					difstring = "peaceful";
					
				} else if(difbox.getSelectedItem().equals("Easy")) {
					
					difstring = "easy";
					
				} else if(difbox.getSelectedItem().equals("Normal")) {
					
					difstring = "normal";
					
				} else if(difbox.getSelectedItem().equals("Hard")) {
					
					difstring = "hard";
					
				} else {
					
					errordif = 44;
					
				}
				
					List<String> lines = Arrays.asList("#Created with FastMCServer", "spawn-protection=" + sp.getText(), "max-tick-time=60000", "query.port=25565", "query.port=25565", "force-gamemode=false",
						"allow-nether=" + na.isSelected(), "enforce-whitelist=false", "gamemode=" + gm, "broadcast-console-to-ops=true", "enable-query=false", "player-idle-timeout=0", "difficulty=" + difstring, "spawn-monsters=" + ms.isSelected(),
						"broadcast-rcon-to-ops=true", "op-permission-level=4", "pvp=" + pvpa.isSelected(), "snooper-enabled=true", "level-type=default", "hardcore=" + ha.isSelected(), "enable-command-block=" + cba.isSelected(), "max-players=" + maxp.getText(),
						"network-compression-threshold=256", "resource-pack-sha1=", "max-world-size=29999984", "rcon.port=25575", "server-port=25565", "debug=false", "server-ip=" + ip.getText(), "spawn-npcs=" + npca.isSelected(), "allow-flight=false",
						"level-name=world", "view-distance=10", "resource-pack=", "spawn-animals=" + aa.isSelected(), "white-list=false", "rcon.password=", "generate-structures=" + sg.isSelected(), "online-mode=" + om.isSelected(), "max-build-height=" + mbh.getText(),
						"level-seed=" + seed.getText(), "prevent-proxy-connections=false", "use-native-transport=true", "motd=\\u00a7a\\u00a7nCreated with \\u00a74\\u00a7l\\u00a7nFastMCServer\\u00a7c!", "enable-rcon=false");
						Path file = Paths.get("server.properties");
						try {
							Files.write(file, lines, StandardCharsets.UTF_8);
							System.out.println("Successfully created server.properties!");
						} catch (IOException e) {
							e.printStackTrace();
							System.out.println("server.properties could not be created! Redownload Program, check GitHub or contact the Developer, if the Programs still occures!");
							errorprop = 43;
						}
						
						frame.dispose();
						finishwindow finwin = new finishwindow();
					
			}          
	    });
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 406, 127, 47);
		frame.getContentPane().add(btnCancel);
		
		
		JLabel lblDifficulty = new JLabel("Difficulty");
		lblDifficulty.setBounds(135, 138, 61, 16);
		frame.getContentPane().add(lblDifficulty);
		
		btnCancel.addActionListener(new ActionListener() {
	        
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					System.exit(0);
					
			}          
	    });
		
	}
}
