package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    //Global Variables---->
    JComboBox  religionComboBox,categoryComboBox,incomeComboBox,eduComboBox,occupationComboBox;
    JTextField panTextField,AadharTextField;
    JRadioButton syes,sno,eaYes,eaNo;
    JButton next;
    String formno;
    
    //constructor---->
    SignupTwo(String formno){
        this.formno = formno;
        
//      Set the base panel for signup Page 2---->
        setTitle("ADDITIONAL DETAILS");
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
//      JLabel for the heading "page 2: Additional Details"--->  
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
//      JLabel for Religion--->        
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100, 140, 150, 30); // 140+30 = 170 + 20 = 190(equal gap between to consecutive labels)
        add(religion);
        
//      JComboBox for religion--->
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionComboBox = new JComboBox(valReligion);
        religionComboBox.setBounds(300, 140, 400, 30);
        religionComboBox.setBackground(Color.white);
        add(religionComboBox);
        
//      JLabel for Category---> 
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
//      JComboBox for category--->
        String valCategory[] = {"General","OBC","ST","SC","Other"};
        categoryComboBox = new JComboBox(valCategory);
        categoryComboBox.setBounds(300, 190, 400, 30);
        categoryComboBox.setBackground(Color.white);
        add(categoryComboBox);
        
//      JLabel for Income--->
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
//      JComboBox for income--->
        String valIncome[] = {"null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        incomeComboBox = new JComboBox(valIncome);
        incomeComboBox.setBounds(300, 240, 400, 30);
        incomeComboBox.setBackground(Color.white);
        add(incomeComboBox);
        
//      JLabel for Educational Qualification--->
        JLabel EduQualification = new JLabel("Educational");
        EduQualification.setFont(new Font("Raleway",Font.BOLD,22));
        EduQualification.setBounds(100, 290, 300, 30);
        add(EduQualification);
        
        JLabel EduQualification2 = new JLabel("Qualification: ");
        EduQualification2.setFont(new Font("Raleway",Font.BOLD,22));
        EduQualification2.setBounds(100, 315, 300, 30);
        add(EduQualification2);
        
//      JComboBox for educational Qualification--->
        String valEduQualification[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        eduComboBox = new JComboBox(valEduQualification);
        eduComboBox.setBounds(300, 300, 400, 30);
        eduComboBox.setBackground(Color.white);
        add(eduComboBox);
        
//      JLabel for Occupation--->
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100, 370, 200, 30);
        add(occupation);
        
//      JComboBox for occupation--->
        String valOccupation[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
        occupationComboBox = new JComboBox(valOccupation);
        occupationComboBox.setBounds(300, 370, 400, 30);
        occupationComboBox.setBackground(Color.white);
        add(occupationComboBox);
        
//      JLabel for PAN number--->
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100, 420, 200, 30);
        add(pan);
        
//      JTextfield for PAN number----->
        panTextField = new JTextField();
        panTextField.setBounds(300, 420, 400, 30);
        panTextField.setBackground(Color.white);
        panTextField.setFont(new Font("Raleway",Font.BOLD,18));
        add(panTextField);

        
//      JLabel for Aadhar Number--->
        JLabel Aadhar = new JLabel("Aadhar Number:");
        Aadhar.setFont(new Font("Raleway",Font.BOLD,22));
        Aadhar.setBounds(100, 470, 200, 30);
        add(Aadhar);     
        
//      JTextfield for Aadhar number----->
        AadharTextField = new JTextField();
        AadharTextField.setBounds(300, 470, 400, 30);
        AadharTextField.setBackground(Color.white);
        AadharTextField.setFont(new Font("Raleway",Font.BOLD,18));
        add(AadharTextField);

        
//      JLabel for Senior Citizen --->
        JLabel snrCitizen = new JLabel("Senior Citizen:");
        snrCitizen.setFont(new Font("Raleway",Font.BOLD,22));
        snrCitizen.setBounds(100, 520, 200, 30);
        add(snrCitizen);
        
//      JRadioButton for YES(senior Citizen) 
        syes = new JRadioButton("Yes");
        syes.setBounds(350, 520, 60, 30);
        syes.setBackground(Color.white);
        add(syes);
//      JRadioButton for NO(senior Citizen) 
        sno = new JRadioButton("No");
        sno.setBackground(Color.white);
        sno.setBounds(500, 520, 60, 30);
        add(sno);
        
//      ButtonGroup for YES or NO (snr Citizen)--->(so that only One radioButton GETS selected out of two buttons YES or NO)
        ButtonGroup YesNosnrCitizen = new ButtonGroup();
        YesNosnrCitizen.add(syes);
        YesNosnrCitizen.add(sno);

//      JLabel for Existing Account--->
        JLabel existingAcc = new JLabel("Existing Account:");
        existingAcc.setFont(new Font("Raleway",Font.BOLD,22));
        existingAcc.setBounds(100, 570, 200, 30);
        add(existingAcc);
//      JRadioButton for yes if Existing Acc exists---->
        eaYes = new JRadioButton("Yes");
        eaYes.setBounds(350,570,60,30);
        eaYes.setBackground(Color.white);
        add(eaYes);
//      JRadioButton for no if Existing Acc donot exists---->
        eaNo = new JRadioButton("No");
        eaNo.setBounds(500,570,60,30);
        eaNo.setBackground(Color.white);
        add(eaNo);
//      ButtonGroup for Existing Acc YES or No----->(takes either YES or  NO  not BOTH the values)--->
        ButtonGroup ExistingAccYesNo = new ButtonGroup();
        ExistingAccYesNo.add(eaYes);
        ExistingAccYesNo.add(eaNo);
        
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
        
        String sreligion = (String)religionComboBox.getSelectedItem(); //you have to typecast it to string since "getSelectedItem" returns an object
        String scategory = (String)categoryComboBox.getSelectedItem();
        String sincome = (String)incomeComboBox.getSelectedItem();
        String seducationalQualification= (String)eduComboBox.getSelectedItem();
        String soccupation = (String)occupationComboBox.getSelectedItem();
        String sPAN = panTextField.getText();
        String sAadhar = AadharTextField.getText();
        
        //For senior Citizen--->
        String Senior_Citizen = null;
        if(syes.isSelected()){
            Senior_Citizen = "Yes";
        }
        else if (sno.isSelected()){
            Senior_Citizen = "No";
        }
        
        //for Existing Account --->
        String Existing_Acc = null;
        if(eaYes.isSelected()){
            Existing_Acc = "Yes";
        }
        else if(eaNo.isSelected()){
            Existing_Acc = "No";
        }
        
        try{
            if(sreligion.equals("")){
                JOptionPane.showMessageDialog(null, "Religion field required!");
            }
            else if(scategory.equals("")){
                JOptionPane.showMessageDialog(null, "Category is required!");
            }
            else if(sincome.equals("")){
                JOptionPane.showMessageDialog(null, "Income is required!");
            }
            else if(seducationalQualification.equals("")){
                JOptionPane.showMessageDialog(null, "Educational Qualification Required!");
            }
            else if(soccupation.equals("")){
                JOptionPane.showMessageDialog(null, "Occupation Required!");
            }
            else if(sPAN.equals("")){
                JOptionPane.showMessageDialog(null, "PAN is required!");
            }
            else if(sAadhar.equals("")){
                JOptionPane.showMessageDialog(null, "Aadhar is required!");
            }
            else if(Senior_Citizen.equals("")){
                JOptionPane.showMessageDialog(null, "Are you a senior citizen? Please Mention!");
            }
            else if(Existing_Acc.equals("")){
                JOptionPane.showMessageDialog(null, "Do you have an Existing Account? Please Mention!");
            }
            else{
                Conn c = new Conn();
                String query2 = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducationalQualification+"','"+soccupation+"','"+sPAN+"','"+sAadhar+"','"+Senior_Citizen+"','"+Existing_Acc+"')";
                c.s.executeUpdate(query2);
                
                //When the user will click the next button the it will automatically close the current window and opens the signup page 3---->
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupTwo(""); //pass empty String since there is no default constructor!
    }
}