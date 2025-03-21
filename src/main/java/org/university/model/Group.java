package org.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group extends BaseUnit {
    private List<Student> students;

    public Group(String name, Human head) {
        super(name, head);
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() { return students; }
    public void addStudent(Student student) { students.add(student); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Group group = (Group) o;
        return students.equals(group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), students);
    }
}