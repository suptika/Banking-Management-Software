package bank.management.system;

import java.sql.*;

public class connection {
    Connection connection;
    Statement statement;

    public connection(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","#Mon9732");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}