/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author foxst
 */

package project;

import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import com.google.gson.*;
import java.util.List;

/**
 *
 * @author foxst
 */
public class DataBase_mySQL {

    
    public static String connectionURL = "jdbc:mysql://localhost/membershipdb";
    public static String uName = "root";
    public static String uPass= "";
    
    public static void main(String[] args) {

        
        /*Done extract data from1 user and send it as ArrayList*/
        //ArrayList data = new ArrayList<String>();
        //data.addAll(getMemberData_Request("vunf1"));
        //System.out.println("Data from single member");
        //System.out.println(data);
        //System.out.println(data.get(2));
        
        //System.out.println(setNewMember(data));
        
        /*Done extract ALL data from1 members_request and send it as JsonArray*/
        /*JsonArray ALLdataMsR = new JsonArray();
        ALLdataMsR.addAll(getALLData_Request());
        System.out.println(ALLdataMsR);
        System.out.println("Data from members ");
        System.out.println(ALLdataMsR.size());
        System.out.println(ALLdataMsR.get(0));*/
        
        
        //System.out.println(checkUsername("m"));
        
        
        
        
        
        
        
        
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
        
        System.out.println(checkAdmin("m"));
        
    }
    
    /**
     *
     * @param username
     * @return
     */
    public static ArrayList getMemberData_Request(String username) {
       
        
        ArrayList<String> blockData = new ArrayList<String>();
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                //retrieve the sample records from the Person table
                //System.out.println("retrieve the sample records");
                //System.out.println("---------------------------------");
                String sql = "SELECT * FROM members_request WHERE username='"+username+"'";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    
                    blockData.add(Integer.toString(rs.getInt("id")));
                    blockData.add(rs.getString("username"));
                    blockData.add(rs.getString("password"));
                    blockData.add(rs.getString("email"));
                    blockData.add(rs.getString("address"));
                    blockData.add(rs.getString("membership"));
                    blockData.add(rs.getString("status"));
                    
                    
                }
                
            }else{System.out.println("DB FAILED");}
        } catch (SQLException ex){
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return blockData;
        
    }
    
    /**
     *
     * @return
     */
    public static JsonArray getALLData_Request() {
       
        
        JsonArray blockData = new JsonArray();
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                String sql = "SELECT * FROM members_request ";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    String  id_json=Integer.toString(rs.getInt("id"));
                    String username_json=rs.getString("username");
                    String email_json=rs.getString("email");
                    String address_json=rs.getString("address");
                    String meship_json=rs.getString("membership");
                    String status_json=Integer.toString(rs.getInt("status"));
                    
                    JsonObject jObj = new JsonObject(); //json class instance
                    jObj.addProperty("member_id",id_json);
                    jObj.addProperty("username",username_json);
                    jObj.addProperty("email",email_json);
                    jObj.addProperty("address",address_json);
                    jObj.addProperty("membership",meship_json);
                    jObj.addProperty("status",status_json);
                    
                    blockData.add(jObj);
                    
                }
                
            }else{System.out.println("DB FAILED");}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return blockData;
        
    
    
    }
    
    /**
     *
     * @param username
     * @return
     */
    public static int checkUsername(String username){//Check Username on DataBase
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                
                String sql = "SELECT COUNT(*)  FROM members WHERE username='"+username+"'";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    if(rs.getInt(1 )==1){
                        return 1;
                    };
                    
                }
                
            }else{System.out.println("DB FAILED"); }
        } catch (SQLException ex){
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 0;//nothing found 
    };
    
    
     
    public static String checkAdmin(String username){//Check Username on DataBase
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                
                String sql = "SELECT COUNT(*)  FROM members WHERE username='"+username+"' AND status=1 AND status=1";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    if(rs.getInt(1 )==1){
                        return "1";
                    };
                    
                }
                
            }else{System.out.println("DB FAILED"); }
        } catch (SQLException ex){
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return "-1";
        }
        return "0";//nothing found 
    }; 
    /**
     *
     * @param username
     * @return
     */
    public static int checkPassword(List<String> data){//Check Username on DataBase
        //data 0 username
        //data 1 password
        
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                
                String sql = "SELECT COUNT(*)  FROM members WHERE username='"+data.get(0)+"' AND password='"+data.get(1)+"'";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    if(rs.getInt(1 )==1){
                        return 1;
                    };
                    
                }
                
            }else{System.out.println("DB FAILED"); }
        } catch (SQLException ex){
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return 0;//nothing found 
    };
    
    
    
    
    /**
     *
     * @param data
     * @return
     */
    public static int registerREQmember(List<String> data){
        /*
        *
        *  data 0 - username
        *  data 1 - pw
        *  data 2 - email
        *  data 3 - address
        *
        */
        
        PreparedStatement statement;
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            conn.setAutoCommit(true);

        String compiledQuery = "INSERT INTO members_request (username, password, email, address, membership,status)" +
                " VALUES" + "(?, ?, ?, ?, ?, ?)";
        statement = conn.prepareStatement(compiledQuery);


        statement.setString(1, data.get(0));
        statement.setString(2, data.get(1));
        statement.setString(3, data.get(2));
        statement.setString(4, data.get(3));
        statement.setString(5, "silver");
        statement.setString(6, "0");

        statement.executeUpdate();
        statement.close();
        conn.close();
                
            }else{System.out.println("DB FAILED");return 0;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getGlobal();}
        
        
        return 1;
    }
    
}
