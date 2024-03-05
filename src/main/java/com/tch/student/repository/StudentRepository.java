package com.tch.student.repository;

import com.tch.student.dto.StudentDto;
import com.tch.student.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepository   {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public StudentDto addStudent(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(studentDto.getStudentName());
        studentEntity.setStudentDept(studentDto.getStudentDept());
        studentEntity.setStudentDiv(studentDto.getStudentDiv());
        studentEntity=studentRepository.save(studentEntity);
        if(studentEntity!=null){
            studentDto = new StudentDto();
            studentDto.setStudentId(studentEntity.getStudentId());
            studentDto.setStudentName(studentEntity.getStudentName());
            studentDto.setStudentDept(studentEntity.getStudentDept());
            studentDto.setStudentDiv(studentEntity.getStudentDiv());
        }
        return studentDto;

    }
    @Override
    public List<StudentDto> getAllStudent(){
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto>   studentDtos = new ArrayList<>();
    }


}








