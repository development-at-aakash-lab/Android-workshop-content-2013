
class MethodOverload {

	public static void main(String[] args) {
		int area1, area2, area3; 
		
		//creating objects
		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle();
		Rectangle rect3 = new Rectangle();
		
		rect1.setData(); // calling no argument method.
		area1 = rect1.rectArea();
		System.out.println("Area 1  :- "+area1); // printing area 1
		
		// accessing methods
		rect2.setData(20); // calling one argument method.
		area2 = rect2.rectArea();
		System.out.println("Area 2 :- "+area2); // printing area 2
		
		rect3.setData(10, 15); // calling two argument method.
		area3 = rect3.rectArea();
		System.out.println("Area 3 :- "+area3); // printing area 3
		
		
	}

}
