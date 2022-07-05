package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    String pinnumber;
    JPasswordField pin,repin;
    JButton change,backa;
    PinChange(String pinnumber){
    this.pinnumber = pinnumber;
    setLayout (null);
    
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
     Image i2 = i1.getImage().getScaledInstance(900, 730, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,0,900,730);
     add(image); 
      
     
        JLabel text = new JLabel("Change your PIN");
        text.setBounds(250, 230, 530, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN");
        pintext.setBounds(165, 280, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(330, 280, 180, 25);
        image.add(pin);
        
        
        JLabel repintext = new JLabel("CONFORM PIN");
        repintext.setBounds(165, 320, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        image.add(repintext);
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 22));
        repin.setBounds(330, 320, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(370, 390, 130, 30);
        change.addActionListener(this);
        image.add(change);
        
        backa = new JButton("BACK");
        backa.setBounds(170, 390, 130, 30);
        backa.addActionListener(this);
        image.add(backa);
       
        
        
        
        setSize(900,730);
       setUndecorated(true);
       setLocation(300,0);
       setVisible(true);
    }
   
        
    
 
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == change){
        try{
          String npin = pin.getText();
          String rpin = repin.getText();
          
          if(!npin.equals(rpin)){
            JOptionPane.showMessageDialog(null, "Entered PIN does not match");
            return;
          }
          if(npin.equals("")){
          
           JOptionPane.showMessageDialog(null, "Please Enter new PIN ");
            return;
          }
          
          if(rpin.equals("")){
          
           JOptionPane.showMessageDialog(null, "Please re-enter new PIN ");
            return;
          }
          
          
          Conn conn = new Conn();
          String query1 = "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
          String query2 = "update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
          String query3 = "update signupthree set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
          
          conn.s.executeUpdate(query1);
          conn.s.executeUpdate(query2);
          conn.s.executeUpdate(query3);
          
          JOptionPane.showMessageDialog(null, "PIN changed successfully ");
          setVisible(false);
          new Transactions(rpin).setVisible(true);
        }catch(Exception e){
          System.out.println(e);
        }
       }else{
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
       }
    }
   public static void main(String arg[]){
     
        new PinChange("").setVisible(true);
   
   }  
}
