package org.university.controller;

import org.university.model.Faculty;
import org.university.model.Human;

public class FacultyCreator implements Creator<Faculty> {
    private String name;
    private Human head;
    private DepartmentCreator[] departmentCreators;

    public FacultyCreator(String name, Human head, DepartmentCreator[] departmentCreators) {
        this.name = name;
        this.head = head;
        this.departmentCreators = departmentCreators;
    }

    @Override
    public Faculty create() {
        Faculty faculty = new Faculty(name, head);
        for (DepartmentCreator creator : departmentCreators) {
            faculty.addDepartment(creator.create());
        }
        return faculty;
    }
}