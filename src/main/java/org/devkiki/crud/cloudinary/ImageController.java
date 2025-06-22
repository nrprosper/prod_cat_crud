package org.devkiki.crud.cloudinary;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@Tag(name = "Image Controller", description = "Upload Images and delete endpoints - Backed by Cloudinary")
@RequestMapping(value = "/api/v1", consumes = "multipart/form-data")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService service;

    @Operation(summary = "Upload Images")
    @PostMapping("/upload")
    public CompletableFuture<ResponseEntity<List<Map<String, String>>>> uploadImage(
            @Parameter(
                    description = "Images to upload",
                    content = @Content(
                            mediaType = "multipart/form-data",
                            schema = @Schema(type = "array", format = "binary")
                    )
            )
            @RequestPart("files") MultipartFile[] files
    ) {
        return service.upload(files, "product_commerce")
                .thenApply(ResponseEntity::ok);
    }

    @Operation(summary = "Delete images using cloudinary public ids")
    @DeleteMapping("/delete")
    public CompletableFuture<ResponseEntity<Void>> deleteImage(@RequestBody List<String> publicIds) {
        return service.delete(publicIds, "product_commerce")
                .thenApply(v -> ResponseEntity.noContent().build());
    }

}
