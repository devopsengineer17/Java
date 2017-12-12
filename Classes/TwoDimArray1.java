package training3;

import java.util.Scanner;

public class TwoDimArray1 {

	public static void main(String args[]) {

		try {

			System.out.println("# 1 2 3 4 5");

			// Print 1-5 Vertical Here

			System.out.println("---------");

			// declaring and initializing 2D array
			char arr[][] = { { '_', '_', '_', '▄', '▄' }, { '_', '▄', '_', '▄', '▄' }, { '_', '_', '_', '_', '_' },
					{ '_', '_', '_', '▄', '▄' }, { '▄', '▄', '_', '_', '_' } };

			// printing 2D array
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println();

		int num;
		String solution;

		System.out.print("Enter clue# to solve, or -1 to exit: ");

		Scanner sc = new Scanner(System.in);

		num = sc.nextInt();

		if (num == -1 && num == 1) {
			System.out.println();
		} else {
			// sc.close();
			System.out.println();
		}
		System.out.print("Enter your solution: ");
		solution = sc.nextLine();

		// if answered correctly invoke correct void method that contains puzzle with
		// word and repeat same process over and over again until puzzle completely
		// solved

	}

}
