/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.util.List;
import org.json.JSONArray;

/**
 *
 * @author foxst
 */
public class HomeController {
    /*-USERNAME - After Login-*/
    public static  String varUser="m";
    
    
    private static DataBase_mySQL dataAction = new DataBase_mySQL();
    
    
    
    private static loginFrame loginFrame = new loginFrame();
    private static Admin_FRAME Admin_FRAME = new Admin_FRAME();
    private static index_FRAME index_FRAME = new index_FRAME();
    
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        
        
        loginFrame.setVisible(true);
        
        
    }
    
    public static int checkUsername(String data){
        
        return  dataAction.checkUsername(data);
        
    };
    
    public static int checkPassword(List<String> data){
    //System.out.println(data.get(1));
        return dataAction.checkPassword(data);
        
    };
    
    public static int registerREQmember(List<String> data){
    //System.out.println(data.get(1));
        return dataAction.registerREQmember(data);
        
    };
    
    /**
     * REQUESTS_
     * @return
     */
    public static JSONArray getREMembersData(){
       
        return  dataAction.getALLData_Request();
        
    };
    
    
    /**
     * DELETE REQUEST_ MEMBER by id
     * @return
     */
    public static int delREQmember(String id){
       
        return  dataAction.deleteRequestROW(id);
        
    };
    
    
    /**
     * INSERT NEW OFICIAL MEMBER
     * @return boolean
     */
    public static int insertNewMember(List<String> data){
       
       return  dataAction.inserREQintoMembers(data);
        
    };
    
    
    
    
    
    
    public static void logOut(String data){
        
        if(data.equals("admin")){
            Admin_FRAME.setVisible(false);
            loginFrame.setVisible(true);
        }else{
            
            index_FRAME.setVisible(false);
            loginFrame.setVisible(true);
        }
        
    };
    
    public static void callNextLogin(String username) {
        varUser=username;
        
        loginFrame.setVisible(false);
        
        if(dataAction.checkAdmin(username)==1){
            
            Admin_FRAME.displayUser();
            Admin_FRAME.setVisible(true);
        
        }else{
            
            index_FRAME.setVisible(true);
        
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int checkMembership(){
        
       
        return  -1;
        
    };
    
}
