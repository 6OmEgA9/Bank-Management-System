package bank.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);  (since we have added the Library JDBC connector so the java compiler will itself Register the sql file, We dont need to register it EXPLICITLY)
            c = DriverManager.getConnection("jdbc:mysql:///BankMannagementSystem","root","#SAYANbTech03");
            s = c.createStatement();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
