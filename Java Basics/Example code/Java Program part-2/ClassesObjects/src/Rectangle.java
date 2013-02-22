
class Rectangle {
	int length, width ; // decaration of variables
	
	void setData(int x, int y) // defination of method
	{
		length = x;
		width = y;
	}
	
	int rectArea() // defination of another method
	{
		int area = length * width;
		return area;
	}
}
