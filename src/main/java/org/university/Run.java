package org.university;

import org.university.controller.*;
import org.university.model.*;

import org.university.view.UniversityView;

import java.io.IOException;


public class Run {
    public static void main(String[] args) {
        // Create a typical university and output it
        University university = createTypicalUniversity();
        UniversityView view = new UniversityView();
        view.displayUniversity(university);

        // Test JSON serialization
        UniversityJsonTest test = new UniversityJsonTest();
        try {
            test.testUniversityJsonSerialization(university); // Pass the university to the test
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
                new StudentCreator("Sasha", "TikTok", "Olegovna", Sex.FEMALE, "123-21-1", "RB1231", "2003-05-15"),
                new StudentCreator("Misha", "Bulkin", "Ilonovich", Sex.MALE, "123-21-2", "RB1232", "2004-08-22")
        };
        StudentCreator[] students2 = {
                new StudentCreator("Justin", "Biber", "Grigirovich", Sex.MALE, "122-21-1", "RB1224", "2003-03-10"),
                new StudentCreator("Max", "Pain", "MacCoffe", Sex.MALE, "122-21-2", "RB1212", "2003-11-05")
        };
        StudentCreator[] students3 = {
                new StudentCreator("Anna", "Kovalenko", "Viktorivna", Sex.FEMALE, "121-21-1", "RB1241", "2004-07-19"),
                new StudentCreator("Dmytro", "Shevchenko", "Petrovych", Sex.MALE, "121-21-2", "RB1242", "2004-09-30")
        };

        StudentCreator[] students4 = {
                new StudentCreator("Olena", "Moroz", "Ivanivna", Sex.FEMALE, "125-21-1", "RB1253", "2003-01-25"),
                new StudentCreator("Igor", "Pavlov", "Oleksandrovych", Sex.MALE, "125-21-2", "RB1254", "2003-12-12")
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