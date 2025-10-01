package bank_Management_System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;


public class signupTwo extends JFrame implements ActionListener {

    Long random;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,education,occupation;

    String formno;


    public signupTwo(String formno) {
        this.formno=formno;


        setTitle("NEW ACCOUNT APPLICATION FORM - Page 2");
        setLayout(null);






        JLabel additionalDetails =new JLabel("Page 2 : AdditionalDetails");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);


        JLabel name =new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String [] value={"Hindu","Muslim","Sikh","Christan","Others"};
        religion=new JComboBox(value);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);





        JLabel fname =new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valCategory []={"GENERAL","OBC","SC","ST","Others"};
        category=new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);



        JLabel dob =new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String valIncome []={"NULL","<2.5K","<5k","Upto 10k"};
        income=new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);




        JLabel gender =new JLabel("Education:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);




        JLabel email =new JLabel("Quallification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);


        String valEdu[]= {"Non Graduate","Graduate","Post Graduate","Docotorate","others"};
        education=new JComboBox(valEdu);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);



        JLabel martialStatus=new JLabel("Ocupation ");
        martialStatus.setFont(new Font("Raleway",Font.BOLD,20));
        martialStatus.setBounds(100,390,200,30);
        add(martialStatus);


        String valOccupation[]= {"Salaried","Self-Employed","BusinessMan","Student", "Retired","others"};
        occupation=new JComboBox(valOccupation);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);




        JLabel address=new JLabel("Pan Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(300,440,400,30);
        add(pan);


        JLabel city=new JLabel("Aadhaar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);


        syes=new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);


        sno=new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup marriageGroup= new ButtonGroup();
        marriageGroup.add(syes);
        marriageGroup.add(sno);


        JLabel pinCode=new JLabel("Existing Account:");
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);

        eyes=new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);


        eno=new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emarriageGroup= new ButtonGroup();
        marriageGroup.add(eyes);
        marriageGroup.add(eno);



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

        String sreligion=(String)religion.getSelectedItem();
        String scateogry= (String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String socupation=(String)occupation.getSelectedItem();

        String seniorCitizen=null;

        if(syes.isSelected()){
            seniorCitizen="YES";
        } else if (sno.isSelected()) {
            seniorCitizen="No";
        }

        String existAccount=null;
        if(eyes.isSelected()){
            existAccount="YES";
        } else if (eno.isSelected()) {
            existAccount="No";
        }

        String span= pan.getText();
        String saadhar=aadhar.getText();


        try {
            connectorDb c=new connectorDb();
            String q="insert into signupTwo values('"+formno+"','"+sreligion+"', '"+scateogry+"', '"+sincome+"', '"+seducation+"', '"+socupation+"','"+span+"', '"+saadhar+"', '"+seniorCitizen+"','"+existAccount+"')";
            c.s.executeUpdate(q);

            setVisible(false);
            new signupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public static void main(String[] args) {
        new signupTwo("");
    }
}

