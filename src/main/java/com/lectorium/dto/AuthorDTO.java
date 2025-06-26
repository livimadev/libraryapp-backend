package com.lectorium.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Integer idAuthor;

    @NotNull
    @Size(max=60)
    private String lastName;

    @NotNull
    @Size(max=60)
    private String firstName;

    private LocalDate birthdate;

    @NotNull
    @Size(max=100)
    private String placeBirthdate;
}
