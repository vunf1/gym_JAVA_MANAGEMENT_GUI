
package project;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * 
 * Database: phpmyAdmin / mySQL connector ()
 * Data manipulation : JSONArray / List
 * @author deoiveij
 */
public class DataBase_mySQL {
    
    
    
    /* Coventry Domain DB 
    private static String connectionURL = "jdbc:mysql://46.101.88.96/vunfcove_membershipdb";
    private static String uName = "root";
    private static String uPass= "1996maia123";
    */
    
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
     * 
     */
    public static void main(String[] args) {

        
        
        
        
        
        
        System.out.println(checkUsername("qws"));
        
        /*Done extract ALL data from1 members_request and send it as JsonArray*/
        
        JSONArray  ALLdataMsR = new JSONArray ();
        ALLdataMsR=getALLData_Request();
        System.out.println(ALLdataMsR);
        System.out.println("Data status members request ");
        System.out.println(ALLdataMsR.length());
        System.out.println(ALLdataMsR.getJSONObject(0));
        
        
        
        //Json Reader
        //Save Index Array as a Object and Display by Key the Values
        
        JSONArray  ALLdata = new JSONArray ();
        ALLdata=getALLData_();
        for(int x=0;x<ALLdata.length();x++){
            JSONArray  Ass = new JSONArray ();
            Ass.put(ALLdata.getJSONObject(x));
            Ass.forEach(item -> {
                JSONObject obj = (JSONObject) item;
                //System.out.println(obj.get("membership").toString());
                //System.out.println(item.toString());
            
            });
                
        }
        
        
        System.out.println("DELETE by ID - OFF ");
        //System.out.println(deleteRequestROW("7"));
        
        
        
        
        
    }
    
    
    /**
     *      
     * Members on Request DATA
     * 
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
     * Members DATA
     * return ALL member data to the Admin
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
                    String pw_json=rs.getString("password");
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
                    jObj.put("password",pw_json);
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
     *
     * Return all user Data on member Table
     * @return JSONArray
     */
    public static JSONArray  getUserData_(String username) {
       
        counter=0;
        
        JSONArray  blockData = new JSONArray();
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                String sql = "SELECT * FROM members WHERE username='"+username+"'";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    
                    
                    
                    String  id_json=Integer.toString(rs.getInt("id"));
                    String username_json=rs.getString("username");
                    String pw_json=rs.getString("password");
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
                    jObj.put("password",pw_json);
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
     * check if username exists on the database -Table Member
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
                    
                    if(rs.getInt(1 )>=1){
                        
                        return 1;
                        
                    }else{ 
                        

                        String sql2 = "SELECT COUNT(*)  FROM members_request WHERE username='"+username+"'";
                        rs=st.executeQuery(sql2);

                        while(rs.next()){
                            
                            if(rs.getInt(1 )>=1){
                                
                                return 1;

                            }else{

                                return 0;
                                
                            }

                        }
                    }
                    
                }
                
                
                
            }else{System.out.println("DB FAILED"); }
        } catch (SQLException ex){
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return 0;
    };
    
    
     /**
      * 
     * send username account status to verify 
     * @param username
     * @return boolean
     */  
    public static int checkAdmin(String username){//Check Username on DataBase
        
        
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            
                Statement st = conn.createStatement();
                ResultSet rs=null;
                
                String sql = "SELECT status  FROM members WHERE username='"+username+"'";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    
                    return  rs.getInt(1);
                        
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
    //data 1 password ENCRYP
        
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
     * @param List of data inserted by user
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
        
        
        return -1;
    }
    

    /**
     * This method prevent SQL IN
     * Insert member data table[request] into table[member]
     * 
     * @param List of data inserted by user
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
     * Members [on Request] 
     * Delete Row on table REQUEST
     * @return boolean
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
    

    /**
     *      
     * Modify Member - FROM adminFRAME
     * modify Row on table Member
     * @return boolean
     */
    public static int modifyMember(List<String> data){
        /*
        *
        *  data 0 - username
        *  data 1 - pw encrypt - key 256 bytes
        *  data 2 - email
        *  data 3 - address
        *  data 4 - membership
        *  data 5 - status
        *  data 6 - gender
        *  data 7 - date
        *  data 8 - booking
        *  data 9 - id
        *
        */
        
        PreparedStatement statement;
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            conn.setAutoCommit(true);

                String compiledQuery = "Update members set username=? ,password=?, email=?, address=?, membership=?, status=?, gender=?, date=?, booking=? WHERE id=?";
                
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, data.get(0));
                statement.setString(2, data.get(1));
                statement.setString(3, data.get(2));
                statement.setString(4, data.get(3));
                statement.setString(5, data.get(4));
                statement.setString(6, data.get(5));
                statement.setString(7, data.get(6));
                statement.setString(8, data.get(7));
                statement.setString(9, data.get(8));
                statement.setString(10, data.get(9));

                if(statement.executeUpdate()==1){
                    statement.close();
                    conn.close();

                    return 1;
                    
                    
                } else {
                    statement.close();
                    conn.close();

                    return 0;
                }
            }else{System.out.println("DB FAILED");return 0;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getGlobal();}
        
        
        return 1;
    }
    


    
    /**
     *      
     * Delete Member - FROM adminFRAME
     * Delete Row on table Member
     * @return boolean
     */
    public static int  deleteMemberROW(String idMember) {
       
        counter=0;
        
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
                
                
                PreparedStatement statement;
                
                conn.setAutoCommit(true);

                String compiledQuery = "DELETE FROM members WHERE id=?";
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, idMember);

                if(statement.executeUpdate()==1){
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
    
    
    /**
     *      
     * Update Member - FROM memberFRAME
     * update Row on table Member
     * @return boolean
     */
    public static int setUserDataUpdate(List<String> data){
        /*
        *
        *  data 0 - ID
        *  data 1 - username
        *  data 2 - pw encrypt - key 256 bytes
        *  data 3 - email
        *  data 4 - address
        *  data 5 - gender
        *
        */
        
        
        PreparedStatement statement;
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            conn.setAutoCommit(true);

                String compiledQuery = "Update members set username=? ,password=?, email=?, address=?, gender=? WHERE id=?";
                
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, data.get(1));
                statement.setString(2, data.get(2));
                statement.setString(3, data.get(3));
                statement.setString(4, data.get(4));
                statement.setString(5, data.get(5));
                statement.setString(6, data.get(0));
                

                if(statement.executeUpdate()==1){
                    statement.close();
                    conn.close();

                    return 1;
                    
                    
                } else {
                    statement.close();
                    conn.close();

                    return 0;
                }
            }else{System.out.println("DB FAILED");return 0;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getGlobal();}
        
        
        return -1;
    }
    
    
    
    /**
     * Revoke Member membership to silver and update date
     * @return
     */
     public static int revokeUser(String username,String date){
        
        
        PreparedStatement statement;
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            conn.setAutoCommit(true);

                String compiledQuery = "Update members set date=?,booking=0,membership='silver' WHERE username=?";
                
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, date);
                statement.setString(2, username);

                if(statement.executeUpdate()==1){
                    statement.close();
                    conn.close();

                    return 1;
                    
                    
                } else {
                    statement.close();
                    conn.close();

                    return 0;
                }
            }else{System.out.println("DB FAILED");return 0;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getGlobal();}
        
        
        return -1;
    }
     
     
    /**
     * Send OldBooking number +1 plus username and update on DB
     * @return boolean
     *
     */
    public static int addBookClass(String username,String value){
        /*
        *
        *  data 0 - username
        *
        */
        
        
        PreparedStatement statement;
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            conn.setAutoCommit(true);

                String compiledQuery = "Update members set  booking=? WHERE username=?";
                
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, value);
                statement.setString(2, username);

                if(statement.executeUpdate()==1){
                    statement.close();
                    conn.close();

                    return 1;
                    
                    
                } else {
                    statement.close();
                    conn.close();

                    return 0;
                }
            }else{System.out.println("DB FAILED");return 0;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getGlobal();}
        
        
        return -1;
    }


/**
     * Send OldBooking number +1 plus username and update on DB
     * @return boolean
     *
     */
    public static int setMembership(String username,String membership){
        /*
        *
        *  data 0 - username
        *
        */
        
        
        PreparedStatement statement;
        try {
            Connection conn = DriverManager.getConnection(connectionURL, uName, uPass);
            if (conn != null){
            conn.setAutoCommit(true);

                String compiledQuery = "Update members set  membership=? WHERE username=?";
                
                statement = conn.prepareStatement(compiledQuery);


                statement.setString(1, membership);
                statement.setString(2, username);

                if(statement.executeUpdate()==1){
                    statement.close();
                    conn.close();

                    return 1;
                    
                    
                } else {
                    statement.close();
                    conn.close();

                    return 0;
                }
            }else{System.out.println("DB FAILED");return 0;}
        } catch (SQLException ex) {
            Logger.getLogger(DataBase_mySQL.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getGlobal();}
        
        
        return -1;
    }



}
