package bank_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class PinChange extends JFrame implements ActionListener {

   JButton change,back;
   JPasswordField pin,rePin;

   String pinNumber;

    public PinChange(String pinChange) {
        this.pinNumber=pinChange;

        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text=new JLabel("CHANGE YOUR  PIN");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);


        JLabel pinText=new JLabel("NEW  PIN");
        pinText.setBounds(165,320,180,25);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System",Font.BOLD,16));
        image.add(pinText);

        pin =new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);




        JLabel repinText=new JLabel("RE-ENTER NEW PIN");
        repinText.setBounds(165,360,180,25);
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System",Font.BOLD,16));
        image.add(repinText);


        rePin =new JPasswordField();
        rePin.setFont(new Font("Raleway",Font.BOLD,25));
        rePin.setBounds(330,360,180,25);
        image.add(rePin);


        change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public  void actionPerformed(ActionEvent ae){

        if(ae.getSource()==change){

            try {
                String npin=pin.getText();
                String rpin=rePin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Enter pin does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new Pin");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter the Pin");
                    return;
                }

                connectorDb conn=new connectorDb();
                String query1="update bank Set pin =  '"+rpin+"'where pin ='"+pinNumber+"'";
                String query2="update login Set pinno =  '"+rpin+"'where pinno ='"+pinNumber+"'";
                String query3="update signupThree Set pinno =  '"+rpin+"'where pinno ='"+pinNumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed Successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);



            } catch (Exception e) {
                System.out.println(e);
            }

        }

        else{
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);

        }



    }

    public static void main(String[] args) {

        new PinChange("").setVisible(true);


    }
}
