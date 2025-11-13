package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

        
public class SignupThree extends JFrame implements ActionListener{
//  Global Variables--->
//    JLabel accountType;
    JRadioButton savingAccount,currentAccount,fixedDepositAcc,RecurringDepositAcc;
    JCheckBox atm,mobileBanking,chequebook,internetBanking,emailndsms,estatement,declaration;
    JButton submit,cancel;
    String formno;
//  constructor----->
    SignupThree(String formno){
        this.formno = formno;
//      set the base panel for the signup page 3----->
        setTitle("Few more Details...");
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
//      JLabel for the heading "page 2: Additional Details"--->  
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
        accountDetails.setBounds(280, 40, 400, 40);
        add(accountDetails);
        
//      JLabel for the heading "page 2: Additional Details"--->  
        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway",Font.BOLD,20));
        accountType.setBounds(100, 100, 400, 40);
        add(accountType);
        
//      JRadioButton  for savings account----->
        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setBounds(100, 140, 250, 40);
        savingAccount.setFont(new Font("Raleway",Font.ITALIC,16));
        savingAccount.setBackground(Color.white);
        add(savingAccount);
        
//      JRadioButton for current account--->
        currentAccount = new JRadioButton("Current Account");
        currentAccount.setBounds(100, 180, 250, 40);
        currentAccount.setFont(new Font("Raleway",Font.ITALIC,16));
        currentAccount.setBackground(Color.white);
        add(currentAccount);
        
//      JRadioButton  for savings account----->
        fixedDepositAcc = new JRadioButton("Fixed Deposit Account");
        fixedDepositAcc.setBounds(400, 140, 400, 40);
        fixedDepositAcc.setFont(new Font("Raleway",Font.ITALIC,16));
        fixedDepositAcc.setBackground(Color.white);
        add(fixedDepositAcc);
        
//      JRadioButton for current account--->
        RecurringDepositAcc = new JRadioButton("Recurring Deposit Account");
        RecurringDepositAcc.setBounds(400, 180, 400, 40);
        RecurringDepositAcc.setFont(new Font("Raleway",Font.ITALIC,16));
        RecurringDepositAcc.setBackground(Color.white);
        add(RecurringDepositAcc);  
        
//      ButtonGroup for account type--->
        ButtonGroup accType = new ButtonGroup();
        accType.add(savingAccount);
        accType.add(currentAccount);
        accType.add(fixedDepositAcc);
        accType.add(RecurringDepositAcc);
        
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100, 230, 400, 40);
        add(card);
        JLabel sms = new JLabel("Your 16 digit card number");
        sms.setFont(new Font("Raleway",Font.ITALIC,14));
        sms.setBounds(100, 250, 400, 40);
        add(sms);
        
        JLabel cardno = new JLabel("xxxx-xxxx-xxxx-4129");
        cardno.setFont(new Font("Raleway",Font.BOLD,18));
        cardno.setBounds(250, 230, 400, 40);
        add(cardno);
        
        JLabel pin = new JLabel("PIN Number :");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100, 290, 400, 40);
        add(pin);
        JLabel smspin = new JLabel("Your 4 digit pin");
        smspin.setFont(new Font("Raleway",Font.ITALIC,14));
        smspin.setBounds(100, 310, 400, 40);
        add(smspin);
        
        JLabel pinno = new JLabel("xxxx");
        pinno.setFont(new Font("Raleway",Font.BOLD,18));
        pinno.setBounds(250, 290, 400, 40);
        add(pinno);
        
        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(100, 360, 400, 40);
        add(services);
        
        atm = new JCheckBox("ATM services");
        atm.setBounds(100, 410, 200, 20);
        atm.setBackground(Color.white);
        atm.setFont(new Font("Raleway",Font.ITALIC,16));
        add(atm);
        
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(100, 450, 200, 20);
        mobileBanking.setBackground(Color.white);
        mobileBanking.setFont(new Font("Raleway",Font.ITALIC,16));
        add(mobileBanking);
        
        chequebook = new JCheckBox("Cheque Book");
        chequebook.setBounds(100, 490, 200, 20);
        chequebook.setBackground(Color.white);
        chequebook.setFont(new Font("Raleway",Font.ITALIC,16));
        add(chequebook);
        
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.white);
        internetBanking.setBounds(310, 410, 200, 20);
        internetBanking.setFont(new Font("Raleway",Font.ITALIC,16));
        add(internetBanking);
        
        emailndsms = new JCheckBox("EMAIL & SMS Alerts");
        emailndsms.setBackground(Color.white);
        emailndsms.setBounds(310, 450, 200, 20);
        emailndsms.setFont(new Font("Raleway",Font.ITALIC,16));
        add(emailndsms);
        
        estatement = new JCheckBox("E-Statement");
        estatement.setBackground(Color.white);
        estatement.setBounds(310, 490, 200, 20);
        estatement.setFont(new Font("Raleway",Font.ITALIC,16));
        add(estatement);
        
        declaration = new JCheckBox("i hereby declare that all the information provided above is true to the best of my knowledge");
        declaration.setBackground(Color.white);
        declaration.setBounds(100, 550, 500, 20);
        declaration.setFont(new Font("Raleway",Font.ITALIC,12));
        add(declaration);
        
        submit = new JButton("Submit");
        submit.setBounds(300, 650, 100, 30);
        submit.setBackground(Color.black);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(500, 650, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String account_type = null;
            if(savingAccount.isSelected()){
                account_type = "Saving Account";
            }
            if(currentAccount.isSelected()){
                account_type = "Current Account";
            }
            if(fixedDepositAcc.isSelected()){
                account_type = "Fixed Deposit Account";
            }
            if(RecurringDepositAcc.isSelected()){
                account_type = "Recurring Deposit Account";
            }
            //Generate the card and Pin number---->
            Random random = new Random();
            String cardno = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinno = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(atm.isSelected()){
                facility = facility + "ATM Services  "; 
            }
            if(mobileBanking.isSelected()){
                facility = facility + "Mobile Banking  "; 
            }
            if(chequebook.isSelected()){
                facility = facility + "Cheque Book  ";
            }
            if(internetBanking.isSelected()){
                facility = facility + "Internet Banking  ";
            }
            if(emailndsms.isSelected()){
                facility = facility + "EMAIL & SMS Alerts  ";
            }
            if(estatement.isSelected()){
                facility = facility + "E-Statement  ";
            }
            try{
                if(account_type.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required!");
                }
                else if(declaration.equals("")){
                    JOptionPane.showMessageDialog(null, "Agree Declaration is Required!");
                }
                else{
                    Conn c = new Conn();
                    String query3 = "insert into signupThree values('"+formno+"','"+account_type+"','"+cardno+"','"+pinno+"','"+facility+"')";
                    String query4 = "insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
                    c.s.executeUpdate(query3);
                    c.s.executeUpdate(query4);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: "+cardno+"\nPin Number: "+pinno);
                    
                    //To create a account You have to deposit some amount----> we will close the signup page three and directly open the deposit page for first bank acc opening deposit!
                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]) {
        new SignupThree("");
    }
}
