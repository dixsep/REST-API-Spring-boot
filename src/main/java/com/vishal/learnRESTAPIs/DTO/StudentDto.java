package com.vishal.learnRESTAPIs.DTO;

import lombok.Data;

@Data
public class StudentDto {

    private Long id;
    private String name;
    private String email;


    public StudentDto() {

    }

    public StudentDto(Long id, String name, String email){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // use lombok Data to replace boiler plate code.
}
