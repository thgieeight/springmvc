package com.inventory.invmgtsys.repo;

import com.inventory.invmgtsys.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RolesRepo extends JpaRepository<Roles,Integer> {
    @Query(value = "Select * from roles_tbl where name=:name",nativeQuery = true)
    Roles findRoleByName(String name);
  //  List<Map<String,String>> findEnabledRoles(Integer status);

    @Query(value = "select role_id,name from roles_tbl where status=:status", nativeQuery = true)
    List<Map<String,String>> findEnabledRoles(boolean status);

}