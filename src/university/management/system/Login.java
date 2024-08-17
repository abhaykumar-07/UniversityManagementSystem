package university.management.system;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;
import  javax.swing.*;
public class Login extends JFrame implements ActionListener {
    JButton login,cancel;
    JTextField textField1;
    JPasswordField textField2;
    Login(){
        setLayout(null);
        JLabel label1=new JLabel("Username");
        label1.setBounds(100,30,100,30);
        add(label1);

        textField1=new JTextField();
        textField1.setBounds(210,30,150,25);
        add(textField1);

        JLabel label2=new JLabel("Password");
        label2.setBounds(100,70,100,30);
        add(label2);

        textField2=new JPasswordField();
        textField2.setBounds(210,70,150,25);
        add(textField2);
        login=new JButton("Login");
        login.setBounds(100,130,80,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Serif",Font.BOLD,13));
        add(login);

        cancel=new JButton("Cancel");
        cancel.setBounds(210,130,80,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Serif",Font.BOLD,13));
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel lbl=new JLabel(i3);
        lbl.setBounds(370,-10,200,200);
        add(lbl);

        getContentPane().setBackground(Color.WHITE);
        setLocation(400,230);
        setSize(600,300);
        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==login){
            String username = textField1.getText();
            String password = textField2.getText();

            String query="select*from login where username='"+username+"'and password='"+password+"'";
            try {
                conn con=new conn();
                ResultSet rs=con.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Project();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
                con.s.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        Login login = new Login();
    }
}
