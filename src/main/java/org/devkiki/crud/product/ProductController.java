package org.devkiki.crud.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Products Controller", description = "Endpoints to manage products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Endpoint to get all paginated products")
    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam (defaultValue = "1", required = false) int page,
            @RequestParam (defaultValue = "10", required = false) int size
    ) {
        int springPage = page - 1;
        Pageable pageable = PageRequest.of(springPage, size);
        var products = productService.getPaginatedProducts(pageable);
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Endpoint to create a new product")
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody CreateProductDto dto) {
        var product = productService.createProduct(dto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @Operation(summary = "Get product by Id")
    @GetMapping
    public ResponseEntity<Product> getProductById(@RequestParam Long id) {
        var product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Delete a product")
    @DeleteMapping
    public ResponseEntity<?> deleteProductById(@RequestParam Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

}
