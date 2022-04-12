package ru.kpfu.itis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.dtos.ProductDto;
import ru.kpfu.itis.enums.Role;
import ru.kpfu.itis.services.ProductService;

@Controller
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping(value = "/products")
    @Secured({"ROLE_SHOP"})
    public String productAddPage() {
        return "productAddPage";
    }

    @PostMapping( value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addProduct(@RequestBody() ProductDto productDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(productService.addProduct(productDto));
    }
}
