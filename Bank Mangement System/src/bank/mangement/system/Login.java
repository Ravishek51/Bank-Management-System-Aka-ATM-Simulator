package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    String formno;

    Login(String formno) {
        this.formno = formno;
        setTitle("User Login");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Logo.png"
                + ""));
        Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i1);
        label.setBounds(90, 15, 115, 128);
        add(label);

        getContentPane().setBackground(Color.WHITE);
        JLabel text = new JLabel("Welcome to ARC Bank");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(250, 40, 400, 40);
        add(text);

        getContentPane().setBackground(Color.WHITE);
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(100, 160, 150, 40);
        add(cardno);
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Arial", Font.ITALIC, 23));
        cardTextField.setBounds(300, 160, 240, 40);
        add(cardTextField);

        getContentPane().setBackground(Color.WHITE);
        JLabel pin = new JLabel("PIN No: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(100, 230, 260, 40);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Arial", Font.ITALIC, 23));
        pinTextField.setBounds(300, 230, 240, 40);
        add(pinTextField);

        login = new JButton(" SIGN IN ");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        login.addActionListener(this);

        clear = new JButton(" CLEAR ");
        clear.setBounds(440, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);

        signup = new JButton(" SIGN UP ");
        signup.setBounds(300, 350, 240, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);

        add(signup);

        setSize(650, 500);
        setVisible(true);
        setLocation(360, 120);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == login) {
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "Select * from login where cardnumber  = '" + cardnumber + "'and pin = '" + pinnumber + "'";
            try {
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Galat bhar rha h bhai");
                }
            } catch (Exception e) {
                System.out.print(e);
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }

    public static void main(String args[]) {
        new Login("");
    }

}
