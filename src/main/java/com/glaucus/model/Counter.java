package com.glaucus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author rishirajsahu
 * 
 *        Entity to map to each row of database table 'counter'
 *
 */

@Entity
@Table(name = "counter")
public class Counter {

	private long id;
	private int count;

	public Counter() {
	}

	public Counter(int val) {
		this.count = val;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "count", nullable = false)
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Object class's toString method overriding
	 */
	@Override
	public String toString() {
		return "Counter [id=" + id + ", Count=" + count + "]";
	}

}