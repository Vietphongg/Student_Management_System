import java.util.LinkedList;

public class CRUD_Subject {
    private String classCode;
    private String className;
    private int credit;
    private LinkedList<String> enrolledStudents;

    // private List<Subject> subjects;
    public CRUD_Subject() {
        // constructor
    }

    public CRUD_Subject(String classcode, String name, int credit) {
        this.classCode = classcode;
        this.className = name;
        this.credit = credit;
        this.enrolledStudents = new LinkedList<>();
    }

    public void enrollStudent(String studentId) {
        enrolledStudents.add(studentId);
    }

    public void removeStudent(String studentId) {
        enrolledStudents.remove(studentId);
    }

    // get
    public String get_classCode() {
        return classCode;
    }

    public String get_className() {
        return className;
    }

    public int get_credit() {
        return credit;
    }

    public LinkedList<String> getEnrolledStudents() {
        return enrolledStudents;
    }

    // set
    public void set_classCode(String classcode) {
        this.classCode = classcode;
    }

    public void set_className(String classname) {
        this.className = classname;
    }

    public void set_credit(int credit) {
        this.credit = credit;
    }

    public void menu_design() {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\tStuden Management System");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t   --------------------");
        System.out.println("\t\t\t   <><><><><><><><><><>");
        System.out.println("\t\t\t   --------------------");
        System.out.println("\t\t\t\tCRUD SUBJECT");
    }

    public void CRUD_Subject_Menu() {
        menu_design();
        System.out.println("\n\n1. Add Subject ");
        System.out.println("\n2. Delete Subject ");
        System.out.println("\n3. Search Subject ");
        System.out.println("\n4. Update Subject ");
        System.out.println("\n5. Display list of subject");
        System.out.println("\n6. Back ");
    }

}
