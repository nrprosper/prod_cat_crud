package org.devkiki.crud.category;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.devkiki.crud.common.Image;

@Data
@AllArgsConstructor
public class CreateCategoryDto {
    @NotEmpty(message = "Category name is required")
    private String name;
    private String description;
    @Valid
    @NotNull(message = "Image is required")
    private Image image;
}
