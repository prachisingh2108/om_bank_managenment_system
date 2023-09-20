package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposite extends JFrame implements ActionListener{
    JButton deposit,back;
    JTextField amount;
    String pinnumber;
    Deposite(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("Deposite Page");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to deposite." );
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,200,400,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,250,320,25);
        image.add(amount);
            
        deposit=new JButton("Deposit");
        deposit.setBounds(355,385,150, 30);
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(355,420,150, 30);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==deposit)
        {
            String amt=amount.getText();
            Date d=new Date();
            if(amt.equals(""))
            {
                 JOptionPane.showMessageDialog(null, "Enter the amount you wnat to deposit.");
            }
            else
            {
                try
                {
                Con c=new Con();
                String query="insert into bank values('"+pinnumber+"','"+d+"','Deposit','"+amt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+amt+" Deposited Successfully");
                setVisible(false);
                Transaction t=new Transaction(pinnumber);
                t.setVisible(true);
                }
                catch( Exception ae)    
                {
                       System.out.println(ae);
                }
            }
            
        }
        else if(e.getSource()==back)
        {
         
            setVisible(false);
            Transaction t=new Transaction(pinnumber);
            t.setVisible(true);
        }    
            
    }
    public static void main(String args[]) {
        new Deposite("");
    }
}
