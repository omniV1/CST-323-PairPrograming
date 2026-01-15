
package com.gcu.data;
import org.springframework.data.repository.CrudRepository;
import com.gcu.models.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Integer> {
    // CrudRepository provides basic CRUD operations
    // Custom query method to find user by username
    UserEntity findByUsername(String username);
    
}
