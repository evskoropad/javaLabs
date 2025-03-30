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
        Human rector = new HumanCreator("John", "Smith", "Grigorivich", Sex.MALE).create();

        // Create faculty dean
        Human dean = new HumanCreator("Michael", "Johnson", "Abob", Sex.MALE).create();

        // Create department head
        Human departmentHead = new HumanCreator("Sarah", "Bobrova", "Sergeyevich", Sex.FEMALE).create();

        // Create group curator
        Human groupCurator = new HumanCreator("David", "Babrash", "Olegocich", Sex.MALE).create();

        // Create students
        StudentCreator[] studentCreators = {
                new StudentCreator("Alice", "Brown", "", Sex.FEMALE, "25"),
                new StudentCreator("Bob", "Taylor", "", Sex.MALE, "3"),
                new StudentCreator("Charlie", "Anderson", "", Sex.MALE, "4")
        };


        // Create group
        GroupCreator groupCreator = new GroupCreator("123-21-1", groupCurator, studentCreators);

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
