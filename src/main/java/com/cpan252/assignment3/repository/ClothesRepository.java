package com.cpan252.assignment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.cpan252.assignment3.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.brand LIKE :brand% AND i.year_of_creation = :year")
    List<Item> findByBrandStartsWithAndYear(@Param("brand") String brand, @Param("year") int year_of_creation);

}
