
class SimpleOverride {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub subOb = new Sub(1, 2, 3);
		subOb.show(); // this calls show() in B and not show() in A
		

	}

}
