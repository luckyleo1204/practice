package com.test.murali;

import javax.swing.*;
import java.sql.*;

import static java.lang.Class.forName;

public class dbConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //class.forName("Oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection("jdbc:oracle:thin:@<hostName>:<portNumber>:<DBName>","userid","pasword" );
        String Query="Select * from emp";
        Statement st=con.createStatement();
         boolean status=st.execute(Query);
         if(status){
               ResultSet rs= st.getResultSet();
               while(rs.next()){
                   System.out.println(rs.getString(1));
               }
         }


    }
}


