package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    //Global Variable--->
    String pinNumber;
    JButton exit,balanceEnquiry,miniStatement,cashWithdrawal,pinChange,fastCash,deposit;
    //constructor--->
    Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        
        //setTitle("Transactions");
        setSize(900,900);
        setLocation(350,10);
        setLayout(null);
        setUndecorated(true); //It removes the top panel where the 
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(220, 300, 250, 20);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        //JButton for Deposit--->
        deposit = new JButton("Deposit");
        deposit.setBackground(Color.white);
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBackground(Color.white);
        fastCash.setBounds(170, 450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBackground(Color.white);
        pinChange.setBounds(170, 485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBackground(Color.white);
        cashWithdrawal.setBounds(350, 415, 150, 30);
        cashWithdrawal.addActionListener(this);
        image.add(cashWithdrawal);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBackground(Color.white);
        miniStatement.setBounds(350, 450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBackground(Color.white);
        balanceEnquiry.setBounds(350, 485, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("EXIT");
        exit.setBackground(Color.white);
        exit.setBounds(350, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == cashWithdrawal){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Transactions("");
    }
}
