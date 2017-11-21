package com.example.controller;

import com.example.model.Car;
import com.example.service.CarService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class HomeMB implements Serializable{

	@ManagedProperty("#{carService}")
	private CarService carService;

	private Car newCar;
	private List<Car> carList;

	@PostConstruct
	public void init(){
		newCar = new Car();
		carList = carService.findAllCars();
	}

	public void saveNewCar(){
		carService.saveCar(newCar);
		carList.add(newCar);
		newCar = new Car();
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	public Car getNewCar() {
		return newCar;
	}

	public void setNewCar(Car newCar) {
		this.newCar = newCar;
	}
}
