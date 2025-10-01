package bank_Management_System;
import java.sql.*;

import static java.lang.Class.forName;

public class connectorDb {
    Connection c;
    Statement s;
    public connectorDb() {



        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Fouzan@123#");
          s=c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
