package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {

    JButton deposite, withdrawl, ministatement, pinchange, fastcash, balanceenquiry, exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 730);
        add(image);

        JLabel text = new JLabel("SELECT  WITHRAWL  AMOUNT");
        text.setBounds(180, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposite = new JButton("Rs 100");
        deposite.setBounds(170, 335, 150, 27);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawl = new JButton("Rs 500 ");
        withdrawl.setBounds(355, 335, 150, 27);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton(" Rs 1000");
        fastcash.setBounds(170, 365, 150, 27);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2,000 ");
        ministatement.setBounds(355, 363, 150, 27);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton(" Rs 5,000");
        pinchange.setBounds(170, 395, 150, 27);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 10,000");
        balanceenquiry.setBounds(355, 391, 150, 27);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("BACK");
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
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank Where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "Insufficent balance ");
                    return;
                }
                else {
                    Date date = new Date();
                    String query = "insert into  bank values ('" + pinnumber + "','" + date + "','Withdrawl','" + amount + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + "Debited Sucessfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String args[]) {

        new FastCash("").setVisible(true);
    }

}
