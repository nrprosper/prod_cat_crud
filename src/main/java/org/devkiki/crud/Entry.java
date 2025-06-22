package org.devkiki.crud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Entry {
    @GetMapping
    public String hello() {
        return "Welcome to crud API Testing - Render instance";
    }
}
