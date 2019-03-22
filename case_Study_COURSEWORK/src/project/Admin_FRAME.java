
package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;

import javax.swing.border.Border;

import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author foxst
 */

public class Admin_FRAME extends javax.swing.JFrame {       
    

    private static HomeController controller = new HomeController();
    private static Extras_Notifier alert = new Extras_Notifier();
    
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
        badge_count_request.setText(String.valueOf(dataJson.length()));
        label_users_info.setVisible(false);
       
        timerThread = new DateTimer(_date, _time);
        timerThread.start();
        
        
    }

    public void ImageIconSetup(int option){
        //System.out.println(getClass().getResource("/assets/fullGym.png").toString());
        System.out.println(controller.checkAdmin(label_username_left.getText().toString()));
             int scale = 3;   
         if(option==1){
             btn_users_managment.setVisible(false);
             label_users_info.setVisible(false);
            ImageIcon logo = new ImageIcon(getClass().getResource("/project/assets/clubAdvisorLogo.png"));

            int width = logo.getIconWidth();
            int newWidth = width / scale;
            icon_logo.setBorderPainted(false);
            icon_logo.setBorder(null);
            icon_logo.setContentAreaFilled(false);
            icon_logo.setFocusPainted(false);
            icon_logo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
             
         }    
         if(option==2){
             btn_users_managment.setVisible(true);
            ImageIcon logo = new ImageIcon(getClass().getResource("/project/assets/clubManagerLogo.png"));

            int width = logo.getIconWidth();
            int newWidth = width / scale;
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
        
        
    }
    public void displayUser(){
        
        //label_username_left.setText(controller.varUser);
        label_username_left.setText(controller.varUser);
        initRequestPanel();
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_logOut = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jScrollPane_right = new javax.swing.JScrollPane();
        right_panel_index = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1250, 700));
        setMinimumSize(new java.awt.Dimension(1250, 700));
        setUndecorated(true);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        left_panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Settings", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("HelvLight", 2, 11))); // NOI18N
        left_panel.setMaximumSize(new java.awt.Dimension(300, 600));
        left_panel.setMinimumSize(new java.awt.Dimension(300, 600));
        left_panel.setPreferredSize(new java.awt.Dimension(300, 600));
        left_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_membersRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_membersRequestActionPerformed(evt);
            }
        });
        left_panel.add(btn_membersRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 235, 47));

        label_username_left.setText("<Advisor Username>");
        left_panel.add(label_username_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        upLabel_user_left.setText("Welcome");
        left_panel.add(upLabel_user_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        badge_count_request.setForeground(new java.awt.Color(255, 0, 0));
        left_panel.add(badge_count_request, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 44, 47));

        _date.setText("<date>");
        left_panel.add(_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 86, 23));

        _time.setText("<time>");
        left_panel.add(_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 59, 23));

        btn_users_managment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_users_managmentActionPerformed(evt);
            }
        });
        left_panel.add(btn_users_managment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 240, 47));

        label_users_info.setText("<no. member>");
        left_panel.add(label_users_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 42, 47));
        left_panel.add(icon_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 20, 250, 100));

        jLabel1.setText("Time:");
        left_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 20));

        jLabel2.setText("Date: ");
        left_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        btn_logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logOutActionPerformed(evt);
            }
        });
        left_panel.add(btn_logOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 100, 40));

        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        left_panel.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 100, 40));

        jScrollPane_right.setBorder(null);
        jScrollPane_right.setAutoscrolls(true);
        jScrollPane_right.setHorizontalScrollBar(null);
        jScrollPane_right.setMaximumSize(new java.awt.Dimension(960, 600));
        jScrollPane_right.setMinimumSize(new java.awt.Dimension(960, 600));
        jScrollPane_right.setPreferredSize(new java.awt.Dimension(960, 600));

        right_panel_index.setBackground(left_panel.getBackground());
        right_panel_index.setMaximumSize(new java.awt.Dimension(960, 200000));
        right_panel_index.setMinimumSize(new java.awt.Dimension(960, 600));
        right_panel_index.setPreferredSize(new java.awt.Dimension(960, 600));
        right_panel_index.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane_right.setViewportView(right_panel_index);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(left_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane_right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(left_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane_right, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane_right;
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
        
        right_panel_index.removeAll();
        
        MigLayout layout = new MigLayout("insets 2 2 2 2, fillx"); //create layout type
        right_panel_index.setLayout(layout);//implement layout type
        
        
        for(int x=0;x<=dataJson.length()-1;x++){
            JSONArray  Adata = new JSONArray ();
            Adata.put(dataJson.getJSONObject(x));
            Adata.forEach(index -> {
                JSONObject value = (JSONObject) index;
                right_panel_index.add(createButton(value.get("username").toString(),0), "wrap");
            
            });
        }
        
        
        
        pack();
        
    }
    
    /**
    *
    * Generate Dinamic Buttons on Request of new members for ClubAdvisor / ClubManager
    * Club Manager can have access to this button too - setITUP *****
    * 
     */
    private JButton createButton(String text,int option) {
        
        jScrollPane_right.setPreferredSize(new Dimension (right_panel_index.getWidth() ,615));
        Border empty;
        empty = BorderFactory.createEmptyBorder();
        
        TitledBorder title;
        
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.ITALIC, 40));
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
            title = BorderFactory.createTitledBorder(empty, "Member");
            title.setTitleJustification(TitledBorder.LEFT);
            btn.setBorder(title);

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
            
        
        System.out.println(editUser.get(4).toString());
        System.out.println(editUser.get(5).toString());
        
        
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
                
                sendData.add(6,status_.getSelectedItem().toString().substring(0, 1));//Status, get first char from comboBox [0,1,2]
                
                sendData.add(7,editUser.get(7).toString());//Gender
                sendData.add(8,_date.getText().replaceAll("\\s+",""));//Date
                
                
                
                System.out.println(sendData);
                
                
                
                
                
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





    /**
     *
     *  - USERS BTN EVENT
     */

    private void initUsersPanel() {
        
        dataJsonMem = new JSONArray();
        dataJsonMem=controller.getUsersData();//Reload Data onclick
        label_users_info.setText(String.valueOf(dataJsonMem.length()));//Update onClick
        label_users_info.setVisible(true);
        
        label_users_info.setVisible(true);
        right_panel_index.removeAll();
        
        MigLayout layout = new MigLayout("insets 2 2 2 2, fillx"); //create layout type
        right_panel_index.setLayout(layout);//implement layout type
        
        
        for(int x=0;x<=dataJsonMem.length()-1;x++){
            JSONArray  Adata = new JSONArray ();
            Adata.put(dataJsonMem.getJSONObject(x));
            Adata.forEach(index -> {
                JSONObject value = (JSONObject) index;
                right_panel_index.add(createButton(value.get("username").toString(),1), "wrap");
            
            });
        }
        
        
        pack();
        
        
    }
private void genMemberFrame(String username){
        
    
        dataJsonMem=controller.getUserData(username);//Reload Data onclick
        JSONArray  editUser = new JSONArray ();
        
        
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
*/
                
        
        JFrame main = new JFrame(gc);
        main.setTitle("Users Settings");
        main.setSize(270, 520);
        main.toFront();
        main.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        
        main.setLayout(new FlowLayout());
        JTextField username_,pw_, email_,address_,date_ ;
        username_ = new JTextField(editUser.get(1).toString(), 20);
        pw_ = new JTextField(editUser.get(2).toString(), 20);
        email_ = new JTextField(editUser.get(3).toString(), 20);
        address_ = new JTextField(editUser.get(4).toString(), 20);
        date_ = new JTextField(editUser.get(8).toString(), 20);
        
        username_.setHorizontalAlignment(SwingConstants.CENTER);
        pw_.setHorizontalAlignment(SwingConstants.CENTER);
        email_.setHorizontalAlignment(SwingConstants.CENTER);
        address_.setHorizontalAlignment(SwingConstants.CENTER);
        date_.setHorizontalAlignment(SwingConstants.CENTER);
        date_.setEnabled(false);
        
        
        JLabel user,pw,im,addr,mship,stus,dateL;
        user=new JLabel("Username");
        pw=new JLabel("Password");
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
            
        
        
        
         /* Check membership for comboBox */
        
        
        if(editUser.get(5).toString().equals("silver")){
            membership_.setSelectedItem("Silver");
            
        }else if(editUser.get(5).toString().equals("gold")){
            membership_.setSelectedItem("Gold");
            
        }else if(editUser.get(5).toString().equals("platinum")){
            membership_.setSelectedItem("Platinum");
            
        }
        
        
        /* Check Status for comboBox*/
        
        if(editUser.get(6).toString().equals("0")){
            status_.setSelectedItem("0 - Normal");
        }else if(editUser.get(6).toString().equals("1")){
            status_.setSelectedItem("1 - Club Advisor");
        }else if(editUser.get(6).toString().equals("2")){
            status_.setSelectedItem("2 - Club Manager");
        }
         
        
        JButton action=new JButton("**Modify");
        action.setSize(new Dimension(230,20));
        JButton delete_R=new JButton("**Delete");
        action.setSize(new Dimension(230,20));
        
        main.add(user, BorderLayout.NORTH);
        main.add(username_, BorderLayout.NORTH);
        
        
        main.add(pw, BorderLayout.NORTH);
        main.add(pw_, BorderLayout.NORTH);
        
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
        
        
        /*
        action.addActionListener(new ActionListener(){//create object event
        //'Dynamic' event for each button
            String statusValue;
            public void actionPerformed(ActionEvent e){//event
                
                /* send data in order for databsse
                sendData.add(0,editUser.get(0).toString());//MemberID
                sendData.add(1,username_.getText());//Username
                sendData.add(2,editUser.get(8).toString());//EncryptPW
                sendData.add(3,email_.getText());//email
                sendData.add(4,address_.getText());//Address
                sendData.add(5,membership_.getSelectedItem().toString().toLowerCase());//Membership
                
                sendData.add(6,status_.getSelectedItem().toString().substring(0, 1));//Status, get first char from comboBox [0,1,2]
                
                sendData.add(7,editUser.get(7).toString());//Gender
                sendData.add(8,_date.getText().replaceAll("\\s+",""));//Date
                
                
                
                System.out.println(sendData);
                
                
                
                
                
                if(alert.alertYesNo("Are you sure ?")){
                    
                    if(controller.insertNewMember(sendData)==1&&controller.delREQmember(sendData.get(0))==1){
                        
                        alert.alertINFO("Account activated");
                        /*reload
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
            /*
                if(alert.alertYesNo("<html>Are you sure you want to delete >> <u>"+editUser.get(1)+"</u> </html>")==true){
                    
                      if(controller.delREQmember(editUser.get(0).toString())==1){
                          alert.alertINFO("Request Account Deleted");
                          /*reload
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
        */
        main.setVisible(true);

            
    }



}
