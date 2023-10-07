
package bank.mangement.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame  implements ActionListener  {
   
     JButton back;
      String pinnumber;
    
    BalanceEnquiry(String pinnumber)
           
            
    {
         this.pinnumber = pinnumber;
            setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 730);
        add(image);
        
        back =  new JButton("Back");
        back.setBounds(355,400,150,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;                                                                            
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank Where pin = '" + pinnumber + "'");
                
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                }catch(Exception e)
                        {
                        System.out.print(e);
                        }
            
        JLabel text = new JLabel ("Your current account balance  is Rs: "+ balance);
          text.setBounds(165, 290, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
            
           setSize(900, 730);
        setLocation(250, 0);
//         setUndecorated(true);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible (false);
        new Transaction(pinnumber).setVisible(true); 
    }
 public static void main(String args[])
 {
     new BalanceEnquiry("");
 }
    
}
