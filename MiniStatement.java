
package AtmInterface;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class MiniStatement extends JFrame implements ActionListener{
    String pinNumber;
    JLabel bank, mini,card;
    JButton back;
    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        mini = new JLabel();
        add(mini);
        
        bank = new JLabel("INDIAN BANK");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(280,500,90,20);
        back.addActionListener(this);
        add(back);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from login where pinNumber = '"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));  
            }
        }catch(Exception e){
            System.out.println(e);
                
        }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html> ");
            }
            }catch(Exception e){
            System.out.println(e);
            }
        mini.setBounds(20,140,400,200);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()==back){
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
