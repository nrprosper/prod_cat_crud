package org.devkiki.crud.category;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.devkiki.crud.common.Image;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @Embedded
    private Image image;
}
