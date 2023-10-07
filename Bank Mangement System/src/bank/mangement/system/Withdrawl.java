package bank.mangement.system;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdraw, back;
    JTextField amount;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 730);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit ");
        text.setBounds(180, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 280, 320, 30);
        image.add(amount);

        withdraw = new JButton(" Withdraw");
         withdraw.setBounds(355, 365, 150, 30);
         withdraw.addActionListener(this);
        image.add( withdraw);

        back = new JButton("Back");
        back.setBounds(355, 396, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 730);
        setLocation(250, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() ==  withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                   JOptionPane.showMessageDialog(null, "Enter the amount You want to Withdraw");
//                JOptionPane.showMessageDialog(null, "Chutiya samjha h kya paise daal tab chalega depoit button");

            } else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "',' withdraw','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + "  withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception e) {
System.out.print(e);
                }
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Withdrawl("");
    }
}
    