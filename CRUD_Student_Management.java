import java.util.LinkedList;
import java.util.Scanner;

public class CRUD_Student_Management extends MainSystem {
    LinkedList<CRUD_Student> list;

    public CRUD_Student_Management() {
        list = new LinkedList<>();
    }

    public void add(CRUD_Student student) {
        if (find(student.getID_Student()) == 0) {
            list.add(student);
            System.out.println("\nAdd successfully!");
        } else {
            System.out.println("\nStudent already exits");
        }
    }

    public int find(String idNumber) {
        for (CRUD_Student l : list) {
            if (l.getID_Student().equalsIgnoreCase(idNumber)) {
                // System.out.println(l);
                return 1;
            }
        }
        return 0;
    }

    public void delete(String idNumber) {
        int flag = 0;
        for (CRUD_Student l : list) {
            if (l.getID_Student().equalsIgnoreCase(idNumber)) {
                flag = 1;
                if (l.getIsGrade() == true) {
                    System.out.println("Cannot delete student because he/she is in a class!");
                } else {
                    System.out.println("Delete successfully!");
                    list.remove(l);
                }
                break;
            }
        }
        if (flag == 0) {
            System.out.println("\nStudent donot exist!");
        }
    }

    public void searchStudent(String idNumber) {
        int flag = 0;
        for (CRUD_Student record : list) {
            if (record.getID_Student().equalsIgnoreCase(idNumber)) {
                flag = 1;
                System.out.println("NAME: " + record.getName());
                System.out.println("ID: " + record.getID_Student());
                System.out.println("PHONE NUMBER: " + record.getphoneNumber());
                System.out.println("EMAIL: " + record.getEmail());
                System.out.println("GRADE: " + record.getGrade());
                System.out.println("IN GRADE: " + record.getIsGrade());
                System.out.println("DAY OF BIRTH: " + record.getdayOfbirth());

                break;
            }
        }
        if (flag == 0) {
            System.out.println("\nStudent donot exist!");
        }
    }

    public void updateStudent(String tmp_id) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("\nStudent ID:  ");
        int flag = 0;
        for (CRUD_Student l : list) {
            if (l.getID_Student().equalsIgnoreCase(tmp_id)) {
                String name, id, number, mail, gr, date;
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
                System.out.println("\n6. Day of Birth(dd/mm/yy): ");
                date = inputdayOfbirth();
                //
                flag = 1;
                l.setName(name);
                l.setID_Student(id);
                l.setEmail(mail);
                l.setGrade(gr);
                l.setPhoneNumber(number);
                l.setIsGrade(!gr.isEmpty());
                l.setdayOfbirth(date);
                System.out.println("Update successfully!");
                break;
            }
        }
        if (flag == 0) {
            System.out.println("\nStudent donot exist!");
        }
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("The list has no records\n");
        }
        for (CRUD_Student record : list) {

            System.out.println("NAME: " + record.getName());
            System.out.println("ID: " + record.getID_Student());
            System.out.println("PHONE NUMBER: " + record.getphoneNumber());
            System.out.println("EMAIL: " + record.getEmail());
            System.out.println("GRADE: " + record.getGrade());
            System.out.println("IN GRADE: " + record.getIsGrade());
            System.out.println("DAY OF BIRTH: " + record.getdayOfbirth());
            System.out.println("----------------------------------------\n");
        }
    }
}
