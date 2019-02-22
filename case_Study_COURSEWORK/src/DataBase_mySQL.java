/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author foxst
 */
import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase_mySQL {

    
    public static String connectionURL = "jdbc:mysql://localhost/MembershipDB";
    public static String uName = "root";
    public static String uPass= "";
    
    public static void main(String[] args) {

        
        DataBase_mySQL.getMemberData_Request("vunf1");
        /*
        System.out.println("Trying to connect to database...");
        Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
        System.out.println("Connected");
        if (conn != null){
        Statement st = conn.createStatement();
        ResultSet rs=null;
        //retrieve the sample records from the Person table
        System.out.println("retrieve the sample records");
        System.out.println("---------------------------------");
        String sql = "SELECT * FROM members_request ";
        rs=st.executeQuery(sql);
        while(rs.next()){
        System.out.println(rs.getInt("id")+"\t"+rs.getString("username")+"\t"+rs.getString("membership"));
        }
        
        /*
        //insert a new record to the Person table (id = 2; first name = Paul)
        sql = "INSERT INTO Person VALUES (2, 'Paul')";
        st.executeUpdate(sql);
        
        System.out.println("insert a sample record");
        System.out.println("---------------------------------");
        sql = "SELECT * FROM Person ";
        rs=st.executeQuery(sql);
        while(rs.next()){
        System.out.println(rs.getInt("id")+"\t"+rs.getString("firstname"));
        }
        */
        /*
        //update a record in the Person table (id = 1; first name = David)
        sql = "UPDATE Person SET firstname='David' WHERE id=1";
        st.executeUpdate(sql);
        
        System.out.println("update the sample record");
        System.out.println("---------------------------------");
        sql = "SELECT * FROM Person ";
        rs=st.executeQuery(sql);
        while(rs.next()){
        System.out.println(rs.getInt("id")+"\t"+rs.getString("firstname"));
        }
        
        //delete a record from the Person table (id = 2)
        sql = "DELETE FROM Person WHERE id=2";
        st.executeUpdate(sql);
        
        System.out.println("delete the sample record");
        System.out.println("---------------------------------");
        sql = "SELECT * FROM Person ";
        rs=st.executeQuery(sql);
        while(rs.next()){
        System.out.println(rs.getInt("id")+"\t"+rs.getString("firstname"));
        }
        
        
        rs.close();
        st.close();
        conn.close();
        System.out.println("Connection is closed.");
        
        } else {
        System.out.println("null");
        }
        */
    }
    
    public static void getMemberData_Request(String username) {
       
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                //retrieve the sample records from the Person table
                System.out.println("retrieve the sample records");
                System.out.println("---------------------------------");
                String sql = "SELECT * FROM members_request WHERE username='"+username+"'";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    System.out.println(rs.getInt("id")+"\t"+rs.getString("username")+"\t"+rs.getString("membership"));
                }
            }else{System.out.println("DB FAILED");}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    

    
}
