/*
there are five steps imvolved in jdbc connection 
1.Register the driver 
2.Create Conn 
3. Create STatemen
4.Execute Query 
5.Close Conn
*/
package AtmInterface;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            //registration of conection
            // this is done automatically by java Class.forName(com.mysql.cj.jdbc.Driver);
            //creating connection
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Venudeepu98@");
            //creating of statement
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
   
}
