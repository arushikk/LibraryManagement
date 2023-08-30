package com.example.LibraryManagement.Request;

import com.example.LibraryManagement.Model.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateRequest {

    @NotBlank
    private String name ;
    @NotBlank
    private String contact ;

    private String address ;

    private String email ;


    @NotNull
    private Genre genre;

    //conv to book obj

    public Student to (){
        return Student.builder()
                .name(this.name)
                .contact(this.contact)
                .email(this.email)
                .address(this.address)
                .accountStatus(AccountStatus.ACTIVE)
                .build();

    }
}
