import java.util.LinkedList;
import java.util.Scanner;

public class CRUD_Subject_Management {
    LinkedList<CRUD_Subject> subject_list;

    public CRUD_Subject_Management() {
        subject_list = new LinkedList<>();
    }

    public int find(String subjectCode) {
        for (CRUD_Subject l : subject_list) {
            if (l.get_classCode().equalsIgnoreCase(subjectCode)) {
                // System.out.println(l);
                return 1;
            }
        }
        return 0;
    }

    public void addSubject(CRUD_Subject subject) {
        if (find(subject.get_classCode()) == 0) {
            subject_list.add(subject);
            System.out.println("\nAdd subject successfully!");
        } else {
            System.out.println("\nThe subject is exists!!!");
        }
    }

    public void deleteSubject(String classid) {
        for (CRUD_Subject l : subject_list) {
            if (l.get_classCode().equalsIgnoreCase(classid)) {
                if (l.getEnrolledStudents().isEmpty()) {
                    subject_list.remove(l);
                    System.out.println("\nDelete successfully!");
                    break;
                } else {
                    System.out.println("Subject cannot be deleted as students have joined.");
                    break;
                }
            }
        }
    }

    public void searchSubject(String classid) {
        if (find(classid) == 1) {
            for (CRUD_Subject l : subject_list) {
                if (l.get_classCode().equalsIgnoreCase(classid)) {
                    System.out.println("\nThe class id: " + l.get_classCode() + "\nThe subject name: "
                            + l.get_className() + "\nThe credit: " + l.get_credit() + "\nThe id students: ");
                    for (String id : l.getEnrolledStudents()) {
                        System.out.println(id + " ");
                    }
                }
            }
        } else {
            System.out.println("\nThe subject is not exists!!!");
        }
    }

    public void updateSubject(String classid) {
        Scanner sc = new Scanner(System.in);
        if (find(classid) == 1) {
            for (CRUD_Subject l : subject_list) {
                if (l.get_classCode().equalsIgnoreCase(classid)) {
                    String classname, class_id;
                    int credit;
                    System.out.println("\nEnter the class name: ");
                    classname = sc.nextLine();
                    System.out.println("\nEnter the class id: ");
                    class_id = sc.nextLine();
                    System.out.println("\nEnter the credit: ");
                    credit = sc.nextInt();
                    sc.nextLine();
                    l.set_classCode(class_id);
                    l.set_className(classname);
                    l.set_credit(credit);
                    System.out.println("\nUpdate successfully!");
                    break;
                }
            }
        } else {
            System.out.println("\nThe subject is not exists!!!");
        }
    }
    public void join_subject (String id, String classid)
    {
        for( CRUD_Subject l: subject_list)
        {
            if(l.get_classCode().equalsIgnoreCase(classid))
            {
                l.getEnrolledStudents().add(id);
                System.out.println("\nJoin class successfully!");
                break;

            }
        }
    }

    public void displaySubject() {
        boolean check = false;
        for (CRUD_Subject l : subject_list) {
            System.out.println("\nThe class id: " + l.get_classCode() + "\nThe subject name: "
                    + l.get_className() + "\nThe credit: " + l.get_credit() + "\nThe id students: ");
            check = true;
            for (String id : l.getEnrolledStudents()) {
                System.out.println(id + " ");
            }
            System.out.println("\n--------------------------------");
        }
        if (check == false) {
            System.out.println("\nThe subject list has no record!");
        }
    }

}
