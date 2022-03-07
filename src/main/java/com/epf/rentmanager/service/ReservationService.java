package com.epf.rentmanager.service;

import java.util.ArrayList;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.rentmanager.dao.ReservationDao;

@Service
public class ReservationService {

	private ReservationDao reservationDao;
	// public static ClientService instance;

	@Autowired
	public ReservationService(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	public long delete(Reservation reservation) throws ServiceException {
		try {
			return this.reservationDao.delete(reservation);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public long create(Reservation reservation) throws ServiceException {
		try {
			return this.reservationDao.create(reservation);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Vehicle> findResaByVehicleId(long id) throws ServiceException {
		try {
			return this.reservationDao.findResaByVehicleId(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

    public ArrayList<Reservation> findResaByClientId(long id) throws ServiceException {
		try {
			return this.reservationDao.findResaByClientId(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
        return null;
	} 

	public ArrayList<Reservation> findAll() throws ServiceException {
		try {
			return this.reservationDao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int count() throws ServiceException {
		try {
			return this.reservationDao.findCountReservation();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}	
}
