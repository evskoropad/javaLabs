package org.university;

import org.university.controller.*;
import org.university.model.*;
import org.university.view.UniversityView;

public class Run {
    public static void main(String[] args) {
        University university = createTypicalUniversity();
        UniversityView view = new UniversityView();
        view.displayUniversity(university);
    }

    public static University createTypicalUniversity() {
        // Create university rector
        Human rector = new HumanCreator("John", "Smith", "William", Sex.MALE).create();

        // Create faculty dean
        Human dean = new HumanCreator("Michael", "Johnson", "Robert", Sex.MALE).create();

        // Create department head
        Human departmentHead = new HumanCreator("Sarah", "Davis", "Jane", Sex.FEMALE).create();

        // Create group curator
        Human groupCurator = new HumanCreator("David", "Wilson", "James", Sex.MALE).create();

        // Create students
        StudentCreator[] studentCreators = {
                new StudentCreator("Alice", "Brown", "Mary", Sex.FEMALE, "123-21-1"),
                new StudentCreator("Bob", "Taylor", "John", Sex.MALE, "122-22-4"),
                new StudentCreator("Charlie", "Anderson", "Thomas", Sex.MALE, "121-24-2")
        };


        // Create group
        GroupCreator groupCreator = new GroupCreator("CS-101", groupCurator, studentCreators);

        // Create department
        DepartmentCreator departmentCreator = new DepartmentCreator(
                "Computer Science",
                departmentHead,
                new GroupCreator[]{groupCreator}
        );

        // Create faculty
        FacultyCreator facultyCreator = new FacultyCreator(
                "Faculty of Science",
                dean,
                new DepartmentCreator[]{departmentCreator}
        );

        // Create university
        UniversityCreator universityCreator = new UniversityCreator(
                "National University",
                rector,
                new FacultyCreator[]{facultyCreator}
        );

        return universityCreator.create();


    }
}