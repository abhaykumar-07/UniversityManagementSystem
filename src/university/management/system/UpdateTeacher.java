package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.*;

import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;
public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField tfaddress,tfphone,tfemail,tfrollno,tfcourse,tfbranch;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox cEmpid;
    JButton submit,cancel;
    UpdateTeacher(){
        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(400,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblrollnumber= new JLabel("Select by Employee Id");
        lblrollnumber.setBounds(50,90,300,30);
        lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);

        cEmpid=new JComboBox();
        cEmpid.setBounds(270,95,150,25);
        cEmpid.setBackground(Color.WHITE);
        add(cEmpid);
        try {
            conn con=new conn();
            ResultSet rs=con.s.executeQuery("select * from Teacher");
            while (rs.next()){
                cEmpid.addItem(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblname =new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        JLabel tfname = new JLabel();
        tfname.setBounds(200,150,200,30);
        tfname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfname);

        JLabel lblfname =new JLabel("Father's Name");
        lblfname.setBounds(450,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        JLabel tffname = new JLabel();
        tffname.setBounds(650,150,200,30);
        tffname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tffname);

        JLabel lblrollno =new JLabel("Employee ID");
        lblrollno.setBounds(50,200,150,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelempId =new JLabel();
        labelempId.setBounds(200,200,150,30);
        labelempId.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(labelempId);

        JLabel dob =new JLabel("Date of Birth");
        dob.setBounds(450,200,150,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        JLabel lbldob=new JLabel();
        lbldob.setBounds(650,200,150,30);
        lbldob.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbldob);

        JLabel lbladdress =new JLabel("Address");
        lbladdress.setBounds(50,250,150,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,200,30);
        add(tfaddress);

        JLabel lblphone =new JLabel("Phone");
        lblphone.setBounds(450,250,150,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(650,250,200,30);
        add(tfphone);

        JLabel lblx =new JLabel("Class X(%)");
        lblx.setBounds(50,300,150,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        JLabel tfx = new JLabel();
        tfx.setBounds(200,300,200,30);
        tfx.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfx);

        JLabel lblxii =new JLabel("Class XII(%)");
        lblxii.setBounds(450,300,150,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        JLabel tfxii = new JLabel();
        tfxii.setBounds(650,300,200,30);
        tfxii.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfxii);

        JLabel lblemail =new JLabel("Email ID");
        lblemail.setBounds(50,350,150,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,350,200,30);
        add(tfemail);

        JLabel lblaadhar =new JLabel("Aadhar Number");
        lblaadhar.setBounds(450,350,150,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);

        JLabel tfaadharno = new JLabel();
        tfaadharno.setBounds(650,350,200,30);
        tfaadharno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfaadharno);

        JLabel lblcouse =new JLabel("Education");
        lblcouse.setBounds(50,400,150,30);
        lblcouse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcouse);

        tfcourse=new JTextField();
        tfcourse.setBounds(200,400,200,30);
        add(tfcourse);

        JLabel lblbranch =new JLabel("Department");
        lblbranch.setBounds(450,400,150,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);

        tfbranch=new JTextField();
        tfbranch.setBounds(650,400,200,30);
        add(tfbranch);

        try {
            conn con =new conn();
            String query="select * from Teacher where empid='"+cEmpid.getSelectedItem()+"'";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                labelempId.setText(rs.getString("empId"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfx.setText(rs.getString("class_x"));
                tfxii.setText(rs.getString("class_xii"));
                tfemail.setText(rs.getString("email"));
                tfaadharno.setText(rs.getString("aadhar"));
                tfcourse.setText(rs.getString("education"));
                tfbranch.setText(rs.getString("department"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        cEmpid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn con =new conn();
                    String query="select * from Teacher where empid='"+cEmpid.getSelectedItem()+"'";
                    ResultSet rs=con.s.executeQuery(query);
                    while(rs.next()){
                        tfname.setText(rs.getString("name"));
                        tffname.setText(rs.getString("fname"));
                        labelempId.setText(rs.getString("empId"));
                        lbldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfx.setText(rs.getString("class_x"));
                        tfxii.setText(rs.getString("class_xii"));
                        tfemail.setText(rs.getString("email"));
                        tfaadharno.setText(rs.getString("aadhar"));
                        tfcourse.setText(rs.getString("education"));
                        tfbranch.setText(rs.getString("department"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });


        submit=new JButton("Update");
        submit.setBounds(300,550,150,30);
        submit.setFont(new Font("serif",Font.BOLD,20));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(500,550,150,30);
        cancel.setFont(new Font("serif",Font.BOLD,20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setLocation(220,20);
        setSize(1000,700);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String empId = labelempId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {
                String query ="update Teacher set address ='"+address+"',phone ='"+phone+"',email='"+email+"',education='"+course+"',department='"+branch+"' where empId='"+empId+"'";

                conn con = new conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Details updated Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new UpdateTeacher();
    }
}
