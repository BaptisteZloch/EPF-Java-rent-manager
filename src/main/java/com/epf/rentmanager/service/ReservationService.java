package com.epf.rentmanager.service;

import java.util.ArrayList;
import java.util.Optional;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Reservation;

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

	/*
	 * public static ClientService getInstance() {
	 * if (instance == null) {
	 * instance = new ClientService();
	 * }
	 * return instance;
	 * }
	 */

	public long delete(Reservation reservation) throws ServiceException {
		try {
			return this.reservationDao.delete(reservation);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/*public int count() throws ServiceException {
		try {
			return this.reservationDao.findCountClient();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}*/

	public long create(Reservation reservation) throws ServiceException {
		try {
			return this.reservationDao.create(reservation);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}
	/*public long update(Reservation reservation) throws ServiceException {
		try {
			return this.reservationDao.update(reservation);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return 0;
	}*/
	public Optional<Reservation> findResaByVehicleId(long id) throws ServiceException {
		try {
			return this.reservationDao.findResaByVehicleId(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

    public Optional<Reservation> findResaByClientId(long id) throws ServiceException {
		try {
			return this.reservationDao.findResaByClientId(id);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

    

	public ArrayList<Reservation> findAll() throws ServiceException {
		try {
			return this.reservationDao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;
	}
}
