package bank_Management_System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JButton login,signup,clear;
    JTextField cardText;
    JPasswordField pinText;
    public login() {
        setTitle("AUTOMATED TRAILOR MACHINE");
        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);

        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel txt=new JLabel("Welcome to Atm");
        txt.setFont(new Font("Osward",Font.BOLD,38));
        txt.setBounds(200,40,400,40);
        add(txt);

        JLabel cardNo =new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120,150,150,30);
        add(cardNo);

        cardText=new JTextField();
        cardText.setBounds(300,150,230,30);
        add(cardText);

        JLabel pinno=new JLabel("PIN:");
        pinno.setFont(new Font("Raleway",Font.BOLD,28));
        pinno.setBounds(120,220,250,30);
        add(pinno);

        pinText=new JPasswordField();
        pinText.setBounds(300,220,230,30);
        add(pinText);

        login= new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear= new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup= new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);





        getContentPane().setBackground(Color.WHITE);


        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==clear){
          cardText.setText("");
          pinText.setText("");
        } else if (ae.getSource()==login) {

            connectorDb con=new connectorDb();
            String cardNumber=cardText.getText();
            String pinNumber=pinText.getText();
            String query="Select * from login where cardno='"+cardNumber+"' and pinno= '"+pinNumber+"'";

            try {
              ResultSet rs= con.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Transaction(pinNumber).setVisible(true);
              } else {
                  JOptionPane.showMessageDialog(null,"Incorrect card no or Pin");
              }


            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (ae.getSource()==signup) {
            setVisible(false);
            new signupOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new login();

    }
}