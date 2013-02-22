
class Error {

	public static void main(String[] args) 
	{
		int a = 10, b = 5, c = 5;
		int x;
		
		x = a/(b-c) ;    // Division by zero
		System.out.println("x = " + x);
		
		
		int y = a/(b+c);
		System.out.println("y = " + y);
	}
}
