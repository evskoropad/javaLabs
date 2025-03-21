package org.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty extends BaseUnit {
    private List<Department> departments;

    public Faculty(String name, Human head) {
        super(name, head);
        this.departments = new ArrayList<>();
    }

    public List<Department> getDepartments() { return departments; }
    public void addDepartment(Department department) { departments.add(department); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Faculty faculty = (Faculty) o;
        return departments.equals(faculty.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departments);
    }
}