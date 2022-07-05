
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {
     JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    FastCash( String pinnumber){
        this.pinnumber = pinnumber;
        setLayout (null);
        
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,730);
        add(image); 
        
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(215, 230, 730, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton ("Rs 100");
        deposit.setBounds(170, 330, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton ("Rs 500");
        withdrawl.setBounds(370, 330, 130, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton ("Rs 1000");
        fastcash.setBounds(170, 360, 130, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton ("Rs 2000");
        ministatement.setBounds(370, 360, 130, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton ("Rs 5000");
        pinchange.setBounds(170, 390, 130, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton ("Rs 10000");
        balanceenquiry.setBounds(370, 390, 130, 25);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton ("Back");
        exit.setBounds(370, 420, 130, 25);
        exit.addActionListener(this);
        image.add(exit);
        
       setSize(900,730);
       setUndecorated(true);
       setLocation(300,0);
       setVisible(true);
    
    }
     public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == exit){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
      }else {
         String amount = ((JButton)ae.getSource()).getText().substring(3); //Rs
         Conn conn = new Conn();
         try{
           ResultSet rs = conn.s.executeQuery("select * from bank where pin ='"+pinnumber+"' ");
           int balance =0;
           while(rs.next()){
             if(rs.getString("type").equals("Deposit")){
               balance += Integer.parseInt(rs.getString("amount"));
             }else{
               balance -= Integer.parseInt(rs.getString("amount"));
             }
           }
           
           if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
             JOptionPane.showMessageDialog(null, "Insufficient Balance");
             return;
           
           }
           Date date = new Date();
           String query = " insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debitad Sucessfuly");
             setVisible(false);
             new Transactions(pinnumber).setVisible(true);
         }catch(Exception e){
           System.out.println(e);
         }
      }
   }
    
    public static void main(String arg[]){
     new FastCash("");
    }
}
