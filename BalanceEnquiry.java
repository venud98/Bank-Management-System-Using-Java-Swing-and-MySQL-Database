
package AtmInterface;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinNumber ;
    JButton back;
    JLabel image,text;
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        back = new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBounds(355,520,150,30);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("Select * from bank where pinNumber = '"+pinNumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }              
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        text = new JLabel("Your Current Account Balance is : "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
        
         
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinNumber).setVisible(true);
        
    }
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
