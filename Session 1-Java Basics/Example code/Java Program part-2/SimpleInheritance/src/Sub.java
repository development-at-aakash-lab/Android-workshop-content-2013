
// Create a subclass by extending class Super.

class Sub extends Super{
	
	int k;
	
	void showk() {
		System.out.println("k: " + k);
	}
	
	void sum() {
		System.out.println("i+j+k: " + (i+j+k)); // accessing i and j variable of Super
	}

}
