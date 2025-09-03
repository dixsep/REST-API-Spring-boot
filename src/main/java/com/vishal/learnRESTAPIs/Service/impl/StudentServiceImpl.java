package com.vishal.learnRESTAPIs.Service.impl;

import com.vishal.learnRESTAPIs.DTO.AddStudentDto;
import com.vishal.learnRESTAPIs.DTO.StudentDto;
import com.vishal.learnRESTAPIs.Entity.Student;
import com.vishal.learnRESTAPIs.Repository.StudentRepository;
import com.vishal.learnRESTAPIs.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDto> getAllStudents() {

        List< Student > students = studentRepository.findAll();
        List< StudentDto > studentDtoList = students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();


        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id) {

       // exception requires No args constructor
       Student student  = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found with Id : " + id));
       StudentDto studentDto = new StudentDto(student.getId(), student.getName(), student.getEmail());

       return studentDto;
    }

    @Override
    public StudentDto createNewStudent(AddStudentDto addStudentDto) {

        Student newStudent = new Student();
        newStudent.setName(addStudentDto.getName());
        newStudent.setEmail(addStudentDto.getEmail());
        Student student = studentRepository.save(newStudent);
        return new StudentDto(student.getId(), student.getName(), student.getEmail());
    }

    @Override
    public void deleteStudentById(Long id) {

        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Student doesnot exist by id: " + id);
        }
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentDto addStudentDto) {

        Student student  = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found with Id : " + id));

        //update
        student.setName(addStudentDto.getName());
        student.setEmail(addStudentDto.getEmail());

        student = studentRepository.save(student);
        return new StudentDto(student.getId(), student.getName(), student.getEmail());
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {

        Student student  = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found with Id : " + id));

        updates.forEach((field, value) -> {
            switch (field){
                case "name" : student.setName((String) value);
                case "email" : student.setEmail((String) value);
                default: throw new IllegalArgumentException("Field is not supported");
            }
        });

        Student savedStudent = studentRepository.save(student);
        return new StudentDto(savedStudent.getId(), savedStudent.getName(), savedStudent.getEmail());
    }

}
