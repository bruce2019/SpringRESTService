package com.glaucus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glaucus.exception.ResourceNotFoundException;
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
	@Qualifier("counterService")
	private CounterService counterService;

	/**
	 * 
	 * REST-API request mapper for handling all the requests coming for /api/v1/counter
	 * 
	 * @return count of rows effected
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/counter")
	public ResponseEntity<Integer> udpateCounter() throws ResourceNotFoundException {
		int rows = counterService.updateNative();
		return ResponseEntity.ok().body(rows);
	}
}
