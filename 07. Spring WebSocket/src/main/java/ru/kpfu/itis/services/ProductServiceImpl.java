package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dtos.ProductDto;
import ru.kpfu.itis.models.Product;
import ru.kpfu.itis.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(ProductDto productDto) {
        Product product = Product.builder()
                .title(productDto.getTitle())
                .description(productDto.getDescription())
                .cost(productDto.getCost())
                .build();
        return productRepository.save(product);
    }
}
