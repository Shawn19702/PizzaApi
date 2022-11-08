package pizza.example.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/customer/{customer_id}")
    public ResponseEntity<?> getCustomer(Long customer_id) {
        Customer p = customerRepository.findById(customer_id).orElse(null);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
    @PutMapping("/customer/{customer_id}")

    public ResponseEntity<?> updateCustomer(Customer customer, Long customer_id) {
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping("/customer/{customer_id}")

    public ResponseEntity<?> deleteCustomer(Long category_id) {
        customerRepository.deleteById(category_id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
