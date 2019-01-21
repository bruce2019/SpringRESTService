package com.glaucus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.glaucus.exception.ResourceNotFoundException;
import com.glaucus.model.Counter;
import com.glaucus.repository.CounterRepository;

/**
 * 
 * @author rishirajsahu
 *
 */
@Service
@Qualifier("counterService")
public class CounterService {
	@Autowired
	CounterRepository counterRepository;

	@Transactional(isolation=Isolation.SERIALIZABLE)
	public Counter update(Long id) throws ResourceNotFoundException {
		return updateCounter(id);
	}

	private Counter updateCounter(Long id) throws ResourceNotFoundException {
		Counter counter = counterRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Counter not found for this id :: " + id));
		counter.setCount(1 + counter.getCount());
		final Counter updatedCounter = counterRepository.save(counter);
		return updatedCounter;
	}

	@Transactional(isolation=Isolation.DEFAULT)
	public int updateNative() throws ResourceNotFoundException {
		return counterRepository.incrementCount();
	}
	
	/*public Counter getCounter(Long id) throws ResourceNotFoundException {
        Counter counter = counterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Counter not found for this id :: " + id));
        return counter;
	}
	
	public Counter createCounter(Counter counter) {
		return counterRepository.save(counter);
	}*/
}