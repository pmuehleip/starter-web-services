package app.example;

import org.springframework.data.repository.CrudRepository;

public interface IExampleRepository extends CrudRepository<Example, Integer> {
}
