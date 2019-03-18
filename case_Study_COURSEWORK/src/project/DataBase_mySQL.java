

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
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * 
 * Database: phpmyAdmin / mySQL connector ()
 * Data manipulation : JSONArray / ArrayList
 * @author foxst
 */
public class DataBase_mySQL {

    
    private static String connectionURL = "jdbc:mysql://localhost/membershipdb";
    private static String uName = "root";
    private static String uPass= "";
    public static int counter=0;//JSON index of all data inside table member
    
    
    /**
     *
     * Test method 
     * 
     * * extract data as JSON and send it as ArrayList
     * * Json Reader
     * * * Save Index Array as a Object and Display by Key the Values
     */
    public static void main(String[] args) {

        
        
        /*Done extract ALL data from1 members_request and send it as JsonArray*/
        JSONArray  ALLdataMsR = new JSONArray ();
        ALLdataMsR=getALLData_Request();
        System.out.println(ALLdataMsR);
        System.out.println("Data status members request ");
        System.out.println(ALLdataMsR.length());
        System.out.println(ALLdataMsR.getJSONObject(0));
        
        
        
        //Json Reader
        //Save Index Array as a Object and Display by Key the Values
        for(int x=0;x<ALLdataMsR.length();x++){
            JSONArray  Ass = new JSONArray ();
            Ass.put(ALLdataMsR.getJSONObject(x));
            Ass.forEach(item -> {
                JSONObject obj = (JSONObject) item;
                //System.out.println(obj.get("membership").toString());
            
            });
                
        }
        
        
        System.out.println("DELETE by ID ");
        System.out.println(deleteRequestROW("7"));
        
        
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
    
    
    /**
     *      
     * Members on Request 
     * Modifid table names when insert data on 'ArrayLsit'
     * @return JSONArray[index][memData] = memData[value]
     */
    public static JSONArray  getALLData_Request() {
       
        counter=0;
        
        JSONArray  blockData = new JSONArray();
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
                    String date_json=Integer.toString(rs.getInt("request_date"));
                    String gender_json=rs.getString("gender");
                    String pwEncrypt_json=rs.getString("password");
                    
                    JSONObject jObj = new JSONObject(); //json class instance
                    jObj.put("member_id",id_json);
                    jObj.put("username",username_json);
                    jObj.put("email",email_json);
                    jObj.put("address",address_json);
                    jObj.put("membership",meship_json);
                    jObj.put("status",status_json);
                    jObj.put("date",date_json);
                    jObj.put("gender",gender_json);
                    jObj.put("passwordEncrypt",pwEncrypt_json);
                    
                    blockData.put(counter, jObj);
                    counter++;
                }
                
            }else{System.out.println("DB FAILED");}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return blockData;
        
    
    
    }
    
    /**
     *      
     * Members on Request 
     * Modifid table names when insert data on 'ArrayLsit'
     * @return JSONArray[index][memData] = memData[value]
     */
    public static JSONArray  getALLData_() {
       
        counter=0;
        
        JSONArray  blockData = new JSONArray();
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                String sql = "SELECT * FROM members ";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    String  id_json=Integer.toString(rs.getInt("id"));
                    String username_json=rs.getString("username");
                    String email_json=rs.getString("email");
                    String address_json=rs.getString("address");
                    String meship_json=rs.getString("membership");
                    String status_json=Integer.toString(rs.getInt("status"));
                    String date_json=Integer.toString(rs.getInt("date"));
                    String gender_json=rs.getString("gender");
                    String book_json=Integer.toString(rs.getInt("booking"));
                    
                    JSONObject jObj = new JSONObject(); //json class instance
                    jObj.put("member_id",id_json);
                    jObj.put("username",username_json);
                    jObj.put("email",email_json);
                    jObj.put("address",address_json);
                    jObj.put("membership",meship_json);
                    jObj.put("status",status_json);
                    jObj.put("date",date_json);
                    jObj.put("gender",gender_json);
                    jObj.put("booking",book_json);
                    
                    
                    blockData.put(counter, jObj);
                    counter++;
                }
                
            }else{System.out.println("DB FAILED") ;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return blockData;
        
    
    
    }
    
    /**
     * check if username exists on the database
     * @param username
     * @return boolean
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
    
    
     /**
      * 
     * check if username have admin status 
     * @param username
     * @return boolean
     */  
    public static int checkAdmin(String username){//Check Username on DataBase
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                
                String sql = "SELECT COUNT(*)  FROM members WHERE username='"+username+"' AND status=1 AND status=1";
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
     * check if username and password   exists
     * @param data
     * @return boolean
     */ 
    public static int checkPassword(List<String> data){
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
                    }
                    
                }
                
            }else{System.out.println("DB FAILED"); }
        } catch (SQLException ex){
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;//Server Error
        }
        return 0;//nothing found 
    };
    
    
    
    
    /**
     * Regist new user on request table for later be verified by ClubAdvisor/ClubManager
     * @param ArrayList of data inserted by user
     * @return boolean
     */
    public static int registerREQmember(List<String> data){
        /*
        *
        *  data 0 - username
        *  data 1 - pw encrypt - key 256 bytes
        *  data 2 - email
        *  data 3 - address
        *  data 4 - Date
        *
        */
        
        PreparedStatement statement;
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            conn.setAutoCommit(true);

                String compiledQuery = "INSERT INTO members_request (username, password, email, address, membership, status, request_date, gender)" +
                        " VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?)";
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, data.get(0));
                statement.setString(2, data.get(1));
                statement.setString(3, data.get(2));
                statement.setString(4, data.get(3));
                statement.setString(5, "silver");
                statement.setString(6, "0");
                statement.setString(7, data.get(4));
                statement.setString(8, data.get(5));

                statement.executeUpdate();
                statement.close();
                conn.close();
        
                return 1;
            }else{System.out.println("DB FAILED");return 0;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getGlobal();}
        
        
        return 1;
    }
    

    /**
     * Regist new user on request table for later be verified by ClubAdvisor/ClubManager
     * @param ArrayList of data inserted by user
     * @return boolean
     */
    public static int inserREQintoMembers(List<String> data){
        /*
        *
        *  data 0 - username
        *  data 1 - pw encrypt - key 256 bytes
        *  data 2 - email
        *  data 3 - address
        *  data   - membership
        *  data   - status
        *  data 4 - gender
        *  data 5 - date
        *
        */
        
        PreparedStatement statement;
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            conn.setAutoCommit(true);

                String compiledQuery = "INSERT INTO members (username, password, email, address, membership, status, gender, date, booking)" +
                        " VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, data.get(1));
                statement.setString(2, data.get(2));
                statement.setString(3, data.get(3));
                statement.setString(4, data.get(4));
                statement.setString(5, data.get(5));
                statement.setString(6, data.get(6));
                statement.setString(7, data.get(7));
                statement.setString(8, data.get(8));
                statement.setString(9, "0");

                statement.executeUpdate();
                statement.close();
                conn.close();
        
                return 1;
            }else{System.out.println("DB FAILED");return 0;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getGlobal();}
        
        
        return 1;
    }
    

    
    /**
     *      
     * Members on Request 
     * Modifid table names when insert data on 'ArrayLsit'
     * @return JSONArray[index][memData] = memData[value]
     */
    public static int  deleteRequestROW(String idMember) {
       
        counter=0;
        
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
                
                
                PreparedStatement statement;
                
                conn.setAutoCommit(true);

                String compiledQuery = "DELETE FROM members_request WHERE id=?";
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, idMember);

                if(statement.executeUpdate()==1){
;
                    statement.close();
                    conn.close();

                    return 1;
                    
                    
                } else {
                    statement.close();
                    conn.close();

                    return 0;
                }
                
                
            }else{System.out.println("DB FAILED");return -1;/*server error}*/}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            return -1;//server error
        }
        
            
    }
    



}
