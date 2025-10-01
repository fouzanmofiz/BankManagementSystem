package bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiniStatement extends JFrame {



    public MiniStatement(String pin) {
        super("MiniStatemen");





        setTitle("MINI STATEMENT");

        setLayout(null);

        JLabel l1=new JLabel();
        add(l1);

        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel bal = new JLabel();
        bal.setBounds(20, 400, 300, 20);
        add(bal);

        try{
            connectorDb conn=new connectorDb();
            ResultSet rs=conn.s.executeQuery("select * from login where pinno = '"+pin+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardno").substring(0,4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        try{
            int balance = 0;
            connectorDb c1  = new connectorDb();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("typeofTrans") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("typeofTrans").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance = Math.abs(balance-Integer.parseInt(rs.getString("amount")));
                }

            }
            bal.setText("Your total Balance is Rs " +balance);

        } catch (Exception e) {
            System.out.println(e);
        }

        l1.setBounds(20,140,400,200);


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new MiniStatement("");

    }
}
