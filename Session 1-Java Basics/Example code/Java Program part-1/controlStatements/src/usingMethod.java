

public class usingMethod {
   /** Main method */
   public static void main(String[] args) {
      int first_no = 5;
      int second_no = 2;
      int result = sum(first_no, second_no);
      System.out.println("The addition of " + first_no +
                    " and " + second_no + " is " + result);
   }

   /** Return the sum of two numbers */
   public static int sum(int no1, int no2) {

	  int result;
      result = no1 + no2;
      return result;
      
   }
}