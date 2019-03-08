/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import com.google.gson.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author foxst
 */
public class HomeController {
    
    public static  String varUser;
    
    private static DataBase_mySQL dataAction = new DataBase_mySQL();
    
    private static loginFrame loginFrame = new loginFrame();
    public static Admin_FRAME Admin_FRAME = new Admin_FRAME();
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
    public static JsonArray getREMembersData(){
        
        JsonArray dataJson = new JsonArray();
        dataJson.addAll(dataAction.getALLData_Request());
        return dataJson;
        
    }
    
    
    
    
    
    
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
    
    
    
}
