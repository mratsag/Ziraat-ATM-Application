package bank_system;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
    Connection connection;
    Statement statement;

    public Connect(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","admin","LG13262.m");
            statement = connection.createStatement();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
