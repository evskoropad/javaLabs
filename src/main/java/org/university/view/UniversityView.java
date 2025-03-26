package org.university.view;

import org.university.model.*;

public class UniversityView {
    public void displayUniversity(University university) {
        System.out.println("University: " + university.getName());
        System.out.println("Rector: " + getHumanName(university.getHead()));

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("  Faculty: " + faculty.getName());
            System.out.println("  Dean: " + getHumanName(faculty.getHead()));

            for (Department department : faculty.getDepartments()) {
                System.out.println("    Department: " + department.getName());
                System.out.println("    Head: " + getHumanName(department.getHead()));

                for (Group group : department.getGroups()) {
                    System.out.println("      Group: " + group.getName());
                    System.out.println("      Curator: " + getHumanName(group.getHead()));

                    for (Student student : group.getStudents()) {
                        System.out.println("        Student: " + getHumanName(student) +
                                " (ID: " + student.getStudentId() +
                                ", Record Book: " + student.getRecordBookNumber() +
                                ", Birth Date: " + student.getBirthDate() + ")");
                    }
                }
            }
        }
    }

    private String getHumanName(Human human) {
        return human.getFirstName() + " " + human.getLastName() + " " + human.getPatronymic();
    }
}