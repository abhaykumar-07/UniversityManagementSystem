package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","MySQL@7860");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }
}


