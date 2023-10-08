
package AtmInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener{

   
    JRadioButton SYes,SNo,EYes,ENo;
    ButtonGroup seniorgroup,existinggroup;
    JButton next;
    JComboBox religionbox,categorybox,incomebox,educationalbox,occupationbox;
    JLabel AdditionalDetails,religion,category,income,educational,qualification,occupation,panno,aadharno,seniorcit,existingacc;
    JTextField pannof,aadharnof;
    String formno;
    SignupTwo(String formnom){
        formno = formnom;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        AdditionalDetails = new JLabel("Page 2 : Additional  Details ");
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        AdditionalDetails.setBounds(290,80,400,30);
        add(AdditionalDetails);
        
        
        religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,200,30);
        add(religion);
        String[] valrel = {"Hindu","Muslim","Sikh","Christian","Other"};
        religionbox = new JComboBox(valrel);
        religionbox.setBackground(Color.WHITE);
        religionbox.setFont(new Font("Raleway",Font.BOLD,14));
        religionbox.setBounds(300,140,400,30);
        add(religionbox);
        
        
        category = new JLabel("Category");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        add(category);
        String[] categoryval = {"General","OBC","SC","ST","Others"};
        categorybox = new JComboBox(categoryval);
        categorybox.setBackground(Color.WHITE);
        categorybox.setFont(new Font("Raleway",Font.BOLD,14));
        categorybox.setBounds(300,190,400,30);
        add(categorybox);
                                             
        
        income = new JLabel("Income");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);
        String[] incomeval = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        incomebox = new JComboBox(incomeval);
        incomebox.setBackground(Color.WHITE);
        incomebox.setFont(new Font("Raleway",Font.BOLD,14));
        incomebox.setBounds(300,240,400,30);
        add(incomebox);
        
        
         
        educational = new JLabel("Educational");
        educational.setBounds(100,315,200,30);
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        add(educational);
        String[] educationval = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        educationalbox = new JComboBox(educationval);
        educationalbox.setBackground(Color.WHITE);
        educationalbox.setFont(new Font("Raleway",Font.BOLD,14));
        educationalbox.setBounds(300,325,400,30);
        add(educationalbox);
        qualification = new JLabel("Qualification");
        qualification.setBounds(100,340,200,30);
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        add(qualification);
       
        
        
        occupation = new JLabel("Occupation");
        occupation.setBounds(100,390,200,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupation);
        String[] occupationval = {"Salaried","Self-Employed","Businessman","Student","Retired","Others"};
        occupationbox = new JComboBox(occupationval);
        occupationbox.setBackground(Color.WHITE);
        occupationbox.setFont(new Font("Raleway",Font.BOLD,14));
        occupationbox.setBounds(300,390,400,30);
        add(occupationbox);
       
        
        
        panno = new JLabel("Pan Number");
        panno.setBounds(100,440,200,30);
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        add(panno);
        pannof = new JTextField();
        pannof.setFont(new Font("Raleway",Font.BOLD,14));
        pannof.setBounds(300,440,400,30);
        add(pannof);
        
        //city and field
        aadharno = new JLabel("Aadhar Number");
        aadharno.setBounds(100,490,200,30);
        aadharno.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadharno);
        aadharnof = new JTextField();
        aadharnof.setFont(new Font("Raleway",Font.BOLD,14));
        aadharnof.setBounds(300,490,400,30);
        add(aadharnof);
        
        //state and field
        seniorcit = new JLabel("Senior Citizen");
        seniorcit.setBounds(100,540,200,30);
        seniorcit.setFont(new Font("Raleway",Font.BOLD,20));
        add(seniorcit);
        SYes = new JRadioButton("Yes");
        SYes.setBackground(Color.WHITE);
        SYes.setFont(new Font("Raleway",Font.BOLD,14));
        SYes.setBounds(300,540,120,30);
        add(SYes);
        SNo = new JRadioButton("No");
        SNo.setBackground(Color.WHITE);
        SNo.setFont(new Font("Raleway",Font.BOLD,14));
        SNo.setBounds(450,540,120,30);
        add(SNo);
        seniorgroup = new ButtonGroup();
        seniorgroup.add(SYes);
        seniorgroup.add(SNo);
        
        //pincode and field
        existingacc = new JLabel("Existing Account");
        existingacc.setBounds(100,590,180,30);
        existingacc.setFont(new Font("Raleway",Font.BOLD,20));
        add(existingacc);
        EYes = new JRadioButton("Yes");
        EYes.setBackground(Color.WHITE);
        EYes.setFont(new Font("Raleway",Font.BOLD,14));
        EYes.setBounds(300,590,120,30);
        add(EYes);
        ENo = new JRadioButton("No");
        ENo.setBackground(Color.WHITE);
        ENo.setFont(new Font("Raleway",Font.BOLD,14));
        ENo.setBounds(450,590,120,30);
        add(ENo);
        existinggroup = new ButtonGroup();
        existinggroup.add(EYes);
        existinggroup.add(ENo);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String religionv = (String)religionbox.getSelectedItem();
        String categoryv = (String)categorybox.getSelectedItem();
        String incomev = (String)incomebox.getSelectedItem();
        String educationalv = (String)educationalbox.getSelectedItem();
        String occupationv = (String)occupationbox.getSelectedItem();
        String seniorcitv = null;
        if(SYes.isSelected()){
            seniorcitv = "Yes";
        }
        else if(SNo.isSelected()){
            seniorcitv = "No";
        }
        String existingaccv = null;
        if(EYes.isSelected()){
            existingaccv = "Yes";
        }
        else if(ENo.isSelected()){
            existingaccv = "No";
        }
        String pannov = panno.getText();
        String aadharnov = aadharno.getText();
        try {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+religionv+"', '"+categoryv+"', '"+incomev+"', '"+educationalv+"', '"+occupationv+"', '"+seniorcitv+"', '"+existingaccv+"', '"+pannov+"', '"+aadharnov+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new SignupTwo();
    }
}


