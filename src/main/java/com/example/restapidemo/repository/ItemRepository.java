package com.example.restapidemo.repository;

import com.example.restapidemo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository  {

    //extends JpaRepository<List<Item>, Integer>
}
