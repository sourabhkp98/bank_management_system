
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquery extends JFrame implements ActionListener{
    String pinnumber;
    JButton change,backa1;
    BalanceEnquery(String pinnumber){
    this.pinnumber = pinnumber;
    setLayout (null);
    
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
     Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,0,900,730);
     add(image); 
     
       
        backa1 = new JButton("BACK");
        backa1.setBounds(370, 420, 130, 25);
        backa1.addActionListener(this);
        image.add(backa1);
        
        
         Conn conn = new Conn();
         int balance =0;
         try{
           ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"' ");
           
           while(rs.next()){
             if(rs.getString("type").equals("Deposit")){
               balance += Integer.parseInt(rs.getString("amount"));
             }else{
               balance -= Integer.parseInt(rs.getString("amount"));
             }
           }
         }catch(Exception e){
          System.out.println(e);
         }
         
         JLabel text = new JLabel("Your Current Account Balance is Rs "+ balance);
        text.setBounds(170, 280, 530, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
     
      setSize(900,730);
       setUndecorated(true);
       setLocation(300,0);
       setVisible(true);
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
    }
    public static void main(String arg[]){
     new BalanceEnquery("");
    }
    
}
