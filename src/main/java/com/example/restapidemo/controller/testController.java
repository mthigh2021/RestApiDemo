package com.example.restapidemo.controller;


import com.example.restapidemo.model.Item;
import com.example.restapidemo.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class testController {

    private ItemService ItemService;

    //Simple helloWorld String api example
    @GetMapping("/v1/hello")
    public String hello(){
        return "hello From Other side";
    }

    //getting userCreated object  as json api example
    @GetMapping("/v1/item")
    public List<Item> getItem(ItemService itemService){
        this.ItemService = itemService;
        List list = new ArrayList<>();
         Item I1= new Item();
         I1.setId(1);
        I1.setItem_name("Pencil");
        I1.setPrice(120);
        I1.setDescription("Black Graphite carbonCoal");
        list.add(I1);
        
        Item I2 = new Item();
        I2.setId(2);
        I2.setItem_name("Calculator");
        I2.setPrice(100);
        I2.setDescription("Casio Grey Scientific Calculator");
        list.add(I2);

        return list;

    }

}
