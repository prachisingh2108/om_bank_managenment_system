package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pantf,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno; 
    JComboBox religion,category,income_category,educat,occupation;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setTitle(" Signup Two Page");
        setLayout(null);//By default Border Layout
       
        setTitle("NEW APPLCATION PAGE-2");
        
        JLabel additionaldetails= new JLabel("Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel name= new JLabel("Religion");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Chirstian","Other"};
        religion =new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
      
        JLabel fname= new JLabel("Category");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[]={"General","SC","ST","OBC"};
        category=new JComboBox(valCategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300,190,400,30);
        add(category);
        
        JLabel dob= new JLabel("Income");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String val_income[]={"NULL","<1,50,000","<2,50,000","5,00,000","Upto 10 Lakh"};
        income_category=new JComboBox(val_income);
        income_category.setBackground(Color.WHITE);
        income_category.setBounds(300,240,400,30);
        add(income_category);
            
        JLabel gender= new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email= new JLabel("Qualification");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String edu_qua[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        educat=new JComboBox(edu_qua);
        educat.setBackground(Color.WHITE);
        educat.setBounds(300,315,400,30);
        add(educat);
        
        
        JLabel martail= new JLabel("Occupation");
        martail.setFont(new Font("Raleway",Font.BOLD,20));
        martail.setBounds(100,390,200,30);
        add(martail);
        
        String occupationValues[]={"Salaried","Self-Employeed","Business","Student","Retired","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,390,400,30);
        add(occupation);
        
        JLabel address= new JLabel("PAN Number");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pantf =new JTextField();
        pantf.setFont(new Font("Raleway", Font.BOLD,20));
        pantf.setBounds(300,440,400,30);
        add(pantf);
        
        JLabel city= new JLabel("Aadhar Number");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar =new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD,20));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
        JLabel state= new JLabel("Senior Citizen");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes= new JRadioButton("yes");
        syes.setBounds(300,540,60,30);
        syes.setBackground(Color.WHITE);
        
        sno= new JRadioButton("no");
        sno.setBounds(450,540,80,30);
        sno.setBackground(Color.WHITE);
        
        ButtonGroup gg= new ButtonGroup();
        gg.add(syes);
        gg.add(sno);
        
        add(syes);
        add(sno);
        
        JLabel pincode= new JLabel("Existing Account");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes= new JRadioButton("yes");
        eyes.setBounds(300,590,60,30);
        eyes.setBackground(Color.WHITE);
        
        eno= new JRadioButton("no");
        eno.setBounds(450,590,80,30);
        eno.setBackground(Color.WHITE);
        
        ButtonGroup eg= new ButtonGroup();
        eg.add(eyes);
        eg.add(eno);
        
        add(eyes);
        add(eno);
        
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
        String s_religion=(String)religion.getSelectedItem();
        
        String s_category=(String)category.getSelectedItem();
        String income=(String)income_category.getSelectedItem();
        String education=(String)educat.getSelectedItem();
        String s_occupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected())
        {
            seniorcitizen="Yes";
        }
        else if(sno.isSelected())
        {
            seniorcitizen="No";
        }
        String existingaccount=null;
        if(eyes.isSelected())
        {
            existingaccount="Yes";
        }
        else if(eno.isSelected())
        {
            existingaccount="No";
        }
        String s_aadhar=aadhar.getText();
        String s_pan=pantf.getText();
       
        try
        {
            Con c=new Con();
                String query="insert into signuptwo values('"+formno+"','"+s_religion+"','"+s_category+"','"+income+"','"+education+"','"+s_occupation+"','"+s_pan+"','"+s_aadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                SignupThree three=new SignupThree(formno);
                three.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }      
            
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
