package com.example.restapidemo.controller;


import com.example.restapidemo.model.Item;
import com.example.restapidemo.model.User;
import com.example.restapidemo.service.ItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping("/api")
public class testController {

    private ItemService ItemService;

    //Simple helloWorld String api example
    @GetMapping("/v1/hello")
    public String hello() {
        return "hello From Other side";
    }

    //getting userCreated object  as json api example
    @GetMapping("/v1/item")
    public List<Item> getItem(ItemService itemService) {
        this.ItemService = itemService;
        List list = new ArrayList<>();
        Item I1 = new Item();
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


    //api call from url :https://jsonplaceholder.typicode.com/users
    //Using HttpURLConnection

    @GetMapping("/v1/usernode")
    public ResponseEntity<?> showUsers() throws IOException {

        User user = new User();
        // Create a neat value object to hold the URL
        URL url = new URL("https://jsonplaceholder.typicode.com/users");

// Open a connection(?) on the URL(??) and cast the response(???)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Now it's "open", we can set the request method, headers etc.
        connection.setRequestProperty("accept", "application/json");

// This line makes the request
        InputStream responseStream = connection.getInputStream();

// Manually converting the response body InputStream to jsonNode using Jackson
        ObjectMapper mapper = new ObjectMapper();

   //Step1: get json using JsonNode
        JsonNode rootNode = mapper.readTree(url);
        System.out.println(rootNode);
        return new ResponseEntity<>(rootNode,HttpStatus.OK);
    }

 ///json reading using RestTemplete Class
    @GetMapping("v1/userResttemplate")
    public ResponseEntity<?> getUsers() throws MalformedURLException {
        Map<String, List<User>> map = new HashMap<>();

        if (!map.containsKey("user")) {

            RestTemplate template = new RestTemplate();
            ResponseEntity<User[]> users = template.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
            User[] userArray = users.getBody();
            List<User> user1 = Arrays.asList(userArray);
            map.put("user", user1);
            System.out.println(map);
        }
        return new ResponseEntity<>(map,HttpStatus.OK);

    }





}















