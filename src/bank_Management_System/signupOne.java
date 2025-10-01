package bank_Management_System;

import javax.naming.StringRefAddr;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser dateChooser;


    public signupOne() {

        setLayout(null);

        Random rn=new Random();
         random=Math.abs((rn.nextLong() % 900l) + 1000L);


        JLabel formno =new JLabel("Application Form No "  +  random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails =new JLabel("Page 1 : PersonalDetails");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);


        JLabel name =new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);


        JLabel fname =new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,20));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);

        JLabel dob =new JLabel("DOB:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);


        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);


        JLabel gender =new JLabel("GENDER:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

         male=new JRadioButton("MALE");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female=new JRadioButton("FEMALE");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup= new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email =new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,20));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);


        JLabel martialStatus=new JLabel("Martial Status ");
        martialStatus.setFont(new Font("Raleway",Font.BOLD,20));
        martialStatus.setBounds(100,390,200,30);
        add(martialStatus);

        married=new JRadioButton("MARRIAGE");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried=new JRadioButton("UNMARRIAGE");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        others=new JRadioButton("OTHERS");
        others.setBounds(630,390,100,30);
        others.setBackground(Color.WHITE);
        add(others);


        ButtonGroup marriageGroup= new ButtonGroup();
        marriageGroup.add(married);
        marriageGroup.add(unmarried);
        marriageGroup.add(others);


        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,20));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);


        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,20));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,20));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);



        JLabel pinCode=new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);


        next=new JButton("NEXT");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway",Font.BOLD,14));
       next.setBounds(700,620,80,30);
       next.addActionListener(this);
       add(next);





        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno= ""+random;
        String name=nameTextField.getText();
        String fname= fnameTextField.getText();
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;

        if(male.isSelected()){
            gender="Male";
        } else if (female.isSelected()) {
            gender="FEMALE";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="MARRIAGE";
        } else if (unmarried.isSelected()) {
            marital="UNMARRIAGE";
        } else if (others.isSelected()) {
            marital="OTHERS";
        }

        String address= addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();

        System.out.println("hello");


        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Req");
            }
            else{
                connectorDb c=new connectorDb();
                String query="insert into signup values('"+formno+"','"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"','"+marital+"', '"+address+"', '"+city+"','"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);
            }


            new signupTwo(formno).setVisible(true);
            setVisible(false);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
         new signupOne();
    }
}
