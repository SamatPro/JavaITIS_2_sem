package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
