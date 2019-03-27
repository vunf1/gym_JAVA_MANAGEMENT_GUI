
package project;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.swing.JDialog;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author deoiveij
 */
public class Extras_Notifier {
    private HomeController calls = new HomeController();
    
/**
     * Custom Alert Objects Yes No 
     * @param s:String
     */
    public boolean alertYesNo(String s){
        JOptionPane optionPane = new JOptionPane();
        Object[] options = {"Yes !","No !"};
        
        int n = JOptionPane.showOptionDialog(optionPane,
        s,
        "WARNING",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[1]); //default button title
        
        
        
        if (n == optionPane.YES_OPTION) {
            return true;
            // yes option
        } else {
            return false;
    // no option
        }
    };
    
    
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
     
    public static Font loadFont(float size, int style, JPanel jp) throws IOException {
               // Opens the JPanel's resource called font/chem1.ttf
	InputStream is = jp.getClass().getResourceAsStream("KOMIKAX_.ttf");
        Font font = null;
	try {
		font = Font.createFont(Font.TRUETYPE_FONT, is);
		font = font.deriveFont(size);
		font = font.deriveFont(style);
	} catch (FontFormatException e) {
                       System.err.println("Font is null");
                       System.exit(1);
	} catch (IOException e) {
                       System.err.println("Font is null");
                       System.exit(1);
	}
	
               // CAREFUL, if font returns null, you can have NullPointerExceptions
	return font;
}
    
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
            calls.callNextLogin(data.get(0));
        }else{
            alertERROR("Fail to Login - Check Username or Password");
        }

    };
    public int checkUsername(String data){
        System.out.println(data);
        return calls.checkUsername(data);
    
    }
    
    
    public int registerMember(List<String> data){
        /*Register new member to member_request to see checked by Advisor*/
        
        
        return calls.registerREQmember(data);
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
