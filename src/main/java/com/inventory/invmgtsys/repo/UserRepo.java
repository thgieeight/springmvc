package com.inventory.invmgtsys.repo;

import com.inventory.invmgtsys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value="SELECT * FROM inventory_user_tbl u WHERE u.username = :username",nativeQuery = true)
    public User getInventoryUserByUsername(@Param("username") String username);

    @Query(value = "select * from inventory_user_tbl u where u.username=?1 and u.enabled=true ", nativeQuery = true)
    User findInventoryUserByUsername(String username);
}