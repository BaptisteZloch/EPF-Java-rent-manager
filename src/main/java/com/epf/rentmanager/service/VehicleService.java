package com.epf.rentmanager.service;

import java.util.ArrayList;
import java.util.Optional;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.VehicleDao;


@Service
public class VehicleService {

	private VehicleDao vehicleDao;

	@Autowired
	private VehicleService(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}
	
	/*public static VehicleService getInstance() {
		if (instance == null) {
			instance = new VehicleService();
		}
		
		return instance;
	}*/

	public long create(Vehicle vehicle) throws ServiceException {
		try {
			return this.vehicleDao.create(vehicle);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long update(Vehicle vehicle) throws ServiceException {
		try {
			return this.vehicleDao.update(vehicle);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}


	public long delete(Vehicle vehicle) throws ServiceException {
		try {
			return this.vehicleDao.delete(vehicle);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Optional<Vehicle> findById(long id) throws ServiceException {
		try {
			return this.vehicleDao.findById(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public ArrayList<Vehicle> findAll() throws ServiceException {
		try {
			return this.vehicleDao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int count() throws ServiceException {
		try {
			return this.vehicleDao.findCountVehicule();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
