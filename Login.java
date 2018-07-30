import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import javax.swing.JSplitPane;

public class Login extends JFrame implements ActionListener{
   public static Login frame;
   private JRadioButton jRadioButton1,jRadioButton2;
   private JTextField inputLine1,inputLine2,fName,lName,uName,password,email;
   private JButton LoginButton=new JButton("Login"),RegisterButton=new JButton("Register");
   private JLabel imgLabel;
   private JPanel Log,NewUser;
   private Component[] com;
   private JLabel textLabel1= new JLabel(),textLabel2= new JLabel(),textLabel3= new JLabel(),textLabel4= new JLabel(),textLabel5= new JLabel(),textLabel6= new JLabel(),textLabel7= new JLabel();
   public static Planner planner;
   
   
 //------main-----
   public static void main(String[] args) {
   
      try
      {
      
         File pervoius = new File("usersInfo.txt");
      
         if(pervoius.exists())
         {
            FileInputStream SF= new FileInputStream(pervoius);
            ObjectInputStream OSF = new ObjectInputStream(SF);
            planner= new Planner((User[])OSF.readObject());
         
            OSF.close();
         }
         else
         {
            User[]users= new User[100];
            planner = new Planner(users);
         
         }
      
      
      
         frame = new Login();
         frame.setVisible(true);
      
      }//:try
      
      catch(ClassNotFoundException e)
      {JOptionPane.showMessageDialog( null, e.getMessage() );}
      
      catch(IOException e)
      {JOptionPane.showMessageDialog( null, e.getMessage() );}
   }//end main


   //:RAZAN
   public Login()
   { 
      Container contentPane;
      setSize(300, 500);
      setResizable (false);
      setTitle("Your Planner");
      setLocation  (500, 150);
      contentPane = getContentPane( );
      contentPane.setLayout(new FlowLayout());
     
      //imgLabel
      imgLabel = new JLabel(new ImageIcon("agenda.gif"));
      contentPane.add(imgLabel);
      imgLabel.setText("Your Planner:               ");
      imgLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
      contentPane.add(imgLabel);
      //jRadioButtons
      jRadioButton1 = new JRadioButton("Log in   ");  
      jRadioButton1.setFont(new Font("Calibri", Font.PLAIN, 16));
      contentPane.add(jRadioButton1);  
      
      jRadioButton2 = new JRadioButton("New User"); 
      jRadioButton2.setFont(new Font("Calibri", Font.PLAIN, 16));
      contentPane.add(jRadioButton2);
     
      //The ButtonGroup class is responsible to make sure only one button is selected (by deselecting others in the group). 
      ButtonGroup group = new ButtonGroup();
      group.add(jRadioButton1);
      group.add(jRadioButton2);
      jRadioButton1.addActionListener(this);
      jRadioButton2.addActionListener(this);
      
   //-----------------------------
      Log = new JPanel();
      Log.setOpaque(true); 
      Log.setLayout(new FlowLayout());
      Log.setBorder(BorderFactory.createTitledBorder("Login"));
      
      textLabel1.setText("User name:");
      textLabel1.setFont(new Font("Calibri", Font.PLAIN, 16));
      inputLine1 = new JTextField();
      inputLine1.setColumns(12);
      inputLine1.setFont(new Font("Courier", Font.PLAIN, 16));
      Log.add(textLabel1);
      Log.add(inputLine1);      
      textLabel2.setText("password: ");
      textLabel2.setFont(new Font("Calibri", Font.PLAIN, 16));
      inputLine2 = new JTextField();
      inputLine2.setColumns(12);
      inputLine2.setFont(new Font("Courier", Font.PLAIN, 16));
      Log.add(textLabel2);
      Log.add(inputLine2);
      Log.add(LoginButton);
      Log.setPreferredSize(new Dimension(250,130));
      contentPane.add(Log);
      LoginButton.addActionListener(this); 
      
      NewUser = new JPanel();
      NewUser.setOpaque(true); 
      NewUser.setLayout(new FlowLayout());
      NewUser.setBorder(BorderFactory.createTitledBorder("New User"));
      textLabel3.setText("First name:  ");
      textLabel4.setText("Last name:  ");
      textLabel5.setText("Email:         ");
      textLabel6.setText("User name: ");
      textLabel7.setText("password:   ");
     
      fName = new JTextField();
      lName = new JTextField();
      uName = new JTextField();
      password = new JTextField();
      email = new JTextField();
      NewUser.add(textLabel3);
      NewUser.add(fName);
      NewUser.add(textLabel4);
      NewUser.add(lName);
      NewUser.add(textLabel5);
      NewUser.add(email);
      NewUser.add(textLabel6);
      NewUser.add(uName);
      NewUser.add(textLabel7);
      NewUser.add(password);
      NewUser.setPreferredSize(new Dimension(250,220));
      fName.setColumns(10);
      lName.setColumns(10);
      uName.setColumns(10);
      password.setColumns(10);
      email.setColumns(10);
      NewUser.add(RegisterButton);
      contentPane.add(NewUser);
      RegisterButton.addActionListener(this);
      //-----------------------------------
      Component[] com;
      com = NewUser.getComponents();
      for (int a = 0; a < com.length; a++)
         com[a].setEnabled(false);
      com = Log.getComponents();
      for (int a = 0; a < com.length; a++)
         com[a].setEnabled(false);
         //: Close Operation
         
      WindowListener exitListener =
         new WindowAdapter()
         {
            public void windowClosing(WindowEvent ev)
            {
               try{
                  File save = new File("usersInfo.txt");
                  FileOutputStream SF= new FileOutputStream(save);
                  ObjectOutputStream OSF= new ObjectOutputStream(SF);
                  OSF.writeObject(planner.getusersList());
                  OSF.close();
               }
               catch(IOException e)
               {JOptionPane.showMessageDialog( null, e.getMessage() );}
                         
               System.exit(0);
            }
         };  
      addWindowListener(exitListener);
   
         
         
      
         
   }//end Constructor 
     //------------------------------------------ 
         
         
                        
      //Action Preformed
         
   public void  actionPerformed(ActionEvent e){
     
     //: if User choose a rdaio Button
   
      
      Component[] com;
      if(jRadioButton1.isSelected()) {
         com = Log.getComponents();
         for (int a = 0; a < com.length; a++)
            com[a].setEnabled(true);
         com = NewUser.getComponents();
         for (int a = 0; a < com.length; a++)
            com[a].setEnabled(false);} 
            
      else if(jRadioButton2.isSelected()) {
         com = NewUser.getComponents();
         for (int a = 0; a < com.length; a++)
            com[a].setEnabled(true);
         com = Log.getComponents();
         for (int a = 0; a < com.length; a++)
            com[a].setEnabled(false);
      }
      
       
   
            
            //: if User Enters Login
      if(e.getSource() instanceof JButton){
         JButton Clicked =(JButton) e.getSource();
         if(Clicked == LoginButton)
         {  String name= inputLine1.getText();
            String password= inputLine2.getText(); 
                
            if(planner.login(name,password))
            { 
               setVisible(false);
               SecondFrame frame= new SecondFrame();
                       
            }
            else
            {JOptionPane.showMessageDialog( null, "wrong Username and password" );
               inputLine1.setText("");
               inputLine2.setText("");}
         }//end loginButton
         else if( Clicked ==  RegisterButton)
         {
            if(!(fName.getText().equals("")||lName.getText().equals("")||uName.getText().equals("")||password.getText().equals("")||email.getText().equals("")))
            {
               if(planner.registerUser(fName.getText(),lName.getText(),uName.getText(),password.getText(),email.getText()))
                  JOptionPane.showMessageDialog( null,"The user has been added" );
               else
                  JOptionPane.showMessageDialog( null, "The user has NOT been added" );
              
            }
            else{
               JOptionPane.showMessageDialog( null, "The user has NOT been added" );
               fName.setText("");lName.setText("");uName.setText("");
               password.setText("");email.setText("");}
         } //end else if     
      }//big if  
   }//:end ActionPreformed
        
        
        
        
        
        
        
     //: ****************************SECOND CLASS ************************************   
        
   class SecondFrame extends JFrame implements ActionListener
   {
      private int index =-1;
      private JSpinner spinner1,spinner2;
      private JButton AddEventButton,findButton=new JButton("Find"),cancelButton=new JButton("Cancel"),saveAgendaButton;
      private JRadioButton yes, no,Daily,Weekly,Monthly;
      private JTextArea DesText,display;
      private JTextField titleText,Duration;
      private Component[] REC;
      private JPanel  content1,content2,content3,content4;
      private JTabbedPane tabbedPane;
   
   
      public SecondFrame()
      {
        
         for(int i=0; i<planner.getusersList().length;i++)
         {  
            if(planner.getusersList()[i] != null)
            { 
               if(inputLine1.getText().equals(planner.getusersList()[i].getuName()))
                  index=i; }
         }
      
        
         Container contentPane;
         this.setSize(340, 500);
         this.setLocation  (500, 150);
      
         this.setResizable (false);
         this.setTitle(planner.getusersList()[index].getfName()+"'s Planner");
         this.setVisible(false);
         contentPane = getContentPane();
         contentPane.setLayout(new BorderLayout());
         this.setVisible(true);
      
      
      
      
         tabbedPane = new JTabbedPane();
      
      
         content1 = FindEvent();
        
         content2 = addEvent();
        
         content3 = SaveLoad();
        
         content4 = Reminders();
      
         tabbedPane.addTab("Find Event", content1);
         tabbedPane.addTab("Add Event",  content2);
         tabbedPane.addTab("Save&Load", content3);
         tabbedPane.addTab("Reminders", content4);
        
      
         contentPane.add( tabbedPane,BorderLayout.CENTER);  
      
         WindowListener exitListener2 = 
            new WindowAdapter()
            {
               public void windowClosing(WindowEvent ev)
               {
                  frame.setVisible(true);
                  dispose();   
               }
            };  
         this.addWindowListener(exitListener2);
      }  
   
   
   
      public void  actionPerformed(ActionEvent e)
      {
         if(yes.isSelected())
         {
            for(int i=0; i<REC.length; i++)
               REC[i].setEnabled(true);
         }
         else if(no.isSelected())
         {
            for(int i=0; i<REC.length; i++)
               REC[i].setEnabled(false);
         }
      
      //: Button Events 
         if(e.getSource() instanceof JButton)
         {
            JButton Clicked =(JButton) e.getSource();
         
            try {
               if(Clicked == AddEventButton )
               {
               
                  if( no.isSelected())
                  {
                     Event event= new Event(titleText.getText(),DesText.getText(),(Date)spinner1.getValue(),(Date)spinner2.getValue());
                     planner.getusersList()[index].addEvent(event);
                  }
                  else if(yes.isSelected())
                  {
                  
                     char recurrence=' ';
                     if(Daily.isSelected())
                        recurrence= 'D';
                     else if(Weekly.isSelected())
                        recurrence= 'W';
                     else if(Monthly.isSelected())
                        recurrence='M';
                  
                     Event recur = new RecurrentEvent(titleText.getText(),DesText.getText(),(Date)spinner1.getValue(),(Date)spinner2.getValue(),Integer.parseInt(Duration.getText()),recurrence);
                     planner.getusersList()[index].addEvent(recur);
                  }
                  JOptionPane.showMessageDialog( null, "The Event has been Added");
               }// if add Event
            }//try
            catch(IllegalArgumentException ex)
            { JOptionPane.showMessageDialog( null, "The End Date can't be After the Satrt Date" ); }
            catch(InputMismatchException ex)
            {JOptionPane.showMessageDialog( null, "Invalid input" );}
            
                    //: here add which button ****************************************************
            try{ 
               if(Clicked==findButton){
                  int id1=Integer.parseInt(  titleText.getText());
                  int find = planner.getusersList()[index].findEvent(id1);
                  Event ee=planner.getusersList()[index].geteventList()[index];
                  display.setText(ee.toString());
               }//if find
               if(Clicked==cancelButton)
               { 
                  int id1=Integer.parseInt(  titleText.getText());
                  boolean cancel= planner.getusersList()[index].cancelEvent(id1);
                  if(cancel)
                     JOptionPane.showMessageDialog( null, " canceled ");
                  display.setText("");
                  if(Clicked==saveAgendaButton){
                     planner.getusersList()[index].saveAgenda();
                     JOptionPane.showMessageDialog( null, " save agenda successfully");
                  } }} 
            catch(ClassNotFoundException ex){
               JOptionPane.showMessageDialog( null, "class not found" );}
            catch(IOException ex){
               JOptionPane.showMessageDialog( null, "IOException" );}
         
         }//:End Button Events
          
      } //: ActionPreformed
   
   
   
   
   //:Rawan
      public JPanel FindEvent()
      {
         JPanel panel1= new JPanel();
         panel1.setLayout(new FlowLayout());
        
      /* panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
      panel1.add(new JSeparator(SwingConstants.VERTICAL));*/
         
      //  panel1.add(new JSeparator(JSeparator.VERTICAL));
      
       /* JSplitPane split;
      split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
      split.setContinuousLayout(false);
      split.setOneTouchExpandable(true); 
      panel1.add(split, BorderLayout.CENTER);*/
      
      
         /*JSplitPane splitPane = new JSplitPane();
         splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
         panel1.add(splitPane, BorderLayout.CENTER);
         */
         
         JLabel title = new JLabel("Event ID :");
         title.setFont(new Font("Calibri", Font.PLAIN, 14));
         title.setBounds(40,20,100,20);
      
         JTextField titleText = new JTextField();
         titleText.setColumns(10);
         
         findButton.setBounds(40,50,60,20);
         cancelButton.setBounds(120,50,90,20);
      
         panel1.add(title);
         panel1.add(titleText);
         panel1.add(findButton);
         panel1.add(cancelButton);
         findButton.addActionListener(this);
         cancelButton.addActionListener(this); 
              
         display = new JTextArea ();
         display.setColumns(18);
         display.setRows(15);
         display.setEditable ( true ); // set textArea non-editable
         JScrollPane scroll = new JScrollPane ( display );
         scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
         scroll.setHorizontalScrollBarPolicy ( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
         display.setLineWrap(true);
         panel1.add ( scroll );
         
      
      
      
      
         saveAgendaButton=new JButton("save Agendas");
         saveAgendaButton.setBounds(70,390,120,20);
      
         panel1.add(saveAgendaButton);
         saveAgendaButton.addActionListener(this);
         
         return panel1;
      
      }
   
   
   
   //:Nawal
      public JPanel addEvent()
      {
      
         JPanel panel2= new JPanel();
         panel2.setLayout(null);
         JLabel title = new JLabel("Event Title:");
         title.setFont(new Font("Calibri", Font.PLAIN, 14));
         titleText = new JTextField();
         title.setBounds(40,20,100,20);
         titleText.setBounds(120,20,100,20);
         panel2.add(title);
         panel2.add(titleText);
      
         JLabel Des = new JLabel("Event Description:");
         Des.setFont(new Font("Calibri", Font.PLAIN, 14));
         DesText = new JTextArea();
         DesText.setLineWrap(true);
      
         Des.setBounds(10,100,130,20);
         DesText.setBounds(120,60,130,100);
         panel2.add(Des);
         panel2.add(DesText);
      
      
         JLabel Start = new JLabel("Start Date: ");
         JLabel End = new JLabel("End Date: ");
         Start.setFont(new Font("Calibri", Font.PLAIN, 14));
         End.setFont(new Font("Calibri", Font.PLAIN, 14));
         Start.setBounds(40,170,100,20);
         End.setBounds(40,195,100,20);
         panel2.add(Start);
         panel2.add(End);
      
         SpinnerDateModel model = new SpinnerDateModel();
         spinner1 = new JSpinner(model);
         spinner1.setEditor(new JSpinner.DateEditor(spinner1,"dd/MM/yyyy"));
         spinner1.setBounds(120,170,110,20);
         panel2.add(spinner1);
      
      
         SpinnerDateModel model2 = new SpinnerDateModel();
         spinner2 = new JSpinner(model2);
         spinner2.setEditor(new JSpinner.DateEditor(spinner2,"dd/MM/yyyy"));
         spinner2.setBounds(120,195,110,20);
         panel2.add(spinner2);
      
      
         JLabel isRecurrent = new JLabel("is it a Recurrent Event? ");
         isRecurrent.setFont(new Font("Calibri", Font.PLAIN, 14));
         isRecurrent.setBounds(40,230,150,20);
         panel2.add(isRecurrent);
      
         yes= new JRadioButton("Yes");
         no= new JRadioButton("No");
         yes.setBounds(180,230,50,20);
         no.setBounds(230,230,50,20);
      
         panel2.add(yes);
         panel2.add(no);
      
         ButtonGroup group1 = new ButtonGroup();
         group1.add(yes);
         group1.add(no);
      
      
      
         Daily= new JRadioButton("Daily");
         Weekly= new JRadioButton("Weekly");
         Monthly=new JRadioButton("Monthly");
      
         Daily.setBounds(100,300,60,20);
         Weekly.setBounds(155,300,70,20);
         Monthly.setBounds(225,300,70,20);
      
         panel2.add(Daily);
         panel2.add(Weekly);
         panel2.add(Monthly);
      
         JLabel dur=new JLabel("Duration");
         dur.setFont(new Font("Calibri", Font.PLAIN, 14));
         dur.setBounds(45,350,150,20);
      
         panel2.add(dur);
      
         Duration = new JTextField();
         Duration.setFont(new Font("Calibri", Font.PLAIN, 14));
         Duration.setBounds(100,350,150,20);
      
         panel2.add(Duration);
      
         REC= new Component[5];
         REC[0]=Daily;
         REC[1]=Weekly;
         REC[2]=Monthly;
         REC[3]=dur;
         REC[4]=Duration;
      
         for (int a = 0; a < REC.length; a++)
            REC[a].setEnabled(false);
         
         yes.addActionListener(this);
         no.addActionListener(this);
      
         AddEventButton= new JButton("Add Event");
         AddEventButton.setBounds(130,380,100,30);
         panel2.add(AddEventButton);
         AddEventButton.addActionListener(this);
         
         return panel2;
      }
   
   
   
   
   //:Maram
      public JPanel SaveLoad()
      {
         JPanel panel3= new JPanel();
         return panel3;
      }
   
   
   //:Nawal
      public JPanel Reminders()
      {
         JPanel  panel4= new JPanel();
         panel4.setLayout(null);
         JLabel Upcoming = new JLabel("Upcoming events:");
         Upcoming.setFont(new Font("Calibri", Font.PLAIN, 14));
         Upcoming.setBounds(90,10,130,20);
         panel4.add(Upcoming);
      
         Event[] remind = planner.getusersList()[index].remaidAll();
         String all="";
          
         for(int i=0 ; i<remind.length; i++)
         { 
            all+=remind[i]+"\n";
         } 
          
         JTextArea txt = new JTextArea(all);
         txt.setEditable(false);  
         txt.setCursor(null);  
         txt.setOpaque(false);  
         txt.setFocusable(false);
         txt.setLineWrap(true);
         txt.setWrapStyleWord(true);
         
         txt.setBounds(20,20,200,400);
         panel4.add(txt);
      
         return panel4;
      
      } 
   
   }//:End Second Class


}//:end First Class class