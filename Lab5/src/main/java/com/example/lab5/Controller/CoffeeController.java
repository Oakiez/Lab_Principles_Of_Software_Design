package com.example.lab5.Controller;

import com.example.lab5.Model.Coffee;
import com.example.lab5.Service.CoffeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService cofferService) {
        this.coffeeService = cofferService;
    }

    @GetMapping
    public List<Coffee> getAll() {
        return coffeeService.getCoffeeList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getById(@PathVariable long id) {
        return coffeeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Coffee add(@RequestBody Coffee coffee) {
        return coffeeService.add(coffee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> update(@PathVariable long id, @RequestBody Coffee coffee) {
        return coffeeService.update(id, coffee)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable long id) {
        if (coffeeService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
