package com.tch.student.service.impl;

import com.tch.student.dto.StudentDto;
import com.tch.student.entity.StudentEntity;
import com.tch.student.repository.StudentRepository;
import com.tch.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public StudentDto addStudent(StudentDto studentDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(studentDto.getStudentName());
        studentEntity.setStudentAddress(studentDto.getStudentAddress());
        studentEntity.setStudentAge(studentDto.getStudentAge());
        studentEntity=studentRepository.save(studentEntity);
        if(studentEntity!=null){
            studentDto = new StudentDto();
            studentDto.setStudentId(studentEntity.getStudentId());
            studentDto.setStudentName(studentEntity.getStudentName());
            studentDto.setStudentAddress(studentEntity.getStudentAddress());
            studentDto.setStudentAge(studentEntity.getStudentAge());
        }
        return studentDto;

    }

    @Override
    public StudentDto  updateStudent(int studentId, StudentDto studentDto){
        StudentDto studentDtoDB = getStudent(studentId);
        if (studentDtoDB.getStudentId()!=null) {
            StudentEntity entity = new StudentEntity();
            entity.setStudentId(studentDto.getStudentId());
            entity.setStudentName(studentDto.getStudentName());
            entity.setStudentAddress(studentDto.getStudentAddress());
            entity.setStudentAge(studentDto.getStudentAge());
            studentRepository.save(entity);
        }
        return studentDto;

    }


    @Override
    public Boolean deleteStudent (int studentId){
        StudentDto studentDtoDB = getStudent(studentId);
        if (studentDtoDB!=null){
            studentRepository.deleteById(studentId);
            return true;
        }

        return false;
}

@Override
    public StudentDto getStudent (int studentId){
    Optional<StudentEntity>entity=studentRepository.findById(studentId);
    StudentEntity studentEntity=entity.get();
    StudentDto studentDto = new StudentDto();
    if (studentEntity!=null){
        studentDto.setStudentId(studentEntity.getStudentId());
        studentDto.setStudentName(studentEntity.getStudentName());
        studentDto.setStudentAddress(studentEntity.getStudentAddress());
        studentDto.setStudentAge(studentEntity.getStudentAge());
    }

    return studentDto;
}

@Override
    public List<StudentDto> getAllStudent(){
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity studentEntity:studentEntities){
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentId(studentEntity.getStudentId());
            studentDto.setStudentName(studentEntity.getStudentName());
            studentDto.setStudentAddress(studentEntity.getStudentAddress());
            studentDto.setStudentAge(studentEntity.getStudentAge());
            studentDtos.add(studentDto);
        }
        return studentDtos;
}
}
