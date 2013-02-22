public class arrayExample {

   public static void main(String[] args) {
	   
      double[] myList = {1.9, 2.9, 3.4, 3.5}; // creating mylist array.

      // Print all the array elements
      for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
      // Adding all the elements
      double total = 0;
      for (int i = 0; i < myList.length; i++) {
         total += myList[i];
      }
      System.out.println("Total is " + total);
      
	   
	  
   }
}
