package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame {
//  global variable--->
    String pinNumber;
//  constructor--->
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        
        setTitle("MiniStatement");
        setLayout(null);
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNo = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardNo").substring(0,4) + "XXXXXXXX" + rs.getString("cardNo").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn con = new Conn();
            int bal = 0; //set the initial balance as 0 and then calculate it from database using while(rs.next) method--->
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(rs.next()){
                //fetch the banking history from the bank table form SQL database---->
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("transaction_Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>"); // &nbsp; is used to give spaces in between in HTML!
                //balance calculation ---->
                if(rs.getString("transaction_Type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount")); //Integer.parseInt converts the String value to Integer Value
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current Account Balance is: "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}