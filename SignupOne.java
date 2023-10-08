
package AtmInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    Long num;
    JDateChooser datechooser;
    ButtonGroup genderGroup ,maritalStatus;
    JRadioButton  male ,female,others,maried,unmaried,other;
    JButton next;
    JLabel formno,personalDetails,name,fatherName,Dob,gender,email,marital,address,city,state,pincode;
    JTextField namef,fathernamef,addressf,emailf,pincodef,cityf,statef;
    SignupOne(){
        setLayout(null);
        
        Random ran = new Random();
        num = Math.abs(ran.nextLong() % 900L + 10000L);
        
        //form number
        formno = new JLabel("APPLICATION FORM No : " +  num );
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        
        personalDetails = new JLabel("Page 1 : Personal Details ");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        //name and TextField
        name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        namef = new JTextField();
        namef.setFont(new Font("Raleway",Font.BOLD,14));
        namef.setBounds(300,140,400,30);
        add(namef);
        
        //fathers name and field
        fatherName = new JLabel("Father's Name");
        fatherName.setBounds(100,190,200,30);
        fatherName.setFont(new Font("Raleway",Font.BOLD,20));
        add(fatherName);
        fathernamef = new JTextField();
        fathernamef.setFont(new Font("Raleway",Font.BOLD,14));
        fathernamef.setBounds(300,190,400,30);
        add(fathernamef);
                                             
        //dob and dobfield
        Dob = new JLabel("Date of Birth");
        Dob.setBounds(100,240,200,30);
        Dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(Dob);
        datechooser = new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(Color.BLACK);
        add(datechooser);
        
        
        //gender 
        gender = new JLabel("Gender");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        others = new JRadioButton("Others");
        others.setBounds(630,290,100,30);
        others.setBackground(Color.WHITE);
        add(others);
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);
        
        
        
        
        //email and field
        email = new JLabel("Email Address");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        add(email);
        emailf = new JTextField();
        emailf.setFont(new Font("Raleway",Font.BOLD,14));
        emailf.setBounds(300,340,400,30);
        add(emailf);
        
        //marital and field
        marital = new JLabel("Marital Status");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        add(marital);
        maried = new JRadioButton("maried");
        maried.setBounds(300,390,100,30);
        maried.setBackground(Color.WHITE);
        add(maried);
        unmaried = new JRadioButton("unmaried");
        unmaried.setBounds(450,390,100,30);
        unmaried.setBackground(Color.WHITE);
        add(unmaried);
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        maritalStatus = new ButtonGroup();
        maritalStatus.add(maried);
        maritalStatus.add(unmaried);
        maritalStatus.add(other);
        
        
        
        //address and field
        address = new JLabel("Address");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);
        addressf = new JTextField();
        addressf.setFont(new Font("Raleway",Font.BOLD,14));
        addressf.setBounds(300,440,400,30);
        add(addressf);
        
        //city and field
        city = new JLabel("City");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);
        cityf = new JTextField();
        cityf.setFont(new Font("Raleway",Font.BOLD,14));
        cityf.setBounds(300,490,400,30);
        add(cityf);
        
        //state and field
        state = new JLabel("State");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);
        statef = new JTextField();
        statef.setFont(new Font("Raleway",Font.BOLD,14));
        statef.setBounds(300,540,400,30);
        add(statef);
        
        //pincode and field
        pincode = new JLabel("Pin Code");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);
        pincodef = new JTextField();
        pincodef.setFont(new Font("Raleway",Font.BOLD,14));
        pincodef.setBounds(300,590,400,30);
        add(pincodef);
        
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
        String formnumber = "" + num ;
        String nameUser = namef.getText();
        String fname = fathernamef.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String Gender = null;
        if(male.isSelected()){
            Gender = "Male";
        }
        else if(female.isSelected()){
            Gender = " Female";
        }
        else {
            Gender = " Others";
        }
        String emailid = emailf.getText();
        String maritalStat = null;
        if(maried.isSelected()){
            maritalStat = "Married";
        }
        else if(unmaried.isSelected()){
            maritalStat = "UnMarried";
        }
        else {
            maritalStat = "Other";
        }
        String addres = addressf.getText();
        String cityy = cityf.getText();
        String states = statef.getText();
        String pinc = pincodef.getText();
        
        try {
            if(nameUser.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"FName is Required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB is Required");
            }else if(emailid.equals("")){
                JOptionPane.showMessageDialog(null,"EmailID is Required");
            }else if(addres.equals("")){
                JOptionPane.showMessageDialog(null,"Address is Required");
            }else if(cityy.equals("")){
                JOptionPane.showMessageDialog(null,"City is Required");
            }else if(states.equals("")){
                JOptionPane.showMessageDialog(null,"State is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formnumber+"', '"+nameUser+"', '"+dob+"', '"+fname+"', '"+Gender+"', '"+emailid+"', '"+maritalStat+"', '"+addres+"', '"+cityy+"', '"+states+"', '"+pinc+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formnumber).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]) {
        new SignupOne();
    }
}

