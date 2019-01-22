package com.glaucus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.glaucus.model.Counter;

/**
 * 
 * @author rishirajsahu
 *
 */
@Repository
@EnableTransactionManagement
public interface CounterRepository extends JpaRepository<Counter, Long> {
	
	/**
	 * 
	 * Responsible for running native sql query via JPA
	 * 
	 * @return count of records updated
	 */
	
	@Modifying
	@Query("update Counter c set c.count = c.count+1")
	int incrementCount();
}