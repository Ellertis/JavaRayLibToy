public class Main {
	
	public static void main(String[] args){
		System.out.println("Hello");
		
		int age;
		
		int max = 10;
		int min = 1;
		
		int Randi = (int)(Math.random() * (max - min) + min);		
		age = Randi;
		
		int i;
		
		for (i = 1; i <= age; i++){
			System.out.println("A year passed " + i);
			
			if ((i ^ 1) ==  (i + 1))
				System.out.println(i + " is even");
			else
				System.out.println(i + " is odd");
					
		}
		System.out.println("Age is " + age);
		//System.out.println(randomFloat);
		//System.out.println(randomDouble);
			
		
	}
}