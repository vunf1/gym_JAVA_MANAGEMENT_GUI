
package project;

import java.awt.Point;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author deoiveij
 */
public class Extras_Notifier {
    HomeController calls = new HomeController(); 
    EncryptClass encrypt= new EncryptClass();
    

    /**
     * Custom Alert Objects
     * @param s:String
     */
    public void alertWARR(String s){
        JOptionPane optionPane = new JOptionPane(s,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog
    };

    
    /**
     * Custom Alert Object 
     * @param s:String
     */
    public void alertINFO(String s){
        JOptionPane optionPane = new JOptionPane(s,JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Information!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog
    };

    
    /**
     * Custom Alert Object
     * @param s:String
     */
    public void alertERROR(String s){
        JOptionPane optionPane = new JOptionPane(s,JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog("Error!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog
    };
    
    
    /**
     *
     * @param data:List String
     * @return
     */
    public void checkLogin(List<String> data){
        int checkUser=calls.checkUsername(data.get(0));
        
        if(calls.checkUsername(data.get(0))==1){
            
        }
        if(calls.checkPassword(data)==1){
            alertINFO("Log in... ");
            calls.callNextFrame(data.get(0));
        }else{
            alertERROR("Fail to Login - Check Username or Password");
        }

    };
    
    
    public int registerMember(List<String> data){
        /*Register new member to member_request to see checked by Advisor*/
        
        
        return calls.registerREQmember(data);
        
        
    }
    
}