package university.management.system;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import  javax.swing.*;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice crollno;
    JTable table;
    JButton search,print,cancel;
    StudentLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Search by Roll no");
        heading.setBounds(20,20,150,20);
        heading.setBackground(Color.WHITE);
        add(heading);

        crollno=new Choice();
        crollno.setBounds(180,20,150,20);
        add(crollno);
        try {
            conn con=new conn();
            ResultSet rs=con.s.executeQuery("select * from StudentLeave");
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table =new JTable();

        try {
            conn con=new conn();
            ResultSet rs=con.s.executeQuery("select * from StudentLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print=new JButton("Print");
        print.setBounds(130,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel=new JButton("Cancel");
        cancel.setBounds(240,70,80,20);
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
            String query="select * from StudentLeave where rollno='"+crollno.getSelectedItem()+"'";
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
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeaveDetails();
    }

}

