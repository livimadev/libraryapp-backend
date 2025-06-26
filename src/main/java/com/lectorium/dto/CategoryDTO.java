package com.lectorium.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Integer idCategory;

    @NotNull
    @Size(min = 3, max = 200)
    private String name;

    @NotNull
    @Size(min = 3, max = 200)
    private String description;
}
