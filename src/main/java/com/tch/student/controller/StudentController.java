package com.tch.student.controller;

import com.tch.student.dto.StudentDto;
import com.tch.student.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.OK);
    }

    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(value = "studentId") int studentDto)

    StudentDto dto = studentService.getStudent(studentId);
           if(studentDto ==null)

    {
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST),
    }

           return new ResponseEntity<>(studentService.deleteStudent(studentId,studentDto),HttpStatus.OK);
}
@DeleteMapping("/deleteStudent/{studentId}")
public ResponseEntity<StudentDto> getStudent(@PathVariable(value = "studentId") int studentDto)
    return new ResponseEntity<>(studentService.getStudent(studentId),HttpStatus.OK);
        }
  @GetMapping("/getStudens")
public ResponseEntity<StudentDto> getStudent(@PathVariable(value = "studentId") int studentDto)
      return new ResponseEntity<>(studentService.getStudent(studentId),HttpStatus.OK);
        }

  @GetMapping("/getStudents")
public ResponseEntity<List<StudentDto>> getAllStudent() {
      return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
  }



}
