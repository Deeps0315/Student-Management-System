package SmartStudent;
import java.util.*;

public class UI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Administrator Login
        if (!AdminService.loginPrompt(sc)) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }

        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Roll No: ");
                    String roll = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    Student s = new Student(0, name, roll, dept, email, phone, marks);
                    if (dao.addStudent(s)) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Failed to add student.");
                    }
                    break;

                case 2:
                    List<Student> list = dao.getAllStudents();
                    System.out.printf("\n%-5s %-20s %-10s %-15s %-25s %-15s %-6s\n",
                            "ID", "Name", "Roll", "Dept", "Email", "Phone", "Marks");
                    for (Student st : list) {
                        System.out.printf("%-5d %-20s %-10s %-15s %-25s %-15s %-6.2f\n",
                                st.getId(), st.getName(), st.getRollNo(), st.getDepartment(),
                                st.getEmail(), st.getPhone(), st.getMarks());
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to update: ");
                    String upRoll = sc.nextLine();
                    Student existing = dao.searchStudentByRollNo(upRoll);
                    if (existing != null) {
                        System.out.print("New Name: ");
                        existing.setName(sc.nextLine());
                        System.out.print("New Department: ");
                        existing.setDepartment(sc.nextLine());
                        System.out.print("New Email: ");
                        existing.setEmail(sc.nextLine());
                        System.out.print("New Phone: ");
                        existing.setPhone(sc.nextLine());
                        System.out.print("New Marks: ");
                        existing.setMarks(sc.nextDouble());

                        if (dao.updateStudent(existing)) {
                            System.out.println("Student updated successfully.");
                        } else {
                            System.out.println("Update failed.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    String delRoll = sc.nextLine();
                    if (dao.deleteStudent(delRoll)) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Deletion failed.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    String srRoll = sc.nextLine();
                    Student found = dao.searchStudentByRollNo(srRoll);
                    if (found != null) {
                        System.out.println("Student Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
