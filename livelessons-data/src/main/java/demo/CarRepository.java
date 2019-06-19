package demo;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

	//Iterable<Car> findByMakeIgnoringCase(String make);
	
	Iterable<Car> findByModel(String model);
	
	Iterable<Car> findByYear(int year);

}
