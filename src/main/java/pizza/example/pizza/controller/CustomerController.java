package pizza.example.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pizza.example.pizza.model.Customer;
import pizza.example.pizza.repository.CustomerRepository;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer")
    public Customer createCustomer(@Validated @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/customer")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomer(Long Id) {
        Customer p = customerRepository.findById(Id).orElse(null);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

}
