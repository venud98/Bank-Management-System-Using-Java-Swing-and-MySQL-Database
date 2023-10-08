
package AtmInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton signup,signin,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        //adding icon to the frame 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        //adding the title 
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        //adding cardno label 
        JLabel cardno = new JLabel("Card No: ");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        //adding textfield to enter cardno
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        //adding pin label
        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        //adding textfield for entering pin;
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        //creating three buttons 1.signin , 2.signup , 3.login
        signin = new JButton("SIGN IN");
        signin.setBounds(300,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGNUP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            pinTextField.setText("");
            cardTextField.setText("");
        }
        else if(ae.getSource() == signin){
            Conn c = new Conn();
            String CardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query= "select * from login where cardNumber = '"+CardNumber+"' and pinNumber = '"+pinNumber+"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect CardNumber or PinNumber Entered");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]) {
        new Login();
    }
}
