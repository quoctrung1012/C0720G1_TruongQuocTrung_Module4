package com.codegym.entity;

import com.codegym.commons.BirthOfDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Please input not empty")
    @Size(min = 1, max = 20,message = "Please input firstName 1-20 character")
    private String firstName;
    @NotBlank(message = "Please input not empty")
    @Size(min = 1, max = 20,message = "Please input lastName 1-20 character")
    private String lastName;
    @NotBlank(message = "Please input not empty")
    @Size(min = 10, max = 11,message = "Please input phoneNumber 10-11 character numeric")
    @Pattern(regexp = "^(090|091)\\d{7}$", message = "Please input phoneNumber start 090 or 091")
    private String phoneNumber;
    @NotBlank(message = "Please input not empty")
    @BirthOfDate
    private String dateOfBirth;
}
