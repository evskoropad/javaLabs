package org.university.model;

import java.util.ArrayList;
import java.util.List;

public class University extends BaseUnit {
    private List<Faculty> faculties;

    public University(String name, Human head) {
        super(name, head);
        this.faculties = new ArrayList<>();
    }

    public List<Faculty> getFaculties() { return faculties; }
    public void addFaculty(Faculty faculty) { faculties.add(faculty); }
}