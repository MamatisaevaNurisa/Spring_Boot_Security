package com.example.spring_boot_security.service;

import com.example.spring_boot_security.entity.Product;
import com.example.spring_boot_security.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public void save(Product product){
        productRepository.save(product);
    }
public void delete(Product product){
        productRepository.delete(product);
}
    public Product getProductById(Long id){
        return productRepository.findById(id).get();
    }

public void update(Long id,Product product){
        Product product1 = productRepository.getById(id);
        product1.setName(product.getName());
        product1.setBrand(product.getBrand());
        productRepository.save(product1);
}


}
