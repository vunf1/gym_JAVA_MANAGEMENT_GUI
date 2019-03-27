
package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsConfiguration;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.border.Border;

import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author foxst
 */

public class Admin_FRAME extends javax.swing.JFrame {       
    

    public static final Color sSilver = new Color(87,86,82);
    public static final Color gGold = new Color(218,165,32);
    public static final Color pPlatinum = new Color(229,228,226);
    private static HomeController controller = new HomeController();
    private static Extras_Notifier alert = new Extras_Notifier();
    private static EncryptClass encrypt= new EncryptClass();
    
    protected DateTimer timerThread;
    
    protected GraphicsConfiguration gc;
    /**
     * Creates new form Admin_Page
     */
    private JSONArray dataJson = new JSONArray();
    
       private JSONArray  dataJsonMem = new JSONArray();
    
    
    public Admin_FRAME() {
        
        
        initComponents();
        
        //label_username_left.setText(controller.varUser);
        dataJson=controller.getREMembersData();
        badge_count_request.setText(String.valueOf(dataJson.length()));//badge Requests
        
        
        dataJsonMem=controller.getUsersData();
        label_users_info.setText(String.valueOf(dataJsonMem.length()));//badge Users
        
        timerThread = new DateTimer(_date, _time);
        timerThread.start();
        
        
    }

    public void ImageIconSetup(int option){
        //System.out.println(getClass().getResource("/assets/fullGym.png").toString());
        //System.out.println(controller.checkAdmin(label_username_left.getText().toString()));
             int scale = 3;   
         if(option==1){
              int scale2 = 2;  
             btn_users_managment.setVisible(false);
             label_users_info.setVisible(false);
            ImageIcon logo = new ImageIcon(getClass().getResource("/project/assets/clubAdvisorLogo.png"));

            int width = logo.getIconWidth();
            int newWidth = width / scale2;
            icon_logo.setBorderPainted(false);
            icon_logo.setBorder(null);
            icon_logo.setContentAreaFilled(false);
            icon_logo.setFocusPainted(false);
            icon_logo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
             
         }    
         if(option==2){
              int scale2 = 2;  
             btn_users_managment.setVisible(true);
            ImageIcon logo = new ImageIcon(getClass().getResource("/project/assets/clubManagerLogo.png"));

            int width = logo.getIconWidth();
            int newWidth = width / scale2;
            icon_logo.setBorderPainted(false);
            icon_logo.setBorder(null);
            icon_logo.setContentAreaFilled(false);
            icon_logo.setFocusPainted(false);
            icon_logo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
             
         } 
        
        
        ImageIcon logOutICON = new ImageIcon(getClass().getResource("/project/assets/logOut.png"));
        
        int width2 = logOutICON.getIconWidth();
        int newWidth2 = width2 / scale;
        
        btn_logOut.setBorderPainted(false);
        btn_logOut.setBorder(null);
        btn_logOut.setContentAreaFilled(false);
        btn_logOut.setFocusPainted(false);
        btn_logOut.setIcon(new ImageIcon(logOutICON.getImage().getScaledInstance(newWidth2, -1,java.awt.Image.SCALE_SMOOTH)));
        
        
        ImageIcon membersREICON = new ImageIcon(getClass().getResource("/project/assets/membersRequest.png"));
        
        int width3 = membersREICON.getIconWidth();
        int newWidth3 = width3 / scale;
        btn_membersRequest.setBorderPainted(false);
        btn_membersRequest.setBorder(null);
        btn_membersRequest.setContentAreaFilled(false);
        btn_membersRequest.setFocusPainted(false);
        btn_membersRequest.setIcon(new ImageIcon(membersREICON.getImage().getScaledInstance(newWidth3, -1,java.awt.Image.SCALE_SMOOTH)));
        
        
        ImageIcon btnUsers = new ImageIcon(getClass().getResource("/project/assets/users.png"));
        
        int width4 = btnUsers.getIconWidth();
        int newWidth4 = width4 / scale;
        btn_users_managment.setBorderPainted(false);
        btn_users_managment.setBorder(null);
        btn_users_managment.setContentAreaFilled(false);
        btn_users_managment.setFocusPainted(false);
        btn_users_managment.setIcon(new ImageIcon(btnUsers.getImage().getScaledInstance(newWidth4, -1,java.awt.Image.SCALE_SMOOTH)));
        
        
        
        
        ImageIcon btnExit = new ImageIcon(getClass().getResource("/project/assets/exit.png"));
        int scale5 = 3; 
        int width5 = btnExit.getIconWidth();
        int newWidth5 = width5 / scale5;
        btn_exit.setBorderPainted(false);
        btn_exit.setBorder(null);
        btn_exit.setContentAreaFilled(false);
        btn_exit.setFocusPainted(false);
        btn_exit.setIcon(new ImageIcon(btnExit.getImage().getScaledInstance(newWidth5, -1,java.awt.Image.SCALE_SMOOTH)));
        
        
        
        ImageIcon dateICON = new ImageIcon(getClass().getResource("/project/assets/date_icon.png"));
        label_date.setIcon(new ImageIcon(dateICON.getImage().getScaledInstance(60, -1,java.awt.Image.SCALE_SMOOTH)));
        ImageIcon timeICON = new ImageIcon(getClass().getResource("/project/assets/time_icon.png"));
        label_time.setIcon(new ImageIcon(timeICON.getImage().getScaledInstance(60, -1,java.awt.Image.SCALE_SMOOTH)));
        
        
    }
    public void displayUser(){
        
        //label_username_left.setText(controller.varUser);
        label_username_left.setText(controller.varUser);
        initRequestPanel();
        
    } 
    public void noOnAdvisor(int op){
        if(op==1){
            btn_users_managment.setVisible(true);
            label_users_info.setVisible(true);
            
        }else{
            btn_users_managment.setVisible(false);
            label_users_info.setVisible(false);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        left_panel = new javax.swing.JPanel();
        btn_membersRequest = new javax.swing.JButton();
        label_username_left = new javax.swing.JLabel();
        upLabel_user_left = new javax.swing.JLabel();
        badge_count_request = new javax.swing.JLabel();
        _date = new javax.swing.JLabel();
        _time = new javax.swing.JLabel();
        btn_users_managment = new javax.swing.JButton();
        label_users_info = new javax.swing.JLabel();
        icon_logo = new javax.swing.JButton();
        label_time = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        btn_logOut = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jScrollPane_right = new javax.swing.JScrollPane();
        right_panel_index = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1289, 676));
        setMinimumSize(new java.awt.Dimension(1289, 676));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1289, 676));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        left_panel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        left_panel.setMaximumSize(new java.awt.Dimension(300, 600));
        left_panel.setMinimumSize(new java.awt.Dimension(300, 600));
        left_panel.setPreferredSize(new java.awt.Dimension(300, 600));
        left_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_membersRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_membersRequestActionPerformed(evt);
            }
        });
        left_panel.add(btn_membersRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 240, 47));

        label_username_left.setFont(new java.awt.Font("Copperplate Gothic Light", 2, 12)); // NOI18N
        label_username_left.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label_username_left.setText("<Advisor Username>");
        label_username_left.setToolTipText("");
        left_panel.add(label_username_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 190, 30));

        upLabel_user_left.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 12)); // NOI18N
        upLabel_user_left.setText("Welcome");
        left_panel.add(upLabel_user_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 30));

        badge_count_request.setForeground(new java.awt.Color(255, 0, 0));
        left_panel.add(badge_count_request, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 44, 47));

        _date.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 11)); // NOI18N
        _date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        _date.setText("<date>");
        left_panel.add(_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 86, 23));

        _time.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 11)); // NOI18N
        _time.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        _time.setText("<time>");
        left_panel.add(_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 90, 23));

        btn_users_managment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_users_managmentActionPerformed(evt);
            }
        });
        left_panel.add(btn_users_managment, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 130, 47));

        label_users_info.setText("<no. member>");
        left_panel.add(label_users_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 42, 47));
        left_panel.add(icon_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 320, 150));
        left_panel.add(label_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));
        left_panel.add(label_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));

        btn_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logOutActionPerformed(evt);
            }
        });
        left_panel.add(btn_logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 130, 40));

        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        left_panel.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 130, 40));

        jScrollPane_right.setBorder(null);
        jScrollPane_right.setAutoscrolls(true);
        jScrollPane_right.setHorizontalScrollBar(null);
        jScrollPane_right.setMaximumSize(new java.awt.Dimension(975, 670));
        jScrollPane_right.setMinimumSize(new java.awt.Dimension(975, 670));
        jScrollPane_right.setPreferredSize(new java.awt.Dimension(975, 670));

        right_panel_index.setBackground(left_panel.getBackground());
        right_panel_index.setMaximumSize(new java.awt.Dimension(975, 670));
        right_panel_index.setMinimumSize(new java.awt.Dimension(975, 670));
        right_panel_index.setPreferredSize(new java.awt.Dimension(975, 670));
        right_panel_index.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane_right.setViewportView(right_panel_index);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(left_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(left_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jScrollPane_right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_membersRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_membersRequestActionPerformed
       
        right_panel_index.setVisible(false);
        initRequestPanel();
        right_panel_index.setVisible(true);
        


        
    }//GEN-LAST:event_btn_membersRequestActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void btn_users_managmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_users_managmentActionPerformed
        
        right_panel_index.setVisible(false);
        initUsersPanel();
        
        
        
        right_panel_index.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_btn_users_managmentActionPerformed

    private void btn_logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logOutActionPerformed

        controller.logOut("admin");
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logOutActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
         timerThread.exitProcedure();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_exitActionPerformed

    
 
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_FRAME().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _date;
    private javax.swing.JLabel _time;
    private javax.swing.JLabel badge_count_request;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_logOut;
    private javax.swing.JButton btn_membersRequest;
    private javax.swing.JButton btn_users_managment;
    private javax.swing.JButton icon_logo;
    private javax.swing.JScrollPane jScrollPane_right;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_time;
    public javax.swing.JLabel label_username_left;
    private javax.swing.JLabel label_users_info;
    private javax.swing.JPanel left_panel;
    private javax.swing.JPanel right_panel_index;
    private javax.swing.JLabel upLabel_user_left;
    // End of variables declaration//GEN-END:variables

    
    /**
     *
     *  - REQUEST BTN EVENT
     */
    private void initRequestPanel() {
        dataJson=controller.getREMembersData();//Reload Data onclick
        badge_count_request.setText(String.valueOf(dataJson.length()));//Update onClick
        
        right_panel_index.removeAll();//Clean
        
        MigLayout layout = new MigLayout("insets 2 2 2 2, fillx"); //create layout type
        right_panel_index.setLayout(layout);//implement layout type
        
        
        for(int x=0;x<=dataJson.length()-1;x++){
            JSONArray  Adata = new JSONArray ();
            Adata.put(dataJson.getJSONObject(x));
            Adata.forEach(index -> {
                JSONObject value = (JSONObject) index;
                right_panel_index.add(createButton(value.get("username").toString(),value.get("membership").toString(),value.get("status").toString(),0), "wrap");
            
            });
        }
        
        
        /*
        * public void pack()
        Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        The resulting width and height of the window are automatically enlarged if either of dimensions
        is less than the minimum size as specified by the previous call to the setMinimumSize method.
        If the window and/or its owner are not displayable yet, both of them are made displayable before calculating the preferred size.
        The Window is validated after its size is being calculated.*/
        pack();
        
    }
    
    
    
    /**
     *
     *  - USERS BTN EVENT
     */

    private void initUsersPanel() {
        
        dataJsonMem=controller.getUsersData();//Reload Data onclick
        label_users_info.setText(String.valueOf(dataJsonMem.length()));//Update onClick
        label_users_info.setVisible(true);
        
        label_users_info.setVisible(true);
        right_panel_index.removeAll();//Clean
        
        MigLayout layout = new MigLayout("insets 2 2 2 2, fillx"); //create layout type
        right_panel_index.setLayout(layout);//implement layout type
        
        
        for(int x=0;x<=dataJsonMem.length()-1;x++){
            JSONArray  Adata = new JSONArray ();
            Adata.put(dataJsonMem.getJSONObject(x));
            Adata.forEach(index -> {
                JSONObject value = (JSONObject) index;
                right_panel_index.add(createButton(value.get("username").toString(),value.get("membership").toString(),value.get("status").toString(),1), "wrap");
            
            });
        }
        
        
        pack();
        
        
    }
    
    /**
    *
    * Generate Dinamic Buttons on Request of new members or Active Members for ClubAdvisor / ClubManager
    * Club Manager can have access to this button too - setITUP *****
    * 
     */
    private JButton createButton(String text,String membership,String status,int option) {

            JButton btn = new JButton(text);
            
            
            jScrollPane_right.setPreferredSize(new Dimension (right_panel_index.getWidth() ,615));
            Border empty;
            empty = BorderFactory.createEmptyBorder();
            TitledBorder title;
            //btn.setFont(font);
            btn.setPreferredSize(new Dimension(right_panel_index.getWidth(), 100));
            
            
            if(option==0){
                right_panel_index.setPreferredSize(new Dimension (right_panel_index.getWidth() ,105*dataJson.length()));
                title = BorderFactory.createTitledBorder(empty, "New Member Request");
                title.setTitleJustification(TitledBorder.LEFT);
                btn.setBorder(title);

                btn.addActionListener(new ActionListener(){
                    //Dynamic event for each button
                    public void actionPerformed(ActionEvent e){//event
                        genMemberRequestFrame(text);
                    }
                });

            }else if(option==1){
                right_panel_index.setPreferredSize(new Dimension (right_panel_index.getWidth() ,105*dataJsonMem.length()));
                if(membership.equals("silver")){

                    btn.setBackground(sSilver);

                }else if(membership.equals("gold")){

                    btn.setBackground(gGold);

                }else if(membership.equals("platinum")){

                    btn.setBackground(pPlatinum);
                }
                if(status.equals("0")){
                        title = BorderFactory.createTitledBorder(empty, "Member");
                        title.setTitleJustification(TitledBorder.LEFT);
                        btn.setBorder(title);
                }else if(status.equals("1")){
                        title = BorderFactory.createTitledBorder(empty, "Club Advisor");
                        title.setTitleJustification(TitledBorder.LEFT);
                        btn.setBorder(title);
                }else if(status.equals("2")){
                        title = BorderFactory.createTitledBorder(empty, "Club Manager");
                        title.setTitleJustification(TitledBorder.LEFT);
                        btn.setBorder(title);
                }
                

                btn.addActionListener(new ActionListener(){
                    //Dynamic event for each button
                    public void actionPerformed(ActionEvent e){//event
                        
                        genMemberFrame(text);
                        
                    }
                });

            }
            return btn;
            
            
    }
    
    /**Frame after trigger event on MEMBER REQUEST button */
    private void genMemberRequestFrame(String username){
        
        
        JSONArray  editUser = new JSONArray ();
        List<String>  sendData = new ArrayList();
        
        
        for(int x=0;x<dataJson.length();x++){
            JSONArray  All = new JSONArray ();
            
            All.put(dataJson.getJSONObject(x));
            All.forEach(index -> {
                JSONObject value = (JSONObject) index;
                if(value.get("username").toString().toLowerCase()==username.toLowerCase()){


                    editUser.put(0,value.get("member_id").toString());
                    editUser.put(1,value.get("username").toString());
                    editUser.put(2,value.get("email").toString());
                    editUser.put(3,value.get("address").toString());
                    editUser.put(4,value.get("membership").toString());
                    editUser.put(5,value.get("status").toString());
                    editUser.put(6,value.get("date").toString());
                    editUser.put(7,value.get("gender").toString());
                    editUser.put(8,value.get("passwordEncrypt").toString());
                }
            });
        }
        
        
            /*    
                System.out.println("------------------");
                System.out.println(editUser.get(0).toString());//member REQ ID
                System.out.println(editUser.get(1).toString());//Username
                System.out.println(editUser.get(2).toString());//Email
                System.out.println(editUser.get(3).toString());//address
                System.out.println(editUser.get(4).toString());//membership
                System.out.println(editUser.get(5).toString());//status
                System.out.println(editUser.get(6).toString());//RequestDate
                System.out.println(editUser.get(7).toString());//Gender
                System.out.println(editUser.get(8).toString());//encryptpw
*/
                
                
        
        JFrame main = new JFrame(gc);
        main.setTitle("Request Approval");
        main.setSize(270, 500);
        main.toFront();
        main.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        
        main.setLayout(new FlowLayout());
        JTextField username_,email_,address_,date_ ;
        username_ = new JTextField(editUser.get(1).toString(), 20);
        email_ = new JTextField(editUser.get(2).toString(), 20);
        address_ = new JTextField(editUser.get(3).toString(), 20);
        date_ = new JTextField(editUser.get(6).toString(), 20);
        
        username_.setHorizontalAlignment(SwingConstants.CENTER);
        email_.setHorizontalAlignment(SwingConstants.CENTER);
        address_.setHorizontalAlignment(SwingConstants.CENTER);
        date_.setHorizontalAlignment(SwingConstants.CENTER);
        date_.setEnabled(false);
        
        
        JLabel user,im,addr,mship,stus,dateL;
        user=new JLabel("Username");
        im=new JLabel("E-mail");
        addr=new JLabel("Address");
        mship=new JLabel("Membership");
        stus=new JLabel("Status");
        dateL=new JLabel("Date");
        
        
        
        
        
        JComboBox membership_,status_;
        
        membership_= new JComboBox(new Object[] {"Silver","Gold","Platinum"});
        status_= new JComboBox(new Object[] {"0 - Normal","1 - Club Advisor","2 - Club Manager"});
        membership_.setPreferredSize(new Dimension(230,20));
        status_.setPreferredSize(new Dimension(230,20));
            
        
        //System.out.println(editUser.get(4).toString());
        //System.out.println(editUser.get(5).toString());
        
        
         /* Check membership for comboBox */
        if(editUser.get(4).toString().equals("silver")){
            membership_.setSelectedItem("Silver");
            
        }else if(editUser.get(4).toString().equals("gold")){
            membership_.setSelectedItem("Gold");
            
        }else if(editUser.get(4).toString().equals("platinum")){
            membership_.setSelectedItem("Platinum");
            
        }
        
        
        /* Check Status for comboBox*/
        if(editUser.get(5).toString().equals("0")){
            status_.setSelectedItem("0 - Normal");
        }else if(editUser.get(5).toString().equals("1")){
            status_.setSelectedItem("1 - Club Advisor");
        }else if(editUser.get(5).toString().equals("2")){
            status_.setSelectedItem("2 - Club Manager");
        }
         
        
        JButton action=new JButton("Activate");
        action.setSize(new Dimension(230,20));
        JButton delete_R=new JButton("Delete");
        action.setSize(new Dimension(230,20));
        
        main.add(user, BorderLayout.NORTH);
        main.add(username_, BorderLayout.NORTH);
        
        main.add(im, BorderLayout.NORTH);
        main.add(email_, BorderLayout.NORTH);
        
        main.add(addr, BorderLayout.NORTH);
        main.add(address_, BorderLayout.NORTH);
        
        main.add(mship, BorderLayout.NORTH);
        main.add(membership_, BorderLayout.NORTH);
        
        main.add(stus, BorderLayout.NORTH);
        main.add(status_, BorderLayout.NORTH);
        
        
        main.add(dateL, BorderLayout.NORTH);
        main.add(date_, BorderLayout.NORTH);
        
        
        
        
        main.add(action, BorderLayout.NORTH);//event done
        
        main.add(delete_R, BorderLayout.NORTH);
        
        
        
        action.addActionListener(new ActionListener(){//create object event
        //'Dynamic' event for each button
            String statusValue;
            public void actionPerformed(ActionEvent e){//event
                
                /* send data in order for databsse*/
                sendData.add(0,editUser.get(0).toString());//MemberID
                sendData.add(1,username_.getText());//Username
                sendData.add(2,editUser.get(8).toString());//EncryptPW
                sendData.add(3,email_.getText());//email
                sendData.add(4,address_.getText());//Address
                sendData.add(5,membership_.getSelectedItem().toString().toLowerCase());//Membership
                
                sendData.add(6,status_.getSelectedItem().toString().substring(0, 1));//Status, get first char from String [0,1,2]
                
                sendData.add(7,editUser.get(7).toString());//Gender
                sendData.add(8,_date.getText().replaceAll("\\s+",""));//Date
                
                
                
                //System.out.println(sendData);
                
                
                
                
                
                if(alert.alertYesNo("Are you sure ?")){
                    
                    if(controller.insertNewMember(sendData)==1&&controller.delREQmember(sendData.get(0))==1){
                        
                        alert.alertINFO("Account activated");
                        /*reload*/
                        right_panel_index.setVisible(false);
                        initRequestPanel();
                        main.setVisible(false);
                        right_panel_index.setVisible(true);
                                                
                    }else{
                        alert.alertERROR("Fail to delete or insert new member ");
                    }
                    
                }else{
                    alert.alertWARR("Canceled");
                    
                }
            }
        });
        
        delete_R.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                if(alert.alertYesNo("<html>Are you sure you want to delete >> <u>"+editUser.get(1)+"</u> </html>")==true){
                    
                      if(controller.delREQmember(editUser.get(0).toString())==1){
                          alert.alertINFO("Request Account Deleted");
                          /*reload*/
                          right_panel_index.setVisible(false);
                          initRequestPanel();
                          main.setVisible(false);
                          right_panel_index.setVisible(true);
                          
                      }else{
                          alert.alertERROR("**FAIL** to delete Request account");
                      }
                    
                }else{
                    alert.alertWARR("Cancelled");
                }


            }
        
        });       
        
        main.setVisible(true);
            
    }


    /**Frame after trigger event on Members button */
    private void genMemberFrame(String username){
        
    
        dataJsonMem=controller.getUserData(username);//Reload Data onclick
        JSONArray  editUser = new JSONArray ();
        List<String>  sendData = new ArrayList();
        
        //System.out.println(dataJson.toString());
        for(int x=0;x<dataJsonMem.length();x++){
            JSONArray  All = new JSONArray ();
            
            All.put(dataJsonMem.getJSONObject(x));
            All.forEach(index -> {
                JSONObject value = (JSONObject) index;
                 
                    
                    editUser.put(0,value.get("member_id").toString());
                    editUser.put(1,value.get("username").toString());
                    editUser.put(2,value.get("password").toString());
                    editUser.put(3,value.get("email").toString());
                    editUser.put(4,value.get("address").toString());
                    editUser.put(5,value.get("membership").toString());
                    editUser.put(6,value.get("status").toString());
                    editUser.put(7,value.get("gender").toString());
                    editUser.put(8,value.get("date").toString());
                    editUser.put(9,value.get("booking").toString());
                    
                
            }); 
        }
            /*
                System.out.println("------------------");
                System.out.println(editUser.get(0).toString());//member REQ ID
                System.out.println(editUser.get(1).toString());//Username
                System.out.println(editUser.get(2).toString());//PW
                System.out.println(editUser.get(3).toString());//Email
                System.out.println(editUser.get(4).toString());//address
                System.out.println(editUser.get(5).toString());//membership
                System.out.println(editUser.get(6).toString());//status
                System.out.println(editUser.get(7).toString());//Gender
                System.out.println(editUser.get(8).toString());//accCreatDate
                System.out.println("OK"+editUser.get(9).toString());//booking
                */
                
        JFrame main = new JFrame(gc);
        main.setTitle("Users Settings");
        main.setSize(270, 520);
        main.toFront();
        main.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        
        
        main.setLayout(new FlowLayout());
        JTextField username_,pw_, email_,address_,date_,booking_ ;
        JCheckBox sendNEWPW;
        username_ = new JTextField(editUser.get(1).toString(), 20);
        pw_ = new JTextField(editUser.get(2).toString(), 20);
        sendNEWPW= new JCheckBox();
        email_ = new JTextField(editUser.get(3).toString(), 20);
        address_ = new JTextField(editUser.get(4).toString(), 20);
        date_ = new JTextField(editUser.get(8).toString(), 20);
        booking_ = new JTextField(editUser.get(9).toString(), 20);
        
        username_.setHorizontalAlignment(SwingConstants.CENTER);
        pw_.setHorizontalAlignment(SwingConstants.CENTER);
        pw_.setEnabled(false);
        sendNEWPW.setHorizontalAlignment(SwingConstants.CENTER);
        email_.setHorizontalAlignment(SwingConstants.CENTER);
        address_.setHorizontalAlignment(SwingConstants.CENTER);
        date_.setHorizontalAlignment(SwingConstants.CENTER);
        booking_.setHorizontalAlignment(SwingConstants.CENTER);
        date_.setEnabled(false);
        
        JLabel user,pw,im,addr,mship,stus,dateL,bookingL;
        user=new JLabel("Username");
        pw=new JLabel("Password");
        im=new JLabel("E-mail");
        addr=new JLabel("Address");
        mship=new JLabel("Membership");
        stus=new JLabel("Status");
        dateL=new JLabel("Date");
        bookingL=new JLabel("Booking");
        
        
        
        
        JComboBox membership_,status_;
        
        membership_= new JComboBox(new Object[] {"Silver","Gold","Platinum"});
        status_= new JComboBox(new Object[] {"0 - Normal","1 - Club Advisor","2 - Club Manager"});
        membership_.setPreferredSize(new Dimension(230,20));
        status_.setPreferredSize(new Dimension(230,20));
            
        
        
        
        /* Check Status for comboBox*/
        
        if(editUser.get(6).toString().equals("0")){
            status_.setSelectedItem("0 - Normal");
        }else if(editUser.get(6).toString().equals("1")){
            status_.setSelectedItem("1 - Club Advisor");
        }else if(editUser.get(6).toString().equals("2")){
            status_.setSelectedItem("2 - Club Manager");
        }
         
        
        JButton action=new JButton("Modify");
        action.setSize(new Dimension(230,20));
        JButton delete_MEM=new JButton("Delete");
        delete_MEM.setSize(new Dimension(230,20));
        
        main.add(user, BorderLayout.NORTH);
        main.add(username_, BorderLayout.NORTH);
        
        
        main.add(pw, BorderLayout.NORTH);
        main.add(pw_, BorderLayout.NORTH);
        main.add(sendNEWPW, BorderLayout.NORTH);
        
        main.add(im, BorderLayout.NORTH);
        main.add(email_, BorderLayout.NORTH);
        
        main.add(addr, BorderLayout.NORTH);
        main.add(address_, BorderLayout.NORTH);
        
        main.add(mship, BorderLayout.NORTH);
        main.add(membership_, BorderLayout.NORTH);
        
        main.add(stus, BorderLayout.NORTH);
        main.add(status_, BorderLayout.NORTH);
        
        
        main.add(dateL, BorderLayout.NORTH);
        main.add(date_, BorderLayout.NORTH);
        
        main.add(bookingL, BorderLayout.NORTH);
        main.add(booking_, BorderLayout.NORTH);
        
        
        
        
        main.add(action, BorderLayout.NORTH);//event btn
        
        main.add(delete_MEM, BorderLayout.NORTH);//event btn
        
        
        sendNEWPW.addActionListener(new ActionListener(){//checkBox event
            
            public void actionPerformed(ActionEvent e){
                
                if(sendNEWPW.isSelected()==true ){
                    pw_.setEnabled(true);
                }else{
                    
                    pw_.setEnabled(false);
                    pw_.setText(editUser.get(2).toString());
                    
                }
            }
        });
        
        
        
        action.addActionListener(new ActionListener(){//create object event
        //'Dynamic' event for each button
            String statusValue;
            
            public void actionPerformed(ActionEvent e){//event
                
                //System.out.println(sendNEWPW.getSelectedObjects());
                //System.out.println(e.getActionCommand());
                
                // send data in order for databsse
                
                
                if(sendNEWPW.isSelected()==true ){
                    if(pw_.getDocument().getLength()>=8&&pw_.getDocument().getLength()<=15){
                        sendData.add(0,username_.getText());//Username
                        sendData.add(1,encrypt.setPassword2Hash(pw_.getText()));//PW
                        sendData.add(2,email_.getText());//email
                        sendData.add(3,address_.getText());//Address
                        sendData.add(4,membership_.getSelectedItem().toString().toLowerCase());//Membership
                        sendData.add(5,status_.getSelectedItem().toString().substring(0, 1));//Status, get first char from String [0,1,2]

                        sendData.add(6,editUser.get(7).toString());//Gender

                        sendData.add(7,date_.getText());//Date
                        sendData.add(8,booking_.getText());//booking


                        sendData.add(9,editUser.get(0).toString());//ID
                        if(alert.alertYesNo("Are you sure ?")){
                    
                            if(controller.updateMember(sendData)==1){

                                alert.alertINFO("Account Modified");

                                /*reload*/
                                right_panel_index.setVisible(false);
                                initUsersPanel();
                                main.setVisible(false);
                                right_panel_index.setVisible(true);


                            }else{
                                alert.alertERROR("Fail to modify member > "+username_.getText() );
                            }

                        }else{
                            alert.alertWARR("Canceled");

                        }
                        
                    }else{
                        alert.alertERROR("<html>Password Field Incorrect <br> PW min:8 max: 15 </html>");
                    }
                }else{
                    sendData.add(0,username_.getText());//Username
                    sendData.add(1,editUser.get(2).toString());//PW
                    sendData.add(2,email_.getText());//email
                    sendData.add(3,address_.getText());//Address
                    sendData.add(4,membership_.getSelectedItem().toString().toLowerCase());//Membership
                    sendData.add(5,status_.getSelectedItem().toString().substring(0, 1));//Status, get first char from String [0,1,2]

                    sendData.add(6,editUser.get(7).toString());//Gender

                    sendData.add(7,date_.getText());//Date
                    sendData.add(8,booking_.getText());//booking


                    sendData.add(9,editUser.get(0).toString());//ID
                    if(alert.alertYesNo("Are you sure ?")){
                    
                        if(controller.updateMember(sendData)==1){

                            alert.alertINFO("Account Modified");

                            /*reload*/
                            right_panel_index.setVisible(false);
                            initUsersPanel();
                            main.setVisible(false);
                            right_panel_index.setVisible(true);


                        }else{
                            alert.alertERROR("Fail to modify member > "+username_.getText() );
                        }
                    
                    }else{
                        alert.alertWARR("Canceled");

                    }

                    
                }
                
            }
        });
        
        delete_MEM.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
            
                if(alert.alertYesNo("<html>Are you sure you want to delete >> member ID: <u>"+editUser.get(0).toString()+"</u> </html>")==true){
                    
                      if(controller.deleteMember(editUser.get(0).toString())==1){
                          alert.alertINFO("Member Account Deleted");
                          
                          right_panel_index.setVisible(false);
                          initUsersPanel();
                          main.setVisible(false);
                          right_panel_index.setVisible(true);
                          
                          
                      }else{
                          alert.alertERROR("**FAIL** to delete "+editUser.get(0).toString()+" Member account");
                      }
                    
                }else{
                    alert.alertWARR("Cancelled");
                }


            }
        
        });   
        
        
        
         /* Check membership for comboBox */
        
        
    Component[] components=main.getContentPane().getComponents();
        
        if(editUser.get(5).toString().equals("silver")){
               
            for(int i=0;i<components.length;i++){

                if(components[i] instanceof JLabel){
                System.out.println(components[i]);
                components[i].setForeground(pPlatinum);
                }
            }
            main.getContentPane().setBackground(sSilver);
            membership_.setSelectedItem("Silver");
            
        }else if(editUser.get(5).toString().equals("gold")){
            main.getContentPane().setBackground(gGold);
            membership_.setSelectedItem("Gold");
            
        }else if(editUser.get(5).toString().equals("platinum")){
            main.getContentPane().setBackground(pPlatinum);
            membership_.setSelectedItem("Platinum");
            
        }
        
        main.setVisible(true);

            
    }



}
