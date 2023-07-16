package com.example.spring_boot_security.controller;

import com.example.spring_boot_security.entity.Product;
import com.example.spring_boot_security.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/new")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "save_product";

    }

    @PostMapping("/save_product")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id ){
       Product product = productService.getProductById(id);
      productService.delete(product);
      return "redirect:/";
    }
    @GetMapping("/update_product/{id}")
    public String updateProduct(@PathVariable("id") Long id,Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("updateProduct",product);
        return "update_product";
    }
@PostMapping("/{id}")
    public String saveProductUpdate(@PathVariable("id") Long id,@ModelAttribute("updateProduct") Product product){
        productService.update(id,product);
        return "redirect:/";
    }

}
