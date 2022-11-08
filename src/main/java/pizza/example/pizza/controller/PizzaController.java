package pizza.example.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pizza.example.pizza.model.Pizza;
import pizza.example.pizza.repository.CustomerRepository;
import pizza.example.pizza.repository.PizzaRepository;

import java.util.Optional;

@RestController
public class PizzaController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PizzaRepository pizzaRepository;


    @PostMapping("/pizza/{customer_id}/pizza")
    public Optional<Pizza> createPizza(@PathVariable(value = "customer_id") Long customer_id, @Validated @RequestBody Pizza pizza) {
        return customerRepository.findById(customer_id).map(customer -> {
            pizza.setCustomer(customer);
            return pizzaRepository.save(pizza);
        });

    }
    @GetMapping("/pizza")
    public Iterable<Pizza> getAllpizzas() {
        return pizzaRepository.findAll();

    }
}
