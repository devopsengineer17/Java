package finalProject;

public class TwoDimArray1 {

	public static void main(String args[]) {
		
		
		try { 
		//declaring and initializing 2D array  
		int arr[][]={{1,2,3,4,5},{3,4,5,5,5},{6,7,8,5,5}};  
		
//		try { 
		//printing 2D array  
		for(int i=0;i<5;i++){  
		 for(int j=0;j<5;j++){  
		   System.out.print(arr[i][j]+" ");  
		 }  
		 System.out.println();  
		} 
		
		}
		catch (ArrayIndexOutOfBoundsException e) { 
			System.out.println(e);
			System.out.println("You can't do that!");
		}
		 
	}

}
