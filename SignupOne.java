package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nametf,ftf,emailtf,addresstf,citytf,statetf,pincodetf;
    JButton next;
    JRadioButton female,male,other,married,unmarried;
    JDateChooser dateChooser;
   
    SignupOne()
    {
        setLayout(null);//By default Border Layout
        setTitle("Signup One Page");
        Random r= new Random();
        random=Math.abs(r.nextLong()%9000L)+1000L;
        
        JLabel formno= new JLabel("APPLCATION FORM NO : "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personaldetails= new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);
        
        JLabel name= new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
         nametf =new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD,20));
        nametf.setBounds(300,140,400,30);
        add(nametf);
        
        JLabel fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
         ftf =new JTextField();
        ftf.setFont(new Font("Raleway", Font.BOLD,20));
        ftf.setBounds(300,190,400,30);
        add(ftf);
        
        JLabel dob= new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
         
        dateChooser= new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        
        JLabel gender= new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        
        female= new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.WHITE);
        
        ButtonGroup gg= new ButtonGroup();
        gg.add(male);
        gg.add(female);
        
        add(male);
        add(female);
        
        JLabel email= new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailtf =new JTextField();
        emailtf.setFont(new Font("Raleway", Font.BOLD,20));
        emailtf.setBounds(300,340,400,30);
        add(emailtf);
        
        JLabel martail= new JLabel("Martial Status:");
        martail.setFont(new Font("Raleway",Font.BOLD,20));
        martail.setBounds(100,390,200,30);
        add(martail);
        
        married= new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        
        unmarried= new JRadioButton("Unmarrried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        
        other= new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        
        ButtonGroup martialg= new ButtonGroup();
        martialg.add(married);
        martialg.add(unmarried);
        martialg.add(other);

        
        add(married);
        add(unmarried);
        add(other);
        
        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addresstf =new JTextField();
        addresstf.setFont(new Font("Raleway", Font.BOLD,20));
        addresstf.setBounds(300,440,400,30);
        add(addresstf);
        
        JLabel city= new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        citytf =new JTextField();
        citytf.setFont(new Font("Raleway", Font.BOLD,20));
        citytf.setBounds(300,490,400,30);
        add(citytf);
        
        
        JLabel state= new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
         statetf= new JTextField();
        statetf.setFont(new Font("Raleway",Font.BOLD,20));
        statetf.setBounds(300,540,400,30);
        add(statetf);
        
        JLabel pincode= new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pincodetf= new JTextField();
        pincodetf.setFont(new Font("Raleway",Font.BOLD,18));
        pincodetf.setBounds(300,590,400,25);
        add(pincodetf);
        
        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(720, 610, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        setSize(900,750);
        setLocation(350,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        String formno=""+random;
        String name=nametf.getText();
        String fname=ftf.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else if(female.isSelected())
        {
            gender="Female";
        }
        String email=emailtf.getText();
        String maritial=null;
        if(married.isSelected())
        {
            maritial="Married";
        }
        else if(unmarried.isSelected())
        {
            maritial="Unmarried";
        }
        else if(other.isSelected())
        {
            maritial="Other";
        }
        String address=addresstf.getText();
        String city=citytf.getText();
        String state=statetf.getText();
        String pincode=pincodetf.getText();
        
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else
            {
                Con c=new Con();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                SignupTwo sign2=new SignupTwo(formno);
                sign2.setVisible(true);
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }      
            
    public static void main(String args[]) {
        new SignupOne();
    }
}
