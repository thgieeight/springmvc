package com.inventory.invmgtsys.repo;

import com.inventory.invmgtsys.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
    @Query(value = "select inventory_id,inventory_name from inventory_tbl where status=:status", nativeQuery = true)
    List<Map<String,String>> findEnabledProduct(Integer status);
}