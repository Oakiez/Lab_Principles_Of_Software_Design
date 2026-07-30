package com.example.lab5.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.lab5.Model.Coffee;

@Service
public class CoffeeService {
    private final List<Coffee> coffeeList = new ArrayList<>();
    private long nextId = 1;

    public CoffeeService() {
        add(new Coffee(nextId, "Espresso", 45.0));
        add(new Coffee(nextId, "Latte", 55.0));
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public Optional<Coffee> getById(long id) {
        return coffeeList.stream().filter(c -> c.getId() == id).findFirst();
    }

    public Coffee add(Coffee coffee) {
        coffee.setId(nextId++);
        coffeeList.add(coffee);
        return coffee;
    }

    public Optional<Coffee> update(long id, Coffee update) {
        Optional<Coffee> existing = getById(id);
        existing.ifPresent(c -> {
            c.setName(update.getName());
            c.setPrice(update.getPrice());
        });
        return existing;
    }

    public boolean delete(long id) {
        return coffeeList.removeIf(c -> c.getId() == id);
    }
}
