package com.tch.student.controller;

import com.tch.student.dto.StudentDto;
import com.tch.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class
StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable (value = "studentId") int studentId, @RequestBody StudentDto studentDto) {

        StudentDto dto = studentService.getStudent(studentId);
        if (studentDto == null) {
            return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(studentService.updateStudent(studentId, studentDto), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable(value = "studentId") int studentId) {
        return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/getStudent/{studentId}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable(value = "studentId") int studentId) {

        return new ResponseEntity<>(studentService.getStudent(studentId), HttpStatus.OK);
    }
    @GetMapping("/getStudents")
    public ResponseEntity< List<StudentDto> > getStudent(){

        return new ResponseEntity<>(studentService.getAllStudent(),HttpStatus.OK);
    }
}

















