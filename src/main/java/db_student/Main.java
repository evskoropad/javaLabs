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
            System.out.println("Введіть номер місяця (1-12) або 0 для виходу:");
            int month = scanner.nextInt();

            if (month == 0) break;
            if (month < 1 || month > 12) {
                System.out.println("Неправильний номер місяця!");
                continue;
            }

            List<Student> students = service.getStudentsByMonth(month);
            if (students.isEmpty()) {
                System.out.println("Студентів, що народилися в цьому місяці, не знайдено.");
            } else {
                System.out.println("Знайдені студенти:");
                students.forEach(System.out::println);
            }
        }
        scanner.close();
    }
}