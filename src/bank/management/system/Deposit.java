
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    
    JButton deposit,back ;
    JTextField amount;
     String pinnumber;
    Deposit(String pinnumber){
       this.pinnumber = pinnumber;
        setLayout (null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,730);
        add(image); 
        
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(200, 230, 400, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(200, 280, 290, 25);
        image.add(amount);
        
        deposit = new JButton ("Deposit");
        deposit.setBounds(370, 350, 150, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
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
      }else if(ae.getSource() == deposit){
         String number = amount.getText();
         Date date = new Date();
         if(number.equals("")){
         JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
         }else{
          try{
           Conn conn = new Conn();
          String qurey = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
          conn.s.executeUpdate(qurey);
          JOptionPane.showMessageDialog(null, "Rs "+ number + " Deposited Successfully");
           setVisible(false);
        new Transactions(pinnumber).setVisible(true);
          }catch(Exception e){
           System.out.println(e);
          }
         }
         
      }
    }
    
    public static void main(String arg[]){
      new Deposit("");
    }
}
