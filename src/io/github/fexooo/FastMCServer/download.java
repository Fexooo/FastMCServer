package io.github.fexooo.FastMCServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import io.github.fexooo.FastMCServer.main;
import io.github.fexooo.FastMCServer.setup;


public class download {

	static Scanner scanner = new Scanner(System.in);
	
	public static void owndl(String os, boolean sfile, boolean screen) {
		
		main.clear(5);
		
		System.out.println("Now you need a Download Link of your Minecraft Server Jar File!");
		System.out.println("To find a Download Link, you can search the internet or check the Website of this Program!");
		System.out.println("NOTE: I (the Developer) am not responsible for the Files you download now! YOU provide the Download Link here and your downloading at you own Risk!");
		System.out.println("Please enter now your Download Link!");
		
		main.clear(1);
		
		String dlurl = scanner.nextLine();
		
		main.clear(1);
		
		System.out.println("Downloading...");
		
		try {
			InputStream in = new URL(dlurl).openStream();
			Files.copy(in, Paths.get("server.jar"), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Download finished!");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("A Problem occured! It may be, that the Download Link you provided doesn't work, or something else happened!");
			System.out.println("Check the Download Link and if the Problem still occurs, please contact the developer or visit the GitHub Page of this Program!");
			System.out.println("The Setup will continue now, but the initial Jar File, to start the Server, is missing!");
			System.out.println("Error Code: 20");
		}
		
		
		
		setup.setupfiles(os, sfile, screen);
		
	}
	
}
