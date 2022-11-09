package pizza.example.pizza.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
    @GetMapping("/pizza/{id}")
    public Optional<Pizza> getPizza(@PathVariable Long id) {
        return pizzaRepository.findById(id);
    }
    @GetMapping("/pizza")
    public Iterable<Pizza> getAllpizzas() {
        return pizzaRepository.findAll();

    }

    @PutMapping("/pizza/{customer_id}/pizza")
    public Optional<Pizza> updateePizza(@PathVariable(value = "customer_id") @JsonInclude Long customer_id, @Validated @RequestBody Pizza pizza) {
        return customerRepository.findById(customer_id).map(customer -> {
            pizza.setCustomer(customer);
            return pizzaRepository.save(pizza);
        });

    }

    @DeleteMapping("/pizza/{id}")
    public void deletePizza(@PathVariable Long id) {
        pizzaRepository.deleteById(id);
    }


    }



