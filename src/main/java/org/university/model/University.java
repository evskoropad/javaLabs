package org.university.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University extends BaseUnit {
    private List<Faculty> faculties;

    public University(String name, Human head) {
        super(name, head);
        this.faculties = new ArrayList<>();
    }

    public List<Faculty> getFaculties() { return faculties; }
    public void addFaculty(Faculty faculty) { faculties.add(faculty); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        University university = (University) o;
        return faculties.equals(university.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculties);
    }
}