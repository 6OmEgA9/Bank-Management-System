package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser; //for calender DOB

public class SignupOne extends JFrame implements ActionListener{
//  Global variables--->
    long random;
    JTextField nameTextfield,fnameTextfield,mnameTextfield,emailTextfield,addressTextfield;
    JTextField cityTextfield,pinTextfield,stateTextfield;
    JButton next;
    JRadioButton male,female,other,married,unmarried,divorced;
    JDateChooser dateChooser;
//  constructor---->
    SignupOne(){
//      Set the base panel---->
        setTitle("Details");
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
//      generate RANDOM nnumber for unique FORM no. (impoet java.util for random numbers)
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L); 
/*Math.abs ---->return +ve values only, it makes the -ve numbers +ve 
(generates random number between 1000 to 9999)*/
        
//      JLabel  for Application number with a random and unique form no. ----->
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
//      JLabel for the title "Page 1: Personal Details"----->
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
//      JLabel for Name---->
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100, 140, 100, 30); // 140+30 = 170 + 20 = 190(equal gap between to consecutive labels)
        add(name);
        
//      TextField for Name----->
        nameTextfield = new JTextField();
        nameTextfield.setBounds(300,140,400,30);
        nameTextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(nameTextfield);
        
//      JLabel for Father's Name---->
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
//      TextField for Father's Name----->
        fnameTextfield = new JTextField();
        fnameTextfield.setBounds(300,190,400,30);
        fnameTextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(fnameTextfield);
        
//      JLabel for Mother's Name--->
        JLabel mname = new JLabel("Mother's Name : ");
        mname.setFont(new Font("Raleway",Font.BOLD,22));
        mname.setBounds(100, 240, 200, 30);
        add(mname);
        
//      TextField for Mother's Name----->
        mnameTextfield = new JTextField();
        mnameTextfield.setBounds(300,240,400,30);
        mnameTextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(mnameTextfield);
        
//      JLabel for D.O.B--->
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100, 290, 200, 30);
        add(dob);
        
//      calendar JCalendar(jar file) for D.O.B ----->
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 290, 400, 30);
        dateChooser.setFont(new Font("Raleway",Font.BOLD,18));
        add(dateChooser);
        
//      JLabel for Gender--->
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100, 340, 200, 30);
        add(gender);
        
//      Radio buttons for gender ----->
        male = new JRadioButton("Male");
        male.setBounds(300, 340, 60, 30);
        male.setBackground(Color.white);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(400, 340, 100, 30);
        female.setBackground(Color.white);
        add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(520, 340, 60, 30);
        other.setBackground(Color.white);
        add(other);
        
//      group the genders so that only one get selected in radio button
//      (without ButtonGroup all the radio buttons can be selected which violates the rule)
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        
//      JLabel for Email--->
        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100, 390, 200, 30);
        add(email);
        
//      TextField for Email ----->
        emailTextfield = new JTextField();
        emailTextfield.setBounds(300,390,400,30);
        emailTextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(emailTextfield);
        
//      JLabel for Marital Status--->
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100, 440, 200, 30);
        add(marital);        
        
        
//      RadioButton for Marital Status--->
        married = new JRadioButton("Married");
        married.setBounds(300, 440, 100, 30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 440, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        divorced = new JRadioButton("Other");
        divorced.setBounds(520, 440, 100, 30);
        divorced.setBackground(Color.white);
        add(divorced);
//      group the genders so that only one get selected in radio button
//      (without ButtonGroup all the radio buttons can be selected which violates the rule)
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(divorced);
        
        
        
//      JLabel for Address--->
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100, 490, 200, 30);
        add(address);
        
//      TextField for address ----->
        addressTextfield = new JTextField();
        addressTextfield.setBounds(300,490,400,30);
        addressTextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(addressTextfield);
        
//      JLabel for City--->
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100, 540, 200, 30);
        add(city);
        
//      TextField for city ----->
        cityTextfield = new JTextField();
        cityTextfield.setBounds(300,540,400,30);
        cityTextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(cityTextfield);
        
//      JLabel for PIN code --->
        JLabel pin = new JLabel("Pin Code : ");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100, 590, 200, 30);
        add(pin);
        
//      TextField for PIN code ----->
        pinTextfield = new JTextField();
        pinTextfield.setBounds(300,590,400,30);
        pinTextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(pinTextfield);
        
//      JLabel for State--->
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100, 640, 200, 30);
        add(state);
        
//      TextField for state ----->
        stateTextfield = new JTextField();
        stateTextfield.setBounds(300,640,400,30);
        stateTextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(stateTextfield);
        
//      Jbutton for next----->
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setBounds(600,700,100,30);
        next.addActionListener(this);
        add(next);
    }
    public void actionPerformed(ActionEvent ae){
        
        String formno = "" + random; // if you add "" before any long/int value and concatenate it with + then it will automatically convert into string value
        String name = nameTextfield.getText();
        String fname = fnameTextfield.getText();
        String mname = mnameTextfield.getText();
        String email = emailTextfield.getText();
        String address = addressTextfield.getText();
        String city = cityTextfield.getText();
        String pin = pinTextfield.getText();
        String state = stateTextfield.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); //imp SYNTAX try to REMEMBER !
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected())
        {
            gender = "Female";
        }else if(other.isSelected()){
            gender = "Other";
        }
        
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unmarried.isSelected())
        {
            marital = "Unmarried";
        }else if(divorced.isSelected()){
            marital = "Other";
        }
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required!");
            }
            else if (fname.equals("")){
               JOptionPane.showMessageDialog(null, "Father's name is missing!");
            }
            else if (mname.equals("")){
                JOptionPane.showMessageDialog(null, "Mother's name is missing!");
            }
            else if (email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is missing!");
            }
            else if (address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required!");
            }
            else if(city.equals("")){
               JOptionPane.showMessageDialog(null, "City is missing!");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required!");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "PIN code is required!");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "D.O.B is required!");
            }
            else if(gender.equals("")){
                JOptionPane.showMessageDialog(null, "Gender is required!");
            }
            else if(marital.equals("")){
                JOptionPane.showMessageDialog(null, "Marital Status is required!");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+mname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                //When the next button of SignUp page 1 is clicked, it automatically saves the data to the database(SQL) and close Signup Page1 and Opens the signUp page 2---->
                setVisible(false);
                new SignupTwo(formno).setVisible(true); //"formno" is treated as a PRIMARY KEY in this case thats why we pass the value of formno from SignUP page1 to SignUp page2--->
            }   
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupOne();
    }
}