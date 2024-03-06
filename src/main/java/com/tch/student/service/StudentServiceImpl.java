package com.tch.student.service;

import com.tch.student.dto.StudentDto;
import com.tch.student.entity.StudentEntity;
import com.tch.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

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
    public StudentDto  updateStudent(int studentId, StudentDto studentDto){
        StudentDto studentDtoDB = getStudent(studentId);
        if (studentDtoDB.getStudentId()!=null) {
            StudentEntity entity = new StudentEntity();
            entity.setStudentId(StudentDto.getStudentId());
            entity.setStudentName(StudentDto.getStudentName());
            entity.setStudentDept(StudentDto.getStudentDept());
            entity.setStudentDiv(StudentDto.getStudentDiv());
            studentRepository.save(entity);
        }
        return studentDto;

    }


    @Override
    public Boolean deleteStudent (int StudentId){
        StudentDto studentDtoDB = getStudent(studentId);
        if (studentDtoDB!=null){
            studentRepository.deleteById(studentId);
            return true;
        }

        return false;
}

@Override
    public StudentDto getStudent (int studentId){
    Optional<StudentEntity>entity=studentRepository.findById(StudentId);
    StudentEntity studentEntity=entity.get();
    StudentDto studentDto = new StudentDto();
    if (studentEntity!=null){
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(studentEntity.getStudentId());
        studentDto.setStudentName(studentEntity.getStudentName());
        studentDto.setStudentDept(studentEntity.getStudentDept());
        studentDto.setStudentDiv(studentEntity.getStudentDiv());
    }

    return studentDto;
}

@Override
    public List<StudentDto> getAllStudent(){
        List<StudentEntity> studentEntities = studentRepository.FindByAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity studentEntity:studentEntities){
            StudentDto studentDto = new StudentDto();
            studentDto.setStudentId(studentEntity.getStudentId());
            studentDto.setStudentName(studentEntity.getStudentName());
            studentDto.setStudentDept(studentEntity.getStudentDept());
            studentDto.setStudentDiv(studentEntity.getStudentDiv());
            studentDtos.add(studentDto);
        }
        return studentDtos;
}
}
