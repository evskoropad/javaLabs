package org.university.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends BaseUnit {
    private List<Department> departments;

    public Faculty(String name, Human head) {
        super(name, head);
        this.departments = new ArrayList<>();
    }

    public List<Department> getDepartments() { return departments; }
    public void addDepartment(Department department) { departments.add(department); }
}