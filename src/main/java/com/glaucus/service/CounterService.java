package com.glaucus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.glaucus.exception.ResourceNotFoundException;
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

	/**
	 * 
	 * @return count of records effected
	 * @throws ResourceNotFoundException
	 */
	@Transactional(isolation=Isolation.DEFAULT)
	public int updateNative() throws ResourceNotFoundException {
		return counterRepository.incrementCount();
	}
}