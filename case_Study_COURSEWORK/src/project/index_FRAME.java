/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONObject;




/**
 *
 * @author deoiveij
 */

public class index_FRAME extends javax.swing.JFrame {
    
    private HomeController controller=new HomeController();
    private Extras_Notifier alert =new Extras_Notifier();
    
    protected DateTimer timerThread;
    private JSONArray datajson=new JSONArray();
    public JSONArray  editUser= new JSONArray();
    public String progressValue;
    
    
    public index_FRAME() {
        
        initComponents();
        
        
        this.index_Panel.setVisible(false);
        this.accSettings_Panel.setVisible(false);
        this.update_Panel.setVisible(false);
        this.book_Panel.setVisible(false);
        
        displayUser(controller.varUser);
        
        timerThread = new DateTimer(_date, _time);
        timerThread.start();
        }
    
    
    
    
    public void displayUser(String username){
        label_username_welcome.setText(username);  
        datajson=controller.getUserData(username);
         
            JSONArray  Adata = new JSONArray ();
            Adata.put(datajson.getJSONObject(0));
            datajson.forEach(index -> {
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
            
        /*
            editUser.getInt(0));member_id
            editUser.get(1));username
            editUser.get(2));password
            editUser.get(3));email
            editUser.get(4));address
            editUser.get(5));membership
            editUser.getInt(6));status
            editUser.get(7));gender
            editUser.getInt(8));date
            editUser.getInt(9));booking
            
            */
        
        this.menu_item_1.setText("<html><center>"+"Check"+"<br>"+"Membership"+"</center></html>");
        
        
        this.menu_item_2.setText("<html><center>"+"Book"+"<br>"+"Class"+"</center></html>");
        
        this.menu_item_3.setText("<html><center>"+"Update"+"<br>"+"Membership"+"</center></html>");
        this.menu_item_4.setText("<html><center>"+"Account"+"<br>"+"Settings"+"</center></html>");
        
        String[] arrayOfGymClass = new String[]{"Yoga","Swimming","Box","Zumba","Running","Other"};
        String[] arrayOfMembership = new String[]{"Silver","Gold","Platinium"};
        this.listOFclass_comboBox.setModel(new javax.swing.DefaultComboBoxModel(arrayOfGymClass));//load array into comboBox
        this.list_membership.setModel(new javax.swing.DefaultComboBoxModel(arrayOfMembership));//load array into comboBox
        
        initFrame();
    
    }
    public void initFrame(){
        progressBar();
        
        label_name.setText(editUser.get(1).toString());
        label_email.setText(editUser.get(3).toString());
        label_membership.setText(editUser.get(5).toString());
        
        
        
        //icon_.setIcon(new javax.swing.ImageIcon());
        
    }
    public void progressBar(){
        
            if(editUser.get(5).toString().equals("silver")){
                ImageIcon logo = new ImageIcon(getClass().getResource("/project/assets/clubMemberLogoSilver.png"));
                int scale = 3;  
                int width = logo.getIconWidth();
                int newWidth = width / scale;
                icon_member.setBorderPainted(false);
                icon_member.setBorder(null);
                icon_member.setContentAreaFilled(false);
                icon_member.setFocusPainted(false);
                icon_member.setIcon(new ImageIcon(logo.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
            }
            if(editUser.get(5).toString().equals("gold")){
                ImageIcon logo = new ImageIcon(getClass().getResource("/project/assets/clubMemberLogoGold.png"));
                int scale = 3;  
                int width = logo.getIconWidth();
                int newWidth = width / scale;
                icon_member.setBorderPainted(false);
                icon_member.setBorder(null);
                icon_member.setContentAreaFilled(false);
                icon_member.setFocusPainted(false);
                icon_member.setIcon(new ImageIcon(logo.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
            }
            if(editUser.get(5).toString().equals("platinum")){
                ImageIcon logo = new ImageIcon(getClass().getResource("/project/assets/clubMemberLogoPlat.png"));
                int scale = 3;  
                int width = logo.getIconWidth();
                int newWidth = width / scale;
                icon_member.setBorderPainted(false);
                icon_member.setBorder(null);
                icon_member.setContentAreaFilled(false);
                icon_member.setFocusPainted(false);
                icon_member.setIcon(new ImageIcon(logo.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
            }
            
        
        
        int pro=0;
        n_actual_class_booked2.setText(Integer.toString(editUser.getInt(9)));
        
            pro=editUser.getInt(9)*100/10;
            progressValue= Integer.toString(pro);
            progressBar_membership2.setValue(pro);
         
            
        if(editUser.get(5).equals("silver")){
            member_next_goal2.setText("Next Goal: Gold");
           
        }
        if(editUser.get(5).equals("gold")){
            member_next_goal2.setText("Next Goal: Platinium");
            
        }
        if(editUser.get(5).equals("platinum")){
            
            member_next_goal2.setText("MAX.");
            
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar_membership2 = new javax.swing.JProgressBar();
        n_actual_class_booked2 = new javax.swing.JLabel();
        label_title_CLASS2 = new javax.swing.JLabel();
        member_next_goal2 = new javax.swing.JLabel();
        menu_Panel = new javax.swing.JPanel();
        menu_item_1 = new javax.swing.JButton();
        menu_item_2 = new javax.swing.JButton();
        menu_item_4 = new javax.swing.JButton();
        menu_item_3 = new javax.swing.JButton();
        label_username_welcome = new javax.swing.JLabel();
        trigger_alert = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        label_time = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        _date = new javax.swing.JLabel();
        _time = new javax.swing.JLabel();
        icon_member = new javax.swing.JButton();
        index_Panel = new javax.swing.JPanel();
        label_name = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        label_membership = new javax.swing.JLabel();
        icon_ = new javax.swing.JButton();
        book_Panel = new javax.swing.JPanel();
        listOFclass_comboBox = new javax.swing.JComboBox<>();
        buttom_add2Book = new javax.swing.JButton();
        label_text_AvaiableClass = new javax.swing.JLabel();
        update_Panel = new javax.swing.JPanel();
        list_membership = new javax.swing.JComboBox<>();
        buttom_add2Book1 = new javax.swing.JButton();
        label_text_AvaiableClass1 = new javax.swing.JLabel();
        label_info = new javax.swing.JLabel();
        label_info_static1 = new javax.swing.JLabel();
        accSettings_Panel = new javax.swing.JPanel();
        buttom_add2Book2 = new javax.swing.JButton();
        textBox_newPW = new javax.swing.JTextField();
        texBox_Address = new javax.swing.JTextField();
        textBox_username = new javax.swing.JTextField();
        label_password = new javax.swing.JLabel();
        label_address = new javax.swing.JLabel();
        label_username = new javax.swing.JLabel();
        textBox_oldPW = new javax.swing.JTextField();
        label_displayName = new javax.swing.JLabel();
        textBox_displayName = new javax.swing.JTextField();
        button_submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Membeship Panel");
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("mainFrame"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progressBar_membership2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        progressBar_membership2.setValue(30);
        getContentPane().add(progressBar_membership2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 460, -1));

        n_actual_class_booked2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        n_actual_class_booked2.setText("<number class Y>");
        getContentPane().add(n_actual_class_booked2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        label_title_CLASS2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        label_title_CLASS2.setText("Membership Update Progress");
        getContentPane().add(label_title_CLASS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        member_next_goal2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        member_next_goal2.setText("<Next Goal>");
        getContentPane().add(member_next_goal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        menu_Panel.setBackground(new java.awt.Color(181, 206, 179));
        menu_Panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu_item_1.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        menu_item_1.setText("Check Membership");
        menu_item_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_1ActionPerformed(evt);
            }
        });
        menu_Panel.add(menu_item_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 130, 40));

        menu_item_2.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        menu_item_2.setText("Book");
        menu_item_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_2ActionPerformed(evt);
            }
        });
        menu_Panel.add(menu_item_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 110, 40));

        menu_item_4.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        menu_item_4.setText("--*-----");
        menu_item_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_4ActionPerformed(evt);
            }
        });
        menu_Panel.add(menu_item_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 110, 40));

        menu_item_3.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        menu_item_3.setText("Update");
        menu_item_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_3ActionPerformed(evt);
            }
        });
        menu_Panel.add(menu_item_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 110, 40));

        label_username_welcome.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 14)); // NOI18N
        label_username_welcome.setText("Hello <display name>");
        menu_Panel.add(label_username_welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 70, 160, -1));

        trigger_alert.setText("Log Out");
        trigger_alert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trigger_alertActionPerformed(evt);
            }
        });
        menu_Panel.add(trigger_alert, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 80, 20));

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        menu_Panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 80, 20));

        label_time.setForeground(new java.awt.Color(0, 0, 0));
        label_time.setText("Time: ");
        menu_Panel.add(label_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        label_date.setForeground(new java.awt.Color(0, 0, 0));
        label_date.setText("Date: ");
        menu_Panel.add(label_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        _date.setForeground(new java.awt.Color(0, 0, 0));
        _date.setText("<date>");
        menu_Panel.add(_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        _time.setForeground(new java.awt.Color(0, 0, 0));
        _time.setText("<time>");
        menu_Panel.add(_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));
        menu_Panel.add(icon_member, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 60));

        getContentPane().add(menu_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 750, 90));

        index_Panel.setBackground(new java.awt.Color(204, 204, 204));
        index_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_name.setText("<Username>");
        index_Panel.add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        label_email.setText("<e-mail>");
        index_Panel.add(label_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        label_membership.setText("<actual membership>");
        index_Panel.add(label_membership, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        icon_.setBackground(new java.awt.Color(204, 204, 204));
        icon_.setText("jButton2");
        index_Panel.add(icon_, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 150, 110));

        getContentPane().add(index_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 740, 380));

        book_Panel.setBackground(java.awt.Color.lightGray);
        book_Panel.setToolTipText("Book a Class");
        book_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listOFclass_comboBox.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        listOFclass_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        book_Panel.add(listOFclass_comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, -1));

        buttom_add2Book.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        buttom_add2Book.setText("Click to Book");
        book_Panel.add(buttom_add2Book, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        label_text_AvaiableClass.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        label_text_AvaiableClass.setText("Avaiable Classes");
        book_Panel.add(label_text_AvaiableClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        getContentPane().add(book_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 740, 380));

        update_Panel.setBackground(java.awt.Color.lightGray);
        update_Panel.setToolTipText("Update Membership");
        update_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list_membership.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        list_membership.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        list_membership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_membershipActionPerformed(evt);
            }
        });
        update_Panel.add(list_membership, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, -1));

        buttom_add2Book1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        buttom_add2Book1.setText("Click to Update");
        update_Panel.add(buttom_add2Book1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        label_text_AvaiableClass1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        label_text_AvaiableClass1.setText("Avaiable Membership");
        update_Panel.add(label_text_AvaiableClass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));
        update_Panel.add(label_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 370, 80));

        label_info_static1.setText("Information:");
        update_Panel.add(label_info_static1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, 10));

        getContentPane().add(update_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 740, 390));

        accSettings_Panel.setBackground(java.awt.Color.lightGray);
        accSettings_Panel.setToolTipText("Membership Settings");
        accSettings_Panel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                accSettings_PanelPropertyChange(evt);
            }
        });
        accSettings_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttom_add2Book2.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        buttom_add2Book2.setText("Edit");
        buttom_add2Book2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_add2Book2ActionPerformed(evt);
            }
        });
        accSettings_Panel.add(buttom_add2Book2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        textBox_newPW.setText("<new pw>");
        accSettings_Panel.add(textBox_newPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 180, -1));

        texBox_Address.setText("<address>");
        accSettings_Panel.add(texBox_Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 180, -1));

        textBox_username.setText("<username>");
        accSettings_Panel.add(textBox_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 180, -1));

        label_password.setText("Password");
        accSettings_Panel.add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        label_address.setText("Address");
        accSettings_Panel.add(label_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        label_username.setText("Username");
        accSettings_Panel.add(label_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        textBox_oldPW.setText("< old pw>");
        accSettings_Panel.add(textBox_oldPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 180, -1));

        label_displayName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_displayName.setText("Display name");
        accSettings_Panel.add(label_displayName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, 30));

        textBox_displayName.setText("<display name>");
        accSettings_Panel.add(textBox_displayName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 180, -1));

        button_submit.setText("Submit");
        accSettings_Panel.add(button_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 70, -1));

        getContentPane().add(accSettings_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 740, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_2ActionPerformed
        
        /**
         BOOK BUTTON
         */
        this.index_Panel.setVisible(false);
        this.accSettings_Panel.setVisible(false);
        this.update_Panel.setVisible(false);
        
        this.book_Panel.setVisible(true);
    }//GEN-LAST:event_menu_item_2ActionPerformed

    private void menu_item_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_1ActionPerformed
        /**
         CHECK BUTTON
         */
        
        
        this.book_Panel.setVisible(false);
        this.accSettings_Panel.setVisible(false);
        this.update_Panel.setVisible(false);
        
        
        
        
        this.index_Panel.setVisible(true);
        
        
    }//GEN-LAST:event_menu_item_1ActionPerformed

    private void menu_item_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_3ActionPerformed
        
        /**
         MEMBERSHIP UPDATE BUTTON
         */
        this.book_Panel.setVisible(false);
        this.index_Panel.setVisible(false);
        this.accSettings_Panel.setVisible(false);
        
        this.update_Panel.setVisible(true);

    }//GEN-LAST:event_menu_item_3ActionPerformed

    private void menu_item_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_4ActionPerformed
        /**
         ACC SETTINGS BUTTON
         */
        this.book_Panel.setVisible(false);
        this.index_Panel.setVisible(false);
        this.update_Panel.setVisible(false);
        
        this.accSettings_Panel.setVisible(true);
    }//GEN-LAST:event_menu_item_4ActionPerformed

    
    
    
    private void accSettings_PanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_accSettings_PanelPropertyChange
        /*ON LOAD Panel ACC-SETTINGS*/
        this.textBox_username.setEditable(false);
        this.textBox_username.setEnabled(false);
        
        this.textBox_oldPW.setEnabled(false);
        this.textBox_oldPW.setEditable(false);
        
        this.textBox_newPW.setVisible(false);
        
        
        this.textBox_displayName.setEnabled(false);
        this.textBox_displayName.setEditable(false);
        
        this.texBox_Address.setEnabled(false);
        this.texBox_Address.setEditable(false);
        
        
        
    }//GEN-LAST:event_accSettings_PanelPropertyChange

    private void buttom_add2Book2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_add2Book2ActionPerformed

        this.textBox_username.setEnabled(true);
        this.textBox_username.setEditable(true);
        
        
        
        this.textBox_oldPW.setEnabled(true);
        this.textBox_oldPW.setEditable(true);
        this.textBox_newPW.setVisible(true);
        
        
        this.textBox_displayName.setEnabled(true);
        this.textBox_displayName.setEditable(true);
        
        this.texBox_Address.setEnabled(true);
        this.texBox_Address.setEditable(true);
        
        this.buttom_add2Book2.setVisible(false);
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_buttom_add2Book2ActionPerformed

    
    
    
    
    
    
    
    private void trigger_alertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trigger_alertActionPerformed
    
        controller.logOut("normal");
        
        
    }//GEN-LAST:event_trigger_alertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void list_membershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_membershipActionPerformed
        
        if(this.list_membership.getSelectedItem()=="Gold"){
            this.label_info.setText("");
            //alertINFO(this.list_membership.getSelectedItem().toString());
        }
        
        if(this.list_membership.getSelectedItem()=="Silver"){
            this.label_info.setText("");
            //alertINFO(this.list_membership.getSelectedItem().toString());
        }
        
        if(this.list_membership.getSelectedItem()=="Platinium"){
            //alertINFO(this.list_membership.getSelectedItem().toString());
            
            this.label_info.setText("<html><center>You need first have membership Gold for only then choose Platinium, costs £100 p/year<center></html>");
        }
        
    }//GEN-LAST:event_list_membershipActionPerformed

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
            java.util.logging.Logger.getLogger(index_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new index_FRAME().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _date;
    private javax.swing.JLabel _time;
    private javax.swing.JPanel accSettings_Panel;
    private javax.swing.JPanel book_Panel;
    private javax.swing.JButton buttom_add2Book;
    private javax.swing.JButton buttom_add2Book1;
    private javax.swing.JButton buttom_add2Book2;
    private javax.swing.JButton button_submit;
    private javax.swing.JButton icon_;
    private javax.swing.JButton icon_member;
    private javax.swing.JPanel index_Panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label_address;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_displayName;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_info;
    private javax.swing.JLabel label_info_static1;
    private javax.swing.JLabel label_membership;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_text_AvaiableClass;
    private javax.swing.JLabel label_text_AvaiableClass1;
    private javax.swing.JLabel label_time;
    private javax.swing.JLabel label_title_CLASS2;
    private javax.swing.JLabel label_username;
    private javax.swing.JLabel label_username_welcome;
    private javax.swing.JComboBox<String> listOFclass_comboBox;
    private javax.swing.JComboBox<String> list_membership;
    private javax.swing.JLabel member_next_goal2;
    private javax.swing.JPanel menu_Panel;
    private javax.swing.JButton menu_item_1;
    private javax.swing.JButton menu_item_2;
    private javax.swing.JButton menu_item_3;
    private javax.swing.JButton menu_item_4;
    public javax.swing.JLabel n_actual_class_booked2;
    public javax.swing.JProgressBar progressBar_membership2;
    private javax.swing.JTextField texBox_Address;
    private javax.swing.JTextField textBox_displayName;
    private javax.swing.JTextField textBox_newPW;
    private javax.swing.JTextField textBox_oldPW;
    private javax.swing.JTextField textBox_username;
    private javax.swing.JButton trigger_alert;
    private javax.swing.JPanel update_Panel;
    // End of variables declaration//GEN-END:variables
}
