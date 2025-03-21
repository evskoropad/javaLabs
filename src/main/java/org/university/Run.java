package org.university;

import org.university.controller.*;
import org.university.model.*;

import org.university.view.UniversityView;
import java.io.IOException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        // Create a typical university and output it
        University university = createTypicalUniversity();
        UniversityView view = new UniversityView();
        view.displayUniversity(university);

        // Test JSON serialization
        UniversityJsonTest test = new UniversityJsonTest();
        try {
            test.testUniversityJsonSerialization(university); // Передаємо університет у тест
            System.out.println("University JSON serialization successful");
        } catch (IOException e) {
            System.out.println("Error test execution: " + e.getMessage());
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }

    public static University createTypicalUniversity() {
        // Create university rector
        Human rector = new HumanCreator("John", "Smith", "William", Sex.MALE).create();

        // Create faculty dean
        Human dean = new HumanCreator("Michael", "Johnson", "Robert", Sex.MALE).create();

        // Create department head
        Human departmentHead = new HumanCreator("Sarah", "Davis", "Jane", Sex.FEMALE).create();

        // Create group curator
        Human groupCurator = new HumanCreator("Oleksand", "Mineev", "Sergiyovich", Sex.MALE).create();

        // Create students
        StudentCreator[] students1 = {
                new StudentCreator("Sasha", "TikTok", "Olegovna", Sex.FEMALE, "123-21-1"),
                new StudentCreator("Misha", "Bulkin", "Ilonovich", Sex.MALE, "123-21-2")
        };
        StudentCreator[] students2 = {
                new StudentCreator("Justin", "Biber", "Grigirovich", Sex.MALE, "122-22-4"),
                new StudentCreator("Max", "Pain", "MacCoffe", Sex.MALE, "121-24-2")
        };
        StudentCreator[] students3 = {
                new StudentCreator("Anna", "Kovalenko", "Viktorivna", Sex.FEMALE, "124-23-1"),
                new StudentCreator("Dmytro", "Shevchenko", "Petrovych", Sex.MALE, "124-23-2")
        };

        StudentCreator[] students4 = {
                new StudentCreator("Olena", "Moroz", "Ivanivna", Sex.FEMALE, "125-24-3"),
                new StudentCreator("Igor", "Pavlov", "Oleksandrovych", Sex.MALE, "125-24-4")
        };
        // Create groups
        GroupCreator group1 = new GroupCreator("AdvancedJava", groupCurator, students1);
        GroupCreator group2 = new GroupCreator("BasicJava", groupCurator, students2);
        GroupCreator group3 = new GroupCreator("English", groupCurator, students3);
        GroupCreator group4 = new GroupCreator("Spanish", groupCurator, students4);

        // Create departments
        DepartmentCreator department1 = new DepartmentCreator(
                "Computer Science",
                departmentHead,
                new GroupCreator[]{group1, group2}
        );
        DepartmentCreator department2 = new DepartmentCreator(
                "Translators",
                departmentHead,
                new GroupCreator[]{group3, group4}
        );

        // Create faculty
        FacultyCreator faculty = new FacultyCreator(
                "Faculty of Science",
                dean,
                new DepartmentCreator[]{department1, department2}
        );

        // Create university
        UniversityCreator university = new UniversityCreator(
                "National University",
                rector,
                new FacultyCreator[]{faculty}
        );

        return university.create();
    }
}