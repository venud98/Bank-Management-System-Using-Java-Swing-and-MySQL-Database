
package AtmInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    String pinNumber;
    JLabel image ,text;
    JTextField amount;
    JButton withdrawl,back;
    Withdrawl(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        text = new JLabel("Enter amount you want to Withdrawl");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(190,300,400,35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(190,350,200,25);
        image.add(amount);
        
        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
                
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else if(ae.getSource()== withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else {
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"','Withdrawl', '"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawled Successfully ");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            
            
            
        }
        
    }
     public static void main(String args[]) {
         new Withdrawl("");
      }
}
        
}

