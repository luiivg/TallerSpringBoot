package com.lab.wishlist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductRepositoty productRepositoty;

    public ProductsController(ProductRepositoty productRepositoty) {
        this.productRepositoty = productRepositoty;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product newProduct = productRepositoty.save(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = (List<Product>) productRepositoty.findAll();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        return productRepositoty.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        Product newProduct = productRepositoty.save(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productRepositoty.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
