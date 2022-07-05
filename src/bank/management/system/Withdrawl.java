
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    
    JButton withdrawl,back ;
    JTextField amount;
     String pinnumber;
    Withdrawl(String pinnumber){
       this.pinnumber = pinnumber;
        setLayout (null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,730);
        add(image); 
        
        
        JLabel text = new JLabel("Enter the amount you want to withdrawl");
        text.setBounds(200, 230, 400, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(200, 280, 290, 25);
        image.add(amount);
        
        withdrawl = new JButton ("Withdraw");
        withdrawl.setBounds(370, 350, 150, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        
        back = new JButton ("Back");
        back.setBounds(370,  390, 150, 25);
        back.addActionListener(this);
        image.add(back);
       
       setSize(900,730);
       //setUndecorated(true);
       setLocation(300,0);
       setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == back){
          setVisible(false);
        new Transactions(pinnumber).setVisible(true);
      }else if(ae.getSource() == withdrawl){
         String number = amount.getText();
         Date date = new Date();
         if(number.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawl");
         }else{
          try{
           Conn conn = new Conn();
          String qurey = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
          conn.s.executeUpdate(qurey);
          JOptionPane.showMessageDialog(null, "Rs "+ number + " Withdrawl Successfully");
           setVisible(false);
        new Transactions(pinnumber).setVisible(true);
          }catch(Exception e){
           System.out.println(e);
          }
         }
         
      }
    }
    
    public static void main(String arg[]){
      new Withdrawl("");
    }
}
