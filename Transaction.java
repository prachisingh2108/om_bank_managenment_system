
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdrawal,ministatement,pinchange,fastcash,balance,exit,back;
    String pinnumber;
    Transaction(String pinnumber)
    {
       
        this.pinnumber=pinnumber;
        setTitle("Transaction Page");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text=new JLabel("Please Select Your Transaction");
        text.setBounds(200,300 , 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);//Through this Label is above the Image
         
        deposit= new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal= new JButton("Cash Withdrawal");
        withdrawal.setBounds(355,415 ,150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(170,450 ,150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement= new JButton("Mini Statement");
        ministatement.setBounds(355,450 ,150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange= new JButton("PIN Change");
        pinchange.setBounds(170,485,150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance= new JButton("Balance Enquiry");
        balance.setBounds(355,485,150, 30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("EXIT");
        exit.setBounds(355,520,150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        back = new JButton("BACK");
        back.setBounds(170,520,150, 30);
        back.addActionListener(this);
        image.add(back);
         
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==exit)
      {
          System.exit(0);
      }
      else if(ae.getSource()==deposit)
      {
          setVisible(false);
          Deposite d=new Deposite(pinnumber);
          d.setVisible(true);
      }
      else if(ae.getSource()==withdrawal)
      {
          setVisible(false);
          Withdrawal w=new Withdrawal(pinnumber);
          w.setVisible(true);
      }
      else if(ae.getSource()==fastcash)
      {
          setVisible(false);
          FastCash f=new FastCash(pinnumber);
          f.setVisible(true);
      }
      else if(ae.getSource()==pinchange)
      {
          setVisible(false);
          PinChange p=new PinChange(pinnumber);
          p.setVisible(true);
      }
      else if(ae.getSource()==balance)
      {
          setVisible(false);
          BalanceEnquiry b=new BalanceEnquiry(pinnumber);
          b.setVisible(true);
      }
      else if(ae.getSource()==ministatement)
      {
          MiniStatement m=new MiniStatement(pinnumber);
          m.setVisible(true);
      }
      else if(ae.getSource()==back)
      { 
          setVisible(false);
          Login l=new Login();
          l.setVisible(true);
      }
   }
    public static void main(String args[]) {
      new Transaction("");   
    }
}
