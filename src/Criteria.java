import java.util.Scanner;

public class Criteria
{
Criteria(int x, int y,  int z){
    
    AHP ahp=new AHP();
    int n=3;
    int NUMBER_COMPARISON;
    Scanner keyboard=new Scanner(System.in);

    //System.out.println("Enter the number of criteria"); 
    //System.out.println("n=");
    //n=keyboard.nextInt();
    NUMBER_COMPARISON=(n*n-n)/2;

    double [][] a=new double[3][3];
    String [] criteria=new String[3];
    criteria[0]="Cost";
    criteria[1]="TimePeriod";
    criteria[2]="Accomodation";
    double [] p={x,y,z};//used to hold the values of comparisons

    //System.out.println("Enter the criteria:"); 
 /* for(int i=0; i<n;i++)
    {
        System.out.print("Criterion "+(i+1)+":");
        criteria[i]=keyboard.next();
    }   */

    //System.out.println("Enter the comparison"); 
    

    a=ahp.initialize_matrix(p);
    // ahp.show_matrix(a);
    new demotopsis(a);
   } 
   public static void main(String[] args) {
       
       new Criteria(0,0,0);
   }   
}