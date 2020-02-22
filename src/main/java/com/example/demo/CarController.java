package com.example.demo;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class CarController {
	private final CarRepository carRepository;
	
	public CarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@GetMapping
	public Iterable<Car> getCars(){
		return carRepository.findAll();
	}
	
	@PostMapping
	public Car addNewCaR(@RequestBody Car car) {
		return carRepository.save(car);
	}
	
	@GetMapping("/{id}")
	public Optional<Car> getCarById(@PathVariable("id") String id){
		return carRepository.findById(Long.parseLong(id));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCarById(@PathVariable("id") Long id) {
		carRepository.deleteById(id);
	}
}
