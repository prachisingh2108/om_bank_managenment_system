
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    int balance=0;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
           
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
       
        Con c=new Con();          
          try
          {
              String query="Select *  from bank where pin='"+pinnumber+"'";
              ResultSet rs=c.s.executeQuery(query);
             
              while(rs.next())
              {
                  if(rs.getString("type").equals("Deposit"))
                  {
                      balance+= Integer.parseInt(rs.getString("amount"));
                  }
                  else
                  {
                      balance-= Integer.parseInt(rs.getString("amount")); 
                  }
              }
          }
          catch(Exception qe)
          { 
                System.out.println(qe);
          }
        JLabel text= new JLabel("Your current Account Balance is Rs."+balance);
        text.setForeground(Color.white);
        text.setBounds(170,344,400,30);
        image.add(text);
          
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent we)
    {
        if(we.getSource()==back)
        {
            setVisible(false);
            Transaction t=new Transaction(pinnumber);
            t.setVisible(true);
        }
        
    }
    public static void main(String args[]) {
       new BalanceEnquiry("");
    }
}
