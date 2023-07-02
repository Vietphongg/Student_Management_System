import java.util.LinkedList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
// import java.util.LinkedList;

class Menu {
    public void menu() {
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\tStuden Management System");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t   --------------------");
        System.out.println("\t\t\t   <><><><><><><><><><>");
        System.out.println("\t\t\t   --------------------");
        System.out.println("\n\n1. CRUD Student ");
        System.out.println("\n2. CRUD Subject ");
        System.out.println("\n3. Join subject ");
        System.out.println("\n4. Grade ");
        System.out.println("\n5. Quit ");
    }
}

public class MainSystem {

    static int getChoice(int minn, int maxx) {
        Scanner sc = new Scanner(System.in);
        int tmp;
        do {
            tmp = sc.nextInt();
        } while (tmp < minn || tmp > maxx);
        return tmp;
    }

    static String inputPhoneNumber() {
        Scanner sc = new Scanner(System.in);
        String number;
        do {
            number = sc.nextLine();
            if (number.length() != 10) {
                System.out.println("\nPhone number has 10 numbers!");
            }
        } while (number.length() != 10);
        return number;
    }

    static String inputID() {
        Scanner sc = new Scanner(System.in);
        String id;
        do {
            id = sc.nextLine();
            if (id.length() != 8 || id.substring(0, 1).equalsIgnoreCase("SE")) {
                System.out.println("\nID must be SE??????");
            }
        } while (id.length() != 8 || id.substring(0, 1).equalsIgnoreCase("SE"));
        return id;
    }

    static String inputMail() {
        Scanner sc = new Scanner(System.in);
        String email;
        boolean check = true;
        do {
            check = true;
            email = sc.nextLine();
            if (email.isEmpty()) {
                check = false;
            }
            if (!email.contains("@")) {
                check = false;
            }
            String[] parts = email.split("@");
            if (parts.length != 2) {
                check = false;
            } else {
                String username = parts[0];
                String domain = parts[1];
                if (username.isEmpty()) {
                    check = false;
                }
                if (domain.isEmpty()) {
                    check = false;
                }
                if (!domain.contains(".")) {
                    check = false;
                }
                if (domain.endsWith(".")) {
                    check = false;
                }
            }

            if (check == false) {
                System.out.println("\nEmail is invalid!!!");
            }
        } while (check == false);
        return email;
    }

    static String inputdayOfbirth() {
        Pattern DATE_Pattern = Pattern.compile("^\\d{2}-\\d{2}-\\d{4}$");
        Scanner sc = new Scanner(System.in);
        String date;
        boolean check = true;
        do {
            date = sc.nextLine();
            if (DATE_Pattern.matcher(date).matches()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                simpleDateFormat.setLenient(false);
                try {
                    simpleDateFormat.parse(date);
                    check = true;
                } catch (ParseException pe) {
                    check = false;
                }
            } else {
                check = false;
            }
            if (!check) {
                System.out.println("\nDate is invalid!!!");
            }
        } while (!check);
        return date;

    }

    static void CRUDStudent(CRUD_Student_Management student_list) {// menu CRUD student
        CRUD_Student pl = new CRUD_Student();
        // CRUD_Student_Management student_list = new CRUD_Student_Management();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            pl.CRUD_Student_Menu();
            choice = getChoice(1, 6);
            switch (choice) {
                case 1: {// add student
                    pl.menu_design();
                    String name, id, number, mail, gr, date;
                    // t[0].set_classCode("132");
                    // Boolean check = false;
                    System.out.println("\n\n1. Student name: ");
                    name = sc.nextLine();
                    //
                    System.out.println("\n2. Student ID:  ");
                    id = inputID();
                    //
                    System.out.println("\n3. Student Phone Number:  ");
                    number = inputPhoneNumber();
                    //
                    System.out.println("\n4. Student Email:  ");
                    mail = inputMail();
                    //
                    System.out.println("\n5. Student Grade: ");
                    gr = sc.nextLine();
                    //
                    System.out.println("\n6. Day of Birth(dd-mm-yyyy): ");
                    date = inputdayOfbirth();
                    //
                    CRUD_Student tmp = new CRUD_Student(name, id, number, mail, gr, !gr.isEmpty(), date);
                    student_list.add(tmp);
                    System.out.println("\nPrint ENTER to back!\n");
                    //
                    sc.nextLine();
                    break;
                }
                case 2: {// delete student
                    pl.menu_design();
                    System.out.println("\nStudent ID:  ");
                    String id;
                    id = inputID();
                    student_list.delete(id);
                    System.out.println("\nPrint ENTER to back!\n");
                    //
                    sc.nextLine();
                    break;
                }
                case 3: {// search student
                    pl.menu_design();
                    System.out.println("\nStudent ID:  ");
                    String id;
                    id = inputID();
                    student_list.searchStudent(id);
                    System.out.println("\nPrint ENTER to back!\n");
                    //
                    sc.nextLine();
                    break;
                }
                case 4: {// update student
                    pl.menu_design();
                    System.out.println("\nStudent ID:  ");
                    String id = inputID();
                    student_list.updateStudent(id);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
                case 5: {// display student list
                    pl.menu_design();
                    student_list.display();
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
            }
        } while (choice != 6);
    }

    static void grade_management(CRUD_Student_Management student_list, Mark_Student_Management mark_list) {
        // Mark_Student pl = new Mark_Student();
        Scanner sc = new Scanner(System.in);
        Mark_Student pl = new Mark_Student();

        int choice;
        do {
            pl.Mark_Student_Menu();
            choice = getChoice(1, 4);
            //
            switch (choice) {
                case 1: {
                    pl.menu_design();
                    System.out.println("\nEnter student id: ");
                    String id;
                    id = inputID();
                    mark_list.addToLinkedList(student_list, id);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
                case 2: {
                    pl.menu_design();
                    System.out.println("\nEnter student id: ");
                    String id;
                    id = inputID();
                    mark_list.display_Mark_List_StudenID(student_list, id);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
                case 3: {
                    pl.menu_design();
                    System.out.println("\nEnter class code: ");
                    String classcode;
                    classcode = sc.nextLine();
                    mark_list.display_Mark_List_ClassCode(student_list, classcode);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
            }

        } while (choice != 4);
    }

    static void CRUD_Subject(CRUD_Subject_Management subject_list) {
        Scanner sc = new Scanner(System.in);
        CRUD_Subject pl = new CRUD_Subject();
        int choice;
        do {
            pl.CRUD_Subject_Menu();
            choice = getChoice(1, 6);
            switch (choice) {
                case 1: {
                    pl.menu_design();
                    String classname, classid;
                    int credit = 0;
                    System.out.println("\nEnter the class name: ");
                    classname = sc.nextLine();
                    System.out.println("\nEnter the class id: ");
                    classid = sc.nextLine();
                    boolean kt = false;
                    do {
                        try {
                            System.out.println("\nEnter the credit: ");
                            kt = true;
                            credit = sc.nextInt();
                            sc.nextLine();
                        } catch (java.util.InputMismatchException e) {
                            // TODO: handle exception
                            kt = false;
                            System.out.println("\nWrong data type of credit!");
                            sc.nextLine();
                        }
                    } while (!kt);
                    CRUD_Subject tmp = new CRUD_Subject(classid, classname, credit);
                    subject_list.addSubject(tmp);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
                case 2: {
                    String classid;
                    pl.menu_design();
                    System.out.println("\nEnter the class id: ");
                    classid = sc.nextLine();
                    subject_list.deleteSubject(classid);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
                case 3: {
                    String classid;
                    pl.menu_design();
                    System.out.println("\nEnter class id: ");
                    classid = sc.nextLine();
                    subject_list.searchSubject(classid);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
                case 4: {
                    pl.menu_design();
                    String classid;
                    System.out.println("\nEnter class id: ");
                    classid = sc.nextLine();
                    subject_list.updateSubject(classid);
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
                case 5: {
                    pl.menu_design();
                    subject_list.displaySubject();
                    System.out.println("\nPrint ENTER to back!\n");
                    sc.nextLine();
                    break;
                }
            }

        } while (choice != 6);
    }

    static void join_subject(CRUD_Subject_Management subject_list, CRUD_Student_Management student_list) {
        Scanner sc = new Scanner(System.in);
        CRUD_Subject pl = new CRUD_Subject();
        pl.menu_design();
        System.out.println("\nEnter id: ");
        String id, subjectid;
        id = inputID();
        if (student_list.find(id) == 1) {
            System.out.println("Enter subject id: ");
            subjectid = sc.nextLine();
            if (subject_list.find(subjectid) == 1) {
                subject_list.join_subject(id, subjectid);
            } else {
                System.out.println("\nThe class is not exists!!!");
            }
        } else {
            System.out.println("\nStudent is not exists!!!");
        }
        System.out.println("\nPrint ENTER to back!\n");
        sc.nextLine();
    }

    public static void main(String[] args) {// main menu
        int choice;
        Menu obj = new Menu();
        CRUD_Student_Management student_list = new CRUD_Student_Management();
        Mark_Student_Management mark_list = new Mark_Student_Management();
        CRUD_Subject_Management subject_list = new CRUD_Subject_Management();
        do {
            obj.menu();
            choice = getChoice(1, 5);
            switch (choice) {
                case 1: {
                    CRUDStudent(student_list);
                    break;
                }
                case 2: {
                    CRUD_Subject(subject_list);
                    break;
                }
                case 3: {
                    join_subject(subject_list, student_list);
                    break;
                }
                case 4: {
                    grade_management(student_list, mark_list);
                    break;
                }
            }
        } while (choice != 5);
    }

}