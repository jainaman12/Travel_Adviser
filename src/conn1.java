import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class conn1
{
   public static void main(String args[]) throws Exception
   {
      String Name="sampleName";
      String sampleImage="C:/Users/Dewa/Desktop/travel management system project/src/icons/demo.jpg";
      //Registering the Driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      //Getting the connection
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms", "root", "");
      System.out.println("Connection established......");
      PreparedStatement pstmt = con.prepareStatement("INSERT INTO demotable VALUES(?,?)");
      
      pstmt.setString(2, Name );
   
      InputStream in = new FileInputStream(sampleImage);
      //Inserting Blob type
      pstmt.setBlob(1, in);               
      //Executing the statement
      pstmt.execute();
      
      System.out.println("Record inserted......");
   }
}

