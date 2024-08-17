package university.management.system;
import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class FeeStructure extends JFrame{
    FeeStructure(){
        setLayout(null);
        setSize(1000,600);
        setLocation(200,50);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Fee Structure");
        heading.setBounds(400,5,500,30);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JTable table=new JTable();
        try {
            conn con=new conn();
            ResultSet rs=con.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,60,1000,600);
        add(jsp);

        setVisible(true);
    }
    public static void main(String[] args) {
        new FeeStructure();
    }
}
