package com.lectorium.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private Integer idBook;

    @NotNull
    @Size(min = 3,  max = 100)
    private String titulo;

    @Size(max = 100)
    private String subtitulo;

    @Size(max = 250)
    private String description;

    @NotNull
    private Integer idCategory;

    @NotNull
    private Integer idPublisher;
}
