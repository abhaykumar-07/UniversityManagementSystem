package university.management.system;
import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class ExaminationDetails extends JFrame implements ActionListener {
    JTextField search;
    JButton submit,back;

    JTable table;
    ExaminationDetails(){

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,500);
        setLocation(220,100);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 10, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        search=new JTextField();
        search.setBounds(80,90,150,25);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);

        submit = new JButton("Result");
        submit.setBounds(250, 90, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        back = new JButton("Back");
        back.setBounds(430, 90, 150, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);

        table=new JTable();
        table.setFont(new Font("Tahoma",Font.PLAIN,15));
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1000,400);
        add(jsp);

        try {
            conn con=new conn();
            ResultSet rs=con.s.executeQuery("select * from Student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row=table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        });

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            setVisible(false);
            new Marks(search.getText());
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
