package hello;

import java.util.Scanner;

public class FromUser {
	public String UserName() {
		Scanner in = new Scanner(System.in);
		System.out.println("What is your name? -> ");
		String userName = in.nextLine();
		return userName;
	}
}
