package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    //Globla Variable--->
    String pinNumber;
    JTextField amount;
    JButton deposit,back;
    //Constructor--->
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        
        //setTitle("Deposit");
        setSize(900,900);
        setLocation(350,10);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(190, 300, 300, 20);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(190, 350, 280, 30);
        amount.setBackground(Color.white);
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(amount);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBackground(Color.white);
        deposit.setBounds(350, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setBounds(350, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == deposit){
            String depositedAmount = amount.getText();
            Date date = new Date();
            try{
                if(depositedAmount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter the Amount to Deposit!");
                }
                else{
                    Conn c = new Conn();
                    String depositQuery ="insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+depositedAmount+"')";
                    c.s.executeUpdate(depositQuery);
                    
                    JOptionPane.showMessageDialog(null, "Rs "+depositedAmount+" credited Succesfully!");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }  
             }catch(Exception e){
                System.out.println(e);
             }
        }
    }
    public static void main(String args[]) {
        new Deposit("");
    }
}
