
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class PinChange extends JFrame implements ActionListener{
    String pinnumber; 
    JPasswordField pin,repin;
    JButton change,back;
    PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("PinChange Page");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font( "System",Font.BOLD,16));
        text.setBounds(250,300,500,35);
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font( "System",Font.BOLD,16));
        pintext.setBounds(165,350,180,25);
        image.add(pintext);
        
        pin =new JPasswordField();
        pin.setFont(new Font( "Raleway",Font.BOLD,16));
        pin.setBounds(330,350,180,25);
        image.add(pin);
        
        JLabel repintext=new JLabel("Re-Enter Your PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font( "System",Font.BOLD,16));
        repintext.setBounds(165,410,180,25);
        image.add(repintext);
        
        repin =new JPasswordField();
        repin.setFont(new Font( "Raleway",Font.BOLD,16));
        repin.setBounds(330,410,180,25);
        image.add(repin);
        
        change=new JButton("CHANGE");
        change.setBounds(165,485,150,30);
        change.setBackground(Color.WHITE);
        image.add(change);
        change.addActionListener(this);
        
        back=new JButton("BACK");
        back.setBounds(355,485,150,30);
        back.setBackground(Color.WHITE);
        image.add(back);
        back.addActionListener(this);
       
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            setVisible(false);
            Transaction t=new Transaction(pinnumber);
            t.setVisible(true);
        }
        else if(e.getSource()==change)
        {
            try
            {
                String npin=pin.getText();
                String rpin=repin.getText();
                 if(!rpin.equals(npin))
                 {
                     JOptionPane.showMessageDialog(null," Entere PIN does not match.");
                     return;
                 }
                 if(npin.equals(""))
                 {
                   JOptionPane.showMessageDialog(null,"Please, Enter the PIN again.");
                     return;  
                 }
                 if(rpin.equals(""))
                 {
                   JOptionPane.showMessageDialog(null,"Please, re-enter New PIN again.");
                     return;  
                 }
                 Con c=new Con();
                 String query1=" Update bank set pin='"+npin+"' where pin='"+pinnumber+"'"; 
                 String query2="Update signupthree set pin='"+npin+"' where pin='"+pinnumber+"'"; 
                 String query3="Update login set pin='"+npin+"' where pin='"+pinnumber+"'"; 
                 
                 c.s.executeUpdate(query1);
                 c.s.executeUpdate(query2);
                 c.s.executeUpdate(query3);
                 JOptionPane.showMessageDialog(null,"PIN changed successfully.");
                 setVisible(false);
                 Transaction t=new Transaction(rpin);
                 t.setVisible(true);
            }
            catch(Exception qe)
            { 
                System.out.println(qe);
            }   
        }     
    }
    public static void main(String args[]) {
         new PinChange("");
    }
}
