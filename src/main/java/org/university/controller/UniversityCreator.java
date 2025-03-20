package org.university.controller;

import org.university.model.University;
import org.university.model.Human;

public class UniversityCreator implements Creator<University> {
    private String name;
    private Human head;
    private FacultyCreator[] facultyCreators;

    public UniversityCreator(String name, Human head, FacultyCreator[] facultyCreators) {
        this.name = name;
        this.head = head;
        this.facultyCreators = facultyCreators;
    }

    @Override
    public University create() {
        University university = new University(name, head);
        for (FacultyCreator creator : facultyCreators) {
            university.addFaculty(creator.create());
        }
        return university;
    }
}