package db_student;

import db_student.model.Student;
import db_student.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("Enter month number (1-12) or 0 to exit:");
            int month = scanner.nextInt();

            if (month == 0) break;
            if (month < 1 || month > 12) {
                System.out.println("Wrong month number!");
                continue;
            }

            List<Student> students = service.getStudentsByMonth(month);
            if (students.isEmpty()) {
                System.out.println("No students born in this month have been found.");
            } else {
                System.out.println("Known students:");
                students.forEach(System.out::println);
            }
        }
        scanner.close();
    }
}