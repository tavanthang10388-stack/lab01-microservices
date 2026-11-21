package com.example.product_service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public List<Map<String, Object>> getProducts() {
        return List.of(
                Map.of("id", 1, "name", "Mouse", "price", 150000),
                Map.of("id", 2, "name", "Keyboard", "price", 250000),
                Map.of("id", 3, "name", "Monitor", "price", 2500000)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getProduct(@PathVariable int id) {
        List<Map<String, Object>> products = List.of(
                Map.of("id", 1, "name", "Mouse", "price", 150000),
                Map.of("id", 2, "name", "Keyboard", "price", 250000),
                Map.of("id", 3, "name", "Monitor", "price", 2500000)
        );
        return products.stream()
                .filter(p -> p.get("id").equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
