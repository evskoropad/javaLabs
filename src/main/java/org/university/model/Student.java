package org.university.model;

import java.util.Objects;

public class Student extends Human {
    private String studentId;
    private String recordBookNumber;
    private String birthDate;

    public Student(String firstName, String lastName, String patronymic, Sex sex, String studentId, String recordBookNumber, String birthDate) {
        super(firstName, lastName, patronymic, sex);
        this.studentId = studentId;
        this.recordBookNumber = recordBookNumber;
        this.birthDate = birthDate;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getRecordBookNumber() { return recordBookNumber; }
    public void setRecordBookNumber(String recordBookNumber) { this.recordBookNumber = recordBookNumber; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId) &&
                recordBookNumber.equals(student.recordBookNumber) &&
                birthDate.equals(student.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId, recordBookNumber, birthDate);
    }
}