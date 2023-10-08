
package AtmInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction  extends JFrame implements ActionListener {
    String pinNumber;
    JLabel image ,text;
    JButton deposit,Withdrawl,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    Transaction(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        text = new JLabel("Please select any transaction");
        text.setForeground(Color.WHITE);
        text.setBounds(215,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        //1.
        deposit = new JButton("Deposit");
        deposit.setBounds(160,415,170,30);
        deposit.setFont(new Font("System",Font.BOLD,16));
        deposit.addActionListener(this);
        image.add(deposit);
        //2.
        Withdrawl = new JButton("Cash Withdrawl");
        Withdrawl.setBounds(345,415,170,30);
        Withdrawl.setFont(new Font("System",Font.BOLD,16));
        Withdrawl.addActionListener(this);
        image.add(Withdrawl);
        //3.
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(160,450,170,30);
        fastCash.setFont(new Font("System",Font.BOLD,16));
        fastCash.addActionListener(this);
        image.add(fastCash);
        //4.
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(345,450,170,30);
        miniStatement.setFont(new Font("System",Font.BOLD,16));
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
       //5.
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(160,485,170,30);
        pinChange.setFont(new Font("System",Font.BOLD,16));
        pinChange.addActionListener(this);
        image.add(pinChange);
        //6.
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(345,485,170,30);
        balanceEnquiry.setFont(new Font("System",Font.BOLD,16));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
       //7.
        exit = new JButton("Exit");
        exit.setBounds(345,520,170,30);
        exit.setFont(new Font("System",Font.BOLD,16));
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setTitle("New Frame");
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource()== Withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true); 
        }
        else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true); 
        }
        else if(ae.getSource()== miniStatement){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true); 
        }
        else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true); 
        }
        else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true); 
        }
        
    }
    public static void main(String args[]) {
        new Transaction("");
       }
}
