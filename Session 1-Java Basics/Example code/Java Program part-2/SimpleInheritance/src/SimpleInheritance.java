
class SimpleInheritance {

	
	public static void main(String[] args) {
		
		Super superOb = new Super(); // object of super class
		Sub subOb = new Sub();       // object of sub class
		
		
		//initializing variables
		superOb.i = 10;
		superOb.j = 20;
		System.out.println("Contents of superOb: ");
		superOb.showij(); // calling method
		System.out.println("----------------------");
		
		
		/* The subclass has access to all public members of
		its superclass. */
		subOb.i = 7;
		subOb.j = 8;
		subOb.k = 9;
		System.out.println("Contents of subOb: ");
		subOb.showij();
		subOb.showk();
		System.out.println("-----------------------");
		System.out.println("Sum of i, j and k in subOb:");
		subOb.sum();


	}

}
