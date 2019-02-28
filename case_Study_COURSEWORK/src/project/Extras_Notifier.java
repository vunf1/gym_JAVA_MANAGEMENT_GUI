/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author foxst
 */
public class Extras_Notifier {
    
    public void alertWARR(String s){
        JOptionPane optionPane = new JOptionPane(s,JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog
    };
    public void alertINFO(String s){
        JOptionPane optionPane = new JOptionPane(s,JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Information!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog
    };
    public void alertERROR(String s){
        JOptionPane optionPane = new JOptionPane(s,JOptionPane.ERROR_MESSAGE);
        JDialog dialog = optionPane.createDialog("Error!");
        dialog.setAlwaysOnTop(true); // to show top of all other application
        dialog.setVisible(true); // to visible the dialog
    };
    
    public void centerFrame() {
        
        
        //call to center Frames to center of actual Screen
          /* 
        Dimension windowSize = getSize();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Point centerPoint = ge.getCenterPoint();

            int dx = centerPoint.x - windowSize.width / 2;
            int dy = centerPoint.y - windowSize.height / 2;    
            setLocation(dx, dy);
    */
    };
    
}
