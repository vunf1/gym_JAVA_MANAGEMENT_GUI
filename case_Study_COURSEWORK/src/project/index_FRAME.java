/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
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
        
        
        timerThread = new DateTimer(_date, _time);
        timerThread.start();
        
        
        // displayUser("m");
         //initFrame();
        
        
        }
    
    
    
    private void uploadData(String username){
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
            
            
    }
    public void displayUser(String username){
        backToAdmin.setVisible(false);
        label_username_welcome.setText(username);  
        uploadData(username);
        
        /*
            editUser.getInt(0));member_id
            editUser.get(1));username
            editUser.get(2));password
            editUser.get(3));ema
            editUser.get(4));address
            editUser.get(5));membership
            editUser.getInt(6));status
            editUser.get(7));gender
            editUser.getInt(8));date
            editUser.getInt(9));booking
            
            */
        //this.label_memberID_info.setText(editUser.get(0));
        this.menu_item_1.setText("<html><center>"+"Check"+"<br>"+"Membership"+"</center></html>");
        
        
        this.menu_item_2.setText("<html><center>"+"Book"+"<br>"+"Class"+"</center></html>");
        
        this.menu_item_3.setText("<html><center>"+"Update"+"<br>"+"Membership"+"</center></html>");
        this.menu_item_4.setText("<html><center>"+"Account"+"<br>"+"Settings"+"</center></html>");
        
        String[] arrayOfGymClass = new String[]{"Yoga","Swimming","Box","Zumba","Running","Other"};
        String[] arrayOfMembership = new String[]{"Silver","Gold","Platinium"};
        String[] arrayOfGender = new String[]{"Male","Female"};
        this.listOFclass_comboBox.setModel(new javax.swing.DefaultComboBoxModel(arrayOfGymClass));//load array into comboBox
        this.list_membership.setModel(new javax.swing.DefaultComboBoxModel(arrayOfMembership));//load array into comboBox
        this.comboBox_gender.setModel(new javax.swing.DefaultComboBoxModel(arrayOfGender));
        button_submit.setVisible(false);
        button_cancel.setVisible(false);
        act_pw_new.setVisible(false);
        initFrame();
    
    }
    public void initFrame(){//Setup MemberInfo
        progressBar();
        
        label_memberID_info.setText(editUser.get(0).toString());
        label_name.setText(editUser.get(1).toString());
        label_email.setText(editUser.get(3).toString());
        label_membership.setText(editUser.get(5).toString());
        
        
        imgInitSetup();
        //icon_.setIcon(new javax.swing.ImageIcon());
        
    }
    public void progressBar(){
        
        
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
    
    public void imgInitSetup(){
        
         
            ImageIcon logoExit = new ImageIcon(getClass().getResource("/project/assets/exit.png"));

            int width2 = logoExit.getIconWidth();
            int newWidth2 = width2 / 5;
            exit_btn_index.setBorderPainted(false);
            exit_btn_index.setBorder(null);
            exit_btn_index.setContentAreaFilled(false);
            exit_btn_index.setFocusPainted(false);
            exit_btn_index.setIcon(new ImageIcon(logoExit.getImage().getScaledInstance(newWidth2, -1,java.awt.Image.SCALE_SMOOTH)));
             
            
            ImageIcon logoLogOut = new ImageIcon(getClass().getResource("/project/assets/logOut.png"));

            int width3 = logoLogOut.getIconWidth();
            int newWidth3 = width3 / 5;
            logOut_btn_index.setBorderPainted(false);
            logOut_btn_index.setBorder(null);
            logOut_btn_index.setContentAreaFilled(false);
            logOut_btn_index.setFocusPainted(false);
            logOut_btn_index.setIcon(new ImageIcon(logoLogOut.getImage().getScaledInstance(newWidth3, -1,java.awt.Image.SCALE_SMOOTH)));
            
            
            
            
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
                
                
                ImageIcon logoMain = new ImageIcon(getClass().getResource("/project/assets/silverSymbol.png"));
                icon_memberShip.setBorderPainted(false);
                icon_memberShip.setBorder(null);
                icon_memberShip.setContentAreaFilled(false);
                icon_memberShip.setFocusPainted(false);
                icon_memberShip.setIcon(new ImageIcon(logoMain.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
                
                
                
                
                
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
                
                
                ImageIcon logoMain = new ImageIcon(getClass().getResource("/project/assets/goldSymbol.png"));
                icon_memberShip.setBorderPainted(false);
                icon_memberShip.setBorder(null);
                icon_memberShip.setContentAreaFilled(false);
                icon_memberShip.setFocusPainted(false);
                icon_memberShip.setIcon(new ImageIcon(logoMain.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
                
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
                
                
                
                ImageIcon logoMain = new ImageIcon(getClass().getResource("/project/assets/platSymbol.png"));
                icon_memberShip.setBorderPainted(false);
                icon_memberShip.setBorder(null);
                icon_memberShip.setContentAreaFilled(false);
                icon_memberShip.setFocusPainted(false);
                icon_memberShip.setIcon(new ImageIcon(logoMain.getImage().getScaledInstance(newWidth, -1,java.awt.Image.SCALE_SMOOTH)));
            }
            
                ImageIcon logBack2Admin = new ImageIcon(getClass().getResource("/project/assets/backToAdminDash.png"));
                backToAdmin.setBorderPainted(false);
                backToAdmin.setBorder(null);
                backToAdmin.setContentAreaFilled(false);
                backToAdmin.setFocusPainted(false);
                backToAdmin.setIcon(new ImageIcon(logBack2Admin.getImage().getScaledInstance(100, -1,java.awt.Image.SCALE_SMOOTH)));
                
                
                
                
                
                ImageIcon logEdit = new ImageIcon(getClass().getResource("/project/assets/editIcon.png"));
                btn_Edit.setBorderPainted(false);
                btn_Edit.setBorder(null);
                btn_Edit.setContentAreaFilled(false);
                btn_Edit.setFocusPainted(false);
                btn_Edit.setIcon(new ImageIcon(logEdit.getImage().getScaledInstance(70, -1,java.awt.Image.SCALE_SMOOTH)));
                
                
                
                ImageIcon logSubmit = new ImageIcon(getClass().getResource("/project/assets/submitIcon.png"));
                button_submit.setBorderPainted(false);
                button_submit.setBorder(null);
                button_submit.setContentAreaFilled(false);
                button_submit.setFocusPainted(false);
                button_submit.setIcon(new ImageIcon(logSubmit.getImage().getScaledInstance(100, -1,java.awt.Image.SCALE_SMOOTH)));
                
                
                ImageIcon logCancel = new ImageIcon(getClass().getResource("/project/assets/cancelIcon.png"));
                button_cancel.setBorderPainted(false);
                button_cancel.setBorder(null);
                button_cancel.setContentAreaFilled(false);
                button_cancel.setFocusPainted(false);
                button_cancel.setIcon(new ImageIcon(logCancel.getImage().getScaledInstance(70, -1,java.awt.Image.SCALE_SMOOTH)));
        
                ImageIcon logCheck = new ImageIcon(getClass().getResource("/project/assets/memberStatusIcon.png"));
                checkMembership.setBorderPainted(false);
                checkMembership.setBorder(null);
                checkMembership.setContentAreaFilled(false);
                checkMembership.setFocusPainted(false);
                checkMembership.setIcon(new ImageIcon(logCheck.getImage().getScaledInstance(130, -1,java.awt.Image.SCALE_SMOOTH)));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        progressBar_membership2 = new javax.swing.JProgressBar();
        n_actual_class_booked2 = new javax.swing.JLabel();
        label_title_CLASS2 = new javax.swing.JLabel();
        member_next_goal2 = new javax.swing.JLabel();
        label_memberid = new javax.swing.JLabel();
        label_memberID_info = new javax.swing.JLabel();
        backToAdmin = new javax.swing.JButton();
        menu_Panel = new javax.swing.JPanel();
        menu_item_1 = new javax.swing.JButton();
        menu_item_2 = new javax.swing.JButton();
        menu_item_4 = new javax.swing.JButton();
        menu_item_3 = new javax.swing.JButton();
        label_username_welcome = new javax.swing.JLabel();
        logOut_btn_index = new javax.swing.JButton();
        exit_btn_index = new javax.swing.JButton();
        label_time = new javax.swing.JLabel();
        label_date = new javax.swing.JLabel();
        _date = new javax.swing.JLabel();
        _time = new javax.swing.JLabel();
        icon_member = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        index_Panel = new javax.swing.JPanel();
        label_name = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        label_membership = new javax.swing.JLabel();
        icon_memberShip = new javax.swing.JButton();
        checkMembership = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        btn_Edit = new javax.swing.JButton();
        texBox_Address = new javax.swing.JTextField();
        textBox_username = new javax.swing.JTextField();
        label_password = new javax.swing.JLabel();
        label_address = new javax.swing.JLabel();
        label_username = new javax.swing.JLabel();
        label_Email = new javax.swing.JLabel();
        textBox_Email = new javax.swing.JTextField();
        button_submit = new javax.swing.JButton();
        textBox_oldPW = new javax.swing.JPasswordField();
        textBox_newPW = new javax.swing.JPasswordField();
        comboBox_gender = new javax.swing.JComboBox<>();
        label_gender = new javax.swing.JLabel();
        button_cancel = new javax.swing.JButton();
        act_pw_new = new javax.swing.JCheckBox();
        act_pw_old = new javax.swing.JCheckBox();

        jButton1.setText("jButton1");

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

        label_memberid.setText("Member ID : ");
        getContentPane().add(label_memberid, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 80, 20));
        getContentPane().add(label_memberID_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 100, 20));

        backToAdmin.setContentAreaFilled(false);
        backToAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToAdminActionPerformed(evt);
            }
        });
        getContentPane().add(backToAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 415, 170, 40));

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

        label_username_welcome.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        label_username_welcome.setText("Hello <display name>");
        menu_Panel.add(label_username_welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 130, 20));

        logOut_btn_index.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btn_indexActionPerformed(evt);
            }
        });
        menu_Panel.add(logOut_btn_index, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 80, 20));

        exit_btn_index.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_btn_indexActionPerformed(evt);
            }
        });
        menu_Panel.add(exit_btn_index, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 80, 20));

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
        menu_Panel.add(_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));
        menu_Panel.add(icon_member, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 60));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Hello, ");
        menu_Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 20));

        getContentPane().add(menu_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 750, 90));

        index_Panel.setBackground(new java.awt.Color(204, 204, 204));
        index_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_name.setText("<Username>");
        index_Panel.add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 110, -1));

        label_email.setText("<e-mail>");
        index_Panel.add(label_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 110, -1));

        label_membership.setText("<actual membership>");
        index_Panel.add(label_membership, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 120, -1));

        icon_memberShip.setBackground(new java.awt.Color(204, 204, 204));
        index_Panel.add(icon_memberShip, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 150, 110));

        checkMembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMembershipActionPerformed(evt);
            }
        });
        index_Panel.add(checkMembership, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 170, 30));

        jLabel2.setText("Username:");
        index_Panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel3.setText("Email: ");
        index_Panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jLabel4.setText("Membership :");
        index_Panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        getContentPane().add(index_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 740, 390));

        book_Panel.setBackground(java.awt.Color.lightGray);
        book_Panel.setToolTipText("Book a Class");
        book_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listOFclass_comboBox.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        listOFclass_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        book_Panel.add(listOFclass_comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, -1));

        buttom_add2Book.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        buttom_add2Book.setText("Click to Book");
        buttom_add2Book.setEnabled(false);
        book_Panel.add(buttom_add2Book, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        label_text_AvaiableClass.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        label_text_AvaiableClass.setText("Avaiable Classes");
        book_Panel.add(label_text_AvaiableClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        getContentPane().add(book_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 740, 390));

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

        btn_Edit.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditActionPerformed(evt);
            }
        });
        accSettings_Panel.add(btn_Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 80, 40));

        texBox_Address.setText("<address>");
        accSettings_Panel.add(texBox_Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 180, -1));

        textBox_username.setText("<username>");
        accSettings_Panel.add(textBox_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 180, -1));

        label_password.setText("Password :");
        accSettings_Panel.add(label_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        label_address.setText("Address :");
        accSettings_Panel.add(label_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, 20));

        label_username.setText("Username :");
        accSettings_Panel.add(label_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        label_Email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_Email.setText("Email :");
        accSettings_Panel.add(label_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 70, 20));

        textBox_Email.setText("<Email>");
        accSettings_Panel.add(textBox_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 180, -1));

        button_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_submitActionPerformed(evt);
            }
        });
        accSettings_Panel.add(button_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 120, 40));

        textBox_oldPW.setToolTipText("Old Password");
        accSettings_Panel.add(textBox_oldPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, 20));

        textBox_newPW.setToolTipText("New Password");
        accSettings_Panel.add(textBox_newPW, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 160, 20));

        comboBox_gender.setMaximumRowCount(2);
        comboBox_gender.setToolTipText("Gender");
        comboBox_gender.setEnabled(false);
        accSettings_Panel.add(comboBox_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 180, -1));

        label_gender.setText("Gender");
        accSettings_Panel.add(label_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 50, 20));

        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });
        accSettings_Panel.add(button_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 80, 40));

        act_pw_new.setBackground(new java.awt.Color(51, 51, 51));
        act_pw_new.setEnabled(false);
        act_pw_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                act_pw_newActionPerformed(evt);
            }
        });
        accSettings_Panel.add(act_pw_new, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, 20));

        act_pw_old.setBackground(new java.awt.Color(51, 51, 51));
        act_pw_old.setEnabled(false);
        act_pw_old.setFocusPainted(false);
        act_pw_old.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                act_pw_oldActionPerformed(evt);
            }
        });
        accSettings_Panel.add(act_pw_old, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, 20));

        getContentPane().add(accSettings_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 740, 390));

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
        memberShipStatusCheck();
        
        
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
        uploadData(editUser.get(1).toString());
        act_pw_old.setOpaque(false);
        act_pw_new.setOpaque(false);
        this.book_Panel.setVisible(false);
        this.index_Panel.setVisible(false);
        this.update_Panel.setVisible(false);
        
        this.accSettings_Panel.setVisible(true);
        
        textBox_username.setText(editUser.get(1).toString());
        textBox_Email.setText(editUser.get(3).toString());
        texBox_Address.setText(editUser.get(4).toString());
        if(editUser.get(7).toString().equals("Male")){
            
            comboBox_gender.setSelectedItem("Male");
        }else if(editUser.get(7).toString().equals("Female")){
            
            comboBox_gender.setSelectedItem("Female");
        }
        /*
            editUser.getInt(0));member_id
            editUser.get(1));username
            editUser.get(2));password
            editUser.get(3));ema
            editUser.get(4));address
            editUser.get(5));membership
            editUser.getInt(6));status
            editUser.get(7));gender
            editUser.getInt(8));date
            editUser.getInt(9));booking
            
            */
        
        
                
                
        
        
    }//GEN-LAST:event_menu_item_4ActionPerformed

    
    
    
    private void accSettings_PanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_accSettings_PanelPropertyChange
        /*ON LOAD Panel ACC-SETTINGS*/
        this.textBox_username.setEditable(false);
        this.textBox_username.setEnabled(false);
        
        this.textBox_oldPW.setEnabled(false);
        this.textBox_oldPW.setEditable(false);
        
        this.textBox_newPW.setVisible(false);
        
        
        this.textBox_Email.setEnabled(false);
        this.textBox_Email.setEditable(false);
        
        this.texBox_Address.setEnabled(false);
        this.texBox_Address.setEditable(false);
        
        
        
    }//GEN-LAST:event_accSettings_PanelPropertyChange

    private void btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditActionPerformed

        this.textBox_username.setEnabled(true);
        this.textBox_username.setEditable(true);
        
        
        
        this.textBox_oldPW.setEnabled(true);
        this.textBox_oldPW.setEditable(true);
        this.textBox_newPW.setVisible(true);
        
        
        this.textBox_Email.setEnabled(true);
        this.textBox_Email.setEditable(true);
        
        this.texBox_Address.setEnabled(true);
        this.texBox_Address.setEditable(true);
        
        this.comboBox_gender.setEnabled(true);
        button_submit.setVisible(true);
        
        button_cancel.setVisible(true);
        act_pw_new.setEnabled(true);
        act_pw_old.setEnabled(true);
        act_pw_new.setVisible(true);
        this.btn_Edit.setVisible(false);
        
        
        
    }//GEN-LAST:event_btn_EditActionPerformed

    
    
    
    
    
    
    
    private void logOut_btn_indexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btn_indexActionPerformed
    
        controller.logOut("normal");
        
        
    }//GEN-LAST:event_logOut_btn_indexActionPerformed

    private void exit_btn_indexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_btn_indexActionPerformed
        
        timerThread.exitProcedure();
    }//GEN-LAST:event_exit_btn_indexActionPerformed

    private void list_membershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_membershipActionPerformed
        
        if(this.list_membership.getSelectedItem()=="Gold"){
            this.label_info.setText("");
            //alertINFO(this.list_membership.getSelectedItem().toString());
            this.label_info.setText("<html><center>You need to have a minimum of 10 Booked Classes p/year<center></html>");
        }
        
        if(this.list_membership.getSelectedItem()=="Silver"){
            this.label_info.setText("");
            this.label_info.setText("<html><center>It's Free<center></html>");
        }
        
        if(this.list_membership.getSelectedItem()=="Platinium"){
            //alertINFO(this.list_membership.getSelectedItem().toString());
            
            this.label_info.setText("<html><center>You need first have membership Gold for only then choose Platinium, costs £100 p/year<center></html>");
        }
        
    }//GEN-LAST:event_list_membershipActionPerformed

    private void checkMembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMembershipActionPerformed
    
        memberShipStatusCheck();


        
    }//GEN-LAST:event_checkMembershipActionPerformed

    private void backToAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToAdminActionPerformed

        controller.callMemberFrame_Admin(0);

        // TODO add your handling code here:
    }//GEN-LAST:event_backToAdminActionPerformed

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed

        this.textBox_username.setEnabled(false);
        this.textBox_username.setEditable(false);
        
        
        
        this.textBox_oldPW.setEnabled(false);
        this.textBox_oldPW.setEditable(false);
        this.textBox_newPW.setVisible(false);
        
        
        this.textBox_Email.setEnabled(false);
        this.textBox_Email.setEditable(false);
        
        this.texBox_Address.setEnabled(false);
        this.texBox_Address.setEditable(false);
        
        this.comboBox_gender.setEnabled(false);
        button_submit.setVisible(false);
        
        button_cancel.setVisible(false);
        act_pw_new.setEnabled(false);
        act_pw_old.setEnabled(false);
        act_pw_new.setVisible(false);
        
        this.btn_Edit.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_button_cancelActionPerformed

    private void act_pw_oldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_act_pw_oldActionPerformed

        if(act_pw_old.isSelected()){
            textBox_oldPW.setEchoChar((char)0);
        }else{
            textBox_oldPW.setEchoChar('*');
        }
        
        
    }//GEN-LAST:event_act_pw_oldActionPerformed

    private void act_pw_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_act_pw_newActionPerformed

        if(act_pw_new.isSelected()){
            textBox_oldPW.setEchoChar((char)0);
        }else{
            textBox_oldPW.setEchoChar('*');
        }
        
        
    }//GEN-LAST:event_act_pw_newActionPerformed

    private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_submitActionPerformed

        
        List<String>  data = new ArrayList();
        List<String>  sendData = new ArrayList();
        System.out.println();
        if(controller.checkPassword(data)==1){
            
        }
        
        
        textBox_username.getText().toString();
        textBox_Email.getText().toString();
        texBox_Address.getText().toString();
        comboBox_gender.getSelectedItem().toString();
        textBox_oldPW.getText().toString();
        textBox_newPW.getText().toString();
        /* send data in order for databsse*/
        sendData.add(0,editUser.get(0).toString());//MemberID
        sendData.add(1,textBox_username.getText().toString());//Username

        sendData.add(2,editUser.get(8).toString());//EncryptPW

        sendData.add(3,textBox_Email.getText().toString());//email
        sendData.add(4,texBox_Address.getText().toString());//Address




        sendData.add(5,comboBox_gender.getSelectedItem().toString());//Gender

                
        System.out.println(sendData);

    }//GEN-LAST:event_button_submitActionPerformed
    
    /*Follow case study logic of membership */
    private void memberShipStatusCheck(){
        
        int dateONDB=editUser.getInt(8);
        int actDate=Integer.parseInt(_date.getText().replaceAll("\\s+",""));
        int calcMembership;
        int yearDays;
        System.out.println(dateONDB);
        System.out.println(actDate);
        //alert.alertINFO(editUser.get(8).toString());
        calcMembership=actDate-dateONDB;
        //calcMembership=20200321-Integer.parseInt(editUser.get(8).toString());
        yearDays= 365*calcMembership/10000;
        
        
            alert.alertINFO("<html>"+calcMembership+" </html>");
        if(yearDays<365){//less 1 year no revoke
            alert.alertINFO("<html>"+yearDays+" </html>");
        }else{// 1 year pass - REVOKE membership
            if(editUser.get(5).equals("silver")){
            alert.alertINFO("<html>A year pass <br>Your membership is <u>"+editUser.get(5)+"</u> so it's free, to upgrade to gold you need 10 active booking classes per year <br><br>Your Number of Booked Classes will now be reseted.</html>");
            
                
            }else if(editUser.get(5).equals("gold")){
            alert.alertWARR("<html>Your membership as <u>"+editUser.get(5)+"</u> ended because a year pass <br> Your Number of Booked Classes will now be reseted.</html>");
            
                
            }else if(editUser.get(5).equals("platinum")){
            alert.alertWARR("<html>Your membership as <u>"+editUser.get(5)+"</u> ended because a year pass <br> Your Number of Booked Classes will now be reseted and silver membership will be added <br> to keep Platinum membership a fee of £100 is required.</html>");
            
                
                
            }
            
        }
        
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel _date;
    private javax.swing.JLabel _time;
    private javax.swing.JPanel accSettings_Panel;
    private javax.swing.JCheckBox act_pw_new;
    private javax.swing.JCheckBox act_pw_old;
    public javax.swing.JButton backToAdmin;
    private javax.swing.JPanel book_Panel;
    private javax.swing.JButton btn_Edit;
    private javax.swing.JButton buttom_add2Book;
    private javax.swing.JButton buttom_add2Book1;
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_submit;
    private javax.swing.JButton checkMembership;
    private javax.swing.JComboBox<String> comboBox_gender;
    private javax.swing.JButton exit_btn_index;
    private javax.swing.JButton icon_member;
    private javax.swing.JButton icon_memberShip;
    private javax.swing.JPanel index_Panel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel label_Email;
    private javax.swing.JLabel label_address;
    private javax.swing.JLabel label_date;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_gender;
    private javax.swing.JLabel label_info;
    private javax.swing.JLabel label_info_static1;
    private javax.swing.JLabel label_memberID_info;
    private javax.swing.JLabel label_memberid;
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
    private javax.swing.JButton logOut_btn_index;
    private javax.swing.JLabel member_next_goal2;
    private javax.swing.JPanel menu_Panel;
    private javax.swing.JButton menu_item_1;
    private javax.swing.JButton menu_item_2;
    private javax.swing.JButton menu_item_3;
    private javax.swing.JButton menu_item_4;
    public javax.swing.JLabel n_actual_class_booked2;
    public javax.swing.JProgressBar progressBar_membership2;
    private javax.swing.JTextField texBox_Address;
    private javax.swing.JTextField textBox_Email;
    private javax.swing.JPasswordField textBox_newPW;
    private javax.swing.JPasswordField textBox_oldPW;
    private javax.swing.JTextField textBox_username;
    private javax.swing.JPanel update_Panel;
    // End of variables declaration//GEN-END:variables
}
