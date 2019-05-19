package app.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    @Autowired
    private IExampleRepository exampleRepository;

    public Example save(Example example) {
        return exampleRepository.save(example);
    }

    public void deleteAll() {
        exampleRepository.deleteAll();
    }

    public Iterable<Example> findAll() {
        return exampleRepository.findAll();
    }
}
