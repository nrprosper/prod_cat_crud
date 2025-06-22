package org.devkiki.crud.product;

import lombok.RequiredArgsConstructor;
import org.devkiki.crud.category.Category;
import org.devkiki.crud.category.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product createProduct(CreateProductDto dto) {
        Product product = new Product();
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setSku(dto.getSku());
        product.setBrand(dto.getBrand());
        product.setCategory(category);
        product.getImages().addAll(dto.getImages());
        return productRepository.save(product);
    }

    public Page<Product> getPaginatedProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

}
