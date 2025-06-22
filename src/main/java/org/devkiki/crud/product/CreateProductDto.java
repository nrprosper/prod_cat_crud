package org.devkiki.crud.product;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.devkiki.crud.common.Image;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateProductDto {
    @NotEmpty(message = "Product name is required")
    private String name;
    @NotEmpty(message = "Product description is required")
    private String description;
    @NotEmpty(message = "Product sku is required")
    private String sku;
    @NotEmpty(message = "Product brand is required")
    private String brand;
    @NotNull(message = "Category id is required")
    private int categoryId;
    @Valid
    @NotEmpty(message = "At least on product image is required")
    private List<Image> images;
}
