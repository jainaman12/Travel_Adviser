import java.sql.ResultSet;
import java.util.Scanner;

public class logininfo {
    logininfo(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your username");
        String user=sc.next();
        System.out.println("Enter your password");
        String pass=sc.next();


        
        try {
            String query="Select * from logininfo where username='"+user+"' ";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(query);
            while(rs.next()){
                String pass1=rs.getString("password");
                if(pass1.equals(pass)){
                    System.out.println("Login Successfully");
                    System.out.println("Do you want to reset your password(y/n)");
                    String s=sc.next();
                    if(s.contains("y")){
                        System.out.println("enter your new password");

                        String newpass=sc.next();
                        try {
                            String query1="update logininfo set password='"+newpass+"' where username='"+user+"'";
                            conn c2=new conn();
                            c2.s.executeUpdate(query1);
                            System.out.println("Password is changed");
                        } catch (Exception e) {
                            //TODO: handle exception
                        }


                    }
                    else{
                        System.out.println("Logged in as "+user);
                    }
                }
                else{
                    System.out.println("Invalid login");
                }

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new logininfo();
    }
    
}
