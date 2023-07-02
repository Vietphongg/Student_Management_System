import java.util.LinkedList;
import java.util.Scanner;

public class Mark_Student_Management extends CRUD_Student_Management {
    LinkedList<Mark_Student> mark_list;

    public Mark_Student_Management() {
        mark_list = new LinkedList<>();
    }

    public double getMark() {
        Scanner sc = new Scanner(System.in);
        double tmp;
        do {
            tmp = sc.nextDouble();
            if (tmp < 0 || tmp > 10) {
                System.out.println("\nThe mark must be from 0 - 10 !!!");
            }
        } while (tmp < 0 || tmp > 10);
        return tmp;
    }

    public void addToLinkedList(CRUD_Student_Management student_list, String id) {
        Mark_Student value = new Mark_Student();
        Scanner sc = new Scanner(System.in);
        String classcode;
        double lab, pt, fn;
        if (student_list.find(id) == 1) {
            System.out.println("\nEnter class code: ");
            classcode = sc.nextLine();
            System.out.println("\nEnter lab mark: ");
            lab = getMark();
            System.out.println("\nEnter progress test mark: ");
            pt = getMark();
            System.out.println("\nEnter final test mark: ");
            fn = getMark();
            value = new Mark_Student(id, classcode, lab, pt, fn);
            mark_list.add(value);
            System.out.println("\nUpdate successfully!");
        } else {
            System.out.println("\nStudent donot exist!");
        }
    }

    public void display_Mark_List_StudenID(CRUD_Student_Management student_list, String id) {
        Scanner sc = new Scanner(System.in);
        if (student_list.find(id) == 1) {
            for (Mark_Student item : mark_list) {
                if (item.get_Student_id().equalsIgnoreCase(id)) {
                    System.out.print("\nStudent id: " + item.get_Student_id() + "\nClassCode: " + item.get_classCode()
                            + "\nLab Mark: "
                            + item.get_lab() + "\nProgress Test Mark: "
                            + item.get_progress_test() + "\nFinal Test Mark:  "
                            + item.get_final_test());
                    System.out.println();
                }
            }
        } else {
            System.out.println("\nStudent donot exist!");
        }
    }

    public void display_Mark_List_ClassCode(CRUD_Student_Management student_list, String classcode) {
        boolean check = false;
        for (Mark_Student item : mark_list) {
            if (item.get_classCode().equalsIgnoreCase(classcode)) {
                System.out.print("\nStudent id: " + item.get_Student_id() + "\nClassCode: " + item.get_classCode()
                        + "\nLab Mark: "
                        + item.get_lab() + "\nProgress Test Mark: "
                        + item.get_progress_test() + "\nFinal Test Mark:  "
                        + item.get_final_test());
                System.out.println("\n------------------------------\n");
                check = true;
            }
        }
        if (!check) {
            System.out.println("\nClass donot exist!");
        }
    }
}
