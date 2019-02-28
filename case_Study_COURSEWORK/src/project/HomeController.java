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

/**
 *
 * @author foxst
 */
public class HomeController {
    
    private static DataBase_mySQL data = new DataBase_mySQL();
    
    
    
    public static void main(String[] args) {
        
        
        loginFrame obj = new loginFrame();
       
        obj.setVisible(true);
        System.out.println(obj);
        
    }
    
    public static JsonArray getMembersData(){
        
        JsonArray dataJson = new JsonArray();
        dataJson.addAll(data.getALLData_Request());
        return dataJson;
        
    }
    
}
