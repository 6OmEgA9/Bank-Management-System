package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    //Global Variables--->
    JButton back;
    String pinNumber;
    //Constructor--->
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setSize(900,900);
        setLocation(350,10);
        setLayout(null);
        //setUndecorated(true);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setBounds(350, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;    
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
                while(rs.next()){
                    if(rs.getString("transaction_Type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount")); //Integer.parseInt converts the String value to Integer Value
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }   
            }catch(Exception e){
                System.out.println(e);
            }
            
            JLabel text = new JLabel("Your Current Account Balance is : ");
            text.setBounds(170, 350, 400, 30);
            text.setForeground(Color.white);
            text.setFont(new Font("System",Font.BOLD,20));
            image.add(text);
            
            JLabel bal = new JLabel("Rs. "+balance);
            bal.setBounds(170, 390, 400, 30);
            bal.setForeground(Color.white);
            bal.setFont(new Font("System",Font.BOLD,20));
            image.add(bal);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
