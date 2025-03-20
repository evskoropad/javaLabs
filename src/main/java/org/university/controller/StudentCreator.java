package org.university.controller;

import org.university.model.Sex;
import org.university.model.Student;

public class StudentCreator implements Creator<Student> {
    private String firstName;
    private String lastName;
    private String patronymic;
    private Sex sex;
    private String studentId;

    public StudentCreator(String firstName, String lastName, String patronymic, Sex sex, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.sex = sex;
        this.studentId = studentId;
    }

    @Override
    public Student create() {
        return new Student(firstName, lastName, patronymic, sex, studentId);
    }
}