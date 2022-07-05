package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame  implements ActionListener{
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,
            pincodeTextField,cityTextField,stateTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    
    SignupOne (){
        setLayout(null);
        
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Raleway",Font.BOLD,34));
        formno.setBounds(160, 10, 500, 30);
        add(formno);
        
        JLabel personaDetails = new JLabel("Page 1: Personal Details" );
        personaDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaDetails.setBounds(290, 60, 400, 30);
        add(personaDetails);
        
        //---------------------------------------------------------------------------
        
        
        JLabel name = new JLabel("Name:" );
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 110, 100, 30);
        add(name);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 110, 400, 30);
        add(nameTextField);
        
        
        JLabel fname = new JLabel("Father's Name:" );
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100, 150, 200, 30);
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300, 150, 400, 30);
        add(fnameTextField);
        
        
        JLabel dob = new JLabel("Date of Birth:" );
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);
        dateChooser = new JDateChooser();
        dateChooser .setBounds(300, 190, 400, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser );
        
        
        JLabel gender = new JLabel("Gender:" );
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 230, 100, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 230, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 230, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email = new JLabel("Email Address:" );
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 270, 200, 30);
        add(email);
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 270, 400, 30);
        add(emailTextField);
        
        
        
        JLabel marital = new JLabel("Marital Status:" );
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100, 310, 200, 30);
        add(marital);
        married = new JRadioButton("Married");
        married.setBounds(300, 310, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 310, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        other = new JRadioButton("Other");
        other.setBounds(630, 310, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        
        JLabel address = new JLabel("Address:" );
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100, 350, 100, 30);
        add(address);
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 350, 400, 30);
        add(addressTextField);
        
        
        JLabel city = new JLabel("City:" );
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 390, 100, 30);
        add(city);
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 390, 400, 30);
        add(cityTextField);
        
        
        JLabel state = new JLabel("State:" );
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 430, 100, 30);
        add(state);
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 430, 400, 30);
        add(stateTextField);
        
        
        JLabel pincode = new JLabel("Pin Code:" );
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100, 470, 100, 30);
        add(pincode);
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(300, 470, 400, 30);
        add(pincodeTextField);
        
        
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
      String formno = "" + random;
      String name = nameTextField.getText();
      String fname = fnameTextField.getText();
      String dob =((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
      
      String gender = null;
      if(male.isSelected()){
       gender = "Male";
      }else if(female.isSelected()){
       gender = "Female";
      }
      
      String email =emailTextField.getText();
      String address = addressTextField.getText();
      String pincode = pincodeTextField.getText();
      String city = cityTextField.getText();
      String state = stateTextField.getText();
      
      String marital =  null;
      if(married.isSelected()){
       marital = "Married";
      }else if(unmarried.isSelected()){
       marital = "Unmarried";
      }else if(other.isSelected()){
       marital = "Other";
      }
      
      try{
        if(name.equals("")){
          JOptionPane.showMessageDialog(null, "Name is Required");
        }else{
         Conn c = new Conn();
         String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
         c.s.executeUpdate(query);
         setVisible(false);
         new SignupTwo(formno).setVisible(true);
        }
      }catch(Exception e){
        System.out.println(e);
      }
      
    }
    
    public static void main(String args[]){
     new SignupOne();
    }
}
