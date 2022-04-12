package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
