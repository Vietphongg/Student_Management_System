public class Mark_Student {
    private String Student_id;
    private String classCode;
    private double lab;
    private double progress_test;
    private double final_test;

    // get
    public Mark_Student() {
        // constructor
        this.lab = 0;
        this.progress_test = 0;
        this.final_test = 0;
    }

    public Mark_Student(String id, String classcode, double lab_mark, double pt_mark, double final_mark) {
        // constructor
        this.Student_id = id;
        this.classCode = classcode;
        this.lab = lab_mark;
        this.progress_test = pt_mark;
        this.final_test = final_mark;
    }

    public String get_Student_id() {
        return Student_id;
    }

    public String get_classCode() {
        return classCode;
    }

    public double get_lab() {
        return lab;
    }

    public double get_progress_test() {
        return progress_test;
    }

    public double get_final_test() {
        return final_test;
    }

    // set
    public void set_Student_id(String id) {
        this.Student_id = id;
    }

    public void set_classCode(String id) {
        this.classCode = id;
    }

    public void set_lab(double diem) {
        this.lab = diem;
    }

    public void set_progress_test(double diem) {
        this.progress_test = diem;
    }

    public void set_final_test(double diem) {
        this.final_test = diem;
    }

    public void menu_design() {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\tStuden Management System");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t   --------------------");
        System.out.println("\t\t\t   <><><><><><><><><><>");
        System.out.println("\t\t\t   --------------------");
        System.out.println("\t\t\t\t\tGRADE");
    }

    public void Mark_Student_Menu() {
        menu_design();
        System.out.println("\n\n1. Enter Grade's Student ");
        System.out.println("\n2. Show Grade's Student ");
        System.out.println("\n3. Show Grade's Class ");
        System.out.println("\n4. Back ");
    }
}
