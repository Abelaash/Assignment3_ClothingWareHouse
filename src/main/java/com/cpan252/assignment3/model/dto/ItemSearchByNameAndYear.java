package com.cpan252.assignment3.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//What is DTO: DTO is a Data Transfer Object.
// It is a simple object that is used to transfer data between application layers.
// In our case we will need to populate this object with data from the form
public class ItemSearchByNameAndYear {
    @NotBlank
    private String brand;

    public String getBrand() {
        return brand;
    }
}