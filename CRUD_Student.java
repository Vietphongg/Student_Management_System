
// import java.util.LinkedList;
// import java.util.Scanner;


public class CRUD_Student {
    private String studentName;
    private String ID_Student;
    private String phoneNumber;
    private String email;
    private String grade;
    private String dayOfbirth;
    private boolean isGrade;// true = in class, false = not in class
    // private mark IdClass[];

    //
    public CRUD_Student() {
        // constructor
    }

    public CRUD_Student(String studentName, String ID_Student, String phoneNumber, String email, String grade,
            boolean check, String date) {
        this.ID_Student = ID_Student;
        this.phoneNumber = phoneNumber;
        this.studentName = studentName;
        this.email = email;
        this.grade = grade;
        this.dayOfbirth = date;
        this.isGrade = check;
        // this.IdClass = tmp_mark;
    }

    public String getID_Student() {
        return ID_Student;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

    public boolean getIsGrade() {
        return isGrade;
    }

    public String getdayOfbirth() {
        return dayOfbirth;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public void setID_Student(String ID) {
        this.ID_Student = ID;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setIsGrade(Boolean check) {
        this.isGrade = check;
    }

    public void setdayOfbirth(String date) {
        this.dayOfbirth = date;
    }

    public void menu_design() {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\tStuden Management System");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t   --------------------");
        System.out.println("\t\t\t   <><><><><><><><><><>");
        System.out.println("\t\t\t   --------------------");
        System.out.println("\t\t\t\tCRUD STUDENT");
    }

    public void CRUD_Student_Menu() {
        menu_design();
        System.out.println("\n\n1. Add Student ");
        System.out.println("\n2. Delete Student ");
        System.out.println("\n3. Search Student ");
        System.out.println("\n4. Update Student ");
        System.out.println("\n5. Display list of student");
        System.out.println("\n6. Back ");
    }
}
