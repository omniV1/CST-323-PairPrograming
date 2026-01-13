package com.gcu.data;

import org.springframework.data.repository.CrudRepository;
import com.gcu.models.OrderEntity;

public interface OrdersRepository extends CrudRepository<OrderEntity, Integer> {
    // CrudRepository provides basic CRUD operations
    // No additional methods needed for this implementation
}
