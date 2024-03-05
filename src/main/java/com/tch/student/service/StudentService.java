package com.tch.student.service;

import com.tch.student.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(StudentDto studentDto);

    StudentDto updateStudent(int studentId, StudentDto studentDto);

    Boolean deleteStudent(int studentId);

    StudentDto getStudent(int studentId);

    List<StudentDto> getAllStudent();
}
