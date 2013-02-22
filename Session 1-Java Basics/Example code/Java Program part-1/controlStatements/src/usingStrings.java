/*

(myString1 == myString2) would actually return FALSE in this situation.
 Even though the strings "abc" are equal, myString1 and myString2 are two different instances of String.
 The "==" operator compares the objects,
 while the ".equals()" method compares the values of the strings.
  
 */



public class usingStrings {
   /** Main method */
   public static void main(String[] args) {
	   
	   String myString1 = new String("abc");
	   String myString2 = new String("xyz");
	   String myString3 = new String("abc");
	   
	   //int myString1= 2;
	   //int myString2 =1;
	  
	   
	   if(myString1.equals(myString2))
	  // if(myString1 == myString2 )
	   	   System.out.println("The two strings are equal");
	   else
		   System.out.println("NOT EQUAL");
		  
	
	
   }

 
}
