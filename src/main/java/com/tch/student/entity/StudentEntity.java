package com.tch.student.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class StudentEntity {
    @Id
    @Column(name = "student_id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String studentId;

    @Column(name = "student_name" )
    String studentName;
    @Column(name = "student_age")
    String studentAge;
    @Column(name = "student_gender")
    String studentGender;
    @Column(name = "student_address")
    String studentAddress;

    public StudentEntity() {
    }

    public StudentEntity(String studentId, String studentName, String studentAge, String studentGender, String studentAddress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentAddress = studentAddress;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
}




