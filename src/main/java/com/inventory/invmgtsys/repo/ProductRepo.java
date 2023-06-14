package com.inventory.invmgtsys.repo;

import com.inventory.invmgtsys.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query(value = "select product_id,product_name from product_tbl where status=:status", nativeQuery = true)
    List<Map<String,String>> findEnabledProduct(Integer status);
}
