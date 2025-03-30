package db_student.service;

import db_student.db.DatabaseConnection;
import db_student.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> allStudents;

    public StudentService() {
        this.allStudents = fetchAllStudents();
    }

    public List<Student> getStudentsByMonth(int month) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getBirthDate().getMonthValue() == month) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

    private List<Student> fetchAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT id, last_name, first_name, middle_name, birth_date, record_book_number FROM students_info";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getString("record_book_number")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}