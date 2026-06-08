package com.example.dangky.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CandidateCreateDTO {

    @NotBlank(message = "Họ và tên không được để trống")
    @Size(min = 5, max = 50, message = "Họ và tên phải từ 5 đến 50 ký tự")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Tuổi phải từ 18 trở lên")
    private Integer age;

    @NotNull(message = "Số năm kinh nghiệm không được để trống")
    @Min(value = 0, message = "Số năm kinh nghiệm phải lớn hơn hoặc bằng 0")
    private Integer yearsOfExperience;

    // Default constructor
    public CandidateCreateDTO() {
    }

    // All-args constructor
    public CandidateCreateDTO(String fullName, String email, Integer age, Integer yearsOfExperience) {
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
