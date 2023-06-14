package com.inventory.invmgtsys.repo;

import com.inventory.invmgtsys.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;


public interface CategoryRepo extends JpaRepository <Category,Integer> {
    @Query(value = "select category_id,category_name from category_tbl where status=:status", nativeQuery = true)
    List<Map<String,String>> findEnabledCategory(Integer status);
}
