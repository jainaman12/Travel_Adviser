import java.util.Arrays;
import java.util.Scanner;

public class Palendrome{
	public static void main(String[] a){
		Scanner s= new Scanner(System.in);
		System.out.println("ENTER A STRING");
		String p=s.next();
        p=p.toLowerCase();
		
		 String rev="";
		
		for(int i=p.length()-1;i>=0;i--){
			rev=rev+p.charAt(i);
		}
      System.out.println("after reverse:-"+rev);
	  if(p.equals(rev)){
			System.out.println("palindrome");
		}
		else{
			System.out.println("not a palindrome");
		}
			
	}	
	
}


