package com.example.dao;

import com.example.model.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao extends AbstractDao<Car> {

	public CarDao() {
		super(Car.class);
	}

}

