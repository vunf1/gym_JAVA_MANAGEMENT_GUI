/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.awt.Color;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    
    
    
    
    
    
    public static void callNextFrame(String username) {
        varUser=username;
        loginFrame.setVisible(false);
        if(dataAction.checkAdmin(username).equals("1")){
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
