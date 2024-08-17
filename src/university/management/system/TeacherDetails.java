package university.management.system;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import  javax.swing.*;

public class TeacherDetails extends JFrame implements ActionListener {
    Choice cEmpId;
    JTextField tfempid;
    JTable table;
    JButton search,print,update,add,cancel;
    TeacherDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        heading.setBackground(Color.WHITE);
        add(heading);

        tfempid=new JTextField();
        tfempid.setBounds(180,20,150,20);
        add(tfempid);

//        cEmpId=new Choice();
//        cEmpId.setBounds(180,20,150,20);
//        add(cEmpId);
//        try {
//            conn con=new conn();
//            ResultSet rs=con.s.executeQuery("select * from Teacher");
//            while (rs.next()){
//                cEmpId.add(rs.getString("empId"));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        table =new JTable();

        try {
            conn con=new conn();
            ResultSet rs=con.s.executeQuery("select * from Teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,895,600);
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
            String query="select * from Teacher where empId='"+tfempid.getText()+"'";
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
            new AddTeacher();
        } else if (ae.getSource()==update) {
            setVisible(false);
            new UpdateTeacher();
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherDetails();
    }

}
