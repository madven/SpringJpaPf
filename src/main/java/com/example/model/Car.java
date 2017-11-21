package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer id;
	private String brand;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Car{");
		sb.append("id=").append(id);
		sb.append(", brand='").append(brand).append('\'');
		sb.append('}');
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Car car = (Car) o;

		if (id != null ? !id.equals(car.id) : car.id != null) return false;
		return brand != null ? brand.equals(car.brand) : car.brand == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (brand != null ? brand.hashCode() : 0);
		return result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
