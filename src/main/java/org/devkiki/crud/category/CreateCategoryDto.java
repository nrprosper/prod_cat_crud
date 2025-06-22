package org.devkiki.crud.category;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCategoryDto {
    @NotEmpty(message = "Category name is required")
    private String name;
    private String description;
    @NotEmpty(message = "Image url is required")
    private String imageUrl;
    @NotEmpty(message = "Image public id is required")
    private String imagePublicId;
}
