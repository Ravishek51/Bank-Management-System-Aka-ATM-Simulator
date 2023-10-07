package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    JButton deposite, withdrawl, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;

    Transaction(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 730);
        add(image);

        JLabel text = new JLabel("Please select your Transaction Method");
        text.setBounds(180, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposite = new JButton("Deposite");
        deposite.setBounds(170, 335, 150, 27);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawl = new JButton("Cash withdrawl");
        withdrawl.setBounds(355, 335, 150, 27);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 365, 150, 27);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 363, 150, 27);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 395, 150, 27);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355, 391, 150, 27);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 420, 150, 27);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 730);
        setLocation(250, 0);
//         setUndecorated(true);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposite) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);

        }

    }

    public static void main(String args[]) {

        new Transaction("");
    }

}
