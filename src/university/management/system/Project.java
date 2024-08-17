package university.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Project extends JFrame implements ActionListener {
    Project(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1350,720,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel lbl=new JLabel(i3);
        add(lbl);

        JMenuBar mb=new JMenuBar();
        JMenu newInfo=new JMenu("Information");
        JMenu viewDetails=new JMenu("Details");
        JMenu leave=new JMenu("Apply Leave");
        JMenu leaveDetails=new JMenu("Leave Details");
        JMenu exam=new JMenu("Examination");
        JMenu updateDetails=new JMenu("Update Details");
        JMenu feeDetails=new JMenu("Fee Details");
        JMenu utility=new JMenu("Utility");
        JMenu about=new JMenu("About");
        JMenu exit=new JMenu("Exit");
        mb.add(newInfo);
        mb.add(viewDetails);
        mb.add(leave);
        mb.add(leaveDetails);
        mb.add(exam);
        mb.add(updateDetails);
        mb.add(feeDetails);
        mb.add(utility);
        mb.add(about);
        mb.add(exit);

        JMenuItem facultyInfo=new JMenuItem("Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);
        JMenuItem studentInfo=new JMenuItem("Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        JMenuItem studentDetails=new JMenuItem("Student Details");
        studentDetails.setBackground(Color.white);
        studentDetails.addActionListener(this);
        viewDetails.add(studentDetails);
        JMenuItem facultyDetails=new JMenuItem("Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        viewDetails.add(facultyDetails);

        JMenuItem facultyLeave=new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);
        JMenuItem studentLeave=new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.white);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        JMenuItem facultyLeaveDetails=new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.white);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);
        JMenuItem studentLeaveDetails=new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        JMenuItem examResult=new JMenuItem("Examination Result");
        examResult.setBackground(Color.white);
        examResult.addActionListener(this);
        exam.add(examResult);
        JMenuItem studentMarks=new JMenuItem("Enter Marks");
        studentMarks.setBackground(Color.white);
        studentMarks.addActionListener(this);
        exam.add(studentMarks);

        JMenuItem facutlyUpdateDetails=new JMenuItem("Update Faculty Details");
        facutlyUpdateDetails.setBackground(Color.white);
        facutlyUpdateDetails.addActionListener(this);
        updateDetails.add(facutlyUpdateDetails);
        JMenuItem studentUpdateDetails=new JMenuItem("Update Student Details");
        studentUpdateDetails.setBackground(Color.white);
        studentUpdateDetails.addActionListener(this);
        updateDetails.add(studentUpdateDetails);

        JMenuItem feeStructure=new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        feeDetails.add(feeStructure);
        JMenuItem studentFeeInfo=new JMenuItem("Student Fee Form");
        studentFeeInfo.setBackground(Color.white);
        studentFeeInfo.addActionListener(this);
        feeDetails.add(studentFeeInfo);

        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);
        JMenuItem calc=new JMenuItem("Calculator");
        calc.setBackground(Color.white);
        calc.addActionListener(this);
        utility.add(calc);

        JMenuItem ab=new JMenuItem("About");
        ab.setBackground(Color.white);
        ab.addActionListener(this);
        about.add(ab);

        JMenuItem ex=new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);

        setSize(1380,768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();

        switch (str) {
            case "Exit": setVisible(false);
            break;
            case "Calculator": try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){}
            break;
            case "Notepad": try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){}
            break;
            case "Faculty Information": new AddTeacher();
            break;
            case "Student Information": new AddStudent();
            break;
            case "Student Details": new StudentDetails();
            break;
            case "Faculty Details": new TeacherDetails();
            break;
            case "Student Leave": new StudentLeave();
            break;
            case "Faculty Leave": new TeacherLeave();
            break;
            case "Student Leave Details": new StudentLeaveDetails();
            break;
            case "Faculty Leave Details": new TeacherLeaveDetails();
            break;
            case "Update Faculty Details": new UpdateTeacher();
            break;
            case "Update Student Details": new UpdateStudent();
            break;
            case "Enter Marks": new EnterMarks();
            break;
            case "Examination Result": new ExaminationDetails();
            break;
            case "About": new About();
            break;
            case "Fee Structure": new FeeStructure();
            break;
            case "Student Fee Form": new FeeForm();
            break;
        }
    }
    public static void main(String[] args) {

        new Project();
    }
}
