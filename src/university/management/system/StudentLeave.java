package university.management.system;
import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class StudentLeave extends JFrame implements ActionListener {
    Choice crollno,ctime;
    JDateChooser dateChooser;
    JButton bsubmit,bcancel;
    StudentLeave(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Apply Leave(Student)");
        heading.setBounds(120,20,200,30);
        heading.setFont(new Font("serif",Font.BOLD,20));
        add(heading);

        JLabel lblrollno=new JLabel("Search by Roll Number");
        lblrollno.setBounds(30,70,250,30);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblrollno);

        crollno=new Choice();
        crollno.setBounds(30,110,200,30);
        add(crollno);
        try {
            conn con=new conn();
            String query="select * from Student";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lbldate=new JLabel("Date");
        lbldate.setBounds(30,160,250,30);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbldate);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(30,200,200,25);
        add(dateChooser);

        JLabel lbltime=new JLabel("Time Duration");
        lbltime.setBounds(30,245,250,30);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltime);

        ctime=new Choice();
        ctime.setBounds(30,285,200,30);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        bsubmit=new JButton("Submit");
        bsubmit.setBounds(80,400,100,30);
        bsubmit.setBackground(Color.BLACK);
        bsubmit.setForeground(Color.WHITE);
        bsubmit.setFont(new Font("serif",Font.BOLD,20));
        bsubmit.addActionListener(this);
        add(bsubmit);

        bcancel=new JButton("Cancel");
        bcancel.setBounds(230,400,100,30);
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setFont(new Font("serif",Font.BOLD,20));
        bcancel.addActionListener(this);
        add(bcancel);

        setSize(500,550);
        setLocation(500,100);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==bsubmit){
            String rollno=crollno.getSelectedItem();
            String date=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();

            String query="insert into StudentLeave values('"+rollno+"','"+date+"','"+duration+"')";
            try {
                conn con=new conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeave();
    }
}
