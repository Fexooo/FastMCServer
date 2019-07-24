package io.github.fexooo.FastMCServer;

import java.util.Scanner;
import io.github.fexooo.FastMCServer.download;

public class main {
	
	static Float version = (float) 1.0;

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to FastMCServer Setup!");
		System.out.println("Version: " + version.toString());
		System.out.println("Please accept the Minecraft Eula first to start the Process!");
		System.out.println("Do you accept the Minecraft Eula? (https://account.mojang.com/documents/minecraft_eula)");
		System.out.println("For Yes: y");
		System.out.println("For No: n");
		clear(1);
		
		String answer = scanner.nextLine();
		
		if(answer.equalsIgnoreCase("y")) {
			
			clear(5);
			
			eula();
			
		} else if(answer.equalsIgnoreCase("n")) {
			
			clear(5);
			
			System.out.println("Without accepting the Eula, the Server won't start, so this Program will now quit!");
			
			System.exit(0);
			
		} else {
			
			clear(5);
			
			System.out.println("Invalid Input! Quitting...");
			
			System.exit(0);
			
		}
		
		
	}
	
	public static void eula() {
		
		System.out.println("Eula accepted!");
		System.out.println("Please select you Operating System!");
		System.out.println("For Windows: win");
		System.out.println("For Linux: linux");
		clear(1);
		
		String answer = scanner.nextLine();
		
		if(answer.equalsIgnoreCase("win") || answer.equalsIgnoreCase("linux")) {
			
			clear(5);
			
			os(answer);
			
		} else {
			
			clear(1);
			
			System.out.println("Invalid Input!");
			clear(3);
			eula();
			
		}
		
		
	}
	
	public static void os(String osystem) {
		
		clear(5);
		
		if(osystem.equalsIgnoreCase("linux")) {
			
			System.out.println("Do you want a start.sh file created with the Server?");
			System.out.println("For Yes: y");
			System.out.println("For No: n");
			
			clear(1);
			
			String answer = scanner.nextLine();
			
			if(answer.equalsIgnoreCase("y")) {
				
				screen(osystem, true);
				
			} else if(answer.equalsIgnoreCase("n")) {
				
				screen(osystem, false);
				
			} else {
				
				clear(1);
				
				System.out.println("Invalid Input!");
				
				clear(1);
				
				os(osystem);
				
			}
			
		} else if(osystem.equalsIgnoreCase("win")) {
			
			System.out.println("Do you want a start.bat file created with the Server?");
			System.out.println("For Yes: y");
			System.out.println("For No: n");
			
			clear(1);
			
			String answer = scanner.nextLine();
			
			if(answer.equalsIgnoreCase("y")) {
				
				screen(osystem, true);
				
			} else if(answer.equalsIgnoreCase("n")) {
				
				screen(osystem, false);
				
			} else {
				
				clear(1);
				
				System.out.println("Invalid Input!");
				
				clear(1);
				
				os(osystem);
				
			}
			
		} else {
			
			System.out.println("An unexpected Error occured! Please try redownloading it! If the Problem still occurs, contact the Developer over GitHub!");
			System.out.println("Error Code: 30");
			
			System.exit(0);
			
		}
		
	}
	
	public static void screen(String os, boolean file) {
		
		if(os.equalsIgnoreCase("linux")) {
			
			System.out.println("Is Screen installed on this System and should it be used?");
			System.out.println("For Yes: y");
			System.out.println("For No: n");
			
			String answer = scanner.nextLine();
			
			if(answer.equalsIgnoreCase("y")) {
				
				download.owndl(os, file, true);
				
			} else if(answer.equalsIgnoreCase("n")) {
				
				download.owndl(os, file, false);
				
			} else {
				
				clear(1);
				
				System.out.println("Invalid Input!");
				
				clear(1);
				
				screen(os, file);
				
			}
			
		} else if(os.equalsIgnoreCase("win")) {
			
			download.owndl(os, file, false);
			
		} else {
			
			System.out.println("An unexpected Error occured! Please try redownloading it! If the Problem still occurs, contact the Developer over GitHub!");
			System.out.println("Error Code: 31");
			
		}
		
	}
	
	public static void clear(int i) {
		
		
		for(int o = 0; o < i; o++) {
			
			System.out.println();
			
		}
		
	}
	
}
