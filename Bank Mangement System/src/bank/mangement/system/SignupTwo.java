
package bank.mangement.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignupTwo extends JFrame implements ActionListener{
   
    JTextField pan,adhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
    
    SignupTwo(String Formno)    
    {
         setLayout(null);
        this.formno = formno;
       setTitle("NEW ACCOUNT APPLICATION FORM - 2");
        
         
          
        JLabel additionalDetails   = new JLabel("Page 2: Additonal Details" );
         additionalDetails  .setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails  .setBounds(290,80,400,30);
         add( additionalDetails  );
         
         JLabel name   = new JLabel("Religion : " );
        name.setFont(new Font("Raleway",Font.BOLD,20));
       name.setBounds(100,140,100,30);
         add(name);
         
         String valReligion[] = {"Hindu","Muslim","Sikh","Other"};
         religion = new JComboBox(valReligion);
          religion.setBounds(300,140,400,30);
         add(religion);
         religion.setFont(new Font("Raleway", Font.BOLD, 18));
       
         String valcategory[] = {"General","OBC","Sc","Other"};
       category = new JComboBox(valcategory);
         JLabel fname   = new JLabel("Category: " );
         category.setBounds(300,190,400,30);
         add(category); 
          category.setBackground(Color.WHITE);
         
         
       fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100,190,200,30);
         add(fname);
         
         
         
         
            JLabel dob   = new JLabel("Income: " );
       dob.setFont(new Font("Raleway",Font.BOLD,20));
      dob.setBounds(100,240,400,30);
         add(dob);
                String incomecategory[] = {"Null","<1,50,000","<2,00,000","Upto 10,00,000"};
       income= new JComboBox(incomecategory);
         income.setBounds(300,240,400,30);
         add(income); 
          income.setBackground(Color.WHITE);
         
         
            JLabel gender    = new JLabel("Educational :" );
       gender.setFont(new Font("Raleway",Font.BOLD,20));
      gender.setBounds(100,290,200,30);
         add(gender);
         
                 JLabel email    = new JLabel("Qualification " );
       email.setFont(new Font("Raleway",Font.BOLD,20));
      email.setBounds(100,320,200,30);
         add(email);
         
                String educationvalues[] = {"Non Graduation","Graduate","Post-Graduation","Others"};
       education= new JComboBox(educationvalues);
         education.setBounds(300,290,400,30);
         add(education); 
          education.setBackground(Color.WHITE);
         
         
                 JLabel martial    = new JLabel("Occupation : " );
       martial.setFont(new Font("Raleway",Font.BOLD,20));
     martial.setBounds(100,390,200,30);
         add(martial );
         
               String occupationvalues[] = {"Salaried","Self-employed","Bussiness Man","Student"};
       occupation= new JComboBox(occupationvalues);
         occupation.setBounds(300,390,400,30);
         add(occupation); 
          occupation.setBackground(Color.WHITE);
  
         
                    JLabel address    = new JLabel("Pan Number : " );
       address.setFont(new Font("Raleway",Font.BOLD,20));
     address.setBounds(100,440,200,30);
         add(address );
           pan = new   JTextField();
         pan.setFont(new Font("Raleway",Font.BOLD,18));
         pan.setBounds(300,440,400,30);
         add(pan); 
         
                    JLabel city  = new JLabel("Adhar Number : " );
       city.setFont(new Font("Raleway",Font.BOLD,20));
     city.setBounds(100,490,200,30);
         add(city );
           adhar = new   JTextField();
         adhar.setFont(new Font("Raleway",Font.BOLD,18));
         adhar.setBounds(300,490,400,30);
         add(adhar); 
         
         
                    JLabel state    = new JLabel("Senior Citizen: " );
       state.setFont(new Font("Raleway",Font.BOLD,20));
     state.setBounds(100,540,200,30);
         add(state );
                syes = new JRadioButton("Yes");
         syes.setBounds(300,540,70,30);
         add(syes);
         syes.setBackground(Color.WHITE);
         
                   sno = new JRadioButton("NO");
         sno.setBounds(300,540,70,30);
         add(sno);
         sno.setBackground(Color.WHITE);
         
         ButtonGroup martialGroup = new ButtonGroup ();
         martialGroup.add(syes);
         martialGroup.add(sno);
         
         
         
                    JLabel pin    = new JLabel(" Exisiting Account : " );
       pin.setFont(new Font("Raleway",Font.BOLD,20));
     pin.setBounds(100,590,200,30);
         add(pin );
         
                         eyes = new JRadioButton("Yes");
         eyes.setBounds(300,590,70,30);
         add(eyes);
         eyes.setBackground(Color.WHITE);
         
                   eno = new JRadioButton("NO");
         eno.setBounds(300,590,70,30);
         add(eno);
         eno.setBackground(Color.WHITE);
         
         ButtonGroup emartialGroup = new ButtonGroup ();
         martialGroup.add(eyes);
         martialGroup.add(eno);
         
         
         
//         next = new JButton ("Next");
//         next.setBackground(Color.BLACK);
//         next.setForeground(Color.WHITE);
         
         
              next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
  next.setBounds(570,620,100,30);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,710);
        setLocation(350,10);
        setVisible(true);
        next.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
          String sincome = (String)income.getSelectedItem();  
            String seducation = (String)education.getSelectedItem();
              String soccupation = (String)occupation.getSelectedItem();
String seniorcitizen = null;
 
 if(syes.isSelected())
{
seniorcitizen = "Yes";
}else if(sno.isSelected())
    seniorcitizen = "NO";
 

     
     String exisitingaccount = " ";
     if(eyes.isSelected())
     {
         exisitingaccount = "Yes";
     }else if (eno.isSelected())
             {
               exisitingaccount = "NO";
             }
     
     String span = pan.getText();
      String sadhar= adhar.getText();
    
      
      try{
         
           Conn c1 = new Conn();
         String query = "INSERT INTO signuptwo VALUES('"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+sadhar+"','"+span+"','"+seniorcitizen+"','"+exisitingaccount+"')";
          c1.s.executeUpdate(query);
//            JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
               
          setVisible(false);
          new SignupThree(formno).setVisible(true);
          
      }catch(Exception ex)
      {
          ex.printStackTrace();
          System.out.println("Error message "+ex.getMessage());
      }
     
}
    public static void main(String  args[])
    {
        new SignupTwo("");
    }
}
