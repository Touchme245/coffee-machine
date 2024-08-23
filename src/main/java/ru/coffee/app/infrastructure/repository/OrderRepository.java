package ru.coffee.app.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.coffee.app.domain.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o.coffeeName, COUNT(o) as orderCount FROM Order o GROUP BY o.coffeeName ORDER BY orderCount DESC LIMIT 1")
    List<Object[]> findMostPopularCoffee();
}
