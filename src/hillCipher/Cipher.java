package hillCipher;

import java.util.Scanner;

public class Cipher {
	
	public static int[][] strToMat(String mat) {
		int[][] strMat = new int[2][mat.length() / 2];
		
		for (int i = 0; i < mat.length() / 2; i++) {
			char c1 = mat.charAt(i);
			char c2 = mat.charAt(i + 1);
			strMat[0][i] = c1 - 65;
			strMat[1][i] = c2 - 65;
		}
		
		return strMat;
	}
	
	public static int[][] matMult(int m1[][], int m2[][]) {
		// Check if matrices can be multiplied
		if (m1[0].length != m2.length) {
			return null;
		}
		
		// Allocate space for new matrix and vars
		int[][] result = new int[m1.length][m2[0].length];
		int[] cRow, cCol;
		
		// Loop through new matrix
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				// Set the current row and col from m1 and m2, respectively
				cRow = m1[i];
				cCol = new int[m2.length];
				for (int k = 0; k < cCol.length; k++) {
					cCol[k] = m2[k][j];
				}
				
				// Calculate the val for result[i][j]
				for (int k = 0; k < cRow.length; k++) {
					result[i][j] += cRow[k] * cCol[k];
				}
			}
		}
		
		return result;
	}
	
	public static String encode(int key[][], int strMat[][]) {
		int[][] encoded = matMult(key, strMat);
		String encrypted = "";
		int cInt;
		char cChar;
		
		// Testing
		for (int i = 0; i < encoded.length; i++) {
			for (int j = 0; j < encoded[0].length; j++) {
				cInt = encoded[i][j];
				cInt = (cInt % 29) + 65;
				cChar = (char) cInt;
				encrypted += String.valueOf(cChar);
			}
		}
		
		return encrypted;
	}
	
	public static String decode(int key[][], int strMat[][]) {
		int[][] decoded = matMult(key, strMat);
		String decrypted = "";
		int cInt;
		char cChar;
		
		// Testing
		for (int i = 0; i < decoded.length; i++) {
			for (int j = 0; j < decoded[0].length; j++) {
				cInt = decoded[i][j];
				cInt = (cInt % 29) + 65;
				cChar = (char) cInt;
				decrypted += String.valueOf(cChar);
			}
		}
		
		return decrypted;
	}
	
	public static void main(String[] args) {
		// Initialize vars
		int[][] keyMat = new int[2][2];
		int[][] strMat;
		int action;
		String inStr, outStr;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the Hill Cipher!");
		
		// Infinite loop of requests
		while (true) {
			
			// Get next instruction
			System.out.println("Encode, Decode, Exit (1,2,3):");
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
			inStr = scanner.next();
			
			System.out.println("Please input your key:");
			keyMat[0][0] = scanner.nextInt();
			keyMat[0][1] = scanner.nextInt();
			keyMat[1][0] = scanner.nextInt();
			keyMat[1][1] = scanner.nextInt();
			
			strMat = strToMat(inStr);

			/*for (int i = 0; i < strMat.length; i++) {
				for (int j = 0; j < strMat[0].length; j++) {
					System.out.print(strMat[i][j]);
				}
				System.out.println();
			}*/
			
			
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
}
