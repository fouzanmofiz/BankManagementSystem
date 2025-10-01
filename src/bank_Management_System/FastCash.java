package bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withDrawl,fastCash,miniStatement,pinChange,balRequired,exit;

    String pinno;
    public FastCash(String pinNumber) {
        this.pinno=pinNumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text=new JLabel("Select WithDrawl Amount");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);


        deposit=new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);


        withDrawl=new JButton(" Rs 500");
        withDrawl.setBounds(355,415,150,30);
        withDrawl.addActionListener(this);
        image.add(withDrawl);


        fastCash=new JButton("Rs 1000");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);


        miniStatement=new JButton("Rs 2000");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange=new JButton("Rs 5000");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balRequired=new JButton("Rs 10000");
        balRequired.setBounds(355,485,150,30);
        balRequired.addActionListener(this);
        image.add(balRequired);

        exit=new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);






        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }

    public  void actionPerformed(ActionEvent ae){

        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }

        else {
            String amount = ((JButton)ae.getSource()).getText().trim().substring(3);
            connectorDb conn=new connectorDb();
            try {
                ResultSet rs=conn.s.executeQuery("Select * from bank where pin = '"+pinno+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("typeofTrans").equals("deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else  balance-=Integer.parseInt(rs.getString("amount"));
                }

                if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }

                Date date=new Date();
                String query="insert into bank values('"+pinno+"', '"+date+"','Withdraw','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " +amount+ "Debited Sucessfully");

                setVisible(false);
                new Transaction(pinno).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }

        }



    }

    public static void main(String[] args) {

        new FastCash("");

    }
}

