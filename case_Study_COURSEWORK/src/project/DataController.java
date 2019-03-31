
package project;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JDialog;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.json.JSONArray;


/**
 *
 * @author deoiveij
 */
public class DataController {
    private static HomeController calls = new HomeController();
    
    private static DataBase_mySQL dataAction = new DataBase_mySQL();

    /**
     *
     * @param data:List String
     * @return
     */
    public void checkLogin(List<String> data){
        /*0 - username , 1 - pw encrypted*/
        int checkUser=dataAction.checkUsername(data.get(0));
        
        if(dataAction.checkUsername(data.get(0))==1){
            
            if(dataAction.checkPassword(data)==1){
                calls.alertINFO("Log in... ");
                calls.callNextLogin(data.get(0));
            }else{
                calls.alertERROR("Fail to Login - Check Username or Password");// PW ERROR
            }
        }else{
            calls.alertERROR("Fail to Login - Check Username or Password");//USER NAME ERROR
        }

    };
    
    
    /*Check username  on official and request table, return true - exists , false - dont*/
    public int checkUsername(String data){
        
        return dataAction.checkUsername(data);
    
    }
    
    
    /*Check username/pass  on official  table for login, return true - exists , false - dont*/
    public static int checkPassword(List<String> data){
        
        return dataAction.checkPassword(data);
        
    };
    
    
    /*Register new user on Request Table, return true - Done , false - not Done*/
    public static int registerREQmember(List<String> data){
        
        return dataAction.registerREQmember(data);
        
    };
    
    
    /*Send User status*/
    public static int checkAdmin(String username) {
        
      return  dataAction.checkAdmin(username);
        
    }
    
    /**
     * GET REQUESTS MEMBERS DATA
     * @return 
     */
    public static JSONArray getALLData_Request(){
       
        return  dataAction.getALLData_Request();
        
    };
    
    
    
    /**
     * Members data
     * @return
     */
    public static JSONArray getALLData_(){
       /*Dont grab pw*/
       //System.out.println(dataAction.getALLData_().toString());
        return  dataAction.getALLData_();
        
    };
    
    /**
     * Member DATA
     * @return
     */
    public static JSONArray getUserData_(String username){
       /*Dont grab pw*/
       //System.out.println(dataAction.getALLData_().toString());
        return  dataAction.getUserData_(username);
        
    };
    /**
     * INSERT NEW OFICIAL MEMBER from Request Table
     * @return true - done , false - not done
     */
    public static int inserREQintoMembers(List<String> data){
       
       return  dataAction.inserREQintoMembers(data);
        
    };
    
    
    /**
     * DELETE REQUEST_ MEMBER by id
     * @return  true - done , false - not done
     */
    public static int deleteRequestROW(String id){
       
        return  dataAction.deleteRequestROW(id);
        
    };
    
    
    
    /**
     * Delete OFICIAL MEMBER using member ID
     * @return boolean
     */
    public static int deleteMemberROW(String usernameID){
       
       return  dataAction.deleteMemberROW(usernameID);
        
    };
    
    
    /**
     * Update OFICIAL MEMBER
     * @return boolean
     */
    public static int modifyMember(List<String> data){
       
       return  dataAction.modifyMember(data);
        
    };
    
    
    /**
     * Member DATA - update - member manually update DATA - memberFrame
     * @return
     */
    public static int setUserDataUpdate(List<String> data){
        
        return  dataAction.setUserDataUpdate(data);
        
    };
    
    
    /**
     * Set  Member Membership
     * @return
     */
    public static int setMembership(String username,String membership){
        
        return  dataAction.setMembership(username, membership);
        
    };
    
    /**
     * Revoke Member membership to silver and update date
     * @return
     */
    public static int revokeUser(String username,String date){
        
        return  dataAction.revokeUser(username, date);
        
    };
    
    
    
    /**
     * Add +1 to Member booking
     * @return
     */
    public static int addBookClass(String username,String number){
        
        return  dataAction.addBookClass(username, number);
        
    };
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
