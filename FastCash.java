
package AtmInterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash  extends JFrame implements ActionListener {
    String pinNumber;
    JLabel image ,text;
    JButton onehun,fivehun,oneth,twoth,fiveth,tenth,back;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setForeground(Color.WHITE);
        text.setBounds(215,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        //1.
        onehun = new JButton("RS 100");
        onehun.setBounds(160,415,170,30);
        onehun.setFont(new Font("System",Font.BOLD,16));
        onehun.addActionListener(this);
        image.add(onehun);
        //2.
        fivehun = new JButton("RS 500");
        fivehun.setBounds(345,415,170,30);
        fivehun.setFont(new Font("System",Font.BOLD,16));
        fivehun.addActionListener(this);
        image.add(fivehun);
        //3.
        oneth = new JButton("RS 1000");
        oneth.setBounds(160,450,170,30);
        oneth.setFont(new Font("System",Font.BOLD,16));
        oneth.addActionListener(this);
        image.add(oneth);
        //4.
        twoth = new JButton("RS 2000");
        twoth.setBounds(345,450,170,30);
        twoth.setFont(new Font("System",Font.BOLD,16));
        twoth.addActionListener(this);
        image.add(twoth);
        
       //5.
        fiveth = new JButton("RS 5000");
        fiveth.setBounds(160,485,170,30);
        fiveth.setFont(new Font("System",Font.BOLD,16));
        fiveth.addActionListener(this);
        image.add(fiveth);
        //6.
        tenth = new JButton("RS 10000");
        tenth.setBounds(345,485,170,30);
        tenth.setFont(new Font("System",Font.BOLD,16));
        tenth.addActionListener(this);
        image.add(tenth);
       //7.
        back = new JButton("Back");
        back.setBounds(345,520,170,30);
        back.setFont(new Font("System",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);
        
        
        
       
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pinNumber = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance in your account");
                    return ;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+ " Successfully withdrawed");
                
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]) {
        new FastCash("");
    }
}

