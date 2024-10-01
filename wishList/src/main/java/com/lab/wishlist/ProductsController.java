package com.lab.wishlist;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository productRepository;
    private static final String REDIRECT_PRODUCTS = "redirect:/products";

    public ProductsController(ProductRepository productRepositoty) {
        this.productRepository = productRepositoty;
    }

    @GetMapping("/create")
    public String showFormCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "products/newEditProduct";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return REDIRECT_PRODUCTS;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products/listProduct";
    }


    @GetMapping("/edit/{id}")
    public String showFormUpdateProduct(@PathVariable Long id, Model model) {
        Product newProduct = productRepository.findById(id)
                        .orElseThrow(()-> new IllegalArgumentException("ID de producto inválido: " + id));
        model.addAttribute("product", newProduct);
        return "products/newEditProduct";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productRepository.save(product);
        return REDIRECT_PRODUCTS;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return REDIRECT_PRODUCTS;
    }
}
