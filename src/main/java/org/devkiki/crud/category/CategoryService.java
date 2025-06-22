package org.devkiki.crud.category;

import lombok.RequiredArgsConstructor;
import org.devkiki.crud.common.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category create(CreateCategoryDto dto) {
        Category category = new Category();
        Image image = new Image();
        image.setUrl(dto.getImage().getUrl());
        image.setPublicId(dto.getImage().getPublicId());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        category.setImage(image);
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void delete(int id) {
        Category category = findById(id);
        categoryRepository.delete(category);
    }

}
