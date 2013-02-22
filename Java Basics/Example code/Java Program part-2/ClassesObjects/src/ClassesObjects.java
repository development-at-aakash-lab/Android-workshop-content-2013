
class ClassesObjects {  // class with main method

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int area1, area2; 
		
		//creating objects
		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle();
		
		// accessing variables
		rect1.length = 15;
		rect1.width = 10;
		
		area1 = rect1.length * rect1.width;
		System.out.println("Area 1 :- "+area1); // printing area 1
		
		// accessing methods
		rect2.setData(30, 10);
		area2 = rect2.rectArea();
		System.out.println("Area 2 :- "+area2); // printing area 2
	}

}
