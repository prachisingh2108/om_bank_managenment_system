package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{
    JButton withdrawal,back;
    JTextField amount;
    String pinnumber;
    Withdrawal(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("Withdrawal Page");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to withdraw." );
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,200,400,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,250,320,25);
        image.add(amount);
            
        withdrawal=new JButton("Withdrawal");
        withdrawal.setBounds(355,385,150, 30);
        withdrawal.setBackground(Color.WHITE);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
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
        if(e.getSource()==withdrawal)
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
                String query="insert into bank values('"+pinnumber+"','"+d+"','Withdraw','"+amt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+amt+" Withdrawal Successfully");
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
        new Withdrawal("");
    }
}
