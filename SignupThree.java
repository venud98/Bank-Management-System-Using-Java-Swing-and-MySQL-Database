
package AtmInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;




public class SignupThree extends JFrame implements ActionListener{
    JLabel details,type,cardno,cnumber,carddetails,pinno,pnumber,pindetails,servicesreq;
    JRadioButton savingacc ,fixeddepo, currentacc,recordepoacc;
    ButtonGroup accTypeGroup;
    JButton submit,cancel;
    JCheckBox agree,emailsmsalert,internetbanking,mobilebanking,atmcard,chequebook,estatement;
    String formno;
    SignupThree(String formno){
        this.formno =formno;
        setLayout(null);
        
        details = new JLabel("Page -3 : Account Details ");
        details.setFont(new Font("Raleway",Font.BOLD,20));
        details.setBounds(280,40,400,40);
        add(details);
        
        type = new JLabel("Account Type ");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100,140,200,30);
        add(type);
        savingacc= new JRadioButton("Savings Account");
        savingacc.setFont(new Font("Raleway",Font.BOLD,16));
        savingacc.setBackground(Color.WHITE);
        savingacc.setBounds(100,180,200,20);
        add(savingacc);
        fixeddepo= new JRadioButton("Fixed Deposit Account");
        fixeddepo.setFont(new Font("Raleway",Font.BOLD,16));
        fixeddepo.setBackground(Color.WHITE);
        fixeddepo.setBounds(350,180,200,20);
        add(fixeddepo);
        currentacc= new JRadioButton("Current Account");
        currentacc.setFont(new Font("Raleway",Font.BOLD,16));
        currentacc.setBackground(Color.WHITE);
        currentacc.setBounds(100,220,200,20);
        add(currentacc);
        recordepoacc = new JRadioButton("Recurring Deposit Account");
        recordepoacc.setFont(new Font("Raleway",Font.BOLD,16));
        recordepoacc.setBackground(Color.WHITE);
        recordepoacc.setBounds(350,220,300,20);
        add(recordepoacc);
        accTypeGroup = new ButtonGroup();
        accTypeGroup.add(savingacc);
        accTypeGroup.add(currentacc);
        accTypeGroup.add(fixeddepo);
        accTypeGroup.add(recordepoacc);
        
        cardno = new JLabel("Card Number");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(100,300,200,30);
        add(cardno);
        carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(100,330,300,20);
        add(carddetails);
        cnumber = new JLabel("XXXX-XXXX-XXXX-1234");
        cnumber.setFont(new Font("Raleway",Font.BOLD,20));
        cnumber.setBounds(330,300,300,30);
        add(cnumber);
        
        pinno = new JLabel("Pin Number");
        pinno.setFont(new Font("Raleway",Font.BOLD,20));
        pinno.setBounds(100,370,200,30);
        add(pinno);
        pindetails = new JLabel("Your 4 Digit Pin Number");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,400,300,20);
        add(pindetails);
        pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pnumber.setBounds(330,370,300,30);
        add(pnumber);
        
        servicesreq = new JLabel("Services Required : ");
        servicesreq.setFont(new Font("Raleway",Font.BOLD,20));
        servicesreq.setBounds(100,450,200,30);
        add(servicesreq);
        
        atmcard = new JCheckBox("ATM Card");
        atmcard.setBackground(Color.WHITE);
        atmcard.setBounds(100,500,200,30);
        atmcard.setFont(new Font("Raleway",Font.BOLD,16));
        add(atmcard);
        internetbanking = new JCheckBox("Internet Banking ");
        internetbanking.setBackground(Color.WHITE);
        internetbanking.setBounds(350,500,200,30);
        internetbanking.setFont(new Font("Raleway",Font.BOLD,16));
        add(internetbanking);
        mobilebanking = new JCheckBox("Mobile Banking");
        mobilebanking.setBackground(Color.WHITE);
        mobilebanking.setBounds(100,550,200,30);
        mobilebanking.setFont(new Font("Raleway",Font.BOLD,16));
        add(mobilebanking);
        emailsmsalert = new JCheckBox("Email and SMS Alert");
        emailsmsalert.setBackground(Color.WHITE);
        emailsmsalert.setBounds(350,550,200,30);
        emailsmsalert.setFont(new Font("Raleway",Font.BOLD,16));
        add(emailsmsalert);
        chequebook = new JCheckBox("Cheque Book ");
        chequebook.setBackground(Color.WHITE);
        chequebook.setBounds(100,600,200,30);
        chequebook.setFont(new Font("Raleway",Font.BOLD,16));
        add(chequebook);
        estatement = new JCheckBox("E-Statement ");
        estatement.setBackground(Color.WHITE);
        estatement.setBounds(350,600,200,30);
        estatement.setFont(new Font("Raleway",Font.BOLD,16));
        add(estatement);
        agree = new JCheckBox("I hereby declare that the above details entered are correct to the best of my Knowledge. ");
        agree.setBackground(Color.WHITE);
        agree.setBounds(100,650,600,30);
        agree.setFont(new Font("Raleway",Font.BOLD,12));
        add(agree);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,720,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(savingacc.isSelected()){
                accountType = "Savings Account";
            }
            else if(fixeddepo.isShowing()){
                accountType = "FD Account" ;
            }
            else if(currentacc.isSelected()){
                accountType = "Current Account";
            }
            else if(recordepoacc.isSelected()){
                accountType = "Reccur Account";  
            }
            
            Random random = new Random();
            String cardNumber = ""+ Math.abs((random.nextLong() %90000000L) + 504093600000000L) ;
            String pinNumber = ""+Math.abs((random.nextLong() & 9000L) + 1000L);
            
           
            String facility = "";
            if(internetbanking.isSelected()){
                facility+=" Internet Banking";
            }else if(mobilebanking.isSelected()){
                facility+=" Mobile Banking";
            }else if(atmcard.isSelected()){
                facility+=" ATM Card";
            }else if(emailsmsalert.isSelected()){
                facility+=" Email And SMS Alert";
            }else if(chequebook.isSelected()){
                facility+=" Cheque Book";
            }else if(estatement.isSelected()){
                facility+=" E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else{
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')"; 
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card Number :"+cardNumber + " \n Pin Number : " + pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                } 
            }catch(Exception e){
                System.out.println(e);
            }
           
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true); 
        }
    }
    public static void main(String args[]) {
        new SignupThree("");
    }
}
