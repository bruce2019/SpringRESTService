package com.glaucus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glaucus.exception.ResourceNotFoundException;
import com.glaucus.repository.CounterRepository;
import com.glaucus.service.CounterService;

/**
 * 
 * @author rishirajsahu
 *
 */
@RestController
@RequestMapping("/api/v1")
@ComponentScan({ "com.glaucus" })
public class CountController {

	@Autowired
	@Qualifier("counterRepository")
	private CounterRepository counterRepository;

	@Autowired
	@Qualifier("counterService")
	private CounterService counterService;

	@PutMapping("/counter")
	public ResponseEntity<Integer> udpateCounter() throws ResourceNotFoundException {
		int rows = counterService.updateNative();
		return ResponseEntity.ok().body(rows);
	}

    /*@DeleteMapping("/counter/{id}")
    public Map<String, Boolean> deleteCounter(@PathVariable(value = "id") Long counterId) throws ResourceNotFoundException {
        Counter counter = counterRepository.findById(counterId)
       .orElseThrow(() -> new ResourceNotFoundException("Counter not found for this id :: " + counterId));
        counterRepository.delete(counter);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

	@GetMapping("/counter/{id}")
	public ResponseEntity<Counter> getCounterById(@PathVariable(value = "id") Long counterId) throws ResourceNotFoundException {
		System.out.println("controller called : getCounterById");
		Counter counter = counterService.getCounter(counterId);
		return ResponseEntity.ok().body(counter);
	}

	@PostMapping("/counter")
	public Counter createCounter(@Valid @RequestBody Counter counter) {
		return counterService.createCounter(counter);
	}*/
}
