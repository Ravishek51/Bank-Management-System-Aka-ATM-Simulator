
package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField, addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,Female,other,married,unmarried;
    JDateChooser dateChooser;
    SignupOne()
            
    {
        setLayout(null);
        Random ran = new Random();
        random = (Math.abs((ran.nextLong() % 9000)+1000L));
        
        JLabel Formno   = new JLabel("APPLICATION FORM NO. "+random );
        Formno.setFont(new Font("Raleway",Font.BOLD,38));
        Formno.setBounds(140,20,600,40);
         add(Formno);
         
        
         
          
        JLabel personDetail   = new JLabel("Page 1: Personal Details" );
        personDetail.setFont(new Font("Raleway",Font.BOLD,22));
       personDetail.setBounds(290,80,400,30);
         add(personDetail);
         
         JLabel name   = new JLabel("Name : " );
        name.setFont(new Font("Raleway",Font.BOLD,20));
       name.setBounds(100,140,100,30);
         add(name);
       
         
           nameTextField = new   JTextField();
         nameTextField.setFont(new Font("Raleway",Font.ITALIC,18));
//         nameTextField.setFont(new Font ("Arial",Font.ITALIC,23));
         nameTextField.setBounds(300,140,400,30);
         add(nameTextField);
         
         
        
         
         JLabel fname   = new JLabel("Father 's Name : " );
       fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100,190,200,30);
         add(fname);
         
          fnameTextField = new   JTextField();
         fnameTextField.setFont(new Font("Raleway",Font.BOLD,18));
         fnameTextField.setBounds(300,190,400,30);
         add(fnameTextField); 
         
            JLabel dob   = new JLabel("D.O.B : " );
       dob.setFont(new Font("Raleway",Font.BOLD,20));
      dob.setBounds(100,240,400,30);
         add(dob);
         
          dateChooser = new JDateChooser();
         dateChooser.setBounds(300,240,400,30);
         add(dateChooser);
         
            JLabel gender    = new JLabel("Gender :" );
       gender.setFont(new Font("Raleway",Font.BOLD,20));
      gender.setBounds(100,290,200,30);
         add(gender);
         
         male = new JRadioButton("Male");
         male.setBounds(300,290,60,30);
         add(male);
         male.setBackground(Color.WHITE);
         
              Female = new JRadioButton("Female");
          Female.setBounds(450,290,120,30);
         add(Female);
         Female.setBackground(Color.WHITE);
         
         ButtonGroup gendergroup = new ButtonGroup ();
         gendergroup.add(male);
         gendergroup.add(Female);
         
                 JLabel email    = new JLabel("Email Address : " );
       email.setFont(new Font("Raleway",Font.BOLD,20));
      email.setBounds(100,340,200,30);
         add(email);
         
           emailTextField = new   JTextField();
         emailTextField.setFont(new Font("Raleway",Font.BOLD,18));
         emailTextField.setBounds(300,340,400,30);
         add(emailTextField); 
         
                 JLabel martial    = new JLabel("Martial Status : " );
       martial.setFont(new Font("Raleway",Font.BOLD,20));
     martial.setBounds(100,390,200,30);
         add(martial );
         
                  married = new JRadioButton("Married");
         married.setBounds(300,390,70,30);
         add(married);
         married.setBackground(Color.WHITE);
         
            unmarried = new JRadioButton("Unmarried");
          unmarried.setBounds(450,390,100,30);
         add(unmarried);
         unmarried.setBackground(Color.WHITE);
                    other = new JRadioButton("Other");
          other.setBounds(630,390,100,30);
         add(other);
         other.setBackground(Color.WHITE);
         
         ButtonGroup martialGroup = new ButtonGroup ();
         martialGroup.add(married);
         martialGroup.add(unmarried);
         martialGroup.add(other);
         
                    JLabel address    = new JLabel("Address : " );
       address.setFont(new Font("Raleway",Font.BOLD,20));
     address.setBounds(100,440,200,30);
         add(address );
           addressTextField = new   JTextField();
         addressTextField.setFont(new Font("Raleway",Font.BOLD,18));
         addressTextField.setBounds(300,440,400,30);
         add(addressTextField); 
         
                    JLabel city    = new JLabel("City : " );
       city.setFont(new Font("Raleway",Font.BOLD,20));
     city.setBounds(100,490,200,30);
         add(city );
           cityTextField = new   JTextField();
         cityTextField.setFont(new Font("Raleway",Font.BOLD,18));
         cityTextField.setBounds(300,490,400,30);
         add(cityTextField); 
         
         
                    JLabel state    = new JLabel("State: " );
       state.setFont(new Font("Raleway",Font.BOLD,20));
     state.setBounds(100,540,200,30);
         add(state );
           stateTextField = new   JTextField();
         stateTextField.setFont(new Font("Raleway",Font.BOLD,18));
         stateTextField.setBounds(300,540,400,30);
         add(stateTextField); 
         
                    JLabel pin    = new JLabel("Pin Code : " );
       pin.setFont(new Font("Raleway",Font.BOLD,20));
     pin.setBounds(100,590,200,30);
         add(pin );
         
             pinTextField = new   JTextField();
         pinTextField.setFont(new Font("Raleway",Font.BOLD,18));
         pinTextField.setBounds(300,590,400,30);
         add(pinTextField); 
         
         next = new JButton ("Next");
         next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.setBounds(620,630,80,30);
         add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,710);
        setLocation(350,10);
        setVisible(true);
        next.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno = " "+random;
        String name = nameTextField.getText(); 
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
String gender = null;
 
 if(male.isSelected())
{
gender = "Male";
}else if(Female.isSelected())
    gender = "Female";
 
    
     String email = emailTextField.getText(); 
     
     String marital = null;
     if(married.isSelected())
     {
         marital = "Married";
     }else if (unmarried.isSelected())
             {
               marital = "Unmarried";
             }else if (other.isSelected())
             {
               marital = "Other";
             }
     String address = addressTextField.getText();
      String city= cityTextField.getText();
      String state= stateTextField.getText();
      String pin= pinTextField.getText();
      
      try{
          if(name.equals(""))
          {
              JOptionPane.showMessageDialog(null,"Name is Required");
          }else{
           Conn c = new Conn();
           String query = "INSERT INTO signup VALUES('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
          c.s.executeUpdate(query); 
//            JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
               
          }
          
      }catch(Exception e)
      {
          e.printStackTrace();
          System.out.println("Error message "+e.getMessage());
      }
     
}
    public static void main(String  args[])
    {
        new SignupOne();
    }
}
