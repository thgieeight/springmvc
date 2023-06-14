package com.inventory.invmgtsys.repo;

import com.inventory.invmgtsys.model.Sells;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellsRepo extends JpaRepository<Sells,Integer> {
}
