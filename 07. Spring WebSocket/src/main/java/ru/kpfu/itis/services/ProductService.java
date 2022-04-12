package ru.kpfu.itis.services;

import ru.kpfu.itis.dtos.ProductDto;
import ru.kpfu.itis.models.Product;

public interface ProductService {
    Product addProduct(ProductDto productDto);
}
