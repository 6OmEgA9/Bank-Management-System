package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    //global Variables--->(it is globally declared to implement it in the abstract class of actionListener)
    JButton login,clear,signup;
    JTextField CardTextField;
    JPasswordField PinTextField;
    
    //constructor
    Login(){
        //Set the base panel---->
        setTitle("ATM");
        setLayout(null);
        setSize(800,480);
        getContentPane().setBackground(Color.white);
        setLocation(350,200);
        setVisible(true);
        
        //import and adjust the icon---->
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel label = new JLabel(i3);
        label.setBounds(120,10,100,100); //since we are using custom layout ---> make setLayout to null.
        add(label);
        
        //JLabel for "Welcome to ATM text" ---->
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(280,40,400,40);
        add(text);
        
        //JLabel for "Cardno text" ---->
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        
        //TextField for entering the card number---->
        CardTextField = new JTextField();
        CardTextField.setBounds(270, 156, 250, 30);
        CardTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(CardTextField);
        
        //JLabel for "PIN text" ---->
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,150,40);
        add(pin);
        
        //TextField for entering the PIN number---->
        PinTextField = new JPasswordField();
        PinTextField.setBounds(270, 226, 250, 30);
        PinTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(PinTextField);
        
        //JButton for login button----->
        login = new JButton("SIGN IN");
        login.setBounds(280, 300, 100, 30);
        login.setBackground(Color.green);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);
        
        //JButton for clear button----->
        clear = new JButton("CLEAR");
        clear.setBounds(420, 300, 100, 30);
        clear.setBackground(Color.red);
        clear.setForeground(Color.white);
        clear.addActionListener(this); //addActionListener is the function which is added to buttons that catches the event !
        add(clear);
        
        //JButton for sign up button----->
        signup = new JButton("SIGN UP");
        signup.setBounds(350, 350, 100, 30);
        signup.setBackground(Color.blue);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear)
        {
            CardTextField.setText("");
            PinTextField.setText("");
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        else if(ae.getSource() == login)
        {
            Conn con =new Conn();
                String cardNumber = CardTextField.getText();
                String pinNumber = PinTextField.getText(); // don't worry it will run but since pinNumber is a password Field and not a textField thats why it not appropriate to use getText !
                String loginQuery  = "select * from login where cardNo = '"+cardNumber+"' and pinNo = '"+pinNumber+"'";
                
            try{
                ResultSet rs = con.s.executeQuery(loginQuery);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }  
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]) {
        new Login();
    }
}