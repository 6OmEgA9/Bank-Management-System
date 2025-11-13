package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    //Global Variables----->
    String pinNumber;
    JButton change,back;
    JPasswordField npin,rnpin;
    //Constructor--->
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        
        //setTitle("Pin Change");
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
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(260, 300, 250, 20);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel newPin = new JLabel("New Pin:");
        newPin.setBounds(160, 350, 100, 20);
        newPin.setFont(new Font("System",Font.BOLD,18));
        newPin.setForeground(Color.white);
        image.add(newPin);
        
        npin = new JPasswordField();
        npin.setBounds(350, 350, 150, 20);
        npin.setBackground(Color.white);
        npin.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(npin);
        
        JLabel renewPin = new JLabel("Re-Enter New Pin:");
        renewPin.setBounds(160, 390, 180, 20);
        renewPin.setFont(new Font("System",Font.BOLD,18));
        renewPin.setForeground(Color.white);
        image.add(renewPin);
        
        rnpin = new JPasswordField();
        rnpin.setBounds(350, 390, 150, 20);
        rnpin.setBackground(Color.white);
        rnpin.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(rnpin);
        
        change = new JButton("CHANGE");
        change.setBackground(Color.white);
        change.setBounds(350, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setBounds(350, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String newPin = npin.getText();
            String RenewPin = rnpin.getText();
            
            if(!newPin.equals(RenewPin)){
                JOptionPane.showMessageDialog(null, "Entered Pin doesn't Match!");
                return;
            }
            if(ae.getSource() == change){
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter New Pin!");
                }
                if(rnpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin!");
                }
                
                Conn c = new Conn();
                
                String q1 = "update bank set pin ='"+RenewPin+"' where pin = '"+pinNumber+"'";
                String q2 = "update login set pinNo ='"+RenewPin+"' where pinNo = '"+pinNumber+"'";
                String q3 = "update signupThree set pinNo ='"+RenewPin+"' where pinNo = '"+pinNumber+"'";
                
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN updated successfully!");
                
                setVisible(false);
                new Login().setVisible(true);
            }
            else if(ae.getSource() == back){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new PinChange("");
    }
}
