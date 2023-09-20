
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton hundered,f_hundered,thousand,two_thousand,five_thousand,ten_thousand,exit;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("FastCash Page");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Select Withdrawal Amount");
        text.setBounds(200,300 , 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);//Through this Label is above the Image
         
        hundered= new JButton("Rs. 100");
        hundered.setBounds(170,415,150,30);
        hundered.addActionListener(this);
        image.add(hundered);
        
        f_hundered= new JButton("Rs. 500");
        f_hundered.setBounds(355,415 ,150, 30);
        f_hundered.addActionListener(this);
        image.add(f_hundered);
        
        thousand= new JButton("Rs. 1000");
        thousand.setBounds(170,450 ,150, 30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        two_thousand= new JButton("Rs. 2000");
        two_thousand.setBounds(355,450 ,150, 30);
        two_thousand.addActionListener(this);
        image.add(two_thousand);
        
        five_thousand= new JButton("Rs. 5000");
        five_thousand.setBounds(170,485,150, 30);
        five_thousand.addActionListener(this);
        image.add(five_thousand);
        
        ten_thousand= new JButton("Rs. 10000");
        ten_thousand.setBounds(355,485,150, 30);
        ten_thousand.addActionListener(this);
        image.add(ten_thousand);
        
        exit = new JButton("Back");
        exit.setBounds(355,520,150, 30);
        exit.addActionListener(this);
        image.add(exit);
         
        setSize(900,900);
        setLocation(300,0);
       //setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==exit)
      {
          setVisible(false);
          new Transaction(pinnumber).setVisible(true);
      }
      else
      {
          String amount="";//((JButton)ae.getSource()).getText().substring(3);//It returns object.
          if(ae.getSource()==hundered)
          {
              amount="100";
              System.out.println(amount);
          }
          else if(ae.getSource()==f_hundered)
          {
              amount="500";
              System.out.println(amount);
          }
          else if(ae.getSource()==thousand)
          {
              amount="1000";
              System.out.println(amount);
          }
          else if(ae.getSource()==two_thousand)
          {
              amount="2000";
              System.out.println(amount);
          }
          else if(ae.getSource()==five_thousand)
          {
              amount="5000";
              System.out.println(amount);
          }
          else if(ae.getSource()==ten_thousand)
          {
              amount="10000";
              System.out.println(amount);
          }
          
          Con c=new Con();          
          try
          {
              String query="Select *  from bank where pin='"+pinnumber+"'";
              ResultSet rs=c.s.executeQuery(query);
              int balance=0;
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
              if(ae.getSource()!=exit &&  balance<Integer.parseInt(amount) )
              {
                  JOptionPane.showMessageDialog(null,"Insufficient Balance");
                  return;
              }
              Date d=new Date();
              String query1= "Insert into bank values('"+pinnumber+"','"+d+"','Withdrawal','"+amount+"')";
              c.s.executeUpdate(query1);
              JOptionPane.showMessageDialog(null,"Rs. "+amount+"Debited Successfully");
              setVisible(false);
              Transaction t=new Transaction(pinnumber);
              t.setVisible(true);
          }
          catch(Exception e)
          {
              System.out.println(e);
          }   
              
      }
      
   }
    public static void main(String args[]) {
      new FastCash("");   
    }
}
