package com.vishal.learnRESTAPIs.Service;

import com.vishal.learnRESTAPIs.DTO.AddStudentDto;
import com.vishal.learnRESTAPIs.DTO.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentDto addStudentDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentDto addStudentDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
