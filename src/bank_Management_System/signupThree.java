package bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox j1,j2,j3,j4,j5,j6,j7;
    JButton submit,cancel;

    String formno;

    public signupThree(String formNo) {

        this.formno=formNo;

        setLayout(null);

        JLabel label=new JLabel("Account Details :Page3");
        label.setFont(new Font("Raleway",Font.BOLD,22));
        label.setBounds(200,30,400,40);
        add(label);


        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,100,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,150,150,20);
        add(r1);


        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,150,160,20);
        add(r2);


        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,200,160,20);
        add(r3);


        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,200,250,20);
        add(r4);

        ButtonGroup addGroup=new ButtonGroup();
        addGroup.add(r1);
        addGroup.add(r2);
        addGroup.add(r3);
        addGroup.add(r4);

        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,260,200,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,260,300,30);
        add(number);

        JLabel cardDetail=new JLabel("your 16 digit Card Number");
        cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetail.setBounds(100,280,300,20);
        add(cardDetail);


        JLabel pin=new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,340,200,30);
        add(pin);

        JLabel pinNumber=new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinNumber.setBounds(330,340,300,30);
        add(pinNumber);

        JLabel pinDetail=new JLabel("Your 4 Digit Pin Password");
        pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetail.setBounds(100,360,300,20);
        add(pinDetail);


        JLabel service=new JLabel("Service Required");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,410,400,30);
        add(service);

         j1=new JCheckBox("ATM CARD");
         j1.setBackground(Color.WHITE);
         j1.setFont(new Font("Raleway",Font.BOLD,16));
         j1.setBounds(100,460,200,30);
         add(j1);

        j2=new JCheckBox("Internet Banking");
        j2.setBackground(Color.WHITE);
        j2.setFont(new Font("Raleway",Font.BOLD,16));
        j2.setBounds(350,460,200,30);
        add(j2);

        j3=new JCheckBox("Mobile Banking");
        j3.setBackground(Color.WHITE);
        j3.setFont(new Font("Raleway",Font.BOLD,16));
        j3.setBounds(100,500,200,30);
        add(j3);

        j4=new JCheckBox("Email & SMS Alert");
        j4.setBackground(Color.WHITE);
        j4.setFont(new Font("Raleway",Font.BOLD,16));
        j4.setBounds(350,500,200,30);
        add(j4);

        j5=new JCheckBox("Check Book");
        j5.setBackground(Color.WHITE);
        j5.setFont(new Font("Raleway",Font.BOLD,16));
        j5.setBounds(100,540,200,30);
        add(j5);

        j6=new JCheckBox("E-Statement");
        j6.setBackground(Color.WHITE);
        j6.setFont(new Font("Raleway",Font.BOLD,16));
        j6.setBounds(350,540,200,30);
        add(j6);

        j7=new JCheckBox("Herby Declared by the above enter detail mention is correct to te best of my Knowledege");
        j7.setBackground(Color.WHITE);
        j7.setFont(new Font("Raleway",Font.BOLD,12));
        j7.setBounds(100,570,550,30);
        add(j7);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,610,100,30);
        submit.addActionListener(this);
        add(submit);


        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,610,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);







        setSize(800,2000);
        setLocation(500,200);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
          String accountType=null;
          if(r1.isSelected())   accountType="Saving Account";
          else if (r2.isSelected())  accountType="Fixed Deposit";
          else if (r3.isSelected())  accountType="Current Account";
          else if (r4.isSelected())  accountType="Recurring Deposit Account";

            Random random=new Random();
            String cardNo= ""+ Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNo= "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility="";

            if(j1.isSelected()) facility=facility+"ATM CARD";
            else if(j2.isSelected()) facility=facility+"Internet Banking";
            else if(j3.isSelected()) facility=facility+"Mobile Banking";
            else if(j4.isSelected()) facility=facility+"Email & SMS Alert";
            else if(j5.isSelected()) facility=facility+"Check Book";
            else if(j6.isSelected()) facility=facility+"E-Statement";

            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Acoount No is Required");
                }

                connectorDb conn=new connectorDb();

                String query1="insert into signupThree values('"+formno+"', '"+accountType+"' ,'"+cardNo+"','"+pinNo+"', '"+facility+"')";
                String query2="insert into login values('"+formno+"' ,'"+cardNo+"','"+pinNo+"')";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);


                JOptionPane.showMessageDialog(null, "Card No :" + cardNo + "\n Pin No :" + pinNo);

                setVisible(false);
                new Deposit(pinNo).setVisible(true);


            } catch (Exception e) {
                throw new RuntimeException(e);
            }



        } else if (ae.getSource()==cancel) {
            setVisible(false);
            new login().setVisible(true);

        }
    }

    public static void main(String[] args) {

        new signupThree("");

    }


}

