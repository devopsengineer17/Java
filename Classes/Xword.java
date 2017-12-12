package finalProject;

public class Xword {

	static String[][] cwArray = null;
	static String[] clues = null;
	static String[] dirs = null;
	static String[] row_col = null;

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		sb.append("5 5 6\n" + "H 1 1 BAA Sheep sound\n" + "H 3 1 SOLID Neither liquid nor gas\n" + "H 5 3 WIT Humor\r\n"
				+ "V 1 1 BUS Road passenger transport\n" + "V 1 3 ALLOW To permit\n" + "V 3 5 DOT Point\n");

		String[][] arrayList = BuildArray(sb);

		for (int r = 0; r < arrayList.length; r++) {
			for (int c = 0; c < arrayList[arrayList.length - 1].length; c++) {
				System.out.print(arrayList[r][c] + " ");
			}
			System.out.println();

		}

	}

	public static String[][] BuildArray(StringBuilder sb) {
		
		String[] lines = sb.toString().split("\n");

		System.out.println(lines.length);

		String firstLine = lines[0];
		String[] firstLineItems = firstLine.split(" ");

		int numrows = Integer.valueOf(firstLineItems[0]);
		int numcols = Integer.valueOf(firstLineItems[1]);
		int numclues = Integer.valueOf(firstLineItems[2]);

		cwArray = new String[numrows][numcols];
		clues = new String[numclues];
		dirs = new String[numclues];
		row_col = new String[numclues];

		for (int i = 1; i < lines.length - 1; i++) {
			String[] items = lines[i].split(" ");
			String dir = items[0];
			int startr = Integer.valueOf(items[1]);
			int startc = Integer.valueOf(items[2]);
			int length = items[3].length();
			String clue = lines[i].substring(
					items[0].length() + 1 + items[1].length() + 1 + items[2].length() + 1 + items[3].length() + 1);

			clues[i - 1] = clue;
			dirs[i - 1] = dir.equalsIgnoreCase("H") ? "Horizontal" : "Vertical"; 
			row_col[i - 1] = String.valueOf(startr) + " / " + String.valueOf(startc);
			
			System.out.println("Filling in for : " + row_col[i - 1] + "-" + items[3]);
			
			int r = startr -1; 
			int c = startc -1; 
			int count = 0; 
			
			if (dir.equalsIgnoreCase("H")) {
				for (; count < length; c++, count++) { 
					cwArray[r][c] = new String("_"); 
					System.out.print("Array[" + r + "][" + c +"]=" + cwArray[r][c]);
					
				}
				System.out.println(); 
				
			} else { 
				for (; count < length; c++, count++) { 
					cwArray[r][c] = new String("_"); 
					System.out.println("Array[" + r + "][" + c +"]=" + cwArray[r][c]);
			}
			
			}
			
		}

		for (int r = 0; r < numrows; r++) {
			for (int c = 0; c < numcols; c++) { 
				if (cwArray[r][c] == null || cwArray[r][c].isEmpty()) { 
					cwArray[r][c] = new String(Character.toChars((char) 0xFE-0x7F)); 
					
		//			"▄"
				}
			}
		}
		return cwArray;
	}

}
