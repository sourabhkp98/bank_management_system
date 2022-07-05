
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno= formno;
        
       setLayout(null);
        
       JLabel l1 = new JLabel("Page 3: Account Details");
       l1.setFont(new Font("Raleway",Font.BOLD,22));
       l1.setBounds(220, 40, 400, 40);
       add(l1);
       
       JLabel type = new JLabel("Account Type:");
       type.setFont(new Font("Raleway",Font.BOLD,20));
       type.setBounds(100, 100, 200, 30);
       add(type);
       r1 = new JRadioButton("Saving Account");
       r1.setFont(new Font("Raleway",Font.BOLD,14));
       r1.setBackground(Color.WHITE); 
       r1.setBounds(100, 140,250, 20);
       add(r1);
       r2 = new JRadioButton("fixed Deposit Account");
       r2.setFont(new Font("Raleway",Font.BOLD,14));
       r2.setBackground(Color.WHITE); 
       r2.setBounds(400, 140,250, 20);
       add(r2);
       r3 = new JRadioButton("Current Account");
       r3.setFont(new Font("Raleway",Font.BOLD,14));
       r3.setBackground(Color.WHITE); 
       r3.setBounds(100, 180,250, 20);
       add(r3);
       r4 = new JRadioButton("Recurring Deposit Account");
       r4.setFont(new Font("Raleway",Font.BOLD,14));
       r4.setBackground(Color.WHITE); 
       r4.setBounds(400, 180,250, 20);
       add(r4);
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        
        
       JLabel card = new JLabel("Card Number:");
       card.setFont(new Font("Raleway",Font.BOLD,20));
       card.setBounds(100, 220, 400, 30);
       add(card);
       JLabel number = new JLabel("XXXX-XXXX-XXXX-4142");
       number.setFont(new Font("Raleway",Font.BOLD,18));
       number.setBounds(400, 220, 400, 40);
       add(number);
       JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
       cardDetail.setFont(new Font("Raleway",Font.BOLD,12));
       cardDetail.setBounds(100, 250, 400, 20);
       add(cardDetail);
       
       
       JLabel pin = new JLabel("PIN:");
       pin.setFont(new Font("Raleway",Font.BOLD,20));
       pin.setBounds(100, 290, 400, 30);
       add(pin);
       JLabel pnumber = new JLabel("XXXX");
       pnumber.setFont(new Font("Raleway",Font.BOLD,18));
       pnumber.setBounds(400, 290, 400, 30);
       add(pnumber);
       JLabel pinDetail = new JLabel("Your 4 Digit Password");
       pinDetail.setFont(new Font("Raleway",Font.BOLD,12));
       pinDetail.setBounds(100, 320, 400, 20);
       add(pinDetail);
       
       
       JLabel services = new JLabel("Services Required:");
       services.setFont(new Font("Raleway",Font.BOLD,20));
       services.setBounds(100, 360, 400, 30);
       add(services);
       c1 = new JCheckBox("ATM CARD");
       c1.setBackground(Color.WHITE);
       c1.setFont(new Font("Raleway",Font.BOLD,14));
       c1.setBounds(100, 400, 300, 20);
       add(c1);
       c2 = new JCheckBox("Internet Banking");
       c2.setBackground(Color.WHITE);
       c2.setFont(new Font("Raleway",Font.BOLD,14));
       c2.setBounds(400, 400, 200, 20);
       add(c2);
       c3 = new JCheckBox("Mobile Banking");
       c3.setBackground(Color.WHITE);
       c3.setFont(new Font("Raleway",Font.BOLD,14));
       c3.setBounds(100, 440, 300, 20);
       add(c3);
       c4 = new JCheckBox("Email & SMS Alerts");
       c4.setBackground(Color.WHITE);
       c4.setFont(new Font("Raleway",Font.BOLD,14));
       c4.setBounds(400, 440, 200, 20);
       add(c4);
       c5 = new JCheckBox("Cheque Book");
       c5.setBackground(Color.WHITE);
       c5.setFont(new Font("Raleway",Font.BOLD,14));
       c5.setBounds(100, 480, 300, 20);
       add(c5);
       c6 = new JCheckBox("E-Statment");
       c6.setBackground(Color.WHITE);
       c6.setFont(new Font("Raleway",Font.BOLD,14));
       c6.setBounds(400, 480, 200, 20);
       add(c6);
       c7 = new JCheckBox("I herby declares that the above entered details are correct to the best of my knowledge ");
       c7.setBackground(Color.WHITE);
       c7.setFont(new Font("Raleway",Font.BOLD,12));
       c7.setBounds(100, 510, 800, 20);
       add(c7);
       
       
       cancel = new JButton ("Cancel");
       cancel.setBackground(Color.BLACK); 
       cancel.setForeground(Color.WHITE);
       cancel.setFont(new Font("Raleway",Font.BOLD,16));
       cancel.setBounds(150, 570, 100, 30);
       cancel.addActionListener(this);
       add(cancel);
       submit = new JButton ("Submit");
       submit.setBackground(Color.GREEN); 
       submit.setForeground(Color.WHITE);
       submit.setFont(new Font("Raleway",Font.BOLD,16));
       submit.setBounds(400, 570, 100, 30);
       submit.addActionListener(this);
       add(submit);
       
       getContentPane().setBackground(Color.WHITE); 
       setSize(750,700);
       setVisible(true);
       setLocation(350,10);
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == submit){
         String accountType = null;
         if(r1.isSelected()){
           accountType ="Saving Account";
         }else if (r2.isSelected()){
           accountType ="fixed Deposit Account";
         }else if (r3.isSelected()){
           accountType ="Current Accountt";
         }else if (r4.isSelected()){
           accountType ="Recurring Deposit Account";
         }
         
         Random random = new Random();
         String cardnumber =""+ Math.abs((random.nextLong() % 90000000L)+5040936000000000L);
         
         String pinnumber = ""+ Math.abs((random.nextLong() % 9000L)+1000L);
         
         String facility ="";
         if(c1.isSelected()){
          facility = facility + " ATM Card";
         }else if(c2.isSelected()){
          facility = facility + " Internet Banking";
         }else if(c3.isSelected()){
          facility = facility + " Mobile Banking";
         }else if(c4.isSelected()){
          facility = facility + " Email & SMS Alerts";
         }else if(c5.isSelected()){
          facility = facility + " Cheque Book";
         }else if(c6.isSelected()){
          facility = facility + " E-Statment";
         }
         try{
           if(accountType.equals("")){
            JOptionPane.showMessageDialog(null, "Account Type is Required");
           }else {
             Conn conn = new Conn();
             String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
             String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
             conn.s.executeUpdate(query1);
             conn.s.executeUpdate(query2);
             
             JOptionPane.showMessageDialog(null, "Card Number: "+ cardnumber +"\n Pin: " + pinnumber);
              setVisible(false);
              new Deposit(pinnumber).setVisible(true);
             
           }
         }catch(Exception e){
           System.out.println(e);
         }
      }else if(ae.getSource() == cancel){
        setVisible(false);
        new Login().setVisible(true);
      }
    }
    public static void main(String arg[]){
      new SignupThree("");    
    }
}
