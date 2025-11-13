package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    //Global Variable--->
    String pinNumber;
    JButton back,TwentyThousand,TenThousand,fiveThousand,twentyFiveHundred,oneThousand,fiveHundred;
    //constructor--->
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        
        //setTitle("FastCash");
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
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220, 300, 250, 20);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        //JButton for Deposit--->
        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBackground(Color.white);
        fiveHundred.setBounds(170, 415, 150, 30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);
        
        oneThousand = new JButton("Rs 1000");
        oneThousand.setBackground(Color.white);
        oneThousand.setBounds(170, 450, 150, 30);
        oneThousand.addActionListener(this);
        image.add(oneThousand);
        
        twentyFiveHundred = new JButton("Rs 2500");
        twentyFiveHundred.setBackground(Color.white);
        twentyFiveHundred.setBounds(170, 485, 150, 30);
        twentyFiveHundred.addActionListener(this);
        image.add(twentyFiveHundred);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBackground(Color.white);
        fiveThousand.setBounds(350, 415, 150, 30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        TenThousand = new JButton("Rs 10000");
        TenThousand.setBackground(Color.white);
        TenThousand.setBounds(350, 450, 150, 30);
        TenThousand.addActionListener(this);
        image.add(TenThousand);
        
        TwentyThousand = new JButton("Rs 20000");
        TwentyThousand.setBackground(Color.white);
        TwentyThousand.setBounds(350, 485, 150, 30);
        TwentyThousand.addActionListener(this);
        image.add(TwentyThousand);
        
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
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3); //It will print Rs 500 but u need only 500 so to get that u have to FETCH substring(3)--->500
            Conn c = new Conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("transaction_Type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount")); //Integer.parseInt converts the String value to Integer Value
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return;
                }
                
                Date date = new Date();
                String queryFastCash ="insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(queryFastCash);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" debited successfully!");
                
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]) {
        new FastCash("");
    }
}
