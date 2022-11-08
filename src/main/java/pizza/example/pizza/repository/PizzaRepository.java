package pizza.example.pizza.repository;

import org.springframework.data.repository.CrudRepository;
import pizza.example.pizza.model.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
}
