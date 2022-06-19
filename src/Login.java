import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Login  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    Login(){

        f=new JFrame("Login");

        f.setBackground(Color.white);
        f.getContentPane().setLayout(null);

        l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(40,20,100,30);
        f.getContentPane().add(l1);
        
        l2 = new JLabel("Password");
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(40,70,100,30);
        f.getContentPane().add(l2);
 
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.getContentPane().add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.getContentPane().add(t2);


        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.getContentPane().add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.getContentPane().add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);

    }

    public void actionPerformed(ActionEvent ae){

        try{
     //       conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            if(u.equals("admin") && v.equals("admin"))
            {
            	new adminDash().frame.setVisible(true);
            	f.dispose();
            }
          //  String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
           // ResultSet rs = c1.s.executeQuery(q); 
            //if(rs.next()){
             //   new details().f.setVisible(true);
              //  f.setVisible(false);
            //}else{
              //  JOptionPane.showMessageDialog(null, "Invalid login");
                //f.setVisible(false);
            //}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        Login l=new Login();
    }
}