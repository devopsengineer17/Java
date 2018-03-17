package training4;

import java.util.ArrayList;
import java.util.Scanner;

public class Starting11 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		ArrayList<String> team = new ArrayList<String>(); 
		
		team.add("Gianluigi Buffon");
		team.add("Philip Lahm");
		team.add("Alaba");
		team.add("Jerome Boateng");
		team.add("Sergio Ramos");
		team.add("Toni Kroos");
		team.add("Luka Modric");
		team.add("Thiago");
		team.add("Lionel Messi");
		team.add("Kylian Mbappe");
		team.add("Robert Lewandowski");
//		team.remove("Robert Lewandowski");
		
		System.out.println("Starting 11: \n" + team.toString());
		
		System.out.println("\nEnter players: (\"a\" to add, \"r\" to remove, or \"exit\" to exit)");
		String newPlayer = sc.nextLine();
		
		boolean found = false;
		boolean foundLetter = false; 
		
		while (newPlayer.equalsIgnoreCase("exit") == false) {
			
			for (int i = 0; i < team.size(); i++) { 
				
				if (newPlayer.equalsIgnoreCase("a") == true) {
					System.out.println("Add player ... ");
					
					newPlayer = sc.nextLine(); 
					if (newPlayer.equalsIgnoreCase(team.get(i))) { 
					System.out.println("The player is already part of the chapionsleague squad of the month ");
					team.add(newPlayer);
					found = true; 
					}
				}
				
				if (newPlayer.equalsIgnoreCase("r") == true) {
					newPlayer = sc.nextLine(); 
					team.remove(team.get(i));
					found = true;
				}
				
			}
//				if (found == false) {
//					team.add(newPlayer);
//				}
				
				System.out.println("\nEnter players \"a\" to add, \"r\" to remove, or \"exit\" to exit:");
				newPlayer = sc.nextLine(); 
		}
		
		System.out.println("New Starting 11 " + team.toString()); 
		
	}

}
