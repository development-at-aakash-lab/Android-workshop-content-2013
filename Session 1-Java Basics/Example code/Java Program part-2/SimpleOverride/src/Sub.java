
class Sub extends Super {
	int k;
	
	Sub(int a, int b, int c) {
		super(a, b); // super keyword is used to call super class constructor
		k = c;
	}
	// display k – this overrides show() in Super
	void show() {
		System.out.println("k in Sub " + k);
		
		super.show(); // calls show() in Super
	}

}
