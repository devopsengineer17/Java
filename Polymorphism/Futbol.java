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
	
//	@Override
	public int jnumber() {
		return 10; 	
	}
	@Override
	public String interestingFact() { 
		return "Won 2002 World Cup and many club titles";  
	}
}

// Fill in player details for other players below

class Footballer2 extends Futbol { 
	
	public Footballer2() { 
		super("Ronaldinho");
	}
	public int jnumber() {
		return 10; 	
	}
	
	public String interestingFact() { 
		return "Won 2002 World Cup and many club titles";  
	}
}

class Footballer3 extends Futbol { 
	
	public Footballer3() { 
		super("Ronaldinho");
	}
	public int jnumber() {
		return 10; 	
	}
	public String interestingFact() { 
		return "Won 2002 World Cup and many club titles";  
	}
}

class Footballer4 extends Futbol { 
	
	public Footballer4() { 
		super("Ronaldinho");
	}
	public int jnumber() {
		return 10; 	
	}
	public String interestingFact() { 
		return "Won 2002 World Cup and many club titles";  
	}
}

class Footballer5 extends Futbol { 
	
	public Footballer5() { 
		super("Ronaldinho");
	}
	public int jnumber() {
		return 10; 	
	}
	public String interestingFact() { 
		return "Won 2002 World Cup and many club titles";  
	}
}





