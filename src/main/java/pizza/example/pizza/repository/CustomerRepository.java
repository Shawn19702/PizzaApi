package pizza.example.pizza.repository;

import org.springframework.data.repository.CrudRepository;
import pizza.example.pizza.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
