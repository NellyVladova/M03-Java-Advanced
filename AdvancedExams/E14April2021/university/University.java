package JavaAdvanced.AdvancedExams.E14April2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (getStudentCount() < this.capacity) {
            if (!this.students.contains(student)) {
                this.students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the university";
            }
        }
        return "No seats in the university";
    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        Student studentToReturn = null;
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                studentToReturn = student;
            }
        }
        return studentToReturn;
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : this.students) {
            stringBuilder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject())).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
