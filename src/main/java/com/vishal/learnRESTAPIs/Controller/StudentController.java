package com.vishal.learnRESTAPIs.Controller;

import com.vishal.learnRESTAPIs.DTO.AddStudentDto;
import com.vishal.learnRESTAPIs.DTO.StudentDto;
import com.vishal.learnRESTAPIs.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping ("/students")
    public ResponseEntity< List <StudentDto > > getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity< StudentDto > getStudentById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity< StudentDto > createNewStudent(@RequestBody @Valid AddStudentDto addStudentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity< Void > deleteStudent(@PathVariable("id") Long id){

        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    // to change entire object use PUT , FULL UPDATE
    // converse use PATCH, PARTIAL UPDATE

    @PutMapping("/students/{id}")
    public ResponseEntity< StudentDto > updateStudent( @PathVariable ("id") Long id, @RequestBody @Valid AddStudentDto addStudentDto){

        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id, addStudentDto));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity< StudentDto > updatePartialStudent(@PathVariable ("id") Long id, @RequestBody Map<String, Object> updates){

        return ResponseEntity.status(HttpStatus.OK).body(studentService.updatePartialStudent(id, updates));
    }
}
