package org.devkiki.crud.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.devkiki.crud.category.Category;
import org.devkiki.crud.common.Image;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String slug;
    @Column(unique = true, nullable = false)
    private String sku;
    private String brand;
    private String description;
    @ElementCollection
    private List<Image> images;

    @ManyToOne
    private Category category;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
