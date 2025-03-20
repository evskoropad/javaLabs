package org.university.model;

import java.util.ArrayList;
import java.util.List;

public class Group extends BaseUnit {
    private List<Student> students;

    public Group(String name, Human head) {
        super(name, head);
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() { return students; }
    public void addStudent(Student student) { students.add(student); }
}