package com.rahim;

public class Main {

	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) { 
			System.out.println("Baller #: " + i);
		
//			Futbol f = new Futbol(10);
			
			Futbol one = randomPlayer();
//			Footballer f = new Footballer(); 
			
			
//		f.setName("RonaldinhoExample");		//	Could invoke the name by using setName 
//		f.setNumber(10);					//  Could invoke the number by using setNumber
		
		System.out.println("Name: " + one.getName() + "\n" + "Jersey Number: " + one.jnumber() + "\n" + "Current Team/ Team Played For: " + one.team() + "\n" +  "Interesting Facts: " + one.interestingFact() + "\n" ); 
	}

	}
	
	public static Futbol randomPlayer() {
		
		int random = (int) (Math.random() * 5) + 1;  
		System.out.println("Random Number generated: " + random);
		
		switch (random) { 
		case 1: 
			return new Footballer(); 
		case 2: 
			return new Footballer2(); 
		case 3: 
			return new Footballer3(); 
		case 4: 
			return new Footballer4(); 
		case 5: 
			return new Footballer5(); 
			
		}
		
		return null; 
		
	}
	
}
