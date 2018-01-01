package com.rahim;

// 1. Athlete # (Generate For Loop here)
// 2. Random Number Generated Was (Generate Random Number Code)
// 3. Athlete Name  
// 4. Jersey Number 
// 5. Position
// 6. Something Interesting about the player

class Futbol {

	private String name; 
	private int number;
	
	public Futbol(String n) { 
		this.name = n; 
	}
	
	public String getName() { 
		return name; 
	}
	
	public int jnumber() {
		return 1000; 
		
	}
	public String team() { 
		return "Blank"; 
	}
	
	public String interestingFact() { 
		return "Nothing Interesting!"; 
	}
	
	
	
// if decide to use additional constructor and methods see below	
	
//	Futbol(int n) { 
//	this.number = n; 
//}
	
/*	public void setName(String name) { 
		this.name = name; 
	}
	
	public int getNumber() { 
		return number; 
	}
	
	public void setNumber(int number) { 
		this.number = number; 
	}*/
	

}

class Footballer extends Futbol { 
	
	public Footballer() { 
		super("Ronaldinho");
	} 
	
//	Below override annotation doesnt work 
// 	However the method overrides the method from above (declared in Futboll class)
//	@Override					
	public int jnumber() {
		return 10; 	
	}
	
	public String team() { 
		return "Retired"; 
	}
	
	@Override
	public String interestingFact() { 
		return "Won 2002 World Cup and many club titles";  
	}
}

// Fill in player details for other players below

class Footballer2 extends Futbol { 
	
	public Footballer2() { 
		super("Mohammed Salah");
	}
	public int jnumber() {
		return 11; 	
	}
	
	public String team() { 
		return "Liverpool"; 
	}
	
	public String interestingFact() { 
		return "Best signing of Premier League Season 2017";  
	}
}

class Footballer3 extends Futbol { 
	
	public Footballer3() { 
		super("Renato Sanches");
	}
	public int jnumber() {
		return 16; 	
	}
	public String team() { 
		return "Swansea City"; 
	}
	
//	@Override
//	public String interestingFact() { 
//		return "Won 2002 World Cup and many club titles";  
//	}
}

class Footballer4 extends Futbol { 
	
	public Footballer4() { 
		super("Claus Lundekwam");
	}
	public int jnumber() {
		return 5; 	
	}
	public String team() { 
		return "Leister City"; 
	}
//	public String interestingFact() { 
//		return "Nothing Interesting";  
//	}
}

class Footballer5 extends Futbol { 
	
	public Footballer5() { 
		super("David Alaba");
	}
	public int jnumber() {
		return 27; 	
	}
	public String team() { 
		return "Bayern Munich"; 
	}
	public String interestingFact() { 
		return "Won 2002 World Cup and many club titles";  
	}
}





