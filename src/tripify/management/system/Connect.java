package tripify.management.system;
import java.sql.*;
public class Connect {
    
    Connection c;
    Statement s;
    Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//1.register the driver 
            c= DriverManager.getConnection("jdbc:mysql:///tripifymanagementsystem","root","wowwow@29");//2.connection string
            s=c.createStatement();//3.creating the statement
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
