
package AtmInterface;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    String pinNumber ;
    JPasswordField pin,reepin;
    JLabel image,text,pintext,repin;
    JButton change,back;
    PinChange(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        text = new JLabel("CHANGE YOUR PIN ");
        text.setBounds(250,280,500,30);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        pintext = new JLabel("NEW PIN : ");
        pintext.setBounds(165,320,180,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(330,320,180,25);
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(pin);
        
        repin = new JLabel("RE-ENTER PIN : ");
        repin.setBounds(165,360,180,25);
        repin.setFont(new Font("System",Font.BOLD,16));
        repin.setForeground(Color.WHITE);
        image.add(repin);
        
        reepin = new JPasswordField();
        reepin.setBounds(330,360,180,25);
        reepin.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(reepin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.setFont(new Font("Raleway",Font.BOLD,16));
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
            try{
                String nPin = pin.getText();
                String rPin = reepin.getText();
                if(!nPin.equals(rPin)){
                    JOptionPane.showMessageDialog(null,"Entered Pin Does'nt Match");
                    return;
                }if(nPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter Pin");
                    return;
                }if(rPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter Pin");
                    return;
                }
                Conn c = new Conn();
                String query1 = "update bank set pinNumber = '"+rPin+"' where pinNumber='"+pinNumber+"'";
                String query2 = "update login set pinNUmber = '"+rPin+"' where pinNumber='"+pinNumber+"'";
                String query3 = "update signupthree set pinNumber = '"+rPin+"' where pinNumber='"+pinNumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"Pin Change Successful");
                setVisible(false);
                new Transaction(rPin).setVisible(true);
            }   
            catch(Exception e){
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
