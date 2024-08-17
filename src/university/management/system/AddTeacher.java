package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class AddTeacher extends JFrame implements ActionListener {
    TextField tfname,tffname,tfrollno,tfaddress,tfphone,tfx,tfxii,tfemail,tfaadharno;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    Random ran=new Random();
    long first4=Math.abs((ran.nextLong()%9000L)+1000L);
    AddTeacher(){
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(400,50,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblname =new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        tfname = new TextField();
        tfname.setBounds(200,150,200,30);
        add(tfname);

        JLabel lblfname =new JLabel("Father's Name");
        lblfname.setBounds(450,150,150,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        tffname = new TextField();
        tffname.setBounds(650,150,200,30);
        add(tffname);

        JLabel lblrollno =new JLabel("Roll Number");
        lblrollno.setBounds(50,200,150,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelempid =new JLabel("101"+first4);
        labelempid.setBounds(200,200,150,30);
        labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);

        JLabel dob =new JLabel("Date of Birth");
        dob.setBounds(450,200,150,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        dcdob=new JDateChooser();
        dcdob.setBounds(650,200,200,30);
        add(dcdob);

        JLabel lbladdress =new JLabel("Address");
        lbladdress.setBounds(50,250,150,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new TextField();
        tfaddress.setBounds(200,250,200,30);
        add(tfaddress);

        JLabel lblphone =new JLabel("Phone");
        lblphone.setBounds(450,250,150,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new TextField();
        tfphone.setBounds(650,250,200,30);
        add(tfphone);

        JLabel lblx =new JLabel("Class X(%)");
        lblx.setBounds(50,300,150,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        tfx = new TextField();
        tfx.setBounds(200,300,200,30);
        add(tfx);

        JLabel lblxii =new JLabel("Class XII(%)");
        lblxii.setBounds(450,300,150,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        tfxii = new TextField();
        tfxii.setBounds(650,300,200,30);
        add(tfxii);

        JLabel lblemail =new JLabel("Email ID");
        lblemail.setBounds(50,350,150,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new TextField();
        tfemail.setBounds(200,350,200,30);
        add(tfemail);

        JLabel lblaadhar =new JLabel("Aadhar Number");
        lblaadhar.setBounds(450,350,150,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);

        tfaadharno = new TextField();
        tfaadharno.setBounds(650,350,200,30);
        add(tfaadharno);

        JLabel lblcouse =new JLabel("Qualification");
        lblcouse.setBounds(50,400,150,30);
        lblcouse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcouse);

        String course[]={"B.Tech","MBA","B.Com","MCA","Bsc","MCom","BBA","BCA","MA"};
        cbcourse =new JComboBox(course);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setBounds(200,400,200,30);
        add(cbcourse);

        JLabel lblbranch =new JLabel("Department");
        lblbranch.setBounds(450,400,150,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);

        String branch[]={"Computer Science Engineering","Electronics","Civil","Mechanical","IT"};
        cbbranch =new JComboBox(branch);
        cbbranch.setBackground(Color.WHITE);
        cbbranch.setBounds(650,400,200,30);
        add(cbbranch);

        submit=new JButton("Submit");
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String empid = labelempid.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String email = tfemail.getText();
            String aadhar = tfaadharno.getText();
            String course = (String)cbcourse.getSelectedItem();
            String branch = (String)cbbranch.getSelectedItem();
            if (name.isEmpty()||fname.isEmpty()||empid.isEmpty()||dob.isEmpty()||address.isEmpty()||phone.isEmpty()||x.isEmpty()||xii.isEmpty()||email.isEmpty()||aadhar.isEmpty()||course.isEmpty()||branch.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill all the field","Error",JOptionPane.ERROR_MESSAGE);
            }else {
                try {
                    String query = "insert into Teacher values('" + name + "','" + fname + "','" + empid + "','" + dob + "','" + address + "','" + phone + "','" + x + "','" + xii + "','" + email + "','" + aadhar + "','" + course + "','" + branch + "')";

                    conn con = new conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddTeacher();
    }
}
