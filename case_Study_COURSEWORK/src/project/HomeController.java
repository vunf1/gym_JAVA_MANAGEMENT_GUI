/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
/*
label_name - username
label_email - email
label_membership - membership

n_actual_class_booked2 - label booking number
progressBar_membership2 - prossgressbar 3simplerule
*/

import java.awt.Color;
import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author foxst
 */
public class HomeController {
    /*-USERNAME - After Login-*/
    public static  String varUser;
    
    
    private static DataBase_mySQL dataAction = new DataBase_mySQL();
    
    
    
    private static loginFrame loginFrame;//Login Frame - Index
    private static Admin_FRAME Admin_FRAME;//Admin Frame - ClubAdvisor, ClubManager
    private static index_FRAME index_FRAME;//Member Frame
    
    
   
    
    /**
     *
     * Main 
     */
    public static void main(String[] args) {
        loginFrame = new loginFrame();
        
        loginFrame.imgInitSetup();
        loginFrame.setVisible(true);
        
        
    }
    
    
    
    /*Log Out from frame */
    public static void logOut(String data){
        
        index_FRAME.backToAdmin.setVisible(false);
        if(data.equals("admin")){
            Admin_FRAME.setVisible(false);
            loginFrame.setVisible(true);
        }else{
            index_FRAME.setVisible(false);
            loginFrame.setVisible(true);
        }
        
    };
    
    
    /*After Login*/
    public static void callNextLogin(String username) {
        varUser=username;
        
        loginFrame.setVisible(false);
        
        if(dataAction.checkAdmin(username)==1){
            Admin_FRAME = new Admin_FRAME();
            Admin_FRAME.displayUser();
            Admin_FRAME.ImageIconSetup(1);
            Admin_FRAME.noOnAdvisor(0);
            Admin_FRAME.setVisible(true);
        
        }if(dataAction.checkAdmin(username)==2){
            Admin_FRAME = new Admin_FRAME();
            Admin_FRAME.displayUser();
            Admin_FRAME.ImageIconSetup(2);
            Admin_FRAME.noOnAdvisor(1);
            Admin_FRAME.setVisible(true);
        
        }
        if(dataAction.checkAdmin(username)==0){
            index_FRAME = new index_FRAME(); 
            index_FRAME.displayUser(varUser);
            index_FRAME.initFrame();
            index_FRAME.setVisible(true);
        
        }
        
      
        
    }
    
    
    public static void callMemberFrame_Admin(int op){
        if(op==1){
            Admin_FRAME.setVisible(false);   
            index_FRAME = new index_FRAME();
            index_FRAME.displayUser(varUser);
            index_FRAME.backToAdmin.setVisible(true);
            index_FRAME.initFrame();
            index_FRAME.setVisible(true);
        }else{
            
            index_FRAME.setVisible(false);  
            index_FRAME.backToAdmin.setVisible(false);
            
            Admin_FRAME.setVisible(true);
            
            
        }
        
    }
    
    /*Check username  on official and request table, return true - exists , false - dont*/
    public static int checkUsername(String data){
        
        return  dataAction.checkUsername(data);
        
    };
    
    /*Check username/pass  on official  table for login, return true - exists , false - dont*/
    public static int checkPassword(List<String> data){
        
        return dataAction.checkPassword(data);
        
    };
    
    /*Register new user on Request Table, return true - Done , false - not Done*/
    public static int registerREQmember(List<String> data){
        
        return dataAction.registerREQmember(data);
        
    };
    
    /**
     * GET REQUESTS MEMBERS DATA
     * @return 
     */
    public static JSONArray getREMembersData(){
       
        return  dataAction.getALLData_Request();
        
    };
    
    
    /**
     * DELETE REQUEST_ MEMBER by id
     * @return  true - done , false - not done
     */
    public static int delREQmember(String id){
       
        return  dataAction.deleteRequestROW(id);
        
    };
    
    
    /**
     * INSERT NEW OFICIAL MEMBER from Request Table
     * @return true - done , false - not done
     */
    public static int insertNewMember(List<String> data){
       
       return  dataAction.inserREQintoMembers(data);
        
    };
    
    /**
     * Update OFICIAL MEMBER
     * @return boolean
     */
    public static int updateMember(List<String> data){
       
       return  dataAction.modifyMember(data);
        
    };
    
    
    /**
     * Delete OFICIAL MEMBER using member ID
     * @return boolean
     */
    public static int deleteMember(String usernameID){
       
       return  dataAction.deleteMemberROW(usernameID);
        
    };
    
    
    /*Send User status*/
    public static int checkAdmin(String username) {
        
      return  dataAction.checkAdmin(username);
        
    }
    
    /**
     * Members data
     * @return
     */
    public static JSONArray getUsersData(){
       /*Dont grab pw*/
       //System.out.println(dataAction.getALLData_().toString());
        return  dataAction.getALLData_();
        
    };
    
    /**
     * Member DATA
     * @return
     */
    public static JSONArray getUserData(String username){
       /*Dont grab pw*/
       //System.out.println(dataAction.getALLData_().toString());
        return  dataAction.getUserData_(username);
        
    };
    
    /**
     * Member DATA - update - member manually update DATA - memberFrame
     * @return
     */
    public static int setUserDataUpdate(List<String> data){
       System.out.println(data);
        return  dataAction.setUserDataUpdate(data);
        
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
    
    /**
     * Set  Member Membership
     * @return
     */
    public static int setMembership(String username,String membership){
        
        return  dataAction.setMembership(username, membership);
        
    };
}
