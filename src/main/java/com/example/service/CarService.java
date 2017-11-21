package com.example.service;

import com.example.dao.CarDao;
import com.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class CarService implements Serializable {

	@Autowired
	CarDao carDao;

	public List<Car> findAllCars(){
		return carDao.findAll();
	}

	@Transactional("exampleTm")
	public void saveCar(Car car) {
		carDao.create(car);
	}
}
