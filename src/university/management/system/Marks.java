package university.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class Marks extends JFrame implements ActionListener {
    String rollno;
    JButton cancel;
    JTextField tfrollno;
    Marks(String rollno){
        this.rollno=rollno;
        setSize(500,500);
        setLocation(400,100);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Delhi Technical Univeristy");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Examination Result of 2023");
        subheading.setBounds(100, 50, 300, 25);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(60, 90, 175, 25);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);


        tfrollno=new JTextField(rollno);
        tfrollno.setBounds(200,90,150,25);
        tfrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfrollno);

        JLabel lblsemester=new JLabel();
        lblsemester.setBounds(60,130,500,25);
        lblsemester.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsemester);

        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);

        try {
            conn con=new conn();
            ResultSet rs=con.s.executeQuery("select * from Subject where rollno='"+rollno+"'");
            while(rs.next()) {
                sub1.setText(rs.getString("subject1"));
                sub2.setText(rs.getString("subject2"));
                sub3.setText(rs.getString("subject3"));
                sub4.setText(rs.getString("subject4"));
                sub5.setText(rs.getString("subject5"));
            }
            ResultSet rs1=con.s.executeQuery("select * from Marks where rollno='"+rollno+"'");
            while(rs1.next()) {
                sub1.setText(sub1.getText() + "-------------" + rs1.getString("marks1"));
                sub2.setText(sub2.getText() + "-------------" + rs1.getString("marks2"));
                sub3.setText(sub3.getText() + "-------------" + rs1.getString("marks3"));
                sub4.setText(sub4.getText() + "-------------" + rs1.getString("marks4"));
                sub5.setText(sub5.getText() + "-------------" + rs1.getString("marks5"));
                lblsemester.setText("Semester "+rs1.getString("semester"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(250, 400, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new Marks("");
    }
}
