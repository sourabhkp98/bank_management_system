
package bank.management.system;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;



public class SignupTwo extends JFrame  implements ActionListener{
    
    String formno;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,education,occupation;
    SignupTwo (String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
       
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details" );
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290, 60, 400, 30);
        add(additionalDetails);
        
        //---------------------------------------------------------------------------
        
        
        JLabel name = new JLabel("Religion:" );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 110, 100, 30);
        add(name);
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 110, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        
        
        JLabel fname = new JLabel("Category:" );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 150, 200, 30);
        add(fname);
        String valCategory[] = {"General","SC","ST","OBC","Other"};
        category = new JComboBox (valCategory);
        category.setBounds(300, 150, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel dob = new JLabel("Income:" );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);
         String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income = new JComboBox (valIncome);
        income.setBackground(Color.WHITE);
        income .setBounds(300, 190, 400, 30);
        add(income);
        
        
        JLabel gender = new JLabel("Educational:" );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 230, 200, 30);
        add(gender);
        JLabel email = new JLabel("Qualification:" );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 260, 200, 30);
        add(email);
        String educationValues[] = {"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
        education = new JComboBox (educationValues);
        education.setBackground(Color.WHITE);
        education.setBounds(300, 250, 400, 30);
        add(education);
        
        
        
        JLabel marital = new JLabel("Occupation:" );
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 310, 200, 30);
        add(marital);
        String occupationalValues[] = {"Saleried","Self-Employed","Bussiness","Student","retired","Other"};
        occupation = new JComboBox (occupationalValues);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 310, 400, 30);
        add(occupation);
       
        
        JLabel address = new JLabel("PAN Number:" );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 350, 200, 30);
        add(address);
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300, 350, 400, 30);
        add(pan);
        
        
        JLabel city = new JLabel("Aadhar number:" );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 390, 200, 30);
        add(city);
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300, 390, 400, 30);
        add(aadhar);
        
        
        JLabel state = new JLabel("Senior Citizen:" );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 430, 200, 30);
        add(state);
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 430, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(500, 430, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
       
        
        
        JLabel pincode = new JLabel("Exisiting Account:" );
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 470, 200, 30);
        add(pincode);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 470, 200, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(500, 470, 200, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);

        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK); 
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 560, 80, 30);
        next.addActionListener(this);
        add(next);
        

       //for apk size
       getContentPane().setBackground(Color.WHITE); 
       setSize(850,750);
       setVisible(true);
       setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae){
      
      String sreligion = (String) religion.getSelectedItem();
      String scategory = (String) category.getSelectedItem();
      String sincome = (String) income.getSelectedItem();
      String seducation = (String) education.getSelectedItem();
      String soccupation = (String) occupation.getSelectedItem();
      
      String seniorcitizen = null;
      if(syes.isSelected()){
       seniorcitizen = "Yes";
      }else if(sno.isSelected()){
       seniorcitizen = "No";
      }
      
      
      String span = pan.getText();
      String  saadhar = aadhar.getText();
     
      
      String exisitingaccount =  null;
      if(eyes.isSelected()){
       exisitingaccount = "Yes";
      }else if(eno.isSelected()){
       exisitingaccount = "No";
      }
      
      try{
         Conn c = new Conn();
         String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+exisitingaccount+"')";
         c.s.executeUpdate(query);
         setVisible(false);
         new SignupThree(formno).setVisible(true);
      }catch(Exception e){
        System.out.println(e);
      }
      
    }
    
    public static void main(String args[]){
     new SignupTwo("");
    }
}

