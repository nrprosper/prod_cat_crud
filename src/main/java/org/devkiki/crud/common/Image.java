package org.devkiki.crud.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Image {
    @NotBlank(message = "Image url is required")
    private String url;
    @NotBlank(message = "Image public id is required")
    @JsonProperty("public_id")
    private String publicId;
}
