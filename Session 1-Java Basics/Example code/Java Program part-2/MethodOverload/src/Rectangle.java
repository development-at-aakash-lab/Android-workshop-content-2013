
class Rectangle {
	
	int length, width ; // declaration of variables
	
	void setData()
	{
		length = 10;
		width = 10;
	}
	
	void setData(int x) // overload setData for one integer parameter
	{
		length = width = x;
	}
	
	void setData(int x, int y) // overload setData for two integer parameter
	{
		length = x;
		width = y;
	}
	
	int rectArea() // defination of another method
	{
		int area = length * width; // getting value in area variable
		return area;
	}
		
}
