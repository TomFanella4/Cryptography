package hillCipher;

import java.util.Scanner;

public class Cipher {

	public static void main(String[] args) {
		// Initialize vars
		int keyMat[][] = new int[2][2];
		int strMat[][];
		int action;
		String inStr, outStr;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the Hill Cipher!");
		
		// Infinite loop of requests
		while (true) {
			
			// Get next instruction
			System.out.println("Encode, Decode, or Exit (1,2,3):");
			if (scanner.hasNextInt()) {
				action = scanner.nextInt();
			} else {
				System.err.println("Invalid Action");
				break;
			}
			
			// Break out of loop if exit
			if (action == 3) {
				break;
			}
			
			System.out.println("Please input your raw text:");
			inStr = scanner.nextLine();
			
			System.out.println("Please input your key:");
			keyMat[0][0] = scanner.nextInt();
			keyMat[0][1] = scanner.nextInt();
			keyMat[1][0] = scanner.nextInt();
			keyMat[1][1] = scanner.nextInt();
			
			strMat = strToMat(inStr);
			
			if (action == 1) {
				outStr = encode(keyMat, strMat);
			}
			else if (action == 2) {
				outStr = decode(keyMat, strMat);
			} else {
				outStr = "";
			}
			
			System.out.printf("Your Output:\n%s\n", outStr);
		}
		
		scanner.close();
	}
	
	public static int[][] strToMat(String mat) {
		int strMat[][] = new int[2][mat.length() / 2];
		
		for (int i = 0; i < mat.length() / 2; i++) {
			char c1 = mat.charAt(i);
			char c2 = mat.charAt(i + 1);
			strMat[0][i] = c1 - 65;
			strMat[1][i] = c2 - 65;
		}
		
		return strMat;
	}
	
	public static int[][] matMult(int m1[][], int m2[][]) {
		
	}
	
	public static String encode(int key[][], int inoutMat[][]) {
		
	}
	
	public static String decode(int keyMat[][], int inoutMat[][]) {
		
	}
}
