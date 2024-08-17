package university.management.system;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import  javax.swing.*;

public class StudentDetails extends JFrame implements ActionListener {
    Choice crollno;
    JTextField tfrollno;
    JTable table;
    JButton search,print,update,add,cancel;
    StudentDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        heading.setBackground(Color.WHITE);
        add(heading);

        tfrollno=new JTextField();
        tfrollno.setBounds(180,20,150,20);
        add(tfrollno);
//        crollno=new Choice();
//        crollno.setBounds(180,20,150,20);
//        add(crollno);
//        try {
//            conn con=new conn();
//            ResultSet rs=con.s.executeQuery("select*from Student");
//            while (rs.next()){
//                crollno.add(rs.getString("rollno"));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        table =new JTable();

        try {
            conn con=new conn();
            ResultSet rs=con.s.executeQuery("select*from Student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,890,600);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(130,70,80,20);
        print.addActionListener(this);
        add(print);

        update=new JButton("Update");
        update.setBounds(240,70,80,20);
        update.addActionListener(this);
        add(update);

        add=new JButton("Add");
        add.setBounds(350,70,80,20);
        add.addActionListener(this);
        add(add);

        cancel=new JButton("Cancel");
        cancel.setBounds(460,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setLocation(220,20);
        setSize(900,700);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==search){
            String query="select * from Student where rollno='"+tfrollno.getText()+"'";
            try {
                conn con=new conn();
                ResultSet rs=con.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==print) {
            try {
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==add) {
            setVisible(false);
            new AddStudent();
        } else if (ae.getSource()==update) {
            setVisible(false);
            new UpdateStudent();
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentDetails();
    }
}
