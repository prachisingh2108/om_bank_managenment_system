package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField ctf;
    JPasswordField ptf;
    Login()
    {
        setTitle("Automated Teller Machine");
        setLayout(null);// general meaning postion
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//ImageIcon is a class for Image, we are creating the object
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);//To set the label
        add(label);
        
        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No.");
        cardno.setFont(new Font("Ralewat",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        ctf=new JTextField();
        ctf.setBounds(300,150,230,30);
        ctf.setFont(new Font("Arial",Font.BOLD,14));
        add(ctf);
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        ptf=new JPasswordField();
        ptf.setBounds(300,220,230,30);
        ptf.setFont(new Font("Arial",Font.BOLD,14));
        add(ptf);
        
        login =new JButton("LOGIN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear =new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup =new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.white);
        setSize(800,450);//setSize is function used to create a frame size basically 
        setVisible(true); 
        setLocation(350,200);
    }
    @Override
    public void  actionPerformed(ActionEvent e)
    {
        if(e.getSource()== clear)
        {
            ctf.setText("");
            ptf.setText("");
        }
        else if(e.getSource()== login)
        {
            Con c=new Con();
            String cardno=ctf.getText();
            String pinnumber=ptf.getText();
            String query="select * from login where '"+cardno+"'=cardnumber AND '"+pinnumber+"'= pin";
            try
            {
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    Transaction t=new Transaction(pinnumber);
                    t.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect PIN or CardNumber");
                }
            }
            catch(Exception em)
            {
                System.out.println(em);
            }
        }
        else if(e.getSource()== signup)
        {
            setVisible(false);
            SignupOne sign= new SignupOne();
            sign.setVisible(true);
        }
        
    }

    public static void main(String args[]) {
        new Login();//Anonymus Object of Login
        
    }
}
