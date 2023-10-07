package bank.mangement.system;

import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
       String pinnumber;

    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 730);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(260, 230, 700, 35);
        text.setForeground(Color.blue);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("New  PIN:  ");
        pintext.setBounds(165, 270, 180, 25);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        pin = new JPasswordField ();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 270, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN:  ");
        repintext.setBounds(165, 300, 180, 25);
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);

        repin = new JPasswordField ();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 300, 180, 25);
        image.add(repin);

        change = new JButton(" Change");
        change.setBounds(355, 383, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton(" Back");
        back.setBounds(355, 415, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 730);
        setLocation(250, 0);
//         setUndecorated(true);

        setVisible(true);

//     this.pinnumber.setvisible(true);   
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {

            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Enterd Pin does not match ");
                    return;
                }
                if( npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter PIN  ");
                    return;
                }

                if( npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please re-enter new  PIN  ");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pin='"+rpin+"'where pin='"+ pinnumber+"'";
                String query2 = "update login set pin='"+rpin+"'where pin='"+ pinnumber+"'";
                String query3  = "update signupthree set pin='"+rpin+"'where pin='"+ pinnumber+"'";
                 conn.s.executeUpdate(query1);
                  conn.s.executeUpdate(query2);
                   conn.s.executeUpdate(query3);
                   JOptionPane.showMessageDialog(null, "PIN change Sucessfully  ");
                     setVisible(false);
            new Transaction(rpin).setVisible(true);
                
            } catch (Exception e) {
                System.out.print(e);
            }
        }else
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
