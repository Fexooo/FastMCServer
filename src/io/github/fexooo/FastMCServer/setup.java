package io.github.fexooo.FastMCServer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class setup {
	
	static Scanner scanner = new Scanner(System.in);

	public static void setupfiles(String os, boolean sfile, boolean screen) {
		
		main.clear(1);
		
		List<String> lines = Arrays.asList("#The Eula got accepted through FastMCServer!", "eula=true");
		Path file = Paths.get("eula.txt");
		try {
			Files.write(file, lines, StandardCharsets.UTF_8);
			System.out.println("Successfully created eula.txt!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("eula.txt could not be created! Redownload Program, check GitHub or contact the Developer, if the Programs still occures!");
		}
		
		if(sfile == true) {
			
			if(main.console == true)
			{
			
				System.out.println("How much RAM should the Server use at maximum in Gigabyte?");
				System.out.println("Please type in a Number!");
				Integer uram = scanner.nextInt();
				
				if(os.equalsIgnoreCase("win")) {
					
					List<String> lineswin = Arrays.asList("java -Xmx" + uram.toString() + "G -jar server.jar nogui", "pause");
					Path filewin = Paths.get("start.bat");
					
					try {
						Files.write(filewin, lineswin, StandardCharsets.UTF_8);
						System.out.println("Successfully created start.bat!");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("start.bat could not be created! Redownload Program, check GitHub or contact the Developer, if the Programs still occures!");
					}
					
					properties(os, sfile, screen);
					
				} else if(os.equalsIgnoreCase("linux")) {
					
					List<String> lineslinux;
					
					if(screen == true ) {
						
						lineslinux = Arrays.asList("screen -S mc java -Xmx" + uram.toString() + "G -jar server.jar nogui", "pause");
						
					} else {
						
						lineslinux = Arrays.asList("java -Xmx" + uram.toString() + "G -jar server.jar nogui", "pause");
						
					}
					Path filelinux = Paths.get("start.sh");
					
					try {
						Files.write(filelinux, lineslinux, StandardCharsets.UTF_8);
						System.out.println("Successfully created start.sh!");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("start.sh could not be created! Redownload Program, check GitHub or contact the Developer, if the Programs still occures!");
					}
					
					properties(os, sfile, screen);
				
				} else {
					
					System.out.println("An unexpected Error occured! Please try redownloading it! If the Problem still occurs, contact the Developer over GitHub!");
					System.out.println("Error Code: 32");
					
					properties(os, sfile, screen);
					
				}
			
			} else {
				
			setupram ramwin = new setupram(os, sfile, screen);
			
			}
			
			
		} else {
			
			properties(os, sfile, screen);
			
		}
		
		System.out.println("Necessary Files created!");
		
	}
	
	public static void properties(String os, boolean sfile, boolean screen) {
		
		if(main.console == true) {
		
		main.clear(5);
		
		System.out.println("How many blocks should the Spawn Protection go?");
		Integer sp = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Shall the Nether be allowed? (true/false)");
		String na = scanner.nextLine();
		if(na.equalsIgnoreCase("true") || na.equalsIgnoreCase("false")) {
			
			System.out.println("Which Gamemode do you want to play in? (Survival: s | Creative: c)");
			String gm = scanner.nextLine();
			
			if(gm.equalsIgnoreCase("s") || gm.equalsIgnoreCase("c")) {
				
				System.out.println("Which Difficulty should the Server run with? (Peaceful: 0 | Easy: 1 | Normal: 2 | Hard: 3)");
				Integer dif = scanner.nextInt();
				scanner.nextLine();
				
				if(dif.equals(0) || dif.equals(1) || dif.equals(2) || dif.equals(3)) {
					
					System.out.println("Should Monsters be activated? (true/false)");
					String ma = scanner.nextLine();
					
					if(ma.equalsIgnoreCase("true") || ma.equalsIgnoreCase("false")) {
						
						System.out.println("PVP activated? (true/false)");
						String pvp = scanner.nextLine();
						
						if(pvp.equalsIgnoreCase("true") || pvp.equalsIgnoreCase("false")) {
							
							System.out.println("Hardcore Mode activated? (true/false)");
							String hdm = scanner.nextLine();
							
							if(hdm.equalsIgnoreCase("true") || hdm.equalsIgnoreCase("false")) {
								
								System.out.println("Command Blocks enabled? (true/false)");
								String cb = scanner.nextLine();
								
								if(cb.equalsIgnoreCase("true") || cb.equalsIgnoreCase("false")) {
									
									System.out.println("Maximum Players, that can join the Server?");
									Integer maxp = scanner.nextInt();
									scanner.nextLine();
									
									System.out.println("Custom server IP? (Important if you use something like Hamachi! If you don't need it type x)");
									String ip = scanner.nextLine();
									
									System.out.println("Should NPC's be spawned? (true/false)");
									String npc = scanner.nextLine();
									
									if(npc.equalsIgnoreCase("true") || npc.equalsIgnoreCase("false")) {
										
										System.out.println("Should Animals be spawned? (true/false)");
										String as = scanner.nextLine();
										
										if(as.equalsIgnoreCase("true") || as.equalsIgnoreCase("false")) {
											
											System.out.println("Should Structures be generated? (true/false)");
											String sg = scanner.nextLine();
											
											if(sg.equalsIgnoreCase("true") || sg.equalsIgnoreCase("false")) {
												
												System.out.println("Should the Server run in Online Mode? (Default: True | for more Information visit Website!) (true/false)");
												String om = scanner.nextLine();
												
												if(om.equalsIgnoreCase("true") || om.equalsIgnoreCase("false")) {
													
													System.out.println("Maximum Build Height? (Default is 256)");
													Integer mbh = scanner.nextInt();
													scanner.nextLine();
													
													System.out.println("Special Level Seed? (If not needed type x)");
													String seed = scanner.nextLine();
													
													main.clear(5);
													
													System.out.println("Summary:");
													System.out.println("Spawn Protection: " + sp.toString());
													System.out.println("Nether: " + na);
													System.out.println("Gamemode: " + gm);
													System.out.println("Difficulty: " + dif.toString());
													System.out.println("Monsters: " + ma);
													System.out.println("PVP: " + pvp);
													System.out.println("Hardcore: " + hdm);
													System.out.println("Command Blocks: " + cb);
													System.out.println("Maximum Players: " + maxp.toString());
													if(ip.equalsIgnoreCase("x")) {
														
														System.out.println("IP Adress: Not Set!");
														ip = "";
														
													} else {
														
														System.out.println("IP Adress: " + ip);
														
													}
													System.out.println("NPC's: " + npc);
													System.out.println("Animals: " + as);
													System.out.println("Structures: " + sg);
													System.out.println("Online Mode: " + om);
													System.out.println("Maximum Build Height: " + mbh.toString());
													if(seed.equalsIgnoreCase("x")) {
														
														System.out.println("Seed: Not Set!");
														seed = "";
														
													} else {
														
														System.out.println("Seed: " + seed);
														
													}
													
													System.out.println("Creating Properties...");
													
													if(gm.equalsIgnoreCase("s")) {
														
														gm = "survival";
														
													} else if(gm.equalsIgnoreCase("c")) {
														
														gm = "creative";
														
													}
													
													String difstring = null;
													
													if(dif.equals(0)) {
														
														difstring = "peaceful";
														
													} else if(dif.equals(1)) {
														
														difstring = "easy";
														
													} else if(dif.equals(2)) {
														
														difstring = "normal";
														
													} else if(dif.equals(3)) {
														
														difstring = "hard";
														
													}
													
													List<String> lines = Arrays.asList("#Created with FastMCServer", "spawn-protection=" + sp.toString(), "max-tick-time=60000", "query.port=25565", "query.port=25565", "force-gamemode=false",
													"allow-nether=" + na, "enforce-whitelist=false", "gamemode=" + gm, "broadcast-console-to-ops=true", "enable-query=false", "player-idle-timeout=0", "difficulty=" + difstring, "spawn-monsters=" + ma,
													"broadcast-rcon-to-ops=true", "op-permission-level=4", "pvp=" + pvp, "snooper-enabled=true", "level-type=default", "hardcore=" + hdm, "enable-command-block=" + cb, "max-players=" + maxp.toString(),
													"network-compression-threshold=256", "resource-pack-sha1=", "max-world-size=29999984", "rcon.port=25575", "server-port=25565", "debug=false", "server-ip=" + ip, "spawn-npcs=" + npc, "allow-flight=false",
													"level-name=world", "view-distance=10", "resource-pack=", "spawn-animals=" + as, "white-list=false", "rcon.password=", "generate-structures=" + sg, "online-mode=" + om, "max-build-height=" + mbh.toString(),
													"level-seed=" + seed, "prevent-proxy-connections=false", "use-native-transport=true", "motd=\\u00a7a\\u00a7nCreated with \\u00a74\\u00a7l\\u00a7nFastMCServer\\u00a7c!", "enable-rcon=false");
													Path file = Paths.get("server.properties");
													try {
														Files.write(file, lines, StandardCharsets.UTF_8);
														System.out.println("Successfully created server.properties!");
													} catch (IOException e) {
														e.printStackTrace();
														System.out.println("server.properties could not be created! Redownload Program, check GitHub or contact the Developer, if the Programs still occures!");
													}
													
													System.out.println("All Files, necessary for the first Start have been created!");
													
													finish.finishprocess();
													
												} else {
													
													System.out.println("Invalid Input! Restarting Process!");
													properties(os, sfile, screen);
													
												}
												
											} else {
												
												System.out.println("Invalid Input! Restarting Process!");
												properties(os, sfile, screen);
												
											}
											
										} else {
											
											System.out.println("Invalid Input! Restarting Process!");
											properties(os, sfile, screen);
											
										}
										
									} else {
										
										System.out.println("Invalid Input! Restarting Process!");
										properties(os, sfile, screen);
										
									}
									
								} else {
									
									System.out.println("Invalid Input! Restarting Process!");
									properties(os, sfile, screen);
									
								}
								
							} else {
								
								System.out.println("Invalid Input! Restarting Process!");
								properties(os, sfile, screen);
								
							}
							
						} else {
							
							System.out.println("Invalid Input! Restarting Process!");
							properties(os, sfile, screen);
							
						}
						
					} else {
						
						System.out.println("Invalid Input! Restarting Process!");
						properties(os, sfile, screen);
						
					}
					
				} else {
					
					System.out.println("Invalid Input! Restarting Process!");
					properties(os, sfile, screen);
					
				}
				
			} else {
				
				System.out.println("Invalid Input! Restarting Process!");
				properties(os, sfile, screen);
				
			}
			
		} else {
			
			System.out.println("Invalid Input! Restarting Process!");
			properties(os, sfile, screen);
			
		}
		
	} else {
		
		propertieswindow propwin = new propertieswindow();
		
	}
		
	}
	
}
