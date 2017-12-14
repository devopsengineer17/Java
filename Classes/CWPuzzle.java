import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.util.Scanner; 

// how to run 
// javac -encoding UTF-8 CWPuzzle.java 
// java -cp . CWPuzzle 

public class CWPuzzle {

	// declared member variables

	static String[][] cwArray = null;
	static String[] answers = null;
	static String[] clues = null;
	static String[] dirs = null;
	static String[] row_col = null;
	static int[] answered_clues = null;

	public static void main(String[] args) {

// Read file from input
		File file = new File("resources/myinput.txt");
		FileInputStream fileHandler;
		StringBuilder sb = new StringBuilder();
		byte[] data = null; 
		try {
			fileHandler = new FileInputStream(file);
			data = new byte[(int) file.length()];
			fileHandler.read(data);
			fileHandler.close();
			sb.append(new String(data, "UTF-8"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
//		Can be printed like this without text file		
//		StringBuilder sb = new StringBuilder(); 
//		sb.append("5 5 6\n" + "H 1 1 BAA Sheep sound\n" + "H 3 1 SOLID Neither liquid nor gas\n" + "H 5 3 WIT Humor\r\n"
//				+ "V 1 1 BUS Road passenger transport\n" + "V 1 3 ALLOW To permit\n" + "V 3 5 DOT Point\n");

		// First Print the Banner 
		
		PrintBanner(); 
//		Based on the input.txt file data - Build the Matrix with _ and boxes.
		String[][] arrayList = BuildArray(sb);
		
// 		Time to print the prepared Matrix as mentioned in the document. 
		PrintMatrix(arrayList); 
		
// 		Based on the BuildArray - a series of arrays are built to save 
//		Clues, Answers, ROW/COL information in the same order of the clues 
		
		PrintClues(); 
		
// 		Main Loop for Prompts and Displaying Answered Matrix
		
		int opt = 0; 
		String ans = "";
		Scanner sc = new Scanner(System.in);
		
//		Continue the Loop until Option -1 is entered. 
		while (opt != -1) {
			// Prompt for the Option first 
			Prompt4opt(); 
			
// 		Get the option value
		String op = sc.next();
		
		try { 
			opt = Integer.valueOf(op); 
		} catch (Exception e) { 
			System.out.println("Incorrect option value");
			continue; 
		}
			
// 		Otherwise continue
// 		Validate the option is with in the clue range [1-maxClue] 	
		
		if (ValidateOption(opt) == false) { 
//		If wrong option entered - warn user and reprompt - continue 
// 		loop from beginning 
		System.out.println("Wrong Option");
		continue;
		}
		
// 		Once option is valid then proceed asking for answer 
		Prompt4ans();
		ans = sc.next(); 
		
// 		Once answer is received proceed with filling the Matrix with Answer 
		
		if (RearrangeMatrix(opt, ans) == false) { 
// 		Something not right. Wrong Answer may be. So come out and loop again 
		continue; 	
		} else { 
// 		Keep an array of answers so that we can avoid printing answered clues 
		answered_clues[opt -1] = opt - 1;
		PrintMatrix(arrayList); 
		
		if (allAnswered()) { 
			
// 		If all answered entered come out of the Loop 
			
			break; 
		}
// 		Everytime correct answer entered 
// 		Remove the answered clue and print the rest 
		PrintClues(); 
		}
	}
		
// 		End with a thank you note. 
		PrintThankYouNote(); 
	}
	
	private static boolean allAnswered() { 
		for (int i = 0; i < answered_clues.length; i++) { 
			if (answered_clues[i] == -1)
				return false; 
		}
		return true; 
	} 
	
	private static boolean ValidateOption(int opt) { 
		
		if (opt > clues.length)
			return false;
		
		return true;
	} 
	
	private static void PrintThankYouNote() { 
		System.out.println("********************************************************************");
		System.out.println("* Thank you for playing the cross word puzzle.......................");
		System.out.println("********************************************************************");
	} 
	
	private static boolean RearrangeMatrix(int opt, String ans) { 
		int clue_idx = opt -1; 
		
		if (clue_idx < 0 || clue_idx > clues.length)
			return false;
		
		if (!ans.equalsIgnoreCase(answers[clue_idx])) { 
			System.out.println("Wrong answer");
			return false;
		}
		
		String[] items = row_col[clue_idx].split(" "); 
		int r = Integer.valueOf(items[0]) -1; 
		int c = Integer.valueOf(items[2]) -1; 
		int count = 0; 
		
		int length = ans.length(); 
		if (dirs[clue_idx].equalsIgnoreCase("Horizontal")) { 
			for (; count < length; c++, count++) { 
				cwArray[r][c] = answers[clue_idx].substring(count,  count + 1); 
				System.out.print("Array[" + r + "][" + c + "]=" + cwArray[r][c]);
			}
		} else { 
			for (; count < length; r++, count++) { 
				cwArray[r][c] = answers[clue_idx].substring(count, count + 1);
				System.out.print("Array[" + r + "][" + c + "]=" + cwArray[r][c]);
			}
		}
		
		return true; 
	} 
	
	public static void PrintBanner() { 
		
		System.out.println("********************************************************************");
		System.out.println("* A simple game Crossword Puzzle game that a user can play.         ");
		System.out.println("                                                                    ");
		System.out.println("                                                                    ");
		System.out.println("* Author: Loren                                                     ");
		System.out.println("* Date: December 13, 2017                                           ");
		System.out.println("* Final Project: Crossworld Puzzle                                  ");
		System.out.println("********************************************************************");

	} 
	
	public static void PrintMatrix(String[][] matrix) { 
		
		System.out.println("\n\nCurrent Puzzle:");
		System.out.println("***************\n\n");
		
		System.out.print("  ");
		for (int i = 0; i < matrix[matrix.length - 1].length; i++)
			System.out.print(" " + i + " ");
				
		System.out.print("\n   ");
			for (int i = 0; i < matrix[matrix.length - 1].length; i++)
					System.out.print("---");		
				System.out.println(); 
				
		for (int r = 0; r < matrix.length; r++)		{ 
			for (int c = 0; c < matrix[matrix.length - 1].length; c++) { 
				if (c == 0)
					System.out.print(r + 1 + "|");
				System.out.print(" " + matrix[r][c] + " ");
			}
			System.out.println();
		}
	}		
	
	
	public static void PrintClues() { 
		System.out.println("\n\nUnsolved Clues:");
		System.out.println("***************");
		
		System.out.println("#    Direction    Row/Col       Clue            ");
		System.out.println(".    .........    .......       ....            ");
				
		// The following code is the initializer for the answer tracker array 
		if (answered_clues == null) { 
			answered_clues = new int[clues.length]; 
			for (int i = 0; i < clues.length; i++) { 
				answered_clues[i] = -1; 
			}
		}
		for (int i = 0; i < clues.length; i++) { 
//		avoid printing answered clues
			if (i != answered_clues[i])
				System.out.println(i + 1 + "   " + String.format("%-10s", dirs[i]) + "   " + row_col[i] + "      " + clues[i]);
		} 
	} 
	
	public static void Prompt4opt() { 
		System.out.println("\nEnter clue to solve, or -1 to exit: ");
	} 
	
	public static void Prompt4ans() { 
		System.out.println("Enter your solution: ");
		
	} 

	public static String[][] BuildArray(StringBuilder sb) {

		String[] lines = sb.toString().split("\n");
		System.out.println(lines.length);

		String firstLine = lines[0].trim();
		String[] firstLineItems = firstLine.split(" ");

		int numrows = Integer.valueOf(firstLineItems[0]);
		int numcols = Integer.valueOf(firstLineItems[1]);
		int numclues = Integer.valueOf(firstLineItems[2]);

		cwArray = new String[numrows][numcols];
		clues = new String[numclues];
		dirs = new String[numclues];
		row_col = new String[numclues];
		answers = new String[numclues];

		for (int i = 1; i < lines.length; i++) {
			String[] items = lines[i].trim().split(" ");
			String dir = items[0];
			int startr = Integer.valueOf(items[1]);
			int startc = Integer.valueOf(items[2]);
			int length = items[3].length();
			String clue = lines[i].substring(
					items[0].length() + 1 + items[1].length() + 1 + items[2].length() + 1 + items[3].length() + 1);
			
			clues[i - 1] = clue; 
			dirs[i - 1] = dir.equalsIgnoreCase("H") ? "Horizontal": "Vertical"; 
			row_col[i - 1] = String.valueOf(startr) + " / " + String.valueOf(startc); //rearranging numbering scheme of matrix here
			System.out.println("Filling in for : " + row_col[i - 1] + "-" + items[3]);
			
			answers[i - 1] = items[3]; 
			int r = startr - 1; 
			int c = startc - 1; 
			int count = 0; 
			
			if (dir.equalsIgnoreCase("H")) { 
				for (;count < length; c++, count++) { 
					cwArray[r][c] = new String("_");
					System.out.print("Array[" + r + "][" + c + "] =" + cwArray[r][c]);
					
				}
				System.out.println();
			} else { 
				for (;count < length; r++, count++) { 
					cwArray[r][c] = new String("_");
					System.out.print("Array[" + r + "][" + c + "] = " + cwArray[r][c]);
				}	
			}	
			
		}
		
		for (int r = 0; r < numrows; r++) { 
			for (int c = 0; c < numcols; c++) { 
				if (cwArray[r][c] == null || cwArray[r][c].isEmpty()) { 
					cwArray[r][c] = new String(Character.toChars('▄'));
				}
			}
		}
		
		return cwArray;

	}

}
