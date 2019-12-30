package com.example.database_web_demo.controller;

import com.example.database_web_demo.model.Customer;
import com.example.database_web_demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final CustomerRepository repository;

    public HelloController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String index() {
        StringBuilder sb = new StringBuilder();

        for (Customer customer : repository.findAll()) {
            sb.append(customer.toString()).append(" | ");
        }

        return sb.toString();
    }

    @RequestMapping("/clear")
    public String drop() {
        repository.deleteAll();

        return "Removed all entries!";
    }

    @RequestMapping("/insert")
    public String insert() {
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        return "Test names inserted!";
    }

}
