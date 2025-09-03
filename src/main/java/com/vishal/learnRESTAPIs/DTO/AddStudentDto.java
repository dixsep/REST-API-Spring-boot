package com.vishal.learnRESTAPIs.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class AddStudentDto {

    @NotBlank(message = "Name is Required")
    @Size(min = 4, max = 20, message = "Name should be of length from 4 to 20")
    private String name;


    @Email
    @NotBlank (message = "Email is Required")
    private String email;

    public AddStudentDto(){

    }

    public AddStudentDto(String name, String email){
        this.name  = name;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
