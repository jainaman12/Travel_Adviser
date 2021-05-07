import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
public class conn2
{
   public static void main(String args[]) throws Exception
   {
       int[] sno=new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
      String[] pack_name=new String[]{"Manali Holiday","Winter in Himachal","Simple Kerela","Simple kashmir","super saver kashmir",
                                    "Seven Sisters","Short trip to Bhutan","Welcome Gujurat","Gujarat holidays","Nature in MP",
                                    "Backwaters Kerela","West Bengal Holidays","Mountains in Kashmir","Visit to Himalays","Odisha's Temple"};
      int[] price=new int[]{4999,5999,12500,15499,12000,
                            21001,18999,12500,8999,7500,
                            5600,6700,3999,2999,5500};
      int[] accomodation=new int[]{2,3,4,5,4,7,7,5,3,3,2,5,2,1,3};
      String[] location=new String[]{"Manali","Shimla-kufri","Kerela","Srinagar","Srinagar-Gulmarg",
                                    "North East","Bhutan","Gujarat","Ahemdabad","Madhya Pradesh",
                                    "Kerela","Kolkata","Gulamarg-Sonmarg","Spiti Valley","Puri-Odisha"};
      //String[] description=new String[]{};
      String[] image=new String[]{"C:/Users/Dewa/Downloads/rs/1.jpg","C:/Users/Dewa/Downloads/rs/2.jpg","C:/Users/Dewa/Downloads/rs/3.jpg","C:/Users/Dewa/Downloads/rs/4.jpg","C:/Users/Dewa/Downloads/rs/5.jpg",
      "C:/Users/Dewa/Downloads/rs/6.jpg","C:/Users/Dewa/Downloads/rs/7.jpg","C:/Users/Dewa/Downloads/rs/8.jpg","C:/Users/Dewa/Downloads/rs/9.jpg","C:/Users/Dewa/Downloads/rs/10.jpg",
      "C:/Users/Dewa/Downloads/rs/11.jpg","C:/Users/Dewa/Downloads/rs/12.jpg","C:/Users/Dewa/Downloads/rs/13.jpg","C:/Users/Dewa/Downloads/rs/14.jpg","C:/Users/Dewa/Downloads/rs/15.jpg"};
      int[] days=new int[]{3,4,6,7,5,8,5,4,2,2,6,4,3,3,4};
      //Registering the Driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      //Getting the connection
      String mysqlUrl = "jdbc:mysql://localhost:3306/tms";
      Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
      System.out.println("Connection established......");
      PreparedStatement pstmt = con.prepareStatement("INSERT INTO recomendations VALUES(?,?,?,?,?,?,?)");
      for(int i=0;i<15;i++){
    
      pstmt.setInt(1, sno[i] );//Hotel name
      pstmt.setString(2, pack_name[i]);            //hotel star rating
      pstmt.setInt(3, price[i] );        //hotel location
      pstmt.setInt(4, accomodation[i] ); 
      pstmt.setString(5, location[i] );
           //hotel price
      InputStream in = new FileInputStream(image[i]);
      //Inserting Blob type
      pstmt.setBlob(6, in); 
      pstmt.setInt(7, days[i] );                //hotel image
      //Executing the statement
      pstmt.execute();
      }
      System.out.println("Record inserted......");
   }
}
