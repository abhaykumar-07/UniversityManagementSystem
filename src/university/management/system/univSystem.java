package university.management.system;

import javax.swing.*;
import java.awt.*;

public class univSystem extends JFrame implements Runnable{
    Thread t;
    univSystem() {
//        setTitle("University Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t=new Thread(this);
        t.start();

        setLocation(200, 15);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x = 1;
        for (int i = 2; i <= 600; i += 4, x += 1) {
            setLocation(550 - ((i + x) / 2), 350 - (i / 2));
            setSize(i + 3 * x, i + x / 2);

            try{
                Thread.sleep(10);
            }catch (Exception e){}
        }
    }
    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
//                                     Next Frame
            new Login();
        }catch (Exception e){}
    }


    public static void main(String[] args) {
        univSystem us = new univSystem();
    }
}


