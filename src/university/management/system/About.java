package university.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class About extends JFrame {
    About(){
        setSize(700,500);
        setLayout(null);
        setLocation(300,80);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/about.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,0,270,200);
        add(image);

        JLabel heading=new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(50, 20, 500, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);



        JLabel name = new JLabel("Developed By: Abhay Gupta");
        name.setBounds(50, 220, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);

        JLabel rollno = new JLabel("Roll number: 2220832");
        rollno.setBounds(50, 280, 550, 40);
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(rollno);

        JLabel contact = new JLabel("Contact: abhaykumar@gmail.com");
        contact.setBounds(50, 340, 550, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }
}
