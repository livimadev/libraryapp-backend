package com.lectorium.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
    private Integer idPublisher;

    @NotNull
    // @NotBlank
    // @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    @Size(min = 3, max = 150)
    private String address;

    /*@Min(value=0)
    @Max(value=100)
    private int age;*/

    /*@NotNull
    @Pattern(regexp = "[0-9]+")
    private String phone;
     */
}
