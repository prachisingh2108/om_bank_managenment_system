package bank.management.system;
import java.sql.*;

public class Con {

    Connection c;
    Statement s;
    public Con()
    {
        try
        {
           //Class.forName(com.mysql.cj.jdbc.Driver);
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","12345");
           s=c.createStatement();
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
