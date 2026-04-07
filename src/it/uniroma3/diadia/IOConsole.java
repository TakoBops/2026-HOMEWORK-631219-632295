package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole {
	
	public void consoleMsg(String msg) {
		System.out.println(msg);
	}
	
	public String readInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}
}